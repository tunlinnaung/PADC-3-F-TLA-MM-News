package xyz.tunlinaung.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.viewholders.ItemSportNewsItemsViewHolder;

/**
 * Created by eidoshack on 1/11/18.
 */

public class SportNewsItemsAdapter extends RecyclerView.Adapter<ItemSportNewsItemsViewHolder> {
    @Override
    public ItemSportNewsItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // layout id, binding parent, attach to parent
        View newsItemView = inflater.inflate(R.layout.item_sport_news_items, parent, false);
        ItemSportNewsItemsViewHolder viewHolder = new ItemSportNewsItemsViewHolder(newsItemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemSportNewsItemsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
