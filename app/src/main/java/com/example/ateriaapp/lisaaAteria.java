package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

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

public class lisaaAteria extends AppCompatActivity {

    private static final String TAG = "lisaaAteria";

    public EditText ruoka_aine, ruoka_aine2, ruoka_aine3, ruoka_aine4, ruoka_aine5, ruoka_aine6, ruoka_aine7, ateriaNimi;

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

    public void returnButton(View view){
        String nimi = ateriaNimi.getText().toString();
        String aine1 = ruoka_aine.getText().toString();
        String aine2 = ruoka_aine2.getText().toString();
        String aine3 = ruoka_aine3.getText().toString();
        String aine4 = ruoka_aine4.getText().toString();
        String aine5 = ruoka_aine5.getText().toString();
        String aine6 = ruoka_aine6.getText().toString();
        String aine7 = ruoka_aine7.getText().toString();
        Prototyypit.getInstance().addToPrototypeArray(nimi, aine1, aine2, aine3, aine4, aine5, aine6, aine7);

        Log.d(TAG, "returnButton: Nimi: "+nimi+"\n Aine 1: "+aine1+"\n Aine 2: "+aine2+"\n Aine 3: "+aine3+"\n Aine 4: "+aine4+"\n Aine 5: "+aine5+"\n Aine 6: "+aine6+"\n Aine 7: "+aine7);
        Log.d(TAG, "returnButton: Prototyypit Size: "+Prototyypit.getInstance().getIngredients().size());
        for (int i = 0; i < Prototyypit.getInstance().getIngredients().size() ; i++) {
            for (int u = 0 ; u < Prototyypit.getInstance().getIngredients().get(i).size() ; u++) {
                Log.d(TAG, "returnButton: String: "+Prototyypit.getInstance().getIngredients().get(i).get(u).toString());
                Log.d(TAG, "returnButton: Size: "+Prototyypit.getInstance().getIngredients().get(i).size());
            }
        }
        finish();
    }

    public void backButton(View view) {
        finish();
    }
}

