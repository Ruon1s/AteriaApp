package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ostosLista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ostos_lista);

        populateListView();
    }

    private void populateListView(){

        ShoppingAdapter shoppingAdapter = new ShoppingAdapter(this, ListaAteriat.getInstance().aterialista);
        ListView list = (ListView) findViewById(R.id.ListViewMain);
        list.setAdapter(shoppingAdapter);

        /* for (int i = 0 ; i < 7 ; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.US);
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, i);
            String date = sdf.format(cal.getTime());

            for (int x = 0 ; x < ListaAteriat.getInstance().aterialista.size() ; x++) {
                Ateria olio = ListaAteriat.getInstance().aterialista.get(x);

            }
        } */
    }

}
