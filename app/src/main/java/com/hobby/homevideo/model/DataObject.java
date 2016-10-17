package com.hobby.homevideo.model;

import java.util.Map;

/**
 * DataObject; simple class with getters
 */
public class DataObject {

    private final String id;
    private final int type;
    private final String title;
    private final String description;
    private final Map<String, String> attributes;

    public DataObject(final String id, final int type, final String title, final String description,
                      final Map<String, String> attributes) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.description = description;
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
