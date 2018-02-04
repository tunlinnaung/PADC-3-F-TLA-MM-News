package xyz.tunlinaung.news.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.tunlinaung.news.R;

/**
 * Created by eidoshack on 2/4/18.
 */

public class AddCommentDialog extends Dialog {

    public AddCommentDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_new_comment_users);
        ButterKnife.bind(this, this);
        setCancelable(false);
    }

    @OnClick(R.id.iv_close_dialog)
    public void onTapCloseDialog(View view) {
        dismiss();
    }

}
