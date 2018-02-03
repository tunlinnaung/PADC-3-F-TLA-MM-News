package xyz.tunlinaung.news.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.news.MMNewsApp;
import xyz.tunlinaung.news.R;
import xyz.tunlinaung.news.adapters.NewsByCategoryAdapter;
import xyz.tunlinaung.news.events.LoadedNewsEvent;
import xyz.tunlinaung.news.fragments.NewsByCategoryFragment;
import xyz.tunlinaung.news.fragments.NewsByInternaltionalFragment;
import xyz.tunlinaung.news.fragments.NewsBySportFragment;

/**
 * Created by eidoshack on 1/7/18.
 */

public class NewsByCategoryActivity extends BaseActivity {

    @BindView(R.id.toolbar) Toolbar toolbarNewsByCategory;

    @BindView(R.id.vp_news_by_category) ViewPager vpNewsByCategory;

    @BindView(R.id.tb_news_by_category) TabLayout tbNewsByCategory;

    @BindView(R.id.navigation_view) NavigationView navigationView;

    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;

    private NewsByCategoryAdapter mNewsByCategoryAdapter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, NewsByCategoryActivity.class);
        return intent;
    }

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
        mNewsByCategoryAdapter.addTap("International News", new NewsByInternaltionalFragment());
        mNewsByCategoryAdapter.addTap("Sport News", new NewsBySportFragment());

        tbNewsByCategory.setupWithViewPager(vpNewsByCategory);

        vpNewsByCategory.setOffscreenPageLimit(mNewsByCategoryAdapter.getCount());

        navigationView.getMenu().findItem(R.id.menu_news_by_categories).setChecked(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.menu_all_news) {
                    Intent intent = MainActivity.newIntent(getApplicationContext());
                    startActivity(intent);
                } else if (item.getItemId() == R.id.menu_news_by_categories) {
                    Intent intent = NewsByCategoryActivity.newIntent(getApplicationContext());
                    startActivity(intent);
                }

                // to close drawer layout from left menu
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

    }

    // screen back button to be working.
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
