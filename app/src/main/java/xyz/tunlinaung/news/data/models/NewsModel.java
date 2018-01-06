package xyz.tunlinaung.news.data.models;

import xyz.tunlinaung.news.network.HttpUrlConnectionDataAgent;
import xyz.tunlinaung.news.network.NewsDataAgent;
import xyz.tunlinaung.news.network.OkHttpDataAgent;
import xyz.tunlinaung.news.network.RetrofitDataAgent;

/**
 * Created by eidoshack on 12/23/17.
 */

public class NewsModel {

    private static NewsModel sObjInstance;

    private NewsDataAgent mNewsDataAgent;

    private NewsModel() {
//        mNewsDataAgent = HttpUrlConnectionDataAgent.getObjInstance();     // with HttpURLDataAgent
//        mNewsDataAgent = OkHttpDataAgent.getInstance();
        mNewsDataAgent = RetrofitDataAgent.getInstance();
    }

    public static NewsModel getObjInstance()
    {
        // factory logic.
        if (sObjInstance == null)
        {
            sObjInstance = new NewsModel();
        }

        return sObjInstance;
    }

    /**
     * load news from network layer.
     */
    public void loadNews()
    {
        mNewsDataAgent.loadNews();
    }
}
