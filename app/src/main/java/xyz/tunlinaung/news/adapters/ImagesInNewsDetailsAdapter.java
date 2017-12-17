package xyz.tunlinaung.news.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.tunlinaung.news.viewitems.ImageInNewsDetailsViewItem;
import xyz.tunlinaung.news.R;

/**
 * Created by eidoshack on 12/10/17.
 */

public class ImagesInNewsDetailsAdapter extends PagerAdapter {

    @Override
    public int getCount()
    {
        return 6;
    }

    /* check that object is view type or not*/
    @Override
    public boolean isViewFromObject(View view, Object object)
    {
//        if (object instanceof View)
//            return true;
//        else
//            return false;

//        return (object instanceof View);

        return (view == (View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ImageInNewsDetailsViewItem view =
                (ImageInNewsDetailsViewItem) layoutInflater.inflate(R.layout.item_news_details_images,
                                                                    container, false);
        // manually put view to viewGroup (only for ViewPager)
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        container.removeView((View) object);

    }
}
