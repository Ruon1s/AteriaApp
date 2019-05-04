package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class lisaaAteria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisaa_ateria);

        Intent intent = getIntent();
        String date = intent.getStringExtra("date");

        TextView dateview = (TextView) findViewById(R.id.dateView);
        dateview.setText(date);
    }


    public void lisaaAine(View view) {


    }
}
