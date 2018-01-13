package xyz.tunlinaung.news.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.adapters.ImagesInNewsDetailsAdapter;
import xyz.tunlinaung.news.data.models.NewsModel;
import xyz.tunlinaung.news.data.vo.NewsVO;

/**
 * Created by eidoshack on 12/9/17.
 */

public class NewsDetailsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_details) Toolbar toolbar;

    @BindView(R.id.vp_news_details_images) ViewPager viewPager;

    @BindView(R.id.tv_news_details)
    TextView tvNewsDetails;

    private ImagesInNewsDetailsAdapter mImagesInNewsDetailsAdapter;

    // first parameter is context that currently activity.
    // second parameter is class that intent want to communicate.
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

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

        // hide toolbar's title
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        mImagesInNewsDetailsAdapter = new ImagesInNewsDetailsAdapter();
        viewPager.setAdapter(mImagesInNewsDetailsAdapter);

        String newsId = getIntent().getStringExtra("news_id");
        NewsVO newsVO = NewsModel.getObjInstance().getNewsById(newsId);
        bindData(newsVO);
    }

    private void bindData(NewsVO newsVO) {
        tvNewsDetails.setText(newsVO.getDetails());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
