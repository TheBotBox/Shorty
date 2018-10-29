package thebotbox.shorty;


import android.app.Activity;

import java.lang.ref.WeakReference;

import thebotbox.shorty.delegate.TLDRTask;


/**
 * Created by Barry Allen .
 * boxforbot@gmail.com
 */

public class Shorty {

    private String url;
    private boolean isLoader;
    private WeakReference<Activity> mActivity;

    private Shorty(Builder b) {
        this.url = b.url;
        this.isLoader = b.isLoader;
        this.mActivity = b.mActivity;
    }

    public void TLDR(Callback c) {
        new TLDRTask(mActivity, this.url, c, isLoader).execute();
    }

    public static class Builder {
        private String url;
        private WeakReference<Activity> mActivity;
        private boolean isLoader;

        public Builder setURL(String url) {
            this.url = url;
            return this;
        }

        public Builder isLoader(boolean showLoader) {
            this.isLoader = showLoader;
            return this;
        }

        public Shorty build(Activity mActivity) {
            this.mActivity = new WeakReference<Activity>(mActivity);
            return new Shorty(this);
        }
    }

    public interface Callback {
        void shortURL(String url);

        void onError(String error);
    }
}
