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
        Log.d(TAG, "onCreate: Date = " +date);

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
             ateria.setDate(date);
             ListaAteriat.getInstance().aterialista.add(ateria);

             for (int i = 0 ; i < Prototyypit.getInstance().getIngredients().size() ; i++) {
                 for (int s = 0 ; s < Prototyypit.getInstance().getIngredients().get(i).size() ; s++) {
                     String aine = Prototyypit.getInstance().getIngredients().get(i).get(s).toString();

                     if (!aine.equals("")) {
                         ateria.addIngredient(aine);
                         Log.d(TAG, "onItemClick: " + aine);
                         Log.d(TAG, "onItemClick: " + ateria.getAinesosat());
                     }
                 }
             }
             Log.d(TAG, "onItemClick: SIZES "+ListaAteriat.getInstance().aterialista.size());


             for (int c = 0 ; c < ListaAteriat.getInstance().aterialista.size() ; c++) {
                 for (int p = 0 ; p < ListaAteriat.getInstance().aterialista.get(c).getAinesosat().size() ; p++) {
                     Log.d(TAG, "onItemClick: Ingredients "+ListaAteriat.getInstance().aterialista.get(c).getAinesosat().get(c));
                 }
             }


             Log.d(TAG, "onItemClick: date: "+date);

             finish();
         }
     });

    }

}
