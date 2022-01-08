package com.team7.regengers.recyclerViewList;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.team7.regengers.R;
import com.team7.regengers.networking.JsonHeroResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<BaseViewHolder> implements Filterable {


    public interface OnItemClickListener {
        void onClick(View v, String data);
    }

    private List<JsonHeroResponse> arrayData;
    private List<JsonHeroResponse> arrayDataFull;
    private OnItemClickListener listener;

    public MyAdapter(List<JsonHeroResponse> arrayData, OnItemClickListener listener) {
        this.arrayDataFull = arrayData;
        this.arrayData = new ArrayList<>(arrayDataFull);
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

    private final Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<JsonHeroResponse> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(arrayDataFull);
            }
            else {

                String filteredPattern = constraint.toString().toLowerCase().trim();

                for (JsonHeroResponse jsonHeroResponse : arrayDataFull){

                    if (jsonHeroResponse.getName().toLowerCase().contains(filteredPattern)){

                        filteredList.add(jsonHeroResponse);

                    }
                }

            }

            FilterResults results =new FilterResults();
            results.values = filteredList;
            results.count = filteredList.size();
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            arrayData.clear();
            arrayData.addAll((Collection<? extends JsonHeroResponse>) results.values);
            notifyDataSetChanged();

        }
    };

    @Override
    public Filter getFilter() {
        return filter;
    }

}
