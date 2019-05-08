package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

    /**
     * <p>Ostoslistassa on listattuna kaikkien tulevien ruokien ainesosat </p>
     * @author Aku Telimaa
     * @since 1.0
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

    public void backButton(View view) {
        finish();
    }

}
