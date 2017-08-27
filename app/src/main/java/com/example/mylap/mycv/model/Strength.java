package com.example.mylap.mycv.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yalantis
 */
public class Strength {
    private int avatar;
    private String nickname;
    private int background;
    private String details;

    public Strength(int avatar, String nickname, int background, String details) {
        this.avatar = avatar;
        this.nickname = nickname;
        this.background = background;
        this.details = details;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public int getBackground() {
        return background;
    }

    public String getDetails() {
        return details;
    }
}
