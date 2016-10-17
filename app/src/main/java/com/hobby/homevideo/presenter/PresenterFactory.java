package com.hobby.homevideo.presenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A factory that holds the available presenters and returns the appropriate one that is requested by type.
 */
public class PresenterFactory {

    private static PresenterFactory sPresenterFactory;
    private final List<CollectionPresenter> mCollectionPresenters = new ArrayList<>();
    private final List<ObjectPresenter> mObjectPresenters = new ArrayList<>();

    private PresenterFactory() {
    }

    public static synchronized PresenterFactory getInstance() {
        if (sPresenterFactory == null) {
            sPresenterFactory = new PresenterFactory();
        }
        return sPresenterFactory;
    }

    public CollectionPresenter getCollectionPresenter(final String type) {
        for (CollectionPresenter collectionPresenter : mCollectionPresenters) {
            if (collectionPresenter.supports(type)) {
                return collectionPresenter;
            }
        }
        return null;
    }

    public ObjectPresenter getObjectPresenter(final int type) {
        for (ObjectPresenter objectPresenter : mObjectPresenters) {
            if (objectPresenter.supports(type)) {
                return objectPresenter;
            }
        }
        return null;
    }

    public void addPresenter(final CollectionPresenter collectionPresenter) {
        mCollectionPresenters.add(collectionPresenter);
    }

    public void addPresenter(final ObjectPresenter objectPresenter) {
        mObjectPresenters.add(objectPresenter);
    }
}
