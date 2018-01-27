package xyz.tunlinaung.news.data.models;

import android.content.Context;
import android.content.SharedPreferences;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import xyz.tunlinaung.news.data.vo.LoginUserVO;
import xyz.tunlinaung.news.events.SuccessLoginEvent;
import xyz.tunlinaung.news.events.UserLogoutEvent;
import xyz.tunlinaung.news.network.NewsDataAgent;
import xyz.tunlinaung.news.network.RetrofitDataAgent;
import xyz.tunlinaung.news.utils.AppConstants;

/**
 * Created by eidoshack on 1/20/18.
 */

public class LoginUserModel {

    private static LoginUserModel sObjInstance;

    private NewsDataAgent mDataAgent;

    private LoginUserVO mLoginUser;

    private LoginUserModel(Context context) {
        mDataAgent = RetrofitDataAgent.getInstance();

        EventBus.getDefault().register(this);

        SharedPreferences sharedPreferences =
                context.getSharedPreferences(AppConstants.SP_LOGIN_USER_KEY, Context.MODE_PRIVATE);

        int userId = sharedPreferences.getInt(AppConstants.LOGIN_USER_ID_KEY, -1);

        if (userId != -1) {
            // user already registered.

            String userName = sharedPreferences.getString(AppConstants.LOGIN_USER_NAME_KEY, null);
            String email = sharedPreferences.getString(AppConstants.LOGIN_USER_EMAIL_KEY, null);
            String phoneNo = sharedPreferences.getString(AppConstants.LOGIN_USER_PHONE_NO_KEY, null);
            String profileUrl = sharedPreferences.getString(AppConstants.LOGIN_USER_PROFILE_URL_KEY, null);
            String coverUrl = sharedPreferences.getString(AppConstants.LOGIN_USER_COVER_URL_KEY, null);

            mLoginUser = new LoginUserVO(userId, userName, email, phoneNo, profileUrl, coverUrl);
        }
    }

    public static LoginUserModel getInstance(Context context) {
        if (sObjInstance == null)
            sObjInstance = new LoginUserModel(context);

        return sObjInstance;
    }

    public LoginUserVO getLoginUser() {
        return mLoginUser;
    }

    public void loginUser(Context context, String phoneNo, String password) {
        mDataAgent.loginUser(context, phoneNo, password);
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

        // Save user data in SharedPreferences.
        SharedPreferences sharedPreferences = event.getContext()
                                                   .getSharedPreferences(AppConstants.SP_LOGIN_USER_KEY,
                                                                         Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(AppConstants.LOGIN_USER_ID_KEY, mLoginUser.getUserId());
        editor.putString(AppConstants.LOGIN_USER_NAME_KEY, mLoginUser.getName());
        editor.putString(AppConstants.LOGIN_USER_EMAIL_KEY, mLoginUser.getEmail());
        editor.putString(AppConstants.LOGIN_USER_PHONE_NO_KEY, mLoginUser.getPhoneNo());
        editor.putString(AppConstants.LOGIN_USER_PROFILE_URL_KEY, mLoginUser.getProfileUrl());
        editor.putString(AppConstants.LOGIN_USER_COVER_URL_KEY, mLoginUser.getCoverUrl());

        //editor.commit();    // to save data immediately.
        editor.apply();     // to save data async via agent.
    }
}
