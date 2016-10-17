package com.hobby.homevideo.presenter.initializer;

import com.hobby.homevideo.presenter.PresenterFactory;
import com.hobby.homevideo.presenter.PresenterInitializer;
import com.hobby.homevideo.presenter.collection.HorizontalCollectionPresenter;
import com.hobby.homevideo.presenter.collection.VerticalCollectionPresenter;
import com.hobby.homevideo.presenter.object.PicturePresenter;
import com.hobby.homevideo.presenter.object.VideoPresenter;

/**
 * Implementation of the PresenterInitializer.
 */
public class PresenterInitializerImpl implements PresenterInitializer {
    @Override
    public void initializePresenters(final PresenterFactory presenterFactory) {
        presenterFactory.addPresenter(new VerticalCollectionPresenter());
        presenterFactory.addPresenter(new HorizontalCollectionPresenter());
        presenterFactory.addPresenter(new PicturePresenter());
        presenterFactory.addPresenter(new VideoPresenter());
    }
}
