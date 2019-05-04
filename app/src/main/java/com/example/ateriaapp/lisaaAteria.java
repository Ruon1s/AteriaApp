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

public class lisaaAteria extends AppCompatActivity {
    public ConstraintLayout container;
    public EditText ruoka_aine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisaa_ateria);
        container = (ConstraintLayout) findViewById(R.id.LisaaAteria);
        ruoka_aine = (EditText) findViewById(R.id.ruoka_aine);
    }


    public void addIngredient(View view) {

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
    }
}
