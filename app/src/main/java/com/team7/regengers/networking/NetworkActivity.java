package com.team7.regengers.networking;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.team7.regengers.R;
import com.team7.regengers.recyclerViewList.RecyclerActivity;

public class NetworkActivity extends AppCompatActivity {

    //All of the variables below are used for the url response
    private final int anum=225;
    private final String pubApiKey = "1e67da07410421fe7ec0cd67c7654e87";
    private final String myhash = "3e03f558bcd0b7f79d7725cb68e98355";
    private final int limit = 100;
    private int offset = 0;
    private static int i = 0;// page marker
    private static JsonResponse theResponse; //The JSON response to be sent to RecyclerActivity

    private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Get the string intent of anyone who calls this Activity
        String page = getIntent().getExtras().getString("currentPage");

        // Set the page marker value accordingly
        if(page.equalsIgnoreCase("nextOne")) i++;
        if(page.equalsIgnoreCase("previousOne")) i--;
        offset = i*limit; // use the marker to calculate the offset necessary for the finalUrl

        // Create the RequestQueue
        queue = Volley.newRequestQueue(this);

        String basicUrl = "https://gateway.marvel.com/v1/public/characters?";
        String finalUrl = basicUrl + "limit=" + limit + "&offset=" + offset + "&ts=" + anum + "&apikey=" + pubApiKey + "&hash=" + myhash;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, finalUrl,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("TAG", response);

                // Get the response from the request in the form of a JSON file, and handle it with the right class (made by you)
                theResponse = new Gson().fromJson(response, JsonResponse.class);

                // After getting the response file, send it to the RecyclerActivity
                Intent listIntent = new Intent(NetworkActivity.this, RecyclerActivity.class);
                listIntent.putExtra("JsonResponse", theResponse);
                startActivity(listIntent);
                finish();

            }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage());
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

}