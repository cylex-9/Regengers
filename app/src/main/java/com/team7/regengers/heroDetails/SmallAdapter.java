package com.team7.regengers.heroDetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.team7.regengers.R;
import com.team7.regengers.networking.JsonMediaResponse;
import com.team7.regengers.networking.JsonUrlsResponse;

import java.util.List;

public class SmallAdapter extends RecyclerView.Adapter<ChildViewHolder> {

    private List<JsonMediaResponse> childList;
    private List<JsonUrlsResponse> urlsResponses;
    private int buttonPos;

    public SmallAdapter(List<JsonMediaResponse> childList, List<JsonUrlsResponse> urlsResponses, int pos){
        this.childList = childList;
        this.urlsResponses = urlsResponses;
        this.buttonPos = pos;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new ChildViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        if(buttonPos == 8) holder.bind(urlsResponses.get(position).getType());
        else holder.bind(childList.get(buttonPos-4).getItems().get(position).getName());
    }

    @Override
    public int getItemCount() {
        if(buttonPos == 8) return urlsResponses.size();
        else return childList.get(buttonPos-4).getReturned();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.holder_child_item_view;
    }
}
