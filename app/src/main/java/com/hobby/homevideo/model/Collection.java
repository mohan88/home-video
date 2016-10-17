package com.hobby.homevideo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Collection - simple class with getters.
 */
public class Collection {

    private final String id;
    private final String type;
    private final String title;
    private final String description;
    private final List<DataObject> dataObjects = new ArrayList<>();

    public Collection(final String id, final String type, final String title, final String description,
                      final List<DataObject> dataObjects) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.description = description;
        this.dataObjects.addAll(dataObjects);
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<DataObject> getDataObjects() {
        return this.dataObjects;
    }
}
