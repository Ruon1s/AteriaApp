    /**
     * Ateria 8.5.2019 1.0
     */

package com.example.ateriaapp;

import java.util.ArrayList;

    /**
     * <p>Luokka Ateria-olioille, joita lisätään viikkonäkymään päivämäärän mukaan.</p>
     * @author Aku Telimaa
     * @author Mikael Ruonala
     * @since 1.0 8.5.2019
     * @version 1.0 8.5.2019
     */
public class Ateria {
    /**
     * <p>pString nimi on aterian nimi. String date on aterian päivämäärä muodossa "dd.MM.yyyy".
     * ArrayList ainesosat pitää sisällään aterian ainesosat stringeinä.</p>
     */
    private String nimi;
    private String date;
    private ArrayList<String> ainesosat;

    /**
     * <p>Constructori Ateria lisää aterian nimi parametrillä. Luodaan myös aterialle
     * oma ainesosat lista.</p>
     * @param nimi Aterialle annettava nimi.
     */
    public Ateria(String nimi) {
        this.nimi = nimi;
        this.ainesosat = new ArrayList<String>();
    }

    /**
     * <p>setDate(String date) on Ateria-olion metodi ja lisää aterialle päivämäärän.</p>
     * @param date Aterialle annettava päivämäärä.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * <p>getDate() on Ateria-olion metodi ja palauttaa olion päivämäärän.</p>
     * @return Ateria-olion päivämäärä.
     */
    public String getDate() {
        return this.date;
    }

    /**
     * <p>getNimi() on Ateria-olion metodi ja palauttaa olion nimen.</p>
     * @return Ateria-olion nimi.
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * <p>Ostoslistassa käytettävä metodi, joka palauttaa parametrina annetun aterian
     * ainesosat-listan muuttujat string-muuttujina. kaikki muuttujat kootaan yhteen
     * stringiin. Käytetään ainoastaan ostoslistassa käytettävässä
     * {@link ostosLista#populateListView() populateListview()} funktiossa.
     * </p>
     * @param ateria Kutsussa annetun aterian muuttuja
     * @return Kaikkien muuttujien yhteenkoottu string.
     */
    public String getShopListString(Ateria ateria) {
        String aineet = "";
        for (int i = 0 ; i < ateria.ainesosat.size() ; i++) {
            aineet = ""+aineet+""+ateria.ainesosat.get(i)+"\n";
        }
        return aineet;
    }

    /**
     * <p>Ateria-olion metodi, jolla lisätään oliolle ainesosia tämän omaan
     * ainesosat listaan</p>
     * @param aine Listaan lisättävä ainesosa.
     */
    public void addIngredient(String aine) {
        this.ainesosat.add(aine);
    }

    /**
     * <p>Ateria-olion toString() -metodin Override. Käytetää {@link AteriaNakyma aterianäkymässä}
     * olemassa olevien ateria-olioiden printtaukseen.</p>
     * @return Olion nimi.
     */
    @Override
    public String toString() {
        return "" + nimi;
    }
}
