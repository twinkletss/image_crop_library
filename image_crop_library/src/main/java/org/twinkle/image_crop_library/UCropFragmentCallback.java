package org.twinkle.image_crop_library;

public interface UCropFragmentCallback {

    void loadingProgress(boolean showLoader);

    void onCropFinish(UCropFragment.UCropResult result);

}
