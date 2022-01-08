package com.team7.regengers.recyclerViewList;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.team7.regengers.R;
import com.team7.regengers.networking.JsonHeroResponse;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public interface OnItemClickListener {
        void onClick(View v, String data);
    }

    private List<JsonHeroResponse> arrayData;
    private OnItemClickListener listener;

    public MyAdapter(List<JsonHeroResponse> arrayData, OnItemClickListener listener) {
        this.arrayData = arrayData;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        Log.d("TAG", "oncreate viewType"+ viewType);
            return new MyViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        ImageView imageView =  holder.itemView.findViewById(R.id.holder_list_img);
        String data = arrayData.get(position).getName();
        String currentUrl = arrayData.get(position).getThumbnail().toString();
        Glide.with(holder.itemView.getContext())
                .load(currentUrl)
                .into(imageView);
        holder.bind(data);
        Log.d("TAG", "onBind position"+ position);

    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }

    @Override
    public int getItemViewType(int position) {
            return R.layout.holder_list_item;
    }

}
