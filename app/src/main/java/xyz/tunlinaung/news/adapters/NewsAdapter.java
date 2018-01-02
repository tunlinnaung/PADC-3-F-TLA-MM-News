package xyz.tunlinaung.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.data.vo.NewsVO;
import xyz.tunlinaung.news.delegates.NewsActionDelegate;
import xyz.tunlinaung.news.viewholders.ItemNewsViewHolder;

/**
 * Created by eidoshack on 12/3/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<ItemNewsViewHolder> {

    private NewsActionDelegate newsActionDelegate;
    private List<NewsVO> mNewsList;

    public NewsAdapter(NewsActionDelegate newsActionDelegate) {
        this.newsActionDelegate = newsActionDelegate;
        mNewsList = new ArrayList<>();
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
        holder.setNews(mNewsList.get(position));
    }

    @Override
    public int getItemCount()
    {
        return mNewsList.size();
    }

    public void setNews(List<NewsVO> newsList) {
        mNewsList = newsList;
        notifyDataSetChanged(); // call this method whenever data change at collection list.
    }
}
