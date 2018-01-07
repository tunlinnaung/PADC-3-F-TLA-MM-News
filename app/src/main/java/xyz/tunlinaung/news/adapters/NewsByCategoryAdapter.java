package xyz.tunlinaung.news.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eidoshack on 1/7/18.
 */

public class NewsByCategoryAdapter extends FragmentStatePagerAdapter {

    private List<String> mTabTitles;    // 1.tab title
    private List<Fragment> mFragments;  // 2.fragment (content)

    public NewsByCategoryAdapter(FragmentManager fm) {
        super(fm);
        mTabTitles = new ArrayList<>();
        mFragments = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles.get(position);
    }

    public void addTap(String tabTitle, Fragment fragment) {
        mTabTitles.add(tabTitle);
        mFragments.add(fragment);
        notifyDataSetChanged();
    }

}
