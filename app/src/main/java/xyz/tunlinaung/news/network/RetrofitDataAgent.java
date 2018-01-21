package xyz.tunlinaung.news.network;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.tunlinaung.news.events.LoadedNewsEvent;
import xyz.tunlinaung.news.events.SuccessLoginEvent;
import xyz.tunlinaung.news.network.responses.GetNewsResponse;
import xyz.tunlinaung.news.network.responses.LoginResponse;

/**
 * Created by eidoshack on 1/6/18.
 */

public class RetrofitDataAgent implements NewsDataAgent {

    private static RetrofitDataAgent sObjInstance;
    private NewsApi mNewsApi;

    private RetrofitDataAgent()
    {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/mm-news/apis/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        mNewsApi = retrofit.create(NewsApi.class);
    }

    public static RetrofitDataAgent getInstance()
    {
        if (sObjInstance == null) {
            sObjInstance = new RetrofitDataAgent();
        }

        return sObjInstance;
    }

    @Override
    public void loadNews()
    {
        Call<GetNewsResponse> getNewsResponseCall = mNewsApi.getNews("b002c7e1a528b7cb460933fc2875e916", 1);

        getNewsResponseCall.enqueue(new Callback<GetNewsResponse>() {
            @Override
            public void onResponse(Call<GetNewsResponse> call, Response<GetNewsResponse> response)
            {
                GetNewsResponse getNewsResponse = response.body();

                if (getNewsResponse != null) {
                    EventBus.getDefault()  // event object
                            .post(new LoadedNewsEvent(getNewsResponse.getMmNews())); // post method
                }
            }

            @Override
            public void onFailure(Call<GetNewsResponse> call, Throwable t)
            {
            }
        });
    }

    @Override
    public void loginUser(String phoneNo, String password)
    {
        Call<LoginResponse> loginCall = mNewsApi.loginUser(phoneNo, password);

        // capture the response
        loginCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response)
            {
                LoginResponse loginResponse = response.body();

                if (loginResponse != null) {
                    SuccessLoginEvent event = new SuccessLoginEvent(loginResponse.getLoginUser());
                    EventBus.getDefault()   // event object
                            .post(event);   // post method
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t)
            {
            }
        });
    }

    @Override
    public void registerUser(String phoneNo, String password, String name)
    {
        Call<LoginResponse> getRegisterUserResponseCall = mNewsApi.registerUser(phoneNo, password, name);

        getRegisterUserResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response)
            {
                LoginResponse getRegisterUserResponse = response.body();

                if (getRegisterUserResponse != null) {
                    EventBus.getDefault()  // event object
                            .post(getRegisterUserResponse.getLoginUser()); // post method
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t)
            {
            }
        });
    }

}
