package xyz.tunlinaung.news.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.delegates.LoginScreenDelegate;
import xyz.tunlinaung.news.fragments.LoginFragment;
import xyz.tunlinaung.news.fragments.RegisterFragment;

/**
 * Created by eidoshack on 1/20/18.
 */

public class AccountControlActivity extends AppCompatActivity implements LoginScreenDelegate {

    public static final String IE_SCREEN_TYPE    = "IE_SCREEN_TYPE";
    public static final int SCREEN_TYPE_LOGIN    = 1;
    public static final int SCREEN_TYPE_REGISTER = 2;

    Fragment fragment;

    public static Intent newIntentLogin(Context context)
    {
        Intent intent = new Intent(context, AccountControlActivity.class);
        intent.putExtra(IE_SCREEN_TYPE, SCREEN_TYPE_LOGIN);
        return intent;
    }

    public static Intent newIntentRegister(Context context)
    {
        Intent intent = new Intent(context, AccountControlActivity.class);
        intent.putExtra(IE_SCREEN_TYPE, SCREEN_TYPE_REGISTER);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_control);

        ButterKnife.bind(this, this);

        int screenType = getIntent().getIntExtra(IE_SCREEN_TYPE, -1);
        if (screenType == SCREEN_TYPE_LOGIN) {
            fragment = new LoginFragment();
        } else if (screenType == SCREEN_TYPE_REGISTER) {
            fragment = new RegisterFragment();
        }

        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.fl_container, fragment)
                                   .commit();
    }

    @Override
    public void onTapToRegister() {
        getSupportFragmentManager().beginTransaction()
                                   .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                                   .replace(R.id.fl_container, new RegisterFragment())
                                   .addToBackStack("ToRegister")
                                   .commit();
    }
}
