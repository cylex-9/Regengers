package com.team7.regengers;

import android.content.Intent;
import android.os.Bundle;
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

    }

    @Override
    public void startOperations() {

    }

    @Override
    public void stopOperations() {

    }

}