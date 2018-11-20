package com.github.vasiliz.customvkclient.entities.news;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseNews {
    @SerializedName("items")
    private List<Item> mItemList;
    @SerializedName("profiles")
    private List<Profile> mProfileList;
    @SerializedName("groups")
    private List<Group> mGroupList;

    public ResponseNews() {
    }

    public ResponseNews(List<Item> pItemList) {
        mItemList = pItemList;
    }

    public List<Item> getItemList() {
        return mItemList;
    }

    public void setItemList(List<Item> pItemList) {
        mItemList = pItemList;
    }

    public List<Profile> getProfileList() {
        return mProfileList;
    }

    public void setProfileList(List<Profile> pProfileList) {
        mProfileList = pProfileList;
    }

    public List<Group> getGroupList() {
        return mGroupList;
    }

    public void setGroupList(List<Group> pGroupList) {
        mGroupList = pGroupList;
    }
}
