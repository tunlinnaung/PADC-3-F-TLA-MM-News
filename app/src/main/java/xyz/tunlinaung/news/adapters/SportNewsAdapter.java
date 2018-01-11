package xyz.tunlinaung.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.viewholders.ItemSportNewsViewHolder;

/**
 * Created by eidoshack on 1/11/18.
 */

public class SportNewsAdapter extends RecyclerView.Adapter<ItemSportNewsViewHolder> {
    @Override
    public ItemSportNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // layout id, binding parent, attach to parent
        View newsItemView = inflater.inflate(R.layout.item_sport_news, parent, false);
        ItemSportNewsViewHolder viewHolder = new ItemSportNewsViewHolder(newsItemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemSportNewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
