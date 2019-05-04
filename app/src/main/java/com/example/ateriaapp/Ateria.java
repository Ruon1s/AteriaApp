package com.example.ateriaapp;

import android.util.Log;

import java.util.ArrayList;
//aterialuokka jonka parometreinä nimi ja arraylist johon tulee ainesosat.
public class Ateria {

    final static String TAG = "Ateria.Java";

    private String nimi;
    private String date;
    private ArrayList<String> ainesosat = new ArrayList<>();
    public ArrayList<String> kaikkiainesosat = new ArrayList<>();



    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public String getNimi() {
        return nimi;
    }

    //constructori
    public Ateria(String nimi) {
        boolean check = true;
        this.nimi = nimi;
        Log.d(TAG, "Ateria: created. Size: " +Aterialistatesti.getInstance().prototyypit.size());

        if (Aterialistatesti.getInstance().prototyypit.size() != 0) {
            for (int i = 0; i < Aterialistatesti.getInstance().prototyypit.size() ; i++) {
                Log.d(TAG, "Ateria: "+Aterialistatesti.getInstance().prototyypit.get(i)+" = "+nimi);
                if (Aterialistatesti.getInstance().prototyypit.get(i).equals(nimi)) {
                    check = false;
                    Log.d(TAG, "Ateria: Ateria found.");
                } else {
                }
            }
            if(check) {
                Aterialistatesti.getInstance().prototyypit.add(""+nimi);
                Log.d(TAG, "Ateria: ADDED");
            }
        } else { Aterialistatesti.getInstance().prototyypit.add(""+nimi);
            Log.d(TAG, "Ateria: First meal added");
        }

    }




//setteri ainesosille laittaa ainesosat tietylle oliolle arraylist muodossa.
    public void setAinesosat(String aine1,String aine2,String aine3, String aine4, String aine5, String aine6, String aine7){
        ainesosat.add(aine1);
        ainesosat.add(aine2);
        ainesosat.add(aine3);
        ainesosat.add(aine4);
        ainesosat.add(aine5);
        ainesosat.add(aine6);
        ainesosat.add(aine7);
        for (int i=0; i<ainesosat.size(); i++){
            kaikkiainesosat.add(ainesosat.get(i));
        }

    }

//Kikkihiiri
}
