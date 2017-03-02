package zoodirectory.android.csulb.edu;

import java.io.Serializable;

/**
 * Created by LouisAudibert on 23/02/2017.
 */

public class AnimalModel implements Serializable {

    String name;
    String description;
    int image;

    public AnimalModel(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }
}