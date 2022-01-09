package com.team7.regengers;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class SignUp extends AppCompatActivity {

    Button birthCalendar;
    DatePickerDialog.OnDateSetListener setListener;

    Button callSignUp;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        birthCalendar=findViewById(R.id.birthCalendar);

        final Calendar calendar= Calendar.getInstance();
        calendar.add(Calendar.YEAR, -12);
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);


        //birthday
        birthCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        SignUp.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,month,day);
                //datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
                datePickerDialog.show();
            }
        });

        setListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month;
                String date=day+"/"+month+"/"+year;
                birthCalendar.setText(date);
            }
        };
        //telos birthday


        callSignUp = findViewById(R.id.signUpBtn2);
        login=findViewById(R.id.logInBtn);

        callSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(SignUp.this,Home.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(SignUp.this, com.example.karafit.Login.class);
                startActivity(intent);
            }
        });
    }
}