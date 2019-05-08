/**
 * LisaaAteria 8.5.2019 1.0
 */

package com.example.ateriaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>aterian lisäys lomake</p>
 *
 * @version 1.0
 * @author Aku Telimaa ja Mikael Ruonala
 */

public class lisaaAteria extends AppCompatActivity {
    /**
     * <p>Tagi helpottamaan debuggia</p>
     */
    private static final String TAG = "lisaaAteria";
    /**
     * <p>Lomakkeen tekstikentät tekstinsyöttöä varten</p>
     */
    public EditText ruoka_aine, ruoka_aine2, ruoka_aine3, ruoka_aine4, ruoka_aine5, ruoka_aine6, ruoka_aine7, ateriaNimi;
    /**
     * <p>onCreate() laittaa tekstikenttien arvot muuttujiin</p>
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
     * Aku täyttää
     * @param view
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

