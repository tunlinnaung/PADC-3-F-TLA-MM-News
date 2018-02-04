package xyz.tunlinaung.news.delegates;

import xyz.tunlinaung.news.data.vo.NewsVO;

/**
 * Created by eidoshack on 12/17/17.
 */

public interface NewsActionDelegate {

    void onTapNewsItem(NewsVO tappedNew);
    void onTapSendToButton(NewsVO tappedNew);
    void onTapCommentButton();
    void onTapFavouriteButton();
    void onTapLikeUsers(NewsVO tappedNew);
    void onTapCommentUsers(NewsVO tappedNew);
    void onTapSendToUsers(NewsVO tappedNew);

}
