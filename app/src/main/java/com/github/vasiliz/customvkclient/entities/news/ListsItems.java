package com.github.vasiliz.customvkclient.entities.news;

import java.util.List;

public interface ListsItems<T extends Attachment> {

    List<List<T>> getAttach();

    void compareAttach(T pT);

    void setItem(T pItem);
}
