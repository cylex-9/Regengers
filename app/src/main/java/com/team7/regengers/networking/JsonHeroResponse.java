package com.team7.regengers.networking;

import java.io.Serializable;
import java.util.List;

public class JsonHeroResponse implements Serializable {

    private int id;
    private String name;
    private String description;
    private String modified;
    private JsonThumbnailResponse thumbnail;
    private String resourceURI;
    private JsonMediaResponse comics;
    private JsonMediaResponse series;
    private JsonMediaResponse stories;
    private JsonMediaResponse events;
    private List<JsonUrlsResponse> urls;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public JsonThumbnailResponse getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(JsonThumbnailResponse thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public JsonMediaResponse getComics() {
        return comics;
    }

    public void setComics(JsonMediaResponse comics) {
        this.comics = comics;
    }

    public JsonMediaResponse getSeries() {
        return series;
    }

    public void setSeries(JsonMediaResponse series) {
        this.series = series;
    }

    public JsonMediaResponse getStories() {
        return stories;
    }

    public void setStories(JsonMediaResponse stories) {
        this.stories = stories;
    }

    public JsonMediaResponse getEvents() {
        return events;
    }

    public void setEvents(JsonMediaResponse events) {
        this.events = events;
    }

    public List<JsonUrlsResponse> getUrls() {
        return urls;
    }

    public void setUrls(List<JsonUrlsResponse> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "JsonHeroResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", modified='" + modified + '\'' +
                ", thumbnail=" + thumbnail +
                ", resourceURI='" + resourceURI + '\'' +
                ", comics=" + comics +
                ", series=" + series +
                ", stories=" + stories +
                ", events=" + events +
                ", urls=" + urls +
                '}';
    }
}
