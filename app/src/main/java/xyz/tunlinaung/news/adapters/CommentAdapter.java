package xyz.tunlinaung.news.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.data.vo.CommentVO;
import xyz.tunlinaung.news.viewholders.ItemCommentViewHolder;

/**
 * Created by eidoshack on 2/6/18.
 */

public class CommentAdapter extends RecyclerView.Adapter<ItemCommentViewHolder> {

    List<CommentVO> mCommentVoList;

    public CommentAdapter() {
        mCommentVoList = new ArrayList<>();
    }

    @Override
    public ItemCommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View userView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comment_user, parent, false);
        ItemCommentViewHolder viewHolder = new ItemCommentViewHolder(userView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemCommentViewHolder holder, int position) {
        holder.setData(mCommentVoList.get(position));
    }

    @Override
    public int getItemCount() {
        return mCommentVoList.size();
    }

    public void setData(List<CommentVO> mCommentVoList) {
        this.mCommentVoList = mCommentVoList;
        notifyDataSetChanged();
    }

}
