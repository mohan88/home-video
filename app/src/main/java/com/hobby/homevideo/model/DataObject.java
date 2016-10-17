package com.hobby.homevideo.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

/**
 * DataObject; simple class with getters
 */
public class DataObject implements Parcelable {

    private final String id;
    private final int type;
    private final String title;
    private final String description;
    private final Map<String, String> attributes = new HashMap<>();

    public DataObject(final String id, final int type, final String title, final String description,
                      final Map<String, String> attributes) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.description = description;
        this.attributes.putAll(attributes);
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

    protected DataObject(Parcel in) {
        id = in.readString();
        type = in.readInt();
        title = in.readString();
        description = in.readString();
        final int size = in.readInt();
        for (int i = 0; i < size; i++) {
            final String key = in.readString();
            final String value = in.readString();
            attributes.put(key, value);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeInt(type);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(attributes.size());
        for (final Map.Entry<String, String> entry : attributes.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeString(entry.getValue());
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<DataObject> CREATOR = new Parcelable.Creator<DataObject>() {
        @Override
        public DataObject createFromParcel(Parcel in) {
            return new DataObject(in);
        }

        @Override
        public DataObject[] newArray(int size) {
            return new DataObject[size];
        }
    };
}
