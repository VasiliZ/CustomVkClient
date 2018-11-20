package com.github.vasiliz.customvkclient.entities.comments.sendComment;

import com.google.gson.annotations.SerializedName;

public class ResponseSendComment {

    @SerializedName("response")
    private ResponseAddComment mResponseAddComment;

    public ResponseSendComment() {
    }

    public ResponseAddComment getResponseAddComment() {
        return mResponseAddComment;
    }

    public void setResponseAddComment(ResponseAddComment pResponseAddComment) {
        mResponseAddComment = pResponseAddComment;
    }
}
