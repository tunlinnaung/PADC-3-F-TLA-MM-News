package xyz.tunlinaung.news.data.vo;

import java.util.List;

/**
 * Created by eidoshack on 12/17/17.
 */

public class NewsVO {

    private String newsId;
    private String breif;
    private String details;
    private List<String> images;
    private String postedDate;
    private PublicationVO publications;
    private List<FavoriteVO> favorites;
    private List<CommentVO> comments;
    private List<SendToVO> sendTos;

    public String getNewsId() {
        return newsId;
    }

    public String getBreif() {
        return breif;
    }

    public String getDetails() {
        return details;
    }

    public List<String> getImages() {
        return images;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public PublicationVO getPublications() {
        return publications;
    }

    public List<FavoriteVO> getFavorites() {
        return favorites;
    }

    public List<CommentVO> getComments() {
        return comments;
    }

    public List<SendToVO> getSendTos() {
        return sendTos;
    }
}
