package xyz.tunlinaung.news.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eidoshack on 12/17/17.
 */

public class FavoriteVO {

    @SerializedName("favorite-id")
    private String favoriteId;
    @SerializedName("favorite-date")
    private String date;
    @SerializedName("acted-user")
    private ActedUserVO actedUser;

    public String getFavoriteId() {
        return favoriteId;
    }

    public String getDate() {
        return date;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }
}
