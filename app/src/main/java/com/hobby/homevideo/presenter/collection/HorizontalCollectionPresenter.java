package com.hobby.homevideo.presenter.collection;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

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
        addTitleView(collection, parent);
        final RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R.layout.presenter_collection, parent, false);
        GridLayoutManager layoutManager = new GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        parent.addView(recyclerView);
        final RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = new CollectionAdapter(collection);
        recyclerView.setAdapter(adapter);
    }

    private void addTitleView(final Collection collection, final ViewGroup parent) {
        final TextView titleView = new TextView(parent.getContext());
        titleView.setText(collection.getTitle());
        titleView.setPadding(25, 30, 25, 25);
        titleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        titleView.setTextColor(ContextCompat.getColor(parent.getContext(), android.R.color.black));
        titleView.setTypeface(Typeface.DEFAULT_BOLD);
        parent.addView(titleView);
    }
}
