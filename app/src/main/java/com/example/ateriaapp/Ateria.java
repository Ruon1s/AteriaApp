package com.example.ateriaapp;

import java.util.ArrayList;
//aterialuokka jonka parometreinä nimi ja arraylist johon tulee ainesosat.
public class Ateria {
    private String nimi;
    private ArrayList<String> ainesosat = new ArrayList<>();
    public ArrayList<String> kaikkiainesosat = new ArrayList<>();


//constructori
    public Ateria(String nimi){
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


}
