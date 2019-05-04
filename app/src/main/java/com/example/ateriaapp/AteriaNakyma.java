package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class AteriaNakyma extends AppCompatActivity {

    public ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ateria_nakyma);
        listView = (ListView) findViewById(R.id.listViewMeal);
        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        TextView dateview = (TextView) findViewById(R.id.dateView);
        dateview.setText(date);
        setMealList();
    }


    public void createNewMeal(View view) {
        Intent intent = new Intent(this, lisaaAteria.class);
        startActivity(intent);


    }

    public void setMealList() {
         listView.setAdapter(new ArrayAdapter<String>(
                 this,
                 R.layout.activity_ateria_nakyma,
                 Aterialistatesti.getInstance().getPrototyypit()
         ));


    }
}
