package xyz.tunlinaung.news.events;

import android.content.Context;

import xyz.tunlinaung.news.data.vo.LoginUserVO;

/**
 * Created by eidoshack on 1/21/18.
 * Immutable class
 */

public class SuccessLoginEvent {

    private LoginUserVO loginUser;

    private Context context;

    public SuccessLoginEvent(LoginUserVO loginUser, Context context) {
        this.loginUser = loginUser;
        this.context = context;
    }

    public LoginUserVO getLoginUser() {
        return loginUser;
    }

    public Context getContext() {
        return context;
    }
}
