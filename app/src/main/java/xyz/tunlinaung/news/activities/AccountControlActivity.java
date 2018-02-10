package xyz.tunlinaung.news.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import xyz.tunlinaung.news.MMNewsApp;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.delegates.LoginScreenDelegate;
import xyz.tunlinaung.news.fragments.LoginFragment;
import xyz.tunlinaung.news.fragments.RegisterFragment;

/**
 * Created by eidoshack on 1/20/18.
 */

public class AccountControlActivity extends BaseActivity
                                    implements LoginScreenDelegate, GoogleApiClient.OnConnectionFailedListener {

    public static final String IE_SCREEN_TYPE    = "IE_SCREEN_TYPE";
    public static final int SCREEN_TYPE_LOGIN    = 1;
    public static final int SCREEN_TYPE_REGISTER = 2;

    Fragment fragment;

    GoogleApiClient mGoogleApiClient;

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

        setupGoogleApiClient();

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

    @Override
    public void onTapLoginWithGoogle() {
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(intent, 300);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 300) {

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

            if (result.isSuccess()) {
                GoogleSignInAccount account = result.getSignInAccount();
                Log.e(MMNewsApp.LOG_TAG, "onActivityResult: Google SignIn success : " + account.getDisplayName());
                Toast.makeText(getApplicationContext(), "Google SignIn success : " + account.getDisplayName(), Toast.LENGTH_SHORT).show();
            } else {
                Log.e(MMNewsApp.LOG_TAG, "onActivityResult: Google SignIn failed.");
                Toast.makeText(getApplicationContext(), "Google SignIn failed.", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void setupGoogleApiClient() {
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("646187821063-dd1spt984p7gcapkujk0eu0l1icfuc7l.apps.googleusercontent.com")
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(getApplicationContext())
                .enableAutoManage(this /*FragmentActivity*/, this /*onConnectionFailedListener*/)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();
    }

    /**
     * when client don't have google play service or disable.
     *
     * @param connectionResult
     */
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.e(MMNewsApp.LOG_TAG, "onConnectionFailed: " + connectionResult.getErrorMessage());
    }
}
