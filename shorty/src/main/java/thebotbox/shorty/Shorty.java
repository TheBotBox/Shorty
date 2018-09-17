package thebotbox.shorty;


import thebotbox.shorty.delegate.TLDRTask;


/**
 * Created by Barry Allen .
 * boxforbot@gmail.com
 */

public class Shorty {

    private String url;
    private boolean isLoader;

    private Shorty(Builder b) {
        this.url = b.url;
        this.isLoader = b.isLoader;
    }

    public void TLDR(Callback c) {
        new TLDRTask(this.url, c).execute();
    }

    public static class Builder {
        private String url;
        private boolean isLoader;

        public Builder setURL(String url) {
            this.url = url;
            return this;
        }

        public Builder isLoader(boolean showLoader) {
            this.isLoader = showLoader;
            return this;
        }

        public Shorty build() {
            return new Shorty(this);
        }
    }

    public interface Callback {
        void shortURL(String url);
        void onError(String error);
    }
}
