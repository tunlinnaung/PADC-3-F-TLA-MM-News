package xyz.tunlinaung.news.network;

import android.content.Context;

/**
 * Created by eidoshack on 12/23/17.
 */

public interface NewsDataAgent {

    /**
     * load news from network layer.
     */
    void loadNews();

    /**
     * login user
     * @param context
     * @param phoneNo
     * @param password
     */
    void loginUser(Context context, String phoneNo, String password);

    /**
     * register user
     * @param phoneNo
     * @param password
     * @param name
     */
    void registerUser(String phoneNo, String password, String name);

}
