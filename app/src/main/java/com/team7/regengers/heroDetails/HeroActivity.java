package com.team7.regengers.heroDetails;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.team7.regengers.R;
import com.team7.regengers.networking.JsonHeroResponse;
import com.team7.regengers.networking.JsonMediaResponse;
import com.team7.regengers.recyclerViewList.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class HeroActivity extends AppCompatActivity {

    private JsonHeroResponse myHero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);

        myHero = (JsonHeroResponse) getIntent().getSerializableExtra("myHero");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        ImageView heroImg = findViewById(R.id.hero_image);
        RecyclerView myRecView = findViewById(R.id.scrolling_rec);
        myRecView.setAdapter(new NormalAdapter(myHero, new NormalAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, int pos, boolean isClicked, RecyclerView childRec) {
                if(isClicked) childRec.setVisibility(View.VISIBLE);
                else childRec.setVisibility(View.GONE);
                childRec.setAdapter(new SmallAdapter(mediaLists(myHero), myHero.getUrls(), pos));
            }
        }));

        String linkToImg = myHero.getThumbnail().toString();

        Glide.with(this)
                .load(linkToImg)
                .into(heroImg);

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