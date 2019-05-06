package com.example.ateriaapp;

import java.util.ArrayList;

class ListaAteriat {
    public ArrayList<Ateria> aterialista;
    private static final ListaAteriat ourInstance = new ListaAteriat();

    static ListaAteriat getInstance() {
        return ourInstance;
    }

    private ListaAteriat() {
        aterialista = new ArrayList<>();
    }

    public ArrayList<Ateria> getAterialista() {
        return aterialista;
    }

    public Ateria getAteria(int i) {
        return aterialista.get(i);
    }

    //tekee uuden aterian ja sijoittaa ainesosa muuttujat arraylistiin.
    public void addAteria(String nimi, String aine1, String aine2, String aine3, String aine4, String aine5, String aine6, String aine7) {
        Ateria ateria = new Ateria(nimi);
        ateria.setAinesosat(aine1, aine2, aine3, aine4, aine5, aine6, aine7);
    }
}
