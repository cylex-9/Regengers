package com.team7.regengers;

import android.content.Intent;
import android.os.Bundle;
import android.os.HardwarePropertiesManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.team7.regengers.networking.NetworkActivity;


public class MainActivity extends BaseActivity {

    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void useUIElements() {

        ImageView regenLogo = findViewById(R.id.RevengersLogo);
        Button btnList = findViewById(R.id.ListButton);

        Button logInBtn = findViewById(R.id.logInBtn);
        Button homePageBtn=findViewById(R.id.homePageBtn);

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isDestroyed() || isFinishing()) {
                    return;
                }

                Intent toListIntent = new Intent(MainActivity.this, NetworkActivity.class);
                toListIntent.putExtra("currentPage","firstPage");
                startActivity(toListIntent);
            }
        });

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });


        homePageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void startOperations() {

    }

    @Override
    public void stopOperations() {

    }

}