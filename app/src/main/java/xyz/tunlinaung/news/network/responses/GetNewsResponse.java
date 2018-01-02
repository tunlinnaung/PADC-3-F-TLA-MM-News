package xyz.tunlinaung.news.network.responses;

import java.util.List;

import xyz.tunlinaung.news.data.vo.NewsVO;

/**
 * Created by eidoshack on 12/27/17.
 */

public class GetNewsResponse {

    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<NewsVO> mmNews;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<NewsVO> getMmNews() {
        return mmNews;
    }
}
