package com.team7.regengers.heroDetails;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.team7.regengers.R;
import com.team7.regengers.networking.JsonMediaResponse;
import com.team7.regengers.networking.JsonUrlsResponse;
import com.team7.regengers.recyclerViewList.MyAdapter;

import java.util.List;

public class NormalViewHolder extends RecyclerView.ViewHolder {

    private NormalAdapter.OnItemClickListener listener;
    private boolean isIt;

    public NormalViewHolder(@NonNull View itemView, NormalAdapter.OnItemClickListener listener, boolean isIt) {
        super(itemView);
        this.listener = listener;
        this.isIt = isIt;
    }

    public void bind(String data, int pos) {
        TextView textToRead;
        if (pos == 1) {
            textToRead = itemView.findViewById(R.id.hero_name);
            textToRead.setText(data);
        } else if (pos == 3) {
            textToRead = itemView.findViewById(R.id.hero_description);
            if(data.isEmpty()) textToRead.setText("There's not a description for this hero or this group.");
            else textToRead.setText(data);
        } else {
            MaterialButton listButton = itemView.findViewById(R.id.expandable_list_button);
            RecyclerView childRec= itemView.findViewById(R.id.child_list);
            listButton.setText(data);
            listButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(v, pos, isIt, childRec);
                    if(isIt){
                        listButton.setIconResource(R.drawable.ic_baseline_expand_less_24);
                        isIt = false;
                    }
                    else {
                        listButton.setIconResource(R.drawable.ic_baseline_chevron_right_24);
                        isIt = true;
                    }
                }
            });
        }

    }
}
