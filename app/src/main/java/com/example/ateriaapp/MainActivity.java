package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {
    LocalDate date = LocalDate.now();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("aa", "date on" + date);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
