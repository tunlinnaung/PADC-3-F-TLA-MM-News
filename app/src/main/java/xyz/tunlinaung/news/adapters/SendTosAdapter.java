package xyz.tunlinaung.news.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.data.vo.CommentVO;
import xyz.tunlinaung.news.data.vo.SendToVO;
import xyz.tunlinaung.news.viewholders.ItemSendTosViewHolder;

/**
 * Created by eidoshack on 2/6/18.
 */

public class SendTosAdapter extends RecyclerView.Adapter<ItemSendTosViewHolder> {

    private List<SendToVO> sendToVOList;

    public SendTosAdapter() {
        sendToVOList = new ArrayList<>();
    }

    @Override
    public ItemSendTosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View userView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_send_tos_user, parent, false);
        ItemSendTosViewHolder viewHolder = new ItemSendTosViewHolder(userView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemSendTosViewHolder holder, int position) {
        holder.setData(sendToVOList.get(position));
    }

    @Override
    public int getItemCount() {
        return sendToVOList.size();
    }

    public void setData(List<SendToVO> sendToVOList) {
        this.sendToVOList = sendToVOList;
        notifyDataSetChanged();
    }

}
