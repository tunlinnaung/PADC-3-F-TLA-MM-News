package xyz.tunlinaung.news.data.vo;

/**
 * Created by eidoshack on 12/17/17.
 */

public class FavoriteVO {

    private String favoriteId;
    private String date;
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
