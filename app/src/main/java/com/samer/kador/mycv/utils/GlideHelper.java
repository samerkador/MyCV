package com.samer.kador.mycv.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.samer.kador.mycv.model.ProjectModel;

public class GlideHelper {

    private GlideHelper() {}

    public static void loadPaintingImage(ImageView image, ProjectModel projectModel) {
        Glide.with(image.getContext().getApplicationContext())
                .load(projectModel.getImageId())
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(image);
    }

}
