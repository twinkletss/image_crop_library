package org.twinkle.image_crop_library.callback;

import android.graphics.RectF;

public interface OverlayViewChangeListener {

    void onCropRectUpdated(RectF cropRect);

}