package com.hobby.homevideo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hobby.homevideo.R;
import com.hobby.homevideo.model.DataObject;

/**
 * Displays details page for a picture object.
 */
public class PictureActivity extends Activity {

    private DataObject mDataObject;

    public static Intent createIntent(final Context context, final DataObject dataObject) {
        final Intent intent = new Intent(context, PictureActivity.class);
        intent.putExtra("pictureObject", dataObject);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataObject = getIntent().getParcelableExtra("pictureObject");
        setContentView(R.layout.fragment_picture);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mDataObject != null) {
            final ImageView image = (ImageView) findViewById(R.id.image);
            final TextView title = (TextView) findViewById(R.id.title);
            final TextView description = (TextView) findViewById(R.id.description);
            Glide.with(this)
                    .load(R.drawable.picture)
                    .into(image);
            title.setText(mDataObject.getTitle());
            description.setText(mDataObject.getDescription());
        }
    }
}
