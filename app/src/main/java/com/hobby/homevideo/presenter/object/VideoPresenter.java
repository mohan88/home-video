package com.hobby.homevideo.presenter.object;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hobby.homevideo.model.DataObject;
import com.hobby.homevideo.presenter.ObjectPresenter;

/**
 * Presenter for video types.
 */
public class VideoPresenter implements ObjectPresenter {

    private static final int TYPE_VIDEO = 2;

    @Override
    public boolean supports(int objectType) {
        return objectType == TYPE_VIDEO;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder() {
        return null;
    }

    @Override
    public void bindViewHolder(final RecyclerView.ViewHolder viewHolder, final DataObject object) {
        if (!(viewHolder instanceof VideoViewHolder)) {
            // Error: Invalid viewholder type
            return;
        }
    }

    private static class VideoViewHolder extends RecyclerView.ViewHolder {

        public VideoViewHolder(View itemView) {
            super(itemView);
        }
    }
}
