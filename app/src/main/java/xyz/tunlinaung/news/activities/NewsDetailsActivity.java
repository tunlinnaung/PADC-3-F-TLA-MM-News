package xyz.tunlinaung.news.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.adapters.ImagesInNewsDetailsAdapter;

/**
 * Created by eidoshack on 12/9/17.
 */

public class NewsDetailsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_details) Toolbar toolbar;

    @BindView(R.id.vp_news_details_images) ViewPager viewPager;

    private ImagesInNewsDetailsAdapter mImagesInNewsDetailsAdapter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, NewsDetailsActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        ButterKnife.bind(this, this);

        //setSupportActionBar(toolbar);

        // hide toolbar's title
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        mImagesInNewsDetailsAdapter = new ImagesInNewsDetailsAdapter();
        viewPager.setAdapter(mImagesInNewsDetailsAdapter);

    }
}
