package com.example.ateriaapp;

import java.util.ArrayList;

//aterialuokka jonka parametreinä nimi ja arraylist johon tulee ainesosat.
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
        this.nimi = nimi;
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

    @Override
    public String toString() {
        return "" + nimi;
    }
}
