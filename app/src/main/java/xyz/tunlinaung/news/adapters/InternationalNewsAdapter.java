package xyz.tunlinaung.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.viewholders.ItemInternationalNewsViewHolder;

/**
 * Created by eidoshack on 1/18/18.
 */

public class InternationalNewsAdapter extends RecyclerView.Adapter<ItemInternationalNewsViewHolder> {
    @Override
    public ItemInternationalNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // layout id, binding parent, attach to parent
        View newsItemView = inflater.inflate(R.layout.item_international_news, parent, false);
        ItemInternationalNewsViewHolder viewHolder = new ItemInternationalNewsViewHolder(newsItemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemInternationalNewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
