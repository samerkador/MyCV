package com.samer.kador.mycv.model;

import android.content.res.Resources;
import android.content.res.TypedArray;

import com.samer.kador.mycv.R;

import java.io.Serializable;


public class ProjectModel implements Serializable{

    private final int imageId;
    private final String title;

    private final String lang;
    private final String description;


    private ProjectModel(int imageId, String title, String lang, String description) {
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

    public static ProjectModel[] getAllProjects(Resources res) {

        String[] titles = res.getStringArray(R.array.paintings_titles);
        String[] langs = res.getStringArray(R.array.paintings_lang);
        String[] descriptions = res.getStringArray(R.array.paintings_description);
        TypedArray images = res.obtainTypedArray(R.array.paintings_images);

        int size = titles.length;
        ProjectModel[] projectModels = new ProjectModel[size];

        for (int i = 0; i < size; i++) {
            final int imageId = images.getResourceId(i, -1);
            projectModels[i] = new ProjectModel(imageId, titles[i], langs[i], descriptions[i]);
        }

        images.recycle();

        return projectModels;
    }

}
