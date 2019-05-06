package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AteriaNakyma extends AppCompatActivity {

    final static String TAG = "Aterianäkymä";
    public ListView listView;
    public String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ateria_nakyma);
        listView = (ListView) findViewById(R.id.listViewMeal);
        Intent intent = getIntent();
        date = intent.getStringExtra("date");

        Log.d(TAG, "onCreate: Date = " +date);

        TextView dateview = (TextView) findViewById(R.id.dateView);
        dateview.setText(date);
        setMealList();

    }

    public void createNewMeal(View view) {
        Intent intent = new Intent(this, lisaaAteria.class);
        startActivity(intent);
    }

    public void setMealList() {
     Log.d(TAG, "setMealList: Started");

     listView.setAdapter(new ArrayAdapter<String>(
         this,
         android.R.layout.simple_list_item_1,
         Prototyypit.getInstance().getPrototyypit()
     ));

     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             Log.d(TAG, "onItemClick: Clicked position is "+position);
             String nimi = Prototyypit.getInstance().getPrototyypit().get(position);
             Log.d(TAG, "onItemClick: nimi: "+nimi);
             Ateria ateria = new Ateria(nimi);
             Log.d(TAG, "onItemClick: aterian "+ateria);
             ateria.setDate(splitDate(date));
             Log.d(TAG, "onItemClick: date: "+splitDate(date));
             ListaAteriat.getInstance().aterialista.add(ateria);
         }
     });

    }

    public String splitDate(String date){
        String[] splitDate = date.split(" ", 2);
        return splitDate[1];
    }
}
