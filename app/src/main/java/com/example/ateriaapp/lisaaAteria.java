/**
 *  LisaaAteria 8.5.2019 1.0
 */

package com.example.ateriaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * <p>Uuden aterian prototyypin luomiseen tarkoitettu näkymä.
 * Prototyyppi luodaan nimestä, joka on pakkollinen muuttuja.
 * Prototyypillä voi myös olla ainesosia, jotka viedään aterian luonnin yhteydessä
 * ostoslistaan.</p>
 * @version 1.0
 * @author Aku Telimaa ja Mikael Ruonala
 */

public class lisaaAteria extends AppCompatActivity {

    /**
     * <p>Sivun tekstikentät tekstinlukua varten.</p>
     */
    public EditText ruoka_aine, ruoka_aine2, ruoka_aine3, ruoka_aine4, ruoka_aine5, ruoka_aine6, ruoka_aine7, ateriaNimi;

    /**
     * <p>onCreate() metodin Override.
     * Alustetaan EditText muuttujille kullekkin oma EditText elementti</p>
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisaa_ateria);

        ateriaNimi = (EditText) findViewById(R.id.ateriaNimi);
        ruoka_aine = (EditText) findViewById(R.id.ruoka_aine);
        ruoka_aine2 = (EditText) findViewById(R.id.ruoka_aine2);
        ruoka_aine3 = (EditText) findViewById(R.id.ruoka_aine3);
        ruoka_aine4 = (EditText) findViewById(R.id.ruoka_aine4);
        ruoka_aine5 = (EditText) findViewById(R.id.ruoka_aine5);
        ruoka_aine6 = (EditText) findViewById(R.id.ruoka_aine6);
        ruoka_aine7 = (EditText) findViewById(R.id.ruoka_aine7);

    }
    /**
     * <p>Funktio hakee aterialle nimen <i>aterianNimi</i> EditText elementistä.
     * Nimi on aterian luontiin pakollinen muuttuja.
     * Aterialle voidaan myös antaa maksimissaan seitsemän(7) kappaletta ainesosia.</p>
     */
    public void addButton(View view){
        String nimi = ateriaNimi.getText().toString();
        if (nimi.equals("")) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder.setMessage("Anna ateriallesi nimi");
            alertBuilder.setCancelable(true);
            alertBuilder.setPositiveButton(
                    "OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = alertBuilder.create();
            alert.show();
        } else {
            String aine1 = ruoka_aine.getText().toString();
            String aine2 = ruoka_aine2.getText().toString();
            String aine3 = ruoka_aine3.getText().toString();
            String aine4 = ruoka_aine4.getText().toString();
            String aine5 = ruoka_aine5.getText().toString();
            String aine6 = ruoka_aine6.getText().toString();
            String aine7 = ruoka_aine7.getText().toString();
            Prototyypit.getInstance().addToPrototypeArray(nimi, aine1, aine2, aine3, aine4, aine5, aine6, aine7);
            finish();
        }
    }

    public void backButton(View view) {
        finish();
    }
}

