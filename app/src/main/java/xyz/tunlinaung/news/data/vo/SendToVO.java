package xyz.tunlinaung.news.data.vo;

/**
 * Created by eidoshack on 12/17/17.
 */

public class SendToVO {

    private String sentToId;
    private String sentDate;
    private ActedUserVO actedUser;
    private ActedUserVO receivedUser;

    public String getSentToId() {
        return sentToId;
    }

    public String getSentDate() {
        return sentDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }

    public ActedUserVO getReceivedUser() {
        return receivedUser;
    }
}
