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

        Ateria ateria = new Ateria("Laatikko");
        aterialista.add(ateria);
        ateria.setDate("08.05.2019");

        Ateria ateria4 = new Ateria("Kaapo");
        aterialista.add(ateria4);
        ateria4.setDate("10.05.2019");

        Ateria ateria1 = new Ateria("Pihvi");
        aterialista.add(ateria1);
        ateria1.setDate("05.05.2019");

        Ateria ateria2 = new Ateria("Kukkakaali");
        aterialista.add(ateria2);
        ateria2.setDate("06.05.2019");

        Ateria ateria5 = new Ateria("Laatikko");
        aterialista.add(ateria5);
        ateria5.setDate("07.05.2019");

        Ateria ateria6 = new Ateria("Laatikko");
        aterialista.add(ateria6);
        ateria6.setDate("08.05.2019");

        Ateria ateria7 = new Ateria("Laatikko");
        aterialista.add(ateria7);
        ateria7.setDate("09.05.2019");

    }

    public ArrayList<Ateria> getAterialista() {
        return aterialista;
    }

    public Ateria getAteria(int i) { return aterialista.get(i); }

    //tekee uuden aterian ja sijoittaa ainesosa muuttujat arraylistiin.
    public void addAteria(String nimi, String aine1, String aine2, String aine3, String aine4, String aine5, String aine6, String aine7) {
        Ateria ateria = new Ateria(nimi);
        ateria.setAinesosat(aine1, aine2, aine3, aine4, aine5, aine6, aine7);
    }

}
