package com.team7.regengers.heroDetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.team7.regengers.R;
import com.team7.regengers.networking.JsonHeroResponse;
import com.team7.regengers.networking.JsonMediaResponse;

import java.util.ArrayList;
import java.util.List;


public class NormalAdapter extends RecyclerView.Adapter<NormalViewHolder>  {

    public interface OnItemClickListener {
        void onClick(View v, int pos, boolean isClicked, RecyclerView rcv);
    }

    private JsonHeroResponse myHero;
    private OnItemClickListener listener;
    private boolean isClicked;

    public NormalAdapter(JsonHeroResponse myHero, OnItemClickListener listener) {
        this.myHero = myHero;
        this.listener = listener;
        this.isClicked = true;
    }

    @NonNull
    @Override
    public NormalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new NormalViewHolder(view, listener, isClicked);
    }

    @Override
    public void onBindViewHolder(@NonNull NormalViewHolder holder, int position) {
        if (position == 0 || position == 2) {
        } else {
            holder.bind(heroStrings(myHero).get(position), position);
        }
    }

    @Override
    public int getItemCount() {
        return heroStrings(myHero).size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return R.layout.holder_item_view_n_tag;
            case 1:
                return R.layout.holder_item_view_name;
            case 2:
                return R.layout.holder_item_view_d_tag;
            case 3:
                return R.layout.holder_item_view_desc;
            case 4: case 5: case 6: case 7: case 8:
                return R.layout.holder_parent_item_view;
            default:
                return -1;
        }
    }

    public List<String> heroStrings(JsonHeroResponse hero) {
        List<String> heroStrings = new ArrayList<>();

        heroStrings.add("Hero Name: ");
        heroStrings.add(hero.getName());
        heroStrings.add("Description: ");
        heroStrings.add(hero.getDescription());
        heroStrings.add("Comics");
        heroStrings.add("Series");
        heroStrings.add("Stories");
        heroStrings.add("Events");
        heroStrings.add("Urls");

        return heroStrings;
    }

}