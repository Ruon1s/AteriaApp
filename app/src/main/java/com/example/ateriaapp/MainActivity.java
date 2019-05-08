/**
 * @author Aku Telimaa
 */

package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * <p>MainActivity luokka, jossa ohjelma aukeaa. MainActivity toimii
 * viikkonäkymänä, jossa esitetään seuraavien seitsemän päivän ruoat.</p>
 * @author Aku Telimaa
 * @since 1.0 8.5.2019
 */

public class MainActivity extends AppCompatActivity {

    /**
     *  <p>Luokan public muuttujen alustukset. dateText on String, joka on päivämäärä
     *  ja on muotoa "dd.MM.yyyy". day on TextView, johon viedään päivän nimi.
     *  numberofDate on TextView johon viedään päivämäärä muodossa "dd.MM.yyyy"
     *  ruoat TextView listaa tulevien päivien Ateria-luokan oliot.</p>
     */
    public String dateText;
    public TextView day;
    public TextView numberOfDate;
    public TextView ruoat;

    /**
     * <p>Override onCreate funktiolle, jossa kutsutaan SharedPreferenceistä Ateriat,
     * Prototyypit ja prototyyppi-ruokien raaka-aineet.
     * Samalla alustetaan ruokalistan instanssi.</p>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListaAteriat.getInstance();
        loadAteria();
        loadPrototype();
        loadIngredients();
    }

    /**
     * <p>Tallentaa Aterialistan SharedPreferencesiin. Kutsutaan onStop() funktiossa.</p>
     */
    public void saveAteria() {

        SharedPreferences sharedPreferences = getSharedPreferences("shared pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(ListaAteriat.getInstance().getAterialista());
        editor.putString("Ateria", json);
        editor.apply();
    }

    /**
     * <p>Lataa SharedPreferencestä tallennetut Ateria-oliot ja tallentaa ne
     * ListaAteriat-luokan aterialistalle. Kutsutaan onCreate() funktiossa.</p>
     * @throws NullPointerException, jos json saa arvoksi null.
     * @author Mikael Ruonala
     * @author Aku Telimaa
     */
    public void loadAteria() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared pref", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(
                "Ateria",
                null
        );
        Type type = new TypeToken<ArrayList<Ateria>>() {
        }.getType();
        if (json != null) {
            ListaAteriat.getInstance().aterialista = gson.fromJson(json, type);
            setupDays();
        }
    }

    /**
     * <p>Tallentaa Prototyypit listan SharedPreferencesiin. Kutsutaan onStop() funktiossa.</p>
     */
    private void savePrototype() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Prototyypit.getInstance().getPrototyypit());
        editor.putString("Prototyyppi", json);
        editor.apply();
    }

    /**
     * <p>Lataa SharedPreferencestä tallennetut Prototyyppit ja tallentaa ne
     * Prototyypit-luokan prototyypit listalle.
     * kutsutaan onCreate() funktiossa.</p>
     * @throws NullPointerException, jos json saa arvoksi null.
     * @author Mikael Ruonala
     * @author Aku Telimaa
     */
    private void loadPrototype(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared pref", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(
                "Prototyyppi",
                null
        );
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        if (json != null) {
            Prototyypit.getInstance().prototyypit = gson.fromJson(json, type);
        }
    }
    /**
     * <p>Tallentaa ingredients listan SharedPreferencesiin. Kutsutaan onStop() funktiossa.</p>
     */
    private void saveIngredients() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Prototyypit.getInstance().getIngredients());
        editor.putString("Ingredients", json);
        editor.apply();
    }

    /**
     * <p>Lataa SharedPreferencestä tallennetut Prototyyppi luokan ingredients listat ja tallentaa ne
     * Prototyypit luokan ingredients listalle. Kutsutaan onCreate() funktiossa.</p>
     * @throws NullPointerException, jos json saa arvoksi null.
     * @author Mikael Ruonala
     * @author Aku Telimaa
     */
    private void loadIngredients() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared pref", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(
                "Ingredients",
                null
        );
        Type type = new TypeToken<ArrayList<ArrayList>>() {}.getType();
        if ( json != null) {
            Prototyypit.getInstance().ingredients = gson.fromJson(json, type);
        }
    }

    /**
     * <p>Funktio kääntää englanninkieliset päiviennimien lyhenteet
     * suomenkielelle kokonaisiksi sanoiksi./p>
     * @param SDFDay Funktioon tuotu englanninkielinen päivän lyhenne
     * ( Mon, Tue, Wed, Thu, Fri, Sat, Sun )
     * @return Tuodun lyhenteen suomenkielinen kokonimi
     * (Maanantai, Tiistai, Keskiviikko, Torstai, Perjantai, Launtai, Sunnuntai)
     */
    private String convertDayName(String SDFDay) {
        if (SDFDay.contentEquals("Mon")) {
            SDFDay = "Maanantai";
        } else if (SDFDay.contentEquals("Tue")) {
            SDFDay = "Tiistai";
        } else if (SDFDay.contentEquals("Wed")) {
            SDFDay = "Keskiviikko";
        } else if (SDFDay.contentEquals("Thu")) {
            SDFDay = "Torstai";
        } else if (SDFDay.contentEquals("Fri")) {
            SDFDay = "Perjantai";
        } else if (SDFDay.contentEquals("Sat")) {
            SDFDay = "Lauantai";
        } else if (SDFDay.contentEquals("Sun")) {
            SDFDay = "Sunnuntai";
        }
        return SDFDay;
    }

    /**
     * <p>Asettaa viikkonäkymään seuraavat seitsemän(7) päivää
     * ja parsee niihin Aterialistassa olevat ruoat päivämäärien mukaan
     * Kutsutaan onCreate() ja onStart() funktioissa.</p>
     */
    private void setupDays() {
        for (int i = 0; i < 7; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.US);
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, i);
            String date = sdf.format(cal.getTime());
            SimpleDateFormat sdf1 = new SimpleDateFormat("E", Locale.US);
            String paiva = sdf1.format(cal.getTime());
            paiva = convertDayName(paiva);
            if (i == 0) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout1);
                day = (TextView) linearLayout.findViewById(R.id.paiva);
                numberOfDate = (TextView) linearLayout.findViewById(R.id.date);
                ruoat = (TextView) linearLayout.findViewById(R.id.ateriat);
            } else if (i == 1) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout2);
                day = (TextView) linearLayout.findViewById(R.id.paiva);
                numberOfDate = (TextView) linearLayout.findViewById(R.id.date);
                ruoat = (TextView) linearLayout.findViewById(R.id.ateriat);
            } else if (i == 2) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout3);
                day = (TextView) linearLayout.findViewById(R.id.paiva);
                numberOfDate = (TextView) linearLayout.findViewById(R.id.date);
                ruoat = (TextView) linearLayout.findViewById(R.id.ateriat);
            } else if (i == 3) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout4);
                day = (TextView) linearLayout.findViewById(R.id.paiva);
                numberOfDate = (TextView) linearLayout.findViewById(R.id.date);
                ruoat = (TextView) linearLayout.findViewById(R.id.ateriat);
            } else if (i == 4) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout5);
                day = (TextView) linearLayout.findViewById(R.id.paiva);
                numberOfDate = (TextView) linearLayout.findViewById(R.id.date);
                ruoat = (TextView) linearLayout.findViewById(R.id.ateriat);
            } else if (i == 5) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout6);
                day = (TextView) linearLayout.findViewById(R.id.paiva);
                numberOfDate = (TextView) linearLayout.findViewById(R.id.date);
                ruoat = (TextView) linearLayout.findViewById(R.id.ateriat);
            } else {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout7);
                day = (TextView) linearLayout.findViewById(R.id.paiva);
                numberOfDate = (TextView) linearLayout.findViewById(R.id.date);
                ruoat = (TextView) linearLayout.findViewById(R.id.ateriat);
            }
            dateText = "";
            if (ListaAteriat.getInstance().aterialista != null) {
                for (int x = 0; x < ListaAteriat.getInstance().aterialista.size(); x++) {
                    Ateria olio = ListaAteriat.getInstance().aterialista.get(x);

                    if (olio.getDate().equals(date)) {
                        dateText = "" + dateText + "" + olio.getNimi() + "\n";
                    }
                }
            }
            ruoat.setText(dateText);
            day.setText(paiva);
            numberOfDate.setText(date);

        }
    }

    /**
     * <p>Klikatun päivän painaminen avaa uuden Activityn ja vie uuteen
     * activityyn painetun päivämäärän ja viikonpäivän. Seuraava activity
     * on activity_ateria_nakyma.xml / AteriaNakyma.java</p>
     * @param view Klikatun päivän container, joka on LinearLayout.
     */
    public void addMeal (View view){
        LinearLayout linearLayout = (LinearLayout) findViewById(view.getId());
        TextView dateView = (TextView) linearLayout.findViewById(R.id.date);
        TextView dayView = (TextView) linearLayout.findViewById(R.id.paiva);
        String date =  dateView.getText().toString();
        String day = dayView.getText().toString();
        Intent intent = new Intent(this, AteriaNakyma.class);
        intent.putExtra("date", date);
        intent.putExtra("day", day);
        startActivity(intent);
    }

    /**
     * <p>Vie suoraan Aterian lisäys activityyn
     * Seuraava activity on activity_lisää_ateria.xml / lisaaAteria.java</p>
     * @param view Klikatun napin view, jotta funktio voidaan asettaa nappiin.
     */
    public void createNewMeal(View view) {
        Intent intent = new Intent(this, lisaaAteria.class);
        startActivity(intent);
    }

    /**
     * <p>Viee suoraan Ostoslsita activityyn
     * Seuraava activity on activity_ostos_lista.xml / ostosLista.java<p>
     * @param view Klikatun napin view, jotta funktio voidaan asettaa nappiin
     */
    public void goToShoppingList(View view) {
        Intent intent = new Intent(this, ostosLista.class);
        startActivity(intent);
    }

    /**
     * <p>onStart() funktion Override. Alustetaan onStart(), jonka jälkeen
     * kutsutaan setupDays() funktio.
     */
    @Override
    protected void onStart() {
        super.onStart();
        setupDays();
    }

    /**
     * <p>onStop() funktion Override. Alustetaan onStop(), jonka jälkeen
     * kutsutaan saveAteria(), savePrototype() ja saveIngredients() funktiot.</p>
     */
    @Override
    protected void onStop() {
        super.onStop();
        saveAteria();
        savePrototype();
        saveIngredients();
    }
}

