package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AteriaNakyma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ateria_nakyma);

        Intent intent = getIntent();
        String date = intent.getStringExtra("date");

        TextView dateview = (TextView) findViewById(R.id.dateView);
        dateview.setText(date);
    }
}
