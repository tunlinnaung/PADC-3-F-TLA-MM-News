package xyz.tunlinaung.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.delegates.NewsActionDelegate;
import xyz.tunlinaung.news.viewholders.ItemNewsViewHolder;

/**
 * Created by eidoshack on 12/3/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<ItemNewsViewHolder> {

    private NewsActionDelegate newsActionDelegate;

    public NewsAdapter(NewsActionDelegate newsActionDelegate) {
        this.newsActionDelegate = newsActionDelegate;
    }

    @Override
    public ItemNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // layout id, binding parent, attach to parent
        View newsItemView = inflater.inflate(R.layout.item_news, parent, false);
        ItemNewsViewHolder itemNewsViewHolder = new ItemNewsViewHolder(newsItemView, newsActionDelegate);
        return itemNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemNewsViewHolder holder, int position)
    {

    }

    @Override
    public int getItemCount()
    {
        return 16;
    }
}
