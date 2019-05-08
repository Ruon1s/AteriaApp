    /**
     * AteriaNakyma 8.5.2019
     */

package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * <p>Aterialistanäkymä, jossa näkyy listattuna kaikki ateriat nimien mukaan</p>
 * @version 1.0
 * @author Aku Telimaa ja Mikael Ruonala
 */

public class AteriaNakyma extends AppCompatActivity {

    /**
     * <p>Listview elementti aterioiden listausta varten. date on päivämäärä muodossa "dd.MM.yyy".
     * day on viikonpäivän nimi.</p>
     */
    public ListView listView;
    public String date;
    public String day;

    /**
     * <p>onCreate funktion Override. Haetaan listView muuttujaan ListView elementti ja palautetaan
     * intentin vaihdon mukana tulleet date ja day muuttujat. Viikonpäivän nimi ja päivämäärä laitetaan
     * dateView elementtiin. Lopuksi alusteaan Aterialista {@link #setMealList() setMealList()} funktiolla./p>
     * @param savedInstanceState
     */
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

    /**
     * <p>Siirtyy lisää uusi ateria activityyn.
     * Seuraava activity on <i>activity_lisaa_ateria.xml / lisaaAteria.java</i> </p>
     */
    public void createNewMeal(View view) {
        Intent intent = new Intent(this, lisaaAteria.class);
        startActivity(intent);
    }

    /**
     * <p>ArrayAdapter listView elementille. Listaan viedään Prototyyppi ruokien nimet prototyypit listasta.
     * Samalla asetetaan listan jäsenille onClickListener. Painalluksesta ohjelma hakee painetun ruoan indexillä
     * aterialle nimen ja luo uuden Ateria-luokan olion, joka saa construktorin parametriksi painetun ruoan
     * nimen. Sen jälkeen ohjelma hakee Prototyypit luokan ingredients listalta vastaavan ruoan ainesosat.</p>
     */
    public void setMealList() {
        listView.setAdapter(new ArrayAdapter<>(
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
                ListaAteriat.getInstance().getAterialista().add(ateria);;
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

    /**
     * <p>Custom paluunappi</p>
     */
    public void backButton(View view) {
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setMealList();
    }

}
