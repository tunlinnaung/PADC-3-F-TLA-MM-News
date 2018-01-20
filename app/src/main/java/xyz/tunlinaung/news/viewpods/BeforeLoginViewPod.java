package xyz.tunlinaung.news.viewpods;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.delegates.BeforeLoginDelegate;

/**
 * Created by eidoshack on 1/20/18.
 */

public class BeforeLoginViewPod extends RelativeLayout {

    private BeforeLoginDelegate mDelegate;

    public BeforeLoginViewPod(Context context) {
        super(context);
    }

    public BeforeLoginViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BeforeLoginViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // bind butter knife at onFinishInflate method.
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void setDelegate(BeforeLoginDelegate mDelegate) {
        this.mDelegate = mDelegate;
    }

    // Bind view object as parameter for butterknife onclick
    // to be reused at code place
    @OnClick(R.id.btn_to_login)
    public void onTapToLogin(View view) {
        mDelegate.onTapToLogin();
    }

    @OnClick(R.id.btn_to_register)
    public void onTapToRegister(View view) {
        mDelegate.onTapToRegister();
    }
}
