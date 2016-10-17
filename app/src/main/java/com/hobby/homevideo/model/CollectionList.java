package com.hobby.homevideo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class containing list of collections - simple class with getters.
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
