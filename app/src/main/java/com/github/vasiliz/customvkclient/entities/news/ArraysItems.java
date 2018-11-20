package com.github.vasiliz.customvkclient.entities.news;

import java.util.ArrayList;
import java.util.List;

public class ArraysItems implements ListsItems {

    private List<List<Attachment>> mLists = new ArrayList<>();
    List<Attachment> photos = new ArrayList<>();
    List<Attachment> audio = new ArrayList<>();
    List<Attachment> video = new ArrayList<>();

    public void endOnStruct() {
        if (!photos.isEmpty()) {
            mLists.add(photos);
        }

       /* if (!video.isEmpty()) {
            mLists.add(video);
        }*/

        if (!audio.isEmpty()) {
            mLists.add(audio);
        }
    }

    @Override
    public List<List<Attachment>> getAttach() {
        return mLists;
    }

    @Override
    public void compareAttach(Attachment pAttachment) {
        if (pAttachment.getTypeAttachments().equals("photo")){
            photos.add(pAttachment.getPhoto());
        }

        if (pAttachment.getTypeAttachments().equals("audio")){
            audio.add(pAttachment.getAudio());
        }

    }

    @Override
    public void setItem(Attachment pItem) {
        compareAttach(pItem);

    }
}
