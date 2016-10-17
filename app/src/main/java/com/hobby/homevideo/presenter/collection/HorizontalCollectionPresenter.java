package com.hobby.homevideo.presenter.collection;

import android.view.ViewGroup;

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
    public void present(final Collection collection, final ViewGroup parent) {

    }
}
