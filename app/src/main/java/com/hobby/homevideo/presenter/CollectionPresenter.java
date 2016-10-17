package com.hobby.homevideo.presenter;

import android.content.Context;
import android.view.ViewGroup;

import com.hobby.homevideo.model.Collection;

/**
 * Presenter for collections.
 */
public interface CollectionPresenter {

    boolean supports(final String collectionType);

    void present(final Context context, final Collection collection, final ViewGroup parent);
}
