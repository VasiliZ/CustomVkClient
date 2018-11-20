package com.github.vasiliz.customvkclient.entities.comments;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContainerComment {
    @SerializedName("count")
    private int count;
    @SerializedName("items")
    private List<ItemComment> mItemComments;

    public ContainerComment() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int pCount) {
        count = pCount;
    }

    public List<ItemComment> getItemComments() {
        return mItemComments;
    }

    public void setItemComments(List<ItemComment> pItemComments) {
        mItemComments = pItemComments;
    }
}
