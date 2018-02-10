package xyz.tunlinaung.news.delegates;

/**
 * Created by eidoshack on 1/27/18.
 */

public interface LoginScreenDelegate {

    /**
     * To be able to navigate to register screen.
     */
    void onTapToRegister();


    /**
     * To be able to login via google authentication.
     */
    void onTapLoginWithGoogle();

}
