package xyz.tunlinaung.news.events;

import java.util.List;

import xyz.tunlinaung.news.data.vo.NewsVO;

/**
 * Created by eidoshack on 12/27/17.
 */

public class LoadedNewsEvent {

    private List<NewsVO> newsList;

    public LoadedNewsEvent(List<NewsVO> newsList) {
        this.newsList = newsList;
    }

    public List<NewsVO> getNewsList() {
        return newsList;
    }
}
