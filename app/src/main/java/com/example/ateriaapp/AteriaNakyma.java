package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AteriaNakyma extends AppCompatActivity {
    final static String TAG = "Aterianäkymä";
    public ListView listView;
    public Aterialistatesti lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ateria_nakyma);
        listView = (ListView) findViewById(R.id.listViewMeal);
        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        TextView dateview = (TextView) findViewById(R.id.dateView);
        dateview.setText(date);
        lista = Aterialistatesti.getInstance();
        setMealList();

        SharedPreferences sharedPreferences = getSharedPreferences("shared homppelit", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<Aterialistatesti>>() {}.getType();
        lista.prototyypit = gson.fromJson(json, type);


    }


    public void createNewMeal(View view) {
        Intent intent = new Intent(this, lisaaAteria.class);
        startActivity(intent);


    }

    public void setMealList() {

        Log.d(TAG, "setMealList: Hoi");


         listView.setAdapter(new ArrayAdapter<Ateria>(
                 this,
                 android.R.layout.simple_list_item_1,
                 lista.getPrototyypit()
         ));
        Log.d(TAG, "setMealList: " +lista.prototyypit.size());
        for (int i = 0; i < lista.prototyypit.size() ; i++ ) {
            Log.d(TAG, "setMealList: " +lista.prototyypit.get(i));
        }

    }
}
