package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class lisaaAteria extends AppCompatActivity {
    private Aterialistatesti aterialista;
    public ConstraintLayout container;
    public EditText ruoka_aine, ruoka_aine2, ruoka_aine3, ruoka_aine4, ruoka_aine5, ruoka_aine6, ruoka_aine7, ateriaNimi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisaa_ateria);
        aterialista = Aterialistatesti.getInstance();
        container = (ConstraintLayout) findViewById(R.id.LisaaAteria);
        ateriaNimi = (EditText) findViewById(R.id.ateriaNimi);
        ruoka_aine = (EditText) findViewById(R.id.ruoka_aine);
        ruoka_aine2 = (EditText) findViewById(R.id.ruoka_aine2);
        ruoka_aine3 = (EditText) findViewById(R.id.ruoka_aine3);
        ruoka_aine4 = (EditText) findViewById(R.id.ruoka_aine4);
        ruoka_aine5 = (EditText) findViewById(R.id.ruoka_aine5);
        ruoka_aine6 = (EditText) findViewById(R.id.ruoka_aine6);
        ruoka_aine7 = (EditText) findViewById(R.id.ruoka_aine7);

    }

    public void returnButton(){
        String nimi = ateriaNimi.getText().toString();
        String aine1 = ruoka_aine.getText().toString();
        String aine2 = ruoka_aine2.getText().toString();
        String aine3 = ruoka_aine3.getText().toString();
        String aine4 = ruoka_aine4.getText().toString();
        String aine5 = ruoka_aine5.getText().toString();
        String aine6 = ruoka_aine6.getText().toString();
        String aine7 = ruoka_aine7.getText().toString();
        aterialista.addAteria(nimi, aine1, aine2, aine3, aine4, aine5, aine6, aine7);
        Intent intent = new Intent(this, AteriaNakyma.class);
        startActivity(intent);

    }
}


    // Todo <-- Fix if time -->
    /*  public void addIngredient(View view) {

        container.addView(addNewEditView());

    }

     private EditText addNewEditView() {
        final ConstraintLayout.LayoutParams lparams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final EditText editText = new EditText(this);
        editText.setLayoutParams(lparams);
        ConstraintSet cs = new ConstraintSet();
        cs.connect(editText.getId(), ConstraintSet.TOP,
                ruoka_aine.getId(), ConstraintSet.BOTTOM, 14);
        cs.applyTo(container);

        return editText;
    } /*/
