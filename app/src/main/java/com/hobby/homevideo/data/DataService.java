package com.hobby.homevideo.data;

import android.content.Context;

import com.hobby.homevideo.model.Collection;
import com.hobby.homevideo.model.CollectionList;
import com.hobby.homevideo.model.DataObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to parse and return data from the json file.
 */
public class DataService {

    public CollectionList getHomeData(final Context context) {
        final String data = loadJSONFromAsset(context, "home.json");
        try {
            JSONObject jsonobject = new JSONObject(data);
            JSONArray jsonArray = jsonobject.getJSONArray("home");
            return parseCollectionList(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Collection getCategoryData(final Context context, final String fileName) {
        final String data = loadJSONFromAsset(context, fileName);
        try {
            JSONObject jsonobject = new JSONObject(data);
            JSONArray jsonArray = jsonobject.getJSONArray("home");
            final CollectionList collectionList = parseCollectionList(jsonArray);
            if (collectionList != null && !collectionList.getCollections().isEmpty()) {
                return collectionList.getCollections().get(0);
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private CollectionList parseCollectionList(final JSONArray jsonArray) throws JSONException {
        final List<Collection> collections = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            final JSONObject jsonObject = jsonArray.getJSONObject(i);
            collections.add(parseCollection(jsonObject));
        }
        return new CollectionList(collections);
    }

    private Collection parseCollection(final JSONObject collectionObject) throws JSONException {
        final String id = collectionObject.getString("id");
        final String type = collectionObject.getString("type");
        final String title = collectionObject.getString("title");
        final String description = collectionObject.getString("description");
        final JSONArray objectsArr = collectionObject.getJSONArray("dataObjects");
        final List<DataObject> objects = new ArrayList<>();
        for (int i = 0; i < objectsArr.length(); i++) {
            final JSONObject jsonObject = objectsArr.getJSONObject(i);
            objects.add(parseDataObject(jsonObject));
        }
        return new Collection(id, type, title, description, objects);
    }

    private DataObject parseDataObject(final JSONObject dataObject) throws JSONException {
        final String id = dataObject.getString("id");
        final int type = Integer.parseInt(dataObject.getString("type"));
        final String title = dataObject.getString("title");
        final String description = dataObject.getString("description");
        final Map<String, String> attributes = new HashMap<>();
        final String thumbnail = dataObject.optString("thumbnail", "");
        final String url = dataObject.optString("url", "");
        attributes.put("thumbnail", thumbnail);
        attributes.put("url", url);
        return new DataObject(id, type, title, description, attributes);
    }

    private String loadJSONFromAsset(final Context context, final String fileName) {
        String json;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
