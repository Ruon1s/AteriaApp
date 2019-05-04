package com.example.ateriaapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class Aterialista extends AppCompatActivity {
    public String ainesosa1 = "kukkakaali";
    public String ainesosa2 = "peruna";
    public String ainesosa3 = "muna";

    public ArrayList<Ateria> aterialista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ateria_nakyma);

        populateListView();
    }

    public void addAteria(String nimi){
        Ateria ateria = new Ateria(nimi);
        ateria.setAinesosat(ainesosa1, ainesosa2, ainesosa3);
        aterialista.add(ateria);
    }

    private void populateListView(){
        String[] myItems = {"blue", "green", "Purple", "Red"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.ostokset, myItems);
        ListView list = (ListView) findViewById(R.id.ListViewMain);
        list.setAdapter(adapter);
    }

}
