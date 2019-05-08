package com.example.ateriaapp;

import java.util.ArrayList;

    /**
     * Singleton luokka Aterialistan esittämiseen.
     * @author Aku Telimaa
     * @since 1.0
     */
class ListaAteriat {

    public ArrayList<Ateria> aterialista;
    public static ListaAteriat ourInstance = new ListaAteriat();

    static ListaAteriat getInstance() {
        if (ourInstance == null) {
            ourInstance = new ListaAteriat();
        }
        return ourInstance;
    }

    private ListaAteriat() {
        aterialista = new ArrayList<>();
    }

    public ArrayList<Ateria> getAterialista() {
        return aterialista;
    }
}
