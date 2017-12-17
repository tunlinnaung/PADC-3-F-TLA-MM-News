package xyz.tunlinaung.news.data.vo;

/**
 * Created by eidoshack on 12/17/17.
 */

public class CommentVO {

    private String commentId;
    private String comment;
    private String commentDate;
    private ActedUserVO actedUsers;

    public String getCommentId() {
        return commentId;
    }

    public String getComment() {
        return comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public ActedUserVO getActedUsers() {
        return actedUsers;
    }
}
