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
import xyz.tunlinaung.news.adapters.SendTosAdapter;
import xyz.tunlinaung.news.data.vo.SendToVO;

/**
 * Created by eidoshack on 2/6/18.
 */

public class SendTosUserDialog extends Dialog {

    @BindView(R.id.rv_sent_tos_users)
    RecyclerView rvSendTosUsers;

    private SendTosAdapter sendTosAdapter;

    public SendTosUserDialog(@NonNull Context context, List<SendToVO> sendToVOList) {
        super(context);
        setContentView(R.layout.dialog_send_tos_users);
        ButterKnife.bind(this, this);

        // set dialog to not close when clicking outside of dialog
        setCancelable(false);

        sendTosAdapter = new SendTosAdapter();
        sendTosAdapter.setData(sendToVOList);
        rvSendTosUsers.setAdapter(sendTosAdapter);
        rvSendTosUsers.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @OnClick(R.id.iv_close_dialog)
    public void onTapCloseDialog(View view) {
        dismiss();
    }

}
