package com.example.ateriaapp;

import java.util.ArrayList;

public class Ateria {
    private String nimi;
    private ArrayList<String> ainesosat = new ArrayList<>();
    public ArrayList<String> kaikkiainesosat = new ArrayList<>();



    public Ateria(String nimi){
        this.nimi = nimi;
    }

    public void setAinesosat(String aine1,String aine2,String aine3){
        ainesosat.add(aine1);
        ainesosat.add(aine2);
        ainesosat.add(aine3);
        for (int i=0; i<ainesosat.size(); i++){
            kaikkiainesosat.add(ainesosat.get(i));
        }

    }

    public void listaaAinesosat(){


    }

}
