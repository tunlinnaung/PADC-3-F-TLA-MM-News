package xyz.tunlinaung.news.events;

import xyz.tunlinaung.news.data.vo.LoginUserVO;

/**
 * Created by eidoshack on 1/21/18.
 */

public class SuccessLoginEvent {

    private LoginUserVO loginUser;

    public SuccessLoginEvent(LoginUserVO loginUser) {
        this.loginUser = loginUser;
    }

    public LoginUserVO getLoginUser() {
        return loginUser;
    }
}
