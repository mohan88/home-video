package com.hobby.homevideo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohan on 10/17/16.
 */

public class CollectionList {

    private List<Collection> collectionList = new ArrayList<>();

    public CollectionList(final List<Collection> collectionList) {
        this.collectionList.addAll(collectionList);
    }

    public List<Collection> getCollections() {
        return collectionList;
    }
}
