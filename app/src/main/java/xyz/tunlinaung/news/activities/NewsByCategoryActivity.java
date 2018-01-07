package xyz.tunlinaung.news.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.news.MMNewsApp;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.adapters.NewsByCategoryAdapter;
import xyz.tunlinaung.news.events.LoadedNewsEvent;
import xyz.tunlinaung.news.fragments.NewsByCategoryFragment;

/**
 * Created by eidoshack on 1/7/18.
 */

public class NewsByCategoryActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbarNewsByCategory;

    @BindView(R.id.vp_news_by_category) ViewPager vpNewsByCategory;

    @BindView(R.id.tb_news_by_category) TabLayout tbNewsByCategory;

    private NewsByCategoryAdapter mNewsByCategoryAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_by_category);

        ButterKnife.bind(this, this);

        setSupportActionBar(toolbarNewsByCategory);

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setHomeButtonEnabled(true);

            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            getSupportActionBar().setTitle(R.string.title_news_by_category);
        }

        mNewsByCategoryAdapter = new NewsByCategoryAdapter(getSupportFragmentManager());
        vpNewsByCategory.setAdapter(mNewsByCategoryAdapter);

        mNewsByCategoryAdapter.addTap("Local News", new NewsByCategoryFragment());
        mNewsByCategoryAdapter.addTap("International News", new NewsByCategoryFragment());
        mNewsByCategoryAdapter.addTap("Sport News", new NewsByCategoryFragment());

        tbNewsByCategory.setupWithViewPager(vpNewsByCategory);

    }

}
