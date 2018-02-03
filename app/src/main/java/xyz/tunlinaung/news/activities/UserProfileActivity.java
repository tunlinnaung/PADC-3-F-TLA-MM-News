package xyz.tunlinaung.news.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.tunlinaung.news.R;

/**
 * Created by eidoshack on 2/3/18.
 */

public class UserProfileActivity extends BaseActivity {

    @BindView(R.id.iv_login_user_photo)
    ImageView ivLoginUserPhoto;

    @BindView(R.id.iv_login_user_cover)
    ImageView ivLoginUserCover;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, UserProfileActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ButterKnife.bind(this, this);
    }

    @OnClick(R.id.iv_edit_cover)
    public void onTapEditProfileImage(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 300);
    }

    @OnClick(R.id.iv_edit_photo)
    public void onTapEditCoverImage(View view) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*"); // mime-type
        startActivityForResult(intent, 200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 200) {
            Uri originalUri = data.getData();
            Glide.with(getApplicationContext())
                    .load(originalUri)
                    .into(ivLoginUserPhoto);
        } else if (requestCode == 300) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ivLoginUserCover.setImageBitmap(photo);
        }
    }
}
