package com.example.nguyentruonghung1150070013_thb4_truyencuoi;

import java.io.Serializable;

public class Zodiac implements Serializable {
    private final String name;
    private final String date;
    private final String shortDesc;
    private final String longDesc;
    private final int iconRes;

    public Zodiac(String name, String date, String shortDesc, String longDesc, int iconRes) {
        this.name = name;
        this.date = date;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.iconRes = iconRes;
    }

    public String getDisplayName() {
        return name + " (" + date + ")";
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public int getIconRes() {
        return iconRes;
    }
}
