package com.example.ateriaapp;

import java.util.ArrayList;

public class Aterialistatesti {
    public ArrayList<Ateria> aterialista = new ArrayList<>();

    //simpleton malli
    private static Aterialistatesti instance;
    private Aterialistatesti(){

    }
    public static Aterialistatesti getInstance() {
        if (instance == null) {
            return new Aterialistatesti();
        }
        return instance;
    }



//tekee uuden aterian ja sijoittaa ainesosa muuttujat arraylistiin.
    public void addAteria(String nimi,String aine1, String aine2,String aine3, String aine4, String aine5, String aine6, String aine7){
        Ateria ateria = new Ateria(nimi);
        ateria.setAinesosat(aine1, aine2, aine3, aine4, aine5, aine6, aine7);


    }




}
