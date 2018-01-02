package xyz.tunlinaung.news.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by eidoshack on 12/17/17.
 */

public class NewsVO {

    @SerializedName("news-id")
    private String newsId;
    private String brief;
    private String details;
    private List<String> images;
    @SerializedName("posted-date")
    private String postedDate;
    private PublicationVO publication;
    private List<FavoriteVO> favorites;
    private List<CommentVO> comments;
    @SerializedName("sent-tos")
    private List<SendToVO> sendTos;

    public String getNewsId() {
        return newsId;
    }

    public String getBrief() { return brief; }

    public String getDetails() { return details; }

    public List<String> getImages() {
        return images;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public PublicationVO getPublication() { return publication; }

    public List<FavoriteVO> getFavorites() { return favorites; }

    public List<CommentVO> getComments() {
        return comments;
    }

    public List<SendToVO> getSendTos() {
        return sendTos;
    }
}
