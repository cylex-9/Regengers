package com.team7.regengers.networking;

import java.io.Serializable;

public class JsonUrlsResponse implements Serializable {

    private String type;
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "JsonUrlsResponse{" +
                "type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
