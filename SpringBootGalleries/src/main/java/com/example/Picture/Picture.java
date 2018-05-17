package com.example.Picture;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Picture implements Serializable {
    int id;
    String time;
    String name;
    String resolution;
    Long size;

    public Picture(int id,String name, String resolution, Long size, String time,String path)
    {
        this.id = id;
        this.name = name;
        this.resolution = resolution;
        this.size = size;
        this.time = time;
        //this.path = path;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
