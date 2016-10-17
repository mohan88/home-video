package com.hobby.homevideo.presenter.object;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hobby.homevideo.model.DataObject;
import com.hobby.homevideo.presenter.ObjectPresenter;

/**
 * Presenter for picture types.
 */
public class PicturePresenter implements ObjectPresenter {

    private static final int TYPE_PICTURE = 1;

    @Override
    public boolean supports(final int objectType) {
        return objectType == TYPE_PICTURE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder() {
        return null;
    }

    @Override
    public void bindViewHolder(final RecyclerView.ViewHolder viewHolder, final DataObject object) {
        if (!(viewHolder instanceof PictureViewHolder)) {
            // Error: Invalid viewholder type
            return;
        }

    }

    private static class PictureViewHolder extends RecyclerView.ViewHolder {

        public PictureViewHolder(View itemView) {
            super(itemView);
        }
    }
}
