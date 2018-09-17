package thebotbox.shorty.delegate;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import thebotbox.shorty.Shorty;

import static android.content.ContentValues.TAG;

/**
 * Created by Barry Allen .
 * boxforbot@gmail.com
 */

public class TLDRTask extends AsyncTask<Void, String, String> {
    private String url;
    private String BASE_URL = "https://to.ly/api.php?longurl=";
    private Shorty.Callback shortener;

    public TLDRTask(String url, Shorty.Callback shortener) {
        this.url = url;
        this.shortener = shortener;
    }

    @Override
    protected String doInBackground(Void... voids) {
        String response = null;
        try {
            URL url = new URL(BASE_URL + this.url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = getStringFromStream(in);

        } catch (MalformedURLException e) {
            Log.e(TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(TAG, "ProtocolException: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s != null && !TextUtils.isEmpty(s)) {
            if (!s.contains("Invalid")) {
                if (shortener != null) {
                    shortener.shortURL(s);
                } else {
                    new RuntimeException("Activity must implement thebotbox.shorty.Shorty.Shortener interface");
                }
            } else {
                if (shortener != null) {
                    shortener.onError(s);
                } else {
                    new RuntimeException("Activity must implement thebotbox.shorty.Shorty.Shortener interface");
                }
            }
        }

    }

    private String getStringFromStream(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
