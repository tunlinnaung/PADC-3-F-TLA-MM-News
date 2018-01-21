package xyz.tunlinaung.news.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.data.vo.LoginUserVO;
import xyz.tunlinaung.news.delegates.LoginUserDelegate;

/**
 * Created by eidoshack on 1/17/18.
 */

public class LoginUserViewPod extends RelativeLayout {

    @BindView(R.id.tv_login_username)
    TextView tvLoginUserName;

    @BindView(R.id.tv_login_phoneno)
    TextView tvLoginPhoneNo;

    private LoginUserDelegate mDelegate;

    public LoginUserViewPod(Context context) {
        super(context);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDelegate(LoginUserDelegate delegate) {
        mDelegate = delegate;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ButterKnife.bind(this, this);
    }

    public void bindData(LoginUserVO loginUserVO) {
        tvLoginUserName.setText(loginUserVO.getName());
        tvLoginPhoneNo.setText(loginUserVO.getPhoneNo());
    }

    @OnClick(R.id.btn_logout)
    public void logout() {
        mDelegate.onTapLogout();
    }
}
