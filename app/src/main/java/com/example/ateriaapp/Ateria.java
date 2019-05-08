package com.example.ateriaapp;

import android.util.Log;

import java.util.ArrayList;

//aterialuokka jonka parametreinä nimi ja arraylist johon tulee ainesosat.
public class Ateria {

    final static String TAG = "Ateria.Java";

    private String nimi;
    private String date;

    public ArrayList<String> ainesosat;


    public Ateria(String nimi) {
        this.nimi = nimi;
        ainesosat = new ArrayList<String>();
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public String getNimi() {
        return nimi;
    }

    public ArrayList<String> getAinesosat() {
        return ainesosat;
    }

    public String getShopListString() {
        String aineet = "";
        for (int i = 0 ; i < this.getAinesosat().size() ; i++) {
            aineet = ""+aineet+""+this.ainesosat.get(i)+"\n";
            Log.d(TAG, "getShopListString: "+aineet);
        }
        Log.d(TAG, "getShopListString: "+aineet);
        return aineet;
    }
    public void addIngredient(String aine) {
        this.ainesosat.add(aine);
    }

    public void setAinesosat(String aine1,String aine2,String aine3, String aine4, String aine5, String aine6, String aine7){

        if (!aine1.equals("")) { this.ainesosat.add(aine1); }
        if (!aine2.equals("")) { this.ainesosat.add(aine2); }
        if (!aine3.equals("")) { this.ainesosat.add(aine3); }
        if (!aine4.equals("")) { this.ainesosat.add(aine4); }
        if (!aine5.equals("")) { this.ainesosat.add(aine5); }
        if (!aine6.equals("")) { this.ainesosat.add(aine6); }
        if (!aine7.equals("")) { this.ainesosat.add(aine7); }
    }

    @Override
    public String toString() {
        return "" + nimi;
    }
}
