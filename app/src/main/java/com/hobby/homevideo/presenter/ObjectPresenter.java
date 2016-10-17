package com.hobby.homevideo.presenter;

import android.support.v7.widget.RecyclerView;

import com.hobby.homevideo.model.DataObject;

/**
 * Presenter for individual objects.
 */
public interface ObjectPresenter {

    boolean supports(final int objectType);

    RecyclerView.ViewHolder onCreateViewHolder();

    void bindViewHolder(final RecyclerView.ViewHolder viewHolder, final DataObject object);
}
