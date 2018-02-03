package xyz.tunlinaung.news.viewpods;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.data.models.LoginUserModel;
import xyz.tunlinaung.news.data.vo.LoginUserVO;
import xyz.tunlinaung.news.delegates.BeforeLoginDelegate;
import xyz.tunlinaung.news.delegates.LoginUserDelegate;
import xyz.tunlinaung.news.events.SuccessLoginEvent;
import xyz.tunlinaung.news.events.UserLogoutEvent;

/**
 * Created by eidoshack on 1/21/18.
 */

public class AccountControlViewPod extends FrameLayout {

    @BindView(R.id.vp_before_login) BeforeLoginViewPod vpBeforeLogin;

    @BindView(R.id.vp_login_user) LoginUserViewPod vpLoginUser;

    private LoginUserDelegate mLoginUserDelegate;

    public AccountControlViewPod(@NonNull Context context) {
        super(context);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDelegate(BeforeLoginDelegate mDelegate) {
        vpBeforeLogin.setDelegate(mDelegate);
    }

    public void setDelegate(LoginUserDelegate mDelegate) {
        mLoginUserDelegate = mDelegate;
        vpLoginUser.setDelegate(mDelegate);
    }

    @Override
    protected void onFinishInflate()
    {
        super.onFinishInflate();

        ButterKnife.bind(this, this);

        EventBus.getDefault().register(this);

        refreshUserSession();
    }

    @OnClick(R.id.vp_login_user)
    public void onTapLoginUser(View view) {
        mLoginUserDelegate.onTapLoginUser();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginUserSuccess(SuccessLoginEvent event) {
        vpBeforeLogin.setVisibility(GONE);
        vpLoginUser.setVisibility(VISIBLE);

        vpLoginUser.bindData(event.getLoginUser());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLogoutUser(UserLogoutEvent event) {
        vpBeforeLogin.setVisibility(VISIBLE);
        vpLoginUser.setVisibility(GONE);
    }

    public void refreshUserSession() {
        if (LoginUserModel.getInstance(getContext()).isUserLogin()) {
            vpBeforeLogin.setVisibility(GONE);
            vpLoginUser.setVisibility(VISIBLE);

            LoginUserVO loginUserVO = LoginUserModel.getInstance(getContext()).getLoginUser();
            if (loginUserVO != null)
                vpLoginUser.bindData(loginUserVO);
        }
        else
        {
            vpBeforeLogin.setVisibility(VISIBLE);
            vpLoginUser.setVisibility(GONE);
        }
    }

}
