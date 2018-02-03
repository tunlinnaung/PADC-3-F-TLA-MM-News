package xyz.tunlinaung.news.viewpods;

import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.tunlinaung.news.R;

/**
 * Created by eidoshack on 2/3/18.
 */

public class EmptyViewPod extends RelativeLayout
{

    @BindView(R.id.iv_empty)
    ImageView ivEmpty;

    @BindView(R.id.tv_empty)
    TextView tvEmpty;

    public EmptyViewPod(Context context) {
        super(context);
    }

    public EmptyViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EmptyViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ButterKnife.bind(this, this);
    }

    @OnClick(R.id.btn_refresh_empty)
    public void onTapRefreshEmpty() {

    }

    public void setData(String msg, int emptyImage) {
        ivEmpty.setImageResource(emptyImage);
        tvEmpty.setText(msg);
    }
}
