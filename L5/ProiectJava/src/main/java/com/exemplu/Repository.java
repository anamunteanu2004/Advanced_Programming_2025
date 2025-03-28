package com.exemplu;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private final List<Image> images = new ArrayList<>();

    public void add(Image image) {
        images.add(image);
    }

    public Image findImageByName(String name) {
        return images.stream()
                .filter(img -> img.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Image> getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "Repository{" + "images=" + images + '}';
    }
}
