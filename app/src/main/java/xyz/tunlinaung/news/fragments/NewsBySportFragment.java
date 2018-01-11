package xyz.tunlinaung.news.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.adapters.SportNewsAdapter;
import xyz.tunlinaung.news.adapters.SportNewsItemsAdapter;

/**
 * Created by eidoshack on 1/7/18.
 */

public class NewsBySportFragment extends Fragment {

    @BindView(R.id.rv_sport_news)
    RecyclerView rvSportNews;

    private SportNewsAdapter mSportNewsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_by_sport, container, false);

        ButterKnife.bind(this, view);

        mSportNewsAdapter = new SportNewsAdapter();
        rvSportNews.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true));
        rvSportNews.setAdapter(mSportNewsAdapter);

        return view;
    }
}
