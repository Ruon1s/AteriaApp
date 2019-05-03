package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ostosLista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ostos_lista);

        populateListView();
    }

    private void populateListView(){
        String[] myItems = {"blue", "green", "Purple", "Red"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.ostokset, myItems);
        ListView list = (ListView) findViewById(R.id.ListViewMain);
        list.setAdapter(adapter);
    }

}
