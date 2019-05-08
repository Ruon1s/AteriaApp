package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class AteriaNakyma extends AppCompatActivity {

    final static String TAG = "Aterianäkymä";
    public ListView listView;
    public String date;
    public String day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ateria_nakyma);
        listView = (ListView) findViewById(R.id.listViewMeal);
        Intent intent = getIntent();
        date = intent.getStringExtra("date");
        day = intent.getStringExtra("day");
        TextView dateview = (TextView) findViewById(R.id.dateView);
        String dayDate = ""+day+" "+date;
        dateview.setText(dayDate);
        setMealList();
    }

    public void createNewMeal(View view) {
        Intent intent = new Intent(this, lisaaAteria.class);
        startActivity(intent);
    }

    public void setMealList() {
        listView.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                Prototyypit.getInstance().getPrototyypit()
        ));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String nimi = Prototyypit.getInstance().getPrototyypit().get(position);

                Ateria ateria = new Ateria(nimi);

                ateria.setDate(date);
                ListaAteriat.getInstance().aterialista.add(ateria);

                for (int s = 0 ; s < Prototyypit.getInstance().getIngredients().get(position).size() ; s++) {
                    String aine = Prototyypit.getInstance().getIngredients().get(position).get(s).toString();

                    if (!aine.equals("")) {
                        ateria.addIngredient(aine);
                    }
                }
            finish();
         }
     });

    }

    public void backButton(View view) {
        finish();
    }

}
