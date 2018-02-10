package xyz.tunlinaung.news.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import xyz.tunlinaung.news.MMNewsApp;

/**
 * Created by eidoshack on 2/10/18.
 */

public class SampleService extends IntentService
{
    private static final String IE_TIMESTAMP = "timestamp";

    // remove parameter from constructor.
    // param: name is worker thread's name , only for debugging
    public SampleService()
    {
        super("SampleService");
    }

    public static Intent newIntent(Context context, String timestamp) {
        Intent intent = new Intent(context, SampleService.class);
        intent.putExtra(IE_TIMESTAMP, timestamp);
        return intent;
    }

    /**
     * Execute tasks inside onHandleIntent method as background
     *
     * @param intent
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent)
    {
        String timestamp = "";

        if (intent != null) {
            timestamp = intent.getStringExtra(IE_TIMESTAMP);
        }

        Log.d(MMNewsApp.LOG_TAG, "onHandleIntent: Timestamp -> " + timestamp);
    }

}
