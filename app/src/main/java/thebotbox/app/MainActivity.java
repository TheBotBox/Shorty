package thebotbox.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import thebotbox.shorty.Shorty;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        url = (EditText) findViewById(R.id.url);
        url.setSelection(url.getText().length());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Shorty shorty = new Shorty.Builder()
                        .setURL(url.getText().toString())
                        .isLoader(true).build(MainActivity.this);
                shorty.TLDR(new Shorty.Callback() {
                    @Override
                    public void shortURL(final String url) {
                        Snackbar bar = Snackbar.make(btn, url, Snackbar.LENGTH_LONG)
                                .setAction("Click", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                                    }
                                });
                        bar.show();
                    }

                    @Override
                    public void onError(String error) {
                        Snackbar.make(btn, error, Snackbar.LENGTH_SHORT).show();

                    }
                });
            }
        });

    }
}
