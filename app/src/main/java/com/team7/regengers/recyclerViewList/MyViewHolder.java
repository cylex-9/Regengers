package com.team7.regengers.recyclerViewList;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.team7.regengers.R;

public class MyViewHolder extends BaseViewHolder {
    private MyAdapter.OnItemClickListener listener;

    public MyViewHolder(@NonNull View itemView, MyAdapter.OnItemClickListener listener) {
        super(itemView);
        this.listener = listener;
    }

    @Override
    public void bind(String data) {
        TextView textView = itemView.findViewById(R.id.holder_list_txt);
        textView.setText(data);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v, data);
            }
        });
    }
}
