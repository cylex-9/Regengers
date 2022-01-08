package com.team7.regengers.networking;

import java.io.Serializable;

public class JsonThumbnailResponse implements Serializable {

    private String path;
    private String extension;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return  path + "." + extension;
    }
}
