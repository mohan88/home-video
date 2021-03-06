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
import com.hobby.homevideo.R;
import com.hobby.homevideo.activity.VideoActivity;
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
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent) {
        final FrameLayout view = (FrameLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.presenter_object_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void bindViewHolder(final RecyclerView.ViewHolder viewHolder, final DataObject object) {
        if (!(viewHolder instanceof VideoViewHolder)) {
            // Error: Invalid viewholder type
            return;
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = v.getContext();
                final Intent intent = VideoActivity.createIntent(context, object);
                context.startActivity(intent);
            }
        });
        final VideoViewHolder videoViewHolder = (VideoViewHolder) viewHolder;
        Glide.with(viewHolder.itemView.getContext())
                .load(R.drawable.video)
                .into(videoViewHolder.getVideoThumbnail());
        videoViewHolder.getVideoTitle().setText(object.getTitle());
    }

    private static class VideoViewHolder extends RecyclerView.ViewHolder {

        public VideoViewHolder(View itemView) {
            super(itemView);
        }

        public ImageView getVideoThumbnail() {
            return (ImageView) itemView.findViewById(R.id.video_thumbnail);
        }

        public TextView getVideoTitle() {
            return (TextView) itemView.findViewById(R.id.video_title);
        }
    }
}
