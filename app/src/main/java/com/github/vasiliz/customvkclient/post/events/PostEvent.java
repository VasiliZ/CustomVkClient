package com.github.vasiliz.customvkclient.post.events;

import com.github.vasiliz.customvkclient.entities.comments.ResponseComment;

public class PostEvent {
    private String pError;
    private String mNewComment;
    private ResponseComment mResponseComment;
    private long mIdComment;

    public String getpError() {
        return pError;
    }

    public void setpError(String pPError) {
        pError = pPError;
    }

    public ResponseComment getResponseComment() {
        return mResponseComment;
    }

    public void setResponseComment(ResponseComment pResponseComment) {
        mResponseComment = pResponseComment;
    }

    public String getNewComment() {
        return mNewComment;
    }

    public void setNewComment(String pNewComment) {
        mNewComment = pNewComment;
    }

    public long getIdComment() {
        return mIdComment;
    }

    public void setIdComment(long pIdComment) {
        mIdComment = pIdComment;
    }
}
