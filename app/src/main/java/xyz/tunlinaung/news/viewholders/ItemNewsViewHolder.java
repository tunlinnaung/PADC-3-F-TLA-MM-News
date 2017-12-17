package xyz.tunlinaung.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.delegates.NewsActionDelegate;

/**
 * Created by eidoshack on 12/3/17.
 */

public class ItemNewsViewHolder extends RecyclerView.ViewHolder {

    private NewsActionDelegate newsActionDelegate;

    public ItemNewsViewHolder(View itemView, NewsActionDelegate newsActionDelegate)
    {
        super(itemView);

        ButterKnife.bind(this, itemView);

        this.newsActionDelegate = newsActionDelegate;
    }



    @OnClick(R.id.cv_news_item_root)
    public void onNewsItemTap(View itemView)
    {
        newsActionDelegate.onTapNewsItem();

    }

}
