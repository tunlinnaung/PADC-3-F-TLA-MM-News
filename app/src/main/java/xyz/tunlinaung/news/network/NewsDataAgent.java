package xyz.tunlinaung.news.network;

/**
 * Created by eidoshack on 12/23/17.
 */

public interface NewsDataAgent {

    /**
     * load news from network layer.
     */
    void loadNews();

    void loginUser(String email, String password);

}
