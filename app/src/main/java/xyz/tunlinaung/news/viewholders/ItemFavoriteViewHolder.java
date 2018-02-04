package xyz.tunlinaung.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.data.vo.FavoriteVO;

/**
 * Created by eidoshack on 2/4/18.
 */

public class ItemFavoriteViewHolder extends RecyclerView.ViewHolder {

    public static final String TAG = ItemFavoriteViewHolder.class.getSimpleName();

    @BindView(R.id.iv_user_profile)
    ImageView ivUserProfile;

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_phoneno)
    TextView tvPhoneNo;

    @BindView(R.id.tv_timestamp)
    TextView tvTimeStamp;

    public ItemFavoriteViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void setData(FavoriteVO favoriteVO) {
        Glide.with(itemView.getContext())
                .load(favoriteVO.getActedUser().getProfileImage())
                .into(ivUserProfile);
        tvName.setText(favoriteVO.getActedUser().getUserName());

        try {
            String originalTimeFormat = favoriteVO.getDate();
            SimpleDateFormat sdfOriginalFormat = new SimpleDateFormat("E MMM dd hh:mm:ss Z yyyy");
            Date originDate = sdfOriginalFormat.parse(originalTimeFormat);
            SimpleDateFormat sdfConvertedFormat = new SimpleDateFormat("hh:mm a',' MMM dd yyyy");
            String convertedDate = sdfConvertedFormat.format(originDate);

            tvTimeStamp.setText(convertedDate);
        } catch (Exception e) {
            Log.e(TAG, "Error", e);
        }
    }

}
