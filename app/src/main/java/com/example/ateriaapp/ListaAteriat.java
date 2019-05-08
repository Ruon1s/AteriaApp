package com.example.ateriaapp;

import java.util.ArrayList;

    /**
     * Singleton luokka Aterialistan esittämiseen.
     * @author Mimosa Kovero
     * @since 1.0 8.5.2019
     * @version 1.0 8.5.2019
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
