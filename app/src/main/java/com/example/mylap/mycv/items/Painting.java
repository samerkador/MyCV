package com.example.mylap.mycv.items;

import android.content.res.Resources;
import android.content.res.TypedArray;

import com.example.mylap.mycv.R;


public class Painting {

    private final int imageId;
    private final String title;

    private Painting(int imageId, String title) {
        this.imageId = imageId;
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public static Painting[] getAllPaintings(Resources res) {

        String[] titles = res.getStringArray(R.array.paintings_titles);
        TypedArray images = res.obtainTypedArray(R.array.paintings_images);

        int size = titles.length;
        Painting[] paintings = new Painting[size];

        for (int i = 0; i < size; i++) {
            final int imageId = images.getResourceId(i, -1);
            paintings[i] = new Painting(imageId, titles[i]);
        }

        images.recycle();

        return paintings;
    }

}
