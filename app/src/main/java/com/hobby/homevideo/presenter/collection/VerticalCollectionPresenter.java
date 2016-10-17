package com.hobby.homevideo.presenter.collection;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hobby.homevideo.R;
import com.hobby.homevideo.model.Collection;
import com.hobby.homevideo.presenter.CollectionPresenter;

/**
 * Presenter to display a vertical collection of objects.
 */
public class VerticalCollectionPresenter implements CollectionPresenter {

    private static final String TYPE_VERTICAL_COLLECTION = "vertical";

    @Override
    public boolean supports(final String collectionType) {
        return TYPE_VERTICAL_COLLECTION.equals(collectionType);
    }

    @Override
    public void present(final Collection collection, final ViewGroup parent) {
        final RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(parent.getContext()).inflate(R.layout.presenter_collection, null);
        GridLayoutManager layoutManager = new GridLayoutManager(parent.getContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        final RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = new CollectionAdapter(collection);
        recyclerView.setAdapter(adapter);
    }
}
