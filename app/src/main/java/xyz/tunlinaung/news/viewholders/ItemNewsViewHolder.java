package xyz.tunlinaung.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

    private NewsActionDelegate newsActionDelegate;

    private NewsVO mNew;

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

    public void setNews(NewsVO newsVO) {
        mNew = newsVO;

        this.tvPublicationTitle.setText(newsVO.getPublication().getTitle());
        this.tvPostedDate.setText(newsVO.getPostedDate());
        this.tvNewsBreif.setText(newsVO.getBrief());

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

}
