package xyz.tunlinaung.news.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.tunlinaung.news.MMNewsApp;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.adapters.NewsAdapter;
import xyz.tunlinaung.news.data.models.NewsModel;
import xyz.tunlinaung.news.data.vo.NewsVO;
import xyz.tunlinaung.news.delegates.NewsActionDelegate;
import xyz.tunlinaung.news.events.LoadedNewsEvent;
import xyz.tunlinaung.news.network.NewsDataAgent;

public class MainActivity extends AppCompatActivity implements NewsActionDelegate {

    @BindView(R.id.rv_news) RecyclerView rvNews;

    @BindView(R.id.toolbar) Toolbar toolbar;

    @BindView(R.id.fab) FloatingActionButton fab;

    private NewsAdapter mNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this,this);

        setSupportActionBar(toolbar);

        mNewsAdapter = new NewsAdapter(this);

        // TODO use GridLayoutManager to show 2 columns

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        rvNews.setLayoutManager(linearLayoutManager);
        rvNews.setAdapter(mNewsAdapter);

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
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void onTabFab(View view) {
        Snackbar.make(view, "Replace with your own action with ButterKnife", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
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
    public void onTapSendToButton() {

    }

    @Override
    public void onTapFavouriteButton() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsLoaded(LoadedNewsEvent event) {
        Log.d(MMNewsApp.LOG_TAG, "onNewsLoaded: " + event.getNewsList().size());
        mNewsAdapter.setNews(event.getNewsList());
    }
}
