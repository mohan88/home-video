package com.hobby.homevideo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.hobby.homevideo.R;
import com.hobby.homevideo.model.DataObject;

/**
 * Video player.
 */
public class VideoActivity extends Activity {

    private DataObject mDataObject;

    public static Intent createIntent(final Context context, final DataObject dataObject) {
        final Intent intent = new Intent(context, VideoActivity.class);
        intent.putExtra("videoObject", dataObject);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataObject = getIntent().getParcelableExtra("videoObject");
        setContentView(R.layout.fragment_video);
    }

    @Override
    public void onResume() {
        super.onResume();
        final VideoView videoView = (VideoView) findViewById(R.id.video_view);
        videoView.setZOrderOnTop(true);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        if (mDataObject != null) {
            final String videoUrl = mDataObject.getAttributes().get("url");
            videoView.setVideoURI(Uri.parse(videoUrl));
            videoView.requestFocus();
            videoView.start();
        }
    }
}
