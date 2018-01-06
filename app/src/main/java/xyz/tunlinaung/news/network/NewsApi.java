package xyz.tunlinaung.news.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.tunlinaung.news.network.responses.GetNewsResponse;

/**
 * Created by eidoshack on 1/6/18.
 */

public interface NewsApi {

    @FormUrlEncoded
    @POST("getMMNews.php")
    Call<GetNewsResponse> getNews(@Field("access_token") String accessToken, @Field("page") int page);

}
