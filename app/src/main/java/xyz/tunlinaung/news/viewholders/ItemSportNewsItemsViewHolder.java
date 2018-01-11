package xyz.tunlinaung.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.news.R;

/**
 * Created by eidoshack on 1/11/18.
 */

public class ItemSportNewsItemsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_sport_new_subitem_image)
    ImageView rvSportNewSubItemImage;

    @BindView(R.id.tv_sport_new_subitem_title)
    TextView tvSportNewSubItemTitle;

    @BindView(R.id.tv_sport_new_subitem_app_title)
    TextView tvSportNewSubItemAppTitle;


    public ItemSportNewsItemsViewHolder(View itemView)
    {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

}
