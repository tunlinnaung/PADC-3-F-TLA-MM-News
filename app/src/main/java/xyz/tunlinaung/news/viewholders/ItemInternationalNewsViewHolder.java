package xyz.tunlinaung.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.news.R;

/**
 * Created by eidoshack on 1/18/18.
 */

public class ItemInternationalNewsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_header_title)
    TextView tvInternationalText;

    @BindView(R.id.tv_news_time)
    TextView tvNewsTime;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    public ItemInternationalNewsViewHolder(View itemView)
    {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

}
