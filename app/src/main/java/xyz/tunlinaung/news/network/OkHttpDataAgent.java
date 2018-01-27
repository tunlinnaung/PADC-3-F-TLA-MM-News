package xyz.tunlinaung.news.network;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import xyz.tunlinaung.news.MMNewsApp;
import xyz.tunlinaung.news.events.LoadedNewsEvent;
import xyz.tunlinaung.news.network.responses.GetNewsResponse;

/**
 * Created by eidoshack on 1/6/18.
 */

public class OkHttpDataAgent implements NewsDataAgent {

    private static OkHttpDataAgent sObjInstance;

    private static OkHttpClient mHttpClient;

    private OkHttpDataAgent() {
        mHttpClient = new OkHttpClient.Builder() //1.
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpDataAgent getInstance()
    {
        if (sObjInstance == null) {
            sObjInstance = new OkHttpDataAgent();
        }

        return sObjInstance;
    }

    @Override
    public void loadNews()
    {
        new LoadNewsTask().execute("http://padcmyanmar.com/padc-3/mm-news/apis/v1/getMMNews.php");
    }

    @Override
    public void loginUser(Context context, String email, String password) {

    }

    @Override
    public void registerUser(String phoneNo, String password, String name) {

    }

    // 2. to overcome memory leak while calling background thread
    // make *static*
    // 1st parameter - different endpoints
    // 2nd parameter - not necessary
    // 3rd parameter - response json from endpoint
    private static class LoadNewsTask extends AsyncTask<String, Void, String> {

        // work in background thread
        @Override
        protected String doInBackground(String... urls)
        {
            String url = urls[0];

            // connectionTimeout - 15
            // writeTimeout - 15
            // readTimeout - 60


            RequestBody formBody = new FormBody.Builder() //2.
                    .add("access_token", "b002c7e1a528b7cb460933fc2875e916")
                    .add("page", "1")
                    .build();

            Request request = new Request.Builder() //3
                    .url(url)
                    .post(formBody)
                    .build();

            String responseString = null;
            try {
                Response response = mHttpClient.newCall(request).execute(); //4.
                if (response.isSuccessful() && response.body() != null) {
                    responseString = response.body().string();
                    return responseString;
                }
            } catch (IOException e) {
                Log.e(MMNewsApp.LOG_TAG, e.getMessage());
            }

            return responseString;
        }

        // To return value from AsyncTask, call onPostExecute method.
        // work in UI thread.
        @Override
        protected void onPostExecute(String responseString) {
            super.onPostExecute(responseString);

            Log.d(MMNewsApp.LOG_TAG, "onPostExecute: responseString -> " + responseString);

            Gson gson = new Gson();
            GetNewsResponse getNewsResponse = gson.fromJson(responseString, GetNewsResponse.class);
            Log.d(MMNewsApp.LOG_TAG, "onPostExecute: size -> " + getNewsResponse.getMmNews().size());

            EventBus.getDefault()  // event object
                    .post(new LoadedNewsEvent(getNewsResponse.getMmNews())); // post method
        }
    }

}
