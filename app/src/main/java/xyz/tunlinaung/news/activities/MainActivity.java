package xyz.tunlinaung.news.activities;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ShareCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.tunlinaung.news.MMNewsApp;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.adapters.NewsAdapter;
import xyz.tunlinaung.news.data.models.LoginUserModel;
import xyz.tunlinaung.news.data.models.NewsModel;
import xyz.tunlinaung.news.data.vo.NewsVO;
import xyz.tunlinaung.news.delegates.BeforeLoginDelegate;
import xyz.tunlinaung.news.delegates.LoginUserDelegate;
import xyz.tunlinaung.news.delegates.NewsActionDelegate;
import xyz.tunlinaung.news.events.LoadedNewsEvent;
import xyz.tunlinaung.news.viewpods.AccountControlViewPod;
import xyz.tunlinaung.news.viewpods.BeforeLoginViewPod;

public class MainActivity extends AppCompatActivity implements NewsActionDelegate, BeforeLoginDelegate, LoginUserDelegate {

    @BindView(R.id.rv_news) RecyclerView rvNews;

    @BindView(R.id.toolbar) Toolbar toolbar;

    @BindView(R.id.fab) FloatingActionButton fab;

    @BindView(R.id.drawer_layout) DrawerLayout mDrawerLayout;

    @BindView(R.id.navigation_view) NavigationView mNavigationView;

    private NewsAdapter mNewsAdapter;

    AccountControlViewPod vpAccountControl;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this,this);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setHomeButtonEnabled(true);

            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            getSupportActionBar().setTitle(R.string.screen_title_all_news);
        }

        mNewsAdapter = new NewsAdapter(this);

        // TODO use GridLayoutManager to show 2 columns

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        rvNews.setLayoutManager(linearLayoutManager);
        rvNews.setAdapter(mNewsAdapter);

        mNavigationView.getMenu().findItem(R.id.menu_all_news).setChecked(true);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.menu_all_news) {
                    Intent intent = MainActivity.newIntent(getApplicationContext());
                    startActivity(intent);
                } else if (item.getItemId() == R.id.menu_news_by_categories) {
                    Intent intent = NewsByCategoryActivity.newIntent(getApplicationContext());
                    startActivity(intent);
                }

                mDrawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

        // get header layout from navigation view.
        vpAccountControl = (AccountControlViewPod) mNavigationView.getHeaderView(0);
        vpAccountControl.setDelegate((BeforeLoginDelegate) this);
        vpAccountControl.setDelegate((LoginUserDelegate) this);

        NewsModel.getObjInstance().loadNews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 100) {
            // request call phone permission.

            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                String numberToCall = "+959450042454";
                callToNumber(numberToCall);
            }
        }
    }

    @OnClick(R.id.fab)
    public void onTabFab(View view) {
        /*
        Snackbar.make(view, "Replace with your own action with ButterKnife", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
                */

        /*
        String numberToCall = "+959450042454";
        callToNumber(numberToCall);
        */
        showConfirmDialog();
    }

    private void showConfirmDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation")
                .setCancelable(false)
                .setMessage(getResources().getString(R.string.msg_to_exit,
                        LoginUserModel.getInstance(getApplicationContext()).getLoginUser().getName()))
                .setPositiveButton("Sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Snackbar.make(rvNews, "Ok, you will exit in hour.", Snackbar.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "This is right choice.", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void callToNumber(String numberToCall) {
        Intent phoneIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numberToCall));
        //phoneIntent.setData(Uri.parse("tel:" + "+959450042454"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, 100);
            return;
        }
        startActivity(phoneIntent);
    }

    @Override
    public void onTapNewsItem(NewsVO tappedNew) {
        Intent intent = NewsDetailsActivity.newIntent(this.getApplicationContext());
        intent.putExtra("news_id", tappedNew.getNewsId());
        startActivity(intent);
    }

    @Override
    public void onTapCommentButton() {

    }

    @Override
    public void onTapSendToButton(NewsVO mNew) {
        Intent shareIntent = ShareCompat.IntentBuilder
                                        .from(MainActivity.this)
                                        .setText(mNew.getBrief())
                                        .setType("text/plain")
                                        .getIntent();

        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(shareIntent);
        } else {
            Snackbar.make(rvNews, "No app to handle share actions", Snackbar.LENGTH_INDEFINITE).show();
        }

    }

    @Override
    public void onTapFavouriteButton() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsLoaded(LoadedNewsEvent event) {
        Log.d(MMNewsApp.LOG_TAG, "onNewsLoaded: " + event.getNewsList().size());
        mNewsAdapter.setNews(event.getNewsList());
    }

    @Override
    public void onTapToLogin() {
        Intent intent = AccountControlActivity.newIntentLogin(getApplicationContext());
        startActivity(intent);
    }

    @Override
    public void onTapToRegister() {
        Intent intent = AccountControlActivity.newIntentRegister(getApplicationContext());
        startActivity(intent);
    }

    @Override
    public void onTapLogout() {
        LoginUserModel.getInstance(getApplicationContext()).logout();
    }
}
