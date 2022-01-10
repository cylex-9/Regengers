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

    private JsonHeroResponse myHero;

    public NormalAdapter(JsonHeroResponse myHero) {
        this.myHero = myHero;
    }

    @NonNull
    @Override
    public NormalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new NormalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NormalViewHolder holder, int position) {
        if (position == 0 || position == 2) {
        } else {
            holder.bind(heroStrings(myHero).get(position), position, mediaLists(myHero), myHero.getUrls());
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
            case 4:
                return R.layout.holder_item_view_expand_list;
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
        heroStrings.add("Extra Info");

        return heroStrings;
    }

    public List<JsonMediaResponse> mediaLists(JsonHeroResponse hero){
        List<JsonMediaResponse> mediaLists = new ArrayList<>();

        mediaLists.add(hero.getComics());
        mediaLists.add(hero.getSeries());
        mediaLists.add(hero.getStories());
        mediaLists.add(hero.getEvents());

        return mediaLists;
    }

}