package com.github.vasiliz.customvkclient.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseNews {
    @SerializedName("items")
    private List<Items> mItemsList;
    @SerializedName("profiles")
    private List<Profile> mProfileList;
    @SerializedName("groups")
    private List<Group> mGroupList;

    public ResponseNews() {
    }

    public ResponseNews(List<Items> pItemsList) {
        mItemsList = pItemsList;
    }

    public List<Items> getItemsList() {
        return mItemsList;
    }

    public void setItemsList(List<Items> pItemsList) {
        mItemsList = pItemsList;
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
