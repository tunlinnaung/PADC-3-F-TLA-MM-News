package xyz.tunlinaung.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.data.vo.CommentVO;

/**
 * Created by eidoshack on 2/6/18.
 */

public class ItemCommentViewHolder extends RecyclerView.ViewHolder {

    public static final String TAG = ItemCommentViewHolder.class.getSimpleName();

    @BindView(R.id.iv_user_profile)
    ImageView ivUserProfile;

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_comment)
    TextView tvComment;

    @BindView(R.id.tv_timestamp)
    TextView tvTimeStamp;

    public ItemCommentViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void setData(CommentVO commentVO) {
        Glide.with(itemView.getContext())
                .load(commentVO.getActedUser().getProfileImage())
                .into(ivUserProfile);
        tvName.setText(commentVO.getActedUser().getUserName());
        tvComment.setText(commentVO.getComment());

        try {
            String originalTimeFormat = commentVO.getCommentDate();
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
