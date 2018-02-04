package xyz.tunlinaung.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.data.vo.NewsVO;
import xyz.tunlinaung.news.delegates.NewsActionDelegate;

/**
 * Created by eidoshack on 12/3/17.
 */

public class ItemNewsViewHolder extends RecyclerView.ViewHolder {

    public static final String TAG = ItemNewsViewHolder.class.getSimpleName();

    @BindView(R.id.tv_publication_title)
    TextView tvPublicationTitle;

    @BindView(R.id.tv_publication_description)
    TextView tvPostedDate;

    @BindView(R.id.tv_news_brief)
    TextView tvNewsBreif;

    @BindView(R.id.iv_publication_logo)
    ImageView ivPulicationLogo;

    @BindView(R.id.iv_publication_image)
    ImageView ivPublicationImage;

    @BindView(R.id.tv_likes)
    TextView tvLikes;

    @BindView(R.id.tv_comments)
    TextView tvComments;

    @BindView(R.id.tv_send_tos)
    TextView tvSentTos;

    private NewsActionDelegate newsActionDelegate;

    private NewsVO mNew;

    public ItemNewsViewHolder(View itemView, NewsActionDelegate newsActionDelegate)
    {
        super(itemView);

        ButterKnife.bind(this, itemView);

        this.newsActionDelegate = newsActionDelegate;
        this.mNew = new NewsVO();
    }



    @OnClick(R.id.cv_news_item_root)
    public void onNewsItemTap(View itemView)
    {
        newsActionDelegate.onTapNewsItem(mNew);

    }

    @OnClick(R.id.fl_send_to)
    public void onTapSendTo(View view) {
        newsActionDelegate.onTapSendToButton(mNew);
    }

    public void setNews(NewsVO newsVO) {
        mNew = newsVO;

        this.tvPublicationTitle.setText(newsVO.getPublication().getTitle());
        this.tvPostedDate.setText(newsVO.getPostedDate());
        this.tvNewsBreif.setText(newsVO.getBrief());

        this.tvLikes.setText(
                tvLikes.getContext().getResources().getString(R.string.format_likes_users, newsVO.getFavorites().size()));
        this.tvComments.setText(
                tvComments.getContext().getResources().getString(R.string.format_comments_users, newsVO.getComments().size()));
        this.tvSentTos.setText(
                tvSentTos.getContext().getResources().getString(R.string.format_send_tos_users, newsVO.getSendTos().size()));

        Glide.with(ivPulicationLogo.getContext())
                .load(newsVO.getPublication().getLogo())
                .into(ivPulicationLogo);

        if (newsVO.getImages() != null) {
            ivPublicationImage.setVisibility(View.VISIBLE);
            Glide.with(ivPublicationImage.getContext())
                    .load(newsVO.getImages().get(0))
                    .into(ivPublicationImage);
        } else {
            ivPublicationImage.setVisibility(View.GONE);
        }

    }

    @OnClick(R.id.tv_likes)
    public void onTapLikeUsers(View view) {
        newsActionDelegate.onTapLikeUsers(mNew);
    }

    @OnClick(R.id.tv_comments)
    public void onTapCommentUsers(View view) {
        newsActionDelegate.onTapCommentUsers(mNew);
    }

    @OnClick(R.id.tv_send_tos)
    public void onTapSendToUsers(View view) {
        newsActionDelegate.onTapSendToUsers(mNew);
    }

    @OnClick(R.id.fl_comment)
    public void onTapAddComment(View view) {
        newsActionDelegate.onTapCommentButton();
    }

}
