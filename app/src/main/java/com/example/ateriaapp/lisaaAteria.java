package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class lisaaAteria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisaa_ateria);
    }


    public void lisaaAine(View view) {
        ConstraintLayout cLayout = (ConstraintLayout) findViewById(R.id.LisaaAteria);
        EditText editText = new EditText(this);
        editText.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        cLayout.addView(editText);

    }
}
