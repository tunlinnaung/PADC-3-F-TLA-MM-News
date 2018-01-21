package xyz.tunlinaung.news.events;

import xyz.tunlinaung.news.data.vo.LoginUserVO;

/**
 * Created by eidoshack on 1/21/18.
 */

public class LoadedRegisterUserEvent {

    private LoginUserVO registerLoginUserVo;

    public LoadedRegisterUserEvent(LoginUserVO registerLoginUserVo) {
        this.registerLoginUserVo = registerLoginUserVo;
    }

    public LoginUserVO getRegisterLoginUserVo() {
        return registerLoginUserVo;
    }
}
