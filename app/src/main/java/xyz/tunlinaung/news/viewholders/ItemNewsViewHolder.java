package xyz.tunlinaung.news.viewholders;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.activities.NewsDetailsActivity;

/**
 * Created by eidoshack on 12/3/17.
 */

public class ItemNewsViewHolder extends RecyclerView.ViewHolder {

    public ItemNewsViewHolder(View itemView)
    {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }



    @OnClick(R.id.cv_news_item_root)
    public void onNewsItemTap(View itemView)
    {
        Toast.makeText(itemView.getContext(), "View item clicked.", Toast.LENGTH_SHORT).show();
        Intent intent = NewsDetailsActivity.newIntent(itemView.getContext());


    }

}
