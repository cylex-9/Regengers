package com.team7.regengers.recyclerViewList;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.GlideException;
import com.team7.regengers.R;

public class MyViewHolder extends BaseViewHolder {
    private MyAdapter.OnItemClickListener listener;

    public MyViewHolder(@NonNull View itemView, MyAdapter.OnItemClickListener listener) {
        super(itemView);
        this.listener = listener;
    }

    @Override
    public void bind(String data, String imgUrl) {
        TextView textView = itemView.findViewById(R.id.holder_list_txt);
        ImageView imageView =  itemView.findViewById(R.id.holder_list_img);

        Glide.with(itemView.getContext())
                .load(imgUrl)
                .into(imageView);

        textView.setText(data);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v, data);
            }
        });
    }
}
