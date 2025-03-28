package com.exemplu;

import java.util.List;

public class Image {
    private final String name;
    private final String date;
    private final List<String> tags;
    private final String path;

    public Image(String name, String date, List<String> tags, String path) {
        this.name = name;
        this.date = date;
        this.tags = tags;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getPath() {
        return path;
    }
}
