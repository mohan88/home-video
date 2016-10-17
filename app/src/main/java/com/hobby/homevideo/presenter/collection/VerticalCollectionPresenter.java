package com.hobby.homevideo.presenter.collection;

import android.view.ViewGroup;

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

    }
}
