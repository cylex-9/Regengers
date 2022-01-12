package com.team7.regengers.heroDetails;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.team7.regengers.R;

public class ChildViewHolder extends RecyclerView.ViewHolder {

    public ChildViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(String data){
        TextView textView = itemView.findViewById(R.id.child_view);
        textView.setText(data);
    }
}
