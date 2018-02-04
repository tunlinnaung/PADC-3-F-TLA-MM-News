package xyz.tunlinaung.news.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.data.vo.FavoriteVO;
import xyz.tunlinaung.news.viewholders.ItemFavoriteViewHolder;

/**
 * Created by eidoshack on 2/4/18.
 */

public class FavoriteAdapter extends RecyclerView.Adapter<ItemFavoriteViewHolder> {

    private List<FavoriteVO> mFavoriteUsers;

    public FavoriteAdapter() {
        mFavoriteUsers = new ArrayList<>();
    }

    @Override
    public ItemFavoriteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View userView = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.item_user, parent, false);
        ItemFavoriteViewHolder itemFavoriteViewHolder = new ItemFavoriteViewHolder(userView);
        return itemFavoriteViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemFavoriteViewHolder holder, int position) {
        holder.setData(mFavoriteUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mFavoriteUsers.size();
    }

    public void setData(List<FavoriteVO> favoriteVOList) {
        mFavoriteUsers = favoriteVOList;
        notifyDataSetChanged();
    }

}
