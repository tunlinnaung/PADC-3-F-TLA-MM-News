package xyz.tunlinaung.news.network.responses;

import com.google.gson.annotations.SerializedName;

import xyz.tunlinaung.news.data.vo.LoginUserVO;

/**
 * Created by eidoshack on 1/21/18.
 */

public class LoginResponse {

    private int code;
    private String message;
    @SerializedName("login_user")
    private LoginUserVO loginUser;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LoginUserVO getLoginUser() {
        return loginUser;
    }
}
