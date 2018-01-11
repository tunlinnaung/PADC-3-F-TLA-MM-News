package xyz.tunlinaung.news.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.adapters.SportNewsItemsAdapter;

/**
 * Created by eidoshack on 1/11/18.
 */

public class ItemSportNewsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_sport_new_item_category)
    TextView tvSportNewItemCategory;

    @BindView(R.id.iv_sport_new_item_cover)
    ImageView ivSportNewItemCover;

    @BindView(R.id.tv_sport_new_item_title)
    TextView tvSportNewItemTitle;

    @BindView(R.id.tv_sport_new_item_app_title)
    TextView tvSportNewItemAppTitle;

    @BindView(R.id.rv_sport_news_items)
    RecyclerView rvSportNewsItems;

    private SportNewsItemsAdapter mSportNewsItemsAdapter;

    public ItemSportNewsViewHolder(View itemView)
    {
        super(itemView);

        ButterKnife.bind(this, itemView);

        mSportNewsItemsAdapter = new SportNewsItemsAdapter();
        rvSportNewsItems.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, true));
        rvSportNewsItems.setAdapter(mSportNewsItemsAdapter);

    }

}
