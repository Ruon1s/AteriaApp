/**
 * Ateria 8.5.2019 1.0
 */

package com.example.ateriaapp;

import android.util.Log;

import java.util.ArrayList;

/**
 * <p>Luokka Ateria olioille joita lisätään viikkonäkymään päivämäärän mukaan.</p>
 *
 * @version 1.0 8.5.2019
 * @author Aku Telimaa ja Mikael Ruonala
 */
public class Ateria {

    /**
     * <p>public final static String TAG: debuggausta varten tagi</p>
     */

    final static String TAG = "Ateria.Java";
    /**
     * <p>private String nimi: aterian nimi</p>
     */
    private String nimi;
    /**
     * <p>private String date: Aterian päivämäärä</p>
     */
    private String date;
    /**
     * <p>private ArrayList ainesosat: pitää sisällään aterian ainesosat Stringeinä.</p>
     */
    private ArrayList<String> ainesosat;

    /**
     * <p>Constructori Ateria lisää aterian nimi parametrillä</p>
     * @param nimi <p>aterian nimi</p>
     */
    public Ateria(String nimi) {
        this.nimi = nimi;
        this.ainesosat = new ArrayList<String>();
    }

    /**
     * <p>metodi setDate(String date) lisää aterialle päivämäärän</p>
     * @param date <p>päivämäärä</p>
     */

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * <p> metodi getDate palauttaa olion päivämäärän</p>
     * @return <p>palauttaa päivämäärän</p>
     */

    public String getDate() {
        return this.date;
    }

    /**
     * <p>metodi getNimi() palauttaa olion nimen</p>
     * @return <p>palauttaa nimen</p>
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * <p>getAinesosat() metodi palauttaa Arraylistin ainesosat</p>
     * @return <p> arraylist ainesosat</p>
     */
    public ArrayList<String> getAinesosat() {
        return this.ainesosat;
    }

    public String getShopListString(Ateria ateria) {
        String aineet = "";
        for (int i = 0 ; i < ateria.ainesosat.size() ; i++) {
            aineet = ""+aineet+""+ateria.ainesosat.get(i)+"\n";
        }
        return aineet;
    }
    public void addIngredient(String aine) {
        this.ainesosat.add(aine);
    }

    /**
     * <p>setAinesosat() lisää aineet ainesosat ArrayListiin jos ne eivät ole tyhjiä</p>
     * @param aine1 <p> ainesosa</p>
     * @param aine2 <p> ainesosa</p>
     * @param aine3 <p> ainesosa</p>
     * @param aine4 <p> ainesosa</p>
     * @param aine5 <p> ainesosa</p>
     * @param aine6 <p> ainesosa</p>
     * @param aine7 <p> ainesosa</p>
     */
    public void setAinesosat(String aine1,String aine2,String aine3, String aine4, String aine5, String aine6, String aine7){

        if (!aine1.equals("")) { this.ainesosat.add(aine1); }
        if (!aine2.equals("")) { this.ainesosat.add(aine2); }
        if (!aine3.equals("")) { this.ainesosat.add(aine3); }
        if (!aine4.equals("")) { this.ainesosat.add(aine4); }
        if (!aine5.equals("")) { this.ainesosat.add(aine5); }
        if (!aine6.equals("")) { this.ainesosat.add(aine6); }
        if (!aine7.equals("")) { this.ainesosat.add(aine7); }
    }

    @Override
    public String toString() {
        return "" + nimi;
    }
}
