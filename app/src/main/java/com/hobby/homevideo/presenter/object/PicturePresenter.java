package com.hobby.homevideo.presenter.object;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hobby.homevideo.AspectRatioImageView;
import com.hobby.homevideo.R;
import com.hobby.homevideo.fragment.PictureActivity;
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
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent) {
        final FrameLayout view = (FrameLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.presenter_object_picture, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void bindViewHolder(final RecyclerView.ViewHolder viewHolder, final DataObject object) {
        if (!(viewHolder instanceof PictureViewHolder)) {
            // Error: Invalid viewholder type
            return;
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = v.getContext();
                final Intent intent = PictureActivity.createIntent(context, object);
                context.startActivity(intent);
            }
        });
        final PictureViewHolder pictureViewHolder = (PictureViewHolder) viewHolder;
        Glide.with(viewHolder.itemView.getContext())
                .load(object.getAttributes().get("thumbnail"))
                .asBitmap()
                .into(pictureViewHolder.getPictureThumbnail());
        pictureViewHolder.getPictureTitle().setText(object.getTitle());
    }

    private static class PictureViewHolder extends RecyclerView.ViewHolder {

        public PictureViewHolder(View itemView) {
            super(itemView);
        }

        public AspectRatioImageView getPictureThumbnail() {
            return (AspectRatioImageView) itemView.findViewById(R.id.picture_thumbnail);
        }

        public TextView getPictureTitle() {
            return (TextView) itemView.findViewById(R.id.picture_title);
        }
    }
}
