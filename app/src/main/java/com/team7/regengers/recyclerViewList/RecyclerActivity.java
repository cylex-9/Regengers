package com.team7.regengers.recyclerViewList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import com.team7.regengers.R;
import com.team7.regengers.networking.JsonHeroResponse;
import com.team7.regengers.networking.JsonResponse;
import com.team7.regengers.networking.NetworkActivity;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private List<JsonResponse> theResponse = new ArrayList<>();
    private static int currentPart = 0;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
    }

    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Make the activity and connect it to the right xml file.
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        // Also add anything else in that (such as these buttons)
        Button btnNext = findViewById(R.id.next_page_btn);
        Button btnPrev = findViewById(R.id.prev_page_btn);

        // Get the JSON file in a class made to handle it from NetworkActivity (or later possibly from storage)
        theResponse.add((JsonResponse) getIntent().getSerializableExtra("JsonResponse"));

        // Set whether or not the 'Previous' & 'Next' buttons are Visible, according to the page
        if(theResponse.get(currentPart).getData().getCount()!=100) btnNext.setVisibility(View.GONE);
        else if(theResponse.get(currentPart).getData().getOffset()==0) btnPrev.setVisibility(View.GONE);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isDestroyed() || isFinishing()) {
                    return;
                }

                // If 'Next' btn is pressed send string msg to increase page marker by 1
                Intent toNextIntent = new Intent(RecyclerActivity.this, NetworkActivity.class);
                toNextIntent.putExtra("currentPage","nextOne");
                startActivity(toNextIntent);
                finish();
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isDestroyed() || isFinishing()) {
                    return;
                }

                // If 'Previous' btn is pressed send string msg to decrease page marker by 1
                Intent toPrevIntent = new Intent(RecyclerActivity.this, NetworkActivity.class);
                toPrevIntent.putExtra("currentPage","previousOne");
                startActivity(toPrevIntent);
                finish();
            }
        });

        myAdapter = new MyAdapter(getDataList(), new MyAdapter.OnItemClickListener() {
            @Override
            public void onClick(View v, String data) {
                // Will add this later
            }
        });
        // Set an Adapter to handle the files
        recyclerView.setAdapter(myAdapter);
    }

    private List<JsonHeroResponse> getDataList() {
        List<JsonHeroResponse> list = new ArrayList<>();
        // Sends the right part of the list for the Adapter to showcase
        for (JsonHeroResponse h: theResponse.get(currentPart).getData().getResults()
             ) {
            list.add(h);
        }
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem menuItem = menu.findItem(R.id.search_action);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Search your favourite hero..");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                myAdapter.getFilter().filter(newText);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}