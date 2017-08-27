package com.example.mylap.mycv.model;

import android.content.res.Resources;
import android.content.res.TypedArray;

import com.example.mylap.mycv.R;


public class Painting {

    private final int imageId;
    private final String title;

    private final String lang;
    private final String description;


    private Painting(int imageId, String title, String lang, String description) {
        this.imageId = imageId;
        this.title = title;
        this.lang = lang;
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }


    public String getLang() {
        return lang;
    }

    public String getDescription() {
        return description;
    }

    public static Painting[] getAllPaintings(Resources res) {

        String[] titles = res.getStringArray(R.array.paintings_titles);
        String[] langs = res.getStringArray(R.array.paintings_lang);
        String[] descriptions = res.getStringArray(R.array.paintings_description);
        TypedArray images = res.obtainTypedArray(R.array.paintings_images);

        int size = titles.length;
        Painting[] paintings = new Painting[size];

        for (int i = 0; i < size; i++) {
            final int imageId = images.getResourceId(i, -1);
            paintings[i] = new Painting(imageId, titles[i], langs[i], descriptions[i]);
        }

        images.recycle();

        return paintings;
    }

}
