package xyz.tunlinaung.news;

import android.app.Application;

import xyz.tunlinaung.news.network.RetrofitDataAgent;

/**
 * Created by eidoshack on 11/29/17.
 */

public class MMNewsApp extends Application {

    public static final String LOG_TAG = "MMNewsApp";

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitDataAgent.getInstance();
    }
}
