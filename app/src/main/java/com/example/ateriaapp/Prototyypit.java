package com.example.ateriaapp;

import java.lang.reflect.Array;
import java.util.ArrayList;

class Prototyypit {
    public ArrayList<String> prototyypit;
    public ArrayList<ArrayList> ingredients;

    private static final Prototyypit ourInstance = new Prototyypit();

    static Prototyypit getInstance() {
        return ourInstance;
    }

    private Prototyypit() {
        prototyypit = new ArrayList<>();
        ingredients = new ArrayList<>();
    }
    public ArrayList<String> getPrototyypit() {
        return prototyypit;
    }

    public ArrayList<ArrayList> getIngredients() {
        return ingredients;
    }

    public void addToPrototypeArray(String nimi, String aine1, String aine2, String aine3, String aine4, String aine5, String aine6, String aine7) {
        prototyypit.add(nimi);
        ArrayList<String> aineet = new ArrayList<>();
        if (!aine1.equals("")) { aineet.add(aine1); }
        if (!aine2.equals("")) { aineet.add(aine2); }
        if (!aine3.equals("")) { aineet.add(aine3); }
        if (!aine4.equals("")) { aineet.add(aine4); }
        if (!aine5.equals("")) { aineet.add(aine5); }
        if (!aine6.equals("")) { aineet.add(aine6); }
        if (!aine7.equals("")) { aineet.add(aine7); }

        ingredients.add(aineet);

    }

}
