package com.team7.regengers.heroDetails;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.team7.regengers.R;
import com.team7.regengers.networking.JsonMediaResponse;
import com.team7.regengers.networking.JsonUrlsResponse;

import java.util.List;

public class NormalViewHolder extends RecyclerView.ViewHolder {

    private TextView textToRead;

    public NormalViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(String data, int pos, List<JsonMediaResponse> mediaLists, List<JsonUrlsResponse> extraUrls) {
        if (pos == 1) {
            textToRead = itemView.findViewById(R.id.hero_name);
            textToRead.setText(data);
        } else if (pos == 3) {
            textToRead = itemView.findViewById(R.id.hero_description);
            textToRead.setText(data);
        } else if (pos == 4) {
            ExpandableListView myExpandableList = itemView.findViewById(R.id.expanded_list);
            myExpandableList.setAdapter(new MyExpandableListAdapter(mediaLists, extraUrls, myExpandableList.getContext()));
        }

    }
}
