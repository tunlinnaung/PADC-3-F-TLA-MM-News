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
import xyz.tunlinaung.news.adapters.CommentAdapter;
import xyz.tunlinaung.news.data.vo.CommentVO;

/**
 * Created by eidoshack on 2/6/18.
 */

public class CommentUsersDialog extends Dialog {

    @BindView(R.id.rv_comment_users)
    RecyclerView rvCommentUsers;

    private CommentAdapter mCommentAdapter;

    public CommentUsersDialog(@NonNull Context context, List<CommentVO> commentVoList) {
        super(context);
        setContentView(R.layout.dialog_comment_users);
        ButterKnife.bind(this, this);

        // set dialog to not close when clicking outside of dialog
        setCancelable(false);

        mCommentAdapter = new CommentAdapter();
        mCommentAdapter.setData(commentVoList);
        rvCommentUsers.setAdapter(mCommentAdapter);
        rvCommentUsers.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @OnClick(R.id.iv_close_dialog)
    public void onTapCloseDialog(View view) {
        dismiss();
    }

}
