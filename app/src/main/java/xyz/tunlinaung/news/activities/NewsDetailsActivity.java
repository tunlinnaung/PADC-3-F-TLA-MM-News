package xyz.tunlinaung.news.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.adapters.ImagesInNewsDetailsAdapter;
import xyz.tunlinaung.news.data.models.NewsModel;
import xyz.tunlinaung.news.data.vo.NewsVO;

/**
 * Created by eidoshack on 12/9/17.
 */

public class NewsDetailsActivity extends BaseActivity {

    @BindView(R.id.toolbar_details) Toolbar toolbar;

    @BindView(R.id.vp_news_details_images) ViewPager viewPager;

    @BindView(R.id.tv_news_details)
    TextView tvNewsDetails;

    @BindView(R.id.tv_publication_title)
    TextView tvPublicationTitle;

    @BindView(R.id.tv_posted_date)
    TextView tvPostedDate;

    @BindView(R.id.iv_publication_logo)
    ImageView ivPublicationLogo;

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

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setHomeButtonEnabled(true);

            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        mImagesInNewsDetailsAdapter = new ImagesInNewsDetailsAdapter();
        viewPager.setAdapter(mImagesInNewsDetailsAdapter);

        String newsId = getIntent().getStringExtra("news_id");
        NewsVO newsVO = NewsModel.getObjInstance().getNewsById(newsId);
        bindData(newsVO);
    }

    private void bindData(NewsVO newsVO) {
        tvNewsDetails.setText(newsVO.getDetails());
        this.tvPublicationTitle.setText(newsVO.getPublication().getTitle());
        this.tvPostedDate.setText(newsVO.getPostedDate());

        Glide.with(ivPublicationLogo.getContext())
                .load(newsVO.getPublication().getLogo())
                .into(ivPublicationLogo);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
