package xyz.tunlinaung.news.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.adapters.FavoriteAdapter;
import xyz.tunlinaung.news.data.vo.FavoriteVO;

/**
 * Created by eidoshack on 2/4/18.
 */

public class LikeUsersDialog extends Dialog {

    @BindView(R.id.rv_like_users)
    RecyclerView rvLikeUsers;

    private FavoriteAdapter mFavoriteAdapter;

    public LikeUsersDialog(@NonNull Context context, List<FavoriteVO> favoriteVOList) {
        super(context);
        setContentView(R.layout.dialog_like_users);
        ButterKnife.bind(this, this);

        // set dialog to not close when clicking outside of dialog
        setCancelable(false);

        mFavoriteAdapter = new FavoriteAdapter();
        mFavoriteAdapter.setData(favoriteVOList);
        rvLikeUsers.setAdapter(mFavoriteAdapter);
        rvLikeUsers.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @OnClick(R.id.iv_close_dialog)
    public void onTapCloseDialog(View view) {
        dismiss();
    }

}
