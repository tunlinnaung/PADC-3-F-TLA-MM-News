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
import xyz.tunlinaung.news.data.vo.SendToVO;

/**
 * Created by eidoshack on 2/6/18.
 */

public class ItemSendTosViewHolder extends RecyclerView.ViewHolder {

    public static final String TAG = ItemSendTosViewHolder.class.getSimpleName();

    @BindView(R.id.iv_sender_profile)
    ImageView ivSenderProfile;

    @BindView(R.id.tv_sender_name)
    TextView tvSenderName;

    @BindView(R.id.tv_sender_timestamp)
    TextView tvSenderTimeStamp;

    @BindView(R.id.iv_receiver_profile)
    ImageView ivReceiverProfile;

    @BindView(R.id.tv_receiver_name)
    TextView tvReceiverName;

    @BindView(R.id.tv_receiver_timestamp)
    TextView tvReceiverTimeStamp;

    public ItemSendTosViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void setData(SendToVO sendToVO) {
        Glide.with(itemView.getContext())
                .load(sendToVO.getActedUser().getProfileImage())
                .into(ivSenderProfile);
        tvSenderName.setText(sendToVO.getActedUser().getUserName());

        try {
            String originalTimeFormat = sendToVO.getSentDate();
            SimpleDateFormat sdfOriginalFormat = new SimpleDateFormat("E MMM dd hh:mm:ss Z yyyy");
            Date originDate = sdfOriginalFormat.parse(originalTimeFormat);
            SimpleDateFormat sdfConvertedFormat = new SimpleDateFormat("hh:mm a',' MMM dd yyyy");
            String convertedDate = sdfConvertedFormat.format(originDate);

            tvSenderTimeStamp.setText(convertedDate);
        } catch (Exception e) {
            Log.e(TAG, "Error", e);
        }

        Glide.with(itemView.getContext())
                .load(sendToVO.getReceivedUser().getProfileImage())
                .into(ivReceiverProfile);
        tvReceiverName.setText(sendToVO.getReceivedUser().getUserName());

        try {
            String originalTimeFormat = sendToVO.getSentDate();
            SimpleDateFormat sdfOriginalFormat = new SimpleDateFormat("E MMM dd hh:mm:ss Z yyyy");
            Date originDate = sdfOriginalFormat.parse(originalTimeFormat);
            SimpleDateFormat sdfConvertedFormat = new SimpleDateFormat("hh:mm a',' MMM dd yyyy");
            String convertedDate = sdfConvertedFormat.format(originDate);

            tvReceiverTimeStamp.setText(convertedDate);
        } catch (Exception e) {
            Log.e(TAG, "Error", e);
        }
    }

}
