package com.team7.regengers.networking;

import java.io.Serializable;
import java.util.List;

public class JsonDataResponse implements Serializable {

    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<JsonHeroResponse> results;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<JsonHeroResponse> getResults() {
        return results;
    }

    public void setResults(List<JsonHeroResponse> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "JsonDataResponse{" +
                "offset=" + offset +
                ", limit=" + limit +
                ", total=" + total +
                ", count=" + count +
                ", results=" + results +
                '}';
    }
}
