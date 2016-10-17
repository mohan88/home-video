package com.hobby.homevideo.presenter;

/**
 * This initializer will only add those presenters which are required for the application.
 * Hence we can have multiple implementations of this interface to add different sets.
 */
public interface PresenterInitializer {

    void initializePresenters(final PresenterFactory presenterFactory);
}
