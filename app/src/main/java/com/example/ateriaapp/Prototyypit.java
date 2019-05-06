package com.example.ateriaapp;

import java.util.ArrayList;

class Prototyypit {
    private ArrayList<String> prototyypit;
    private static final Prototyypit ourInstance = new Prototyypit();

    static Prototyypit getInstance() {
        return ourInstance;
    }

    private Prototyypit() {
        prototyypit = new ArrayList<>();

        prototyypit.add("Laatikko");
        prototyypit.add("Kaapo");
        prototyypit.add("Pihvi");
        prototyypit.add("Kukkakaali");
    }
    public ArrayList<String> getPrototyypit() {
        return prototyypit;
    }

    public void addToPrototypeArray(String nimi) {
        prototyypit.add(nimi);
    }
}
