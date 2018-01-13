package xyz.tunlinaung.news.data.models;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import xyz.tunlinaung.news.MMNewsApp;
import xyz.tunlinaung.news.data.vo.NewsVO;
import xyz.tunlinaung.news.events.LoadedNewsEvent;
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

    private Map<String, NewsVO> mNewsMap;

    private NewsModel() {
//        mNewsDataAgent = HttpUrlConnectionDataAgent.getObjInstance();     // with HttpURLDataAgent
//        mNewsDataAgent = OkHttpDataAgent.getInstance();                   // with OkHttpDataAgent
        mNewsDataAgent = RetrofitDataAgent.getInstance();
        mNewsMap = new HashMap<>();

        EventBus.getDefault().register(this);
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

    /**
     * get news object by news id
     * @param id
     * @return
     */
    public NewsVO getNewsById(String id) {
        return mNewsMap.get(id);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onNewsLoaded(LoadedNewsEvent event) {
        Log.d(MMNewsApp.LOG_TAG, "onNewsLoadedFromModel: " + event.getNewsList().size());

        for (NewsVO newsVO : event.getNewsList()) {
            mNewsMap.put(newsVO.getNewsId(), newsVO);
        }
    }
}
