package com.example.ateriaapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class Aterialista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ateria_nakyma);

        populateListView();
    }

    private void populateListView(){
        String[] myItems = {"blue", "green", "Purple", "Red"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.ostokset, myItems);
        ListView list = (ListView) findViewById(R.id.ListViewMain);
        list.setAdapter(adapter);
    }

}
