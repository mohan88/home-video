package com.hobby.homevideo.presenter.collection;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hobby.homevideo.R;
import com.hobby.homevideo.model.Collection;
import com.hobby.homevideo.presenter.CollectionPresenter;

/**
 * Presenter to display a horizontal collection of objects.
 */
public class HorizontalCollectionPresenter implements CollectionPresenter {

    private static final String TYPE_HORIZONTAL_COLLECTION = "horizontal";

    @Override
    public boolean supports(final String collectionType) {
        return TYPE_HORIZONTAL_COLLECTION.equals(collectionType);
    }

    @Override
    public void present(final Context context, final Collection collection, final ViewGroup parent) {
        final RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R.layout.presenter_collection, null);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        final RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = new CollectionAdapter(collection);
        recyclerView.setAdapter(adapter);
        parent.addView(recyclerView);
    }
}
