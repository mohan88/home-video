package com.hobby.homevideo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * An extension of ImageView, this will resize and scale images according to the device size and aspect ratios.
 */
public class AspectRatioImageView extends ImageView {

    private int mWidthRatio;
    private int mHeightRatio;

    /**
     * Creates an instance of ResizableImageView.
     *
     * @param context The application context
     * @param attrs   The attribute set
     */
    public AspectRatioImageView(final Context context, final AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.AspectRatioImageView,
                0, 0);

        try {
            mWidthRatio = a.getInteger(R.styleable.AspectRatioImageView_widthRatio, 16);
            mHeightRatio = a.getInteger(R.styleable.AspectRatioImageView_heightRatio, 9);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {

        final int width = MeasureSpec.getSize(widthMeasureSpec);
        final int height = (width / mWidthRatio) * mHeightRatio;

        setMeasuredDimension(width, height);
    }
}
