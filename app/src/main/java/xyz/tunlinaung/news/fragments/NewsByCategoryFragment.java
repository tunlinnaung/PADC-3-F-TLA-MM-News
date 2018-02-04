package xyz.tunlinaung.news.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.news.MMNewsApp;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.activities.NewsDetailsActivity;
import xyz.tunlinaung.news.adapters.NewsAdapter;
import xyz.tunlinaung.news.data.models.NewsModel;
import xyz.tunlinaung.news.data.vo.NewsVO;
import xyz.tunlinaung.news.delegates.NewsActionDelegate;
import xyz.tunlinaung.news.events.LoadedNewsEvent;

/**
 * Created by eidoshack on 1/7/18.
 */

public class NewsByCategoryFragment extends Fragment implements NewsActionDelegate {

    @BindView(R.id.rv_news_by_category) RecyclerView rvNewsByCategory;

    private NewsAdapter mNewsByCategoryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_news_by_category, container, false);

        ButterKnife.bind(this, view);

        mNewsByCategoryAdapter = new NewsAdapter(this);
        rvNewsByCategory.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true));
        rvNewsByCategory.setAdapter(mNewsByCategoryAdapter);

        NewsModel.getObjInstance().loadNews();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onTapNewsItem(NewsVO tappedNew) {
        Intent intent = NewsDetailsActivity.newIntent(this.getContext());
        intent.putExtra("news_id", tappedNew.getNewsId());
        startActivity(intent);
    }

    @Override
    public void onTapCommentButton() {

    }

    @Override
    public void onTapSendToButton(NewsVO mNew) {

    }

    @Override
    public void onTapFavouriteButton() {

    }

    @Override
    public void onTapLikeUsers(NewsVO tappedNew) {

    }

    @Override
    public void onTapCommentUsers(NewsVO tappedNew) {

    }

    @Override
    public void onTapSendToUsers(NewsVO tappedNew) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsLoaded(LoadedNewsEvent event) {
        Log.d(MMNewsApp.LOG_TAG, "onNewsLoaded: " + event.getNewsList().size());
        mNewsByCategoryAdapter.setNews(event.getNewsList());
    }
}
