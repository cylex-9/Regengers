package com.team7.regengers.networking;

import java.io.Serializable;
import java.util.List;

public class JsonMediaResponse implements Serializable {

    private int available;
    private String collectionURI;
    private List<JsonItemResponse> items;
    private int returned;

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<JsonItemResponse> getItems() {
        return items;
    }

    public void setItems(List<JsonItemResponse> items) {
        this.items = items;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "JsonMediaResponse{" +
                "available=" + available +
                ", collectionURI='" + collectionURI + '\'' +
                ", items=" + items +
                ", returned=" + returned +
                '}';
    }
}
