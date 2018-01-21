package xyz.tunlinaung.news.data.models;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import xyz.tunlinaung.news.data.vo.LoginUserVO;
import xyz.tunlinaung.news.events.SuccessLoginEvent;
import xyz.tunlinaung.news.events.UserLogoutEvent;
import xyz.tunlinaung.news.network.NewsDataAgent;
import xyz.tunlinaung.news.network.RetrofitDataAgent;

/**
 * Created by eidoshack on 1/20/18.
 */

public class LoginUserModel {

    private static LoginUserModel sObjInstance;

    private NewsDataAgent mDataAgent;

    private LoginUserVO mLoginUser;

    private LoginUserModel() {
        mDataAgent = RetrofitDataAgent.getInstance();

        EventBus.getDefault().register(this);
    }

    public static LoginUserModel getInstance() {
        if (sObjInstance == null)
            sObjInstance = new LoginUserModel();

        return sObjInstance;
    }

    public void loginUser(String phoneNo, String password) {
        mDataAgent.loginUser(phoneNo, password);
    }

    public boolean isUserLogin() {
        return mLoginUser != null;
    }

    public void logout() {
        mLoginUser = null;
        UserLogoutEvent event = new UserLogoutEvent();
        EventBus.getDefault().post(event);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoginUserSuccess(SuccessLoginEvent event) {
        mLoginUser = event.getLoginUser();
    }
}
