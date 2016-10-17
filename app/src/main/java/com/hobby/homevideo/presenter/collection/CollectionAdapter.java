package com.hobby.homevideo.presenter.collection;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.hobby.homevideo.model.Collection;
import com.hobby.homevideo.model.DataObject;
import com.hobby.homevideo.presenter.ObjectPresenter;
import com.hobby.homevideo.presenter.PresenterFactory;

import java.util.List;

/**
 * Adapter to handle display and recycling of the collection objects.
 */
public class CollectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<DataObject> mDataObjects;
    private final PresenterFactory presenterFactory = PresenterFactory.getInstance();

    public CollectionAdapter(final Collection collection) {
        mDataObjects = collection.getDataObjects();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final ObjectPresenter presenter = presenterFactory.getObjectPresenter(viewType);
        return presenter.onCreateViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final DataObject object = mDataObjects.get(position);
        presenterFactory.getObjectPresenter(object.getType()).bindViewHolder(holder, object);
    }

    @Override
    public int getItemCount() {
        return mDataObjects.size();
    }

    @Override
    public int getItemViewType(int position) {
        final DataObject dataObject = mDataObjects.get(position);
        return dataObject.getType();
    }
}
