package xyz.tunlinaung.news.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eidoshack on 12/17/17.
 */

public class SendToVO {

    @SerializedName("send-to-id")
    private String sentToId;
    @SerializedName("sent-date")
    private String sentDate;
    @SerializedName("acted-user")
    private ActedUserVO actedUser;
    @SerializedName("received-user")
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
