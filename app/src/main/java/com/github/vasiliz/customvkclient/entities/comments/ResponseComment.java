package com.github.vasiliz.customvkclient.entities.comments;

import com.google.gson.annotations.SerializedName;

public class ResponseComment {

    @SerializedName("response")
    private ContainerComment mContainerComment;

    public ResponseComment() {
    }

    public ContainerComment getContainerComment() {
        return mContainerComment;
    }

    public void setContainerComment(ContainerComment pContainerComment) {
        mContainerComment = pContainerComment;
    }
}
