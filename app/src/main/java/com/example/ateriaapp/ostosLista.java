package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
     * <p>Ostoslistassa on listattuna kaikkien tulevien ruokien ainesosat </p>
     * @author Aku Telimaa
     * @author Mikael Ruonala
     * @since 1.0 8.5.2019
     * @version 1.0 8.5.2019
     */
public class ostosLista extends AppCompatActivity {
    /**
     * <p>onCreate() funktion Override. Käynnistää listauksen populateListView() funktiolla</p>
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ostos_lista);
        populateListView();
    }

    /**
     * <p>Funktio aterioiden ja niiden ainesosien sijoittamiseen</p>
     */
    public void populateListView(){
        ArrayList<Ateria> copyOfList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.US);
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, i);
            String date = sdf.format(cal.getTime());
            for (int y = 0; y < ListaAteriat.getInstance().aterialista.size(); y++) {
                if (date.equals(ListaAteriat.getInstance().aterialista.get(y).getDate())) {
                    copyOfList.add(ListaAteriat.getInstance().aterialista.get(y));
                }
            }
        }


            ShoppingAdapter shoppingAdapter = new ShoppingAdapter(this, ListaAteriat.getInstance().aterialista);
            ListView list = (ListView) findViewById(R.id.ListViewMain);
            list.setAdapter(shoppingAdapter);




    }

    public void backButton(View view) {
        finish();
    }

}
