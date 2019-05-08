/**
 * @author Aku Telimaa
 */

package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public String dateText;
    public TextView day;
    public TextView numberOfDate;
    public TextView ruoat;

   public void saveAteria(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("shared pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(ListaAteriat.getInstance().getAterialista());
        editor.putString("Ateria", json);
        editor.apply();

    }

    public void loadAteria(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("shared pref", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Ateria", null);
            Type type = new TypeToken<ArrayList<Ateria>>() {}.getType();
            ListaAteriat.getInstance().aterialista = gson.fromJson(json, type);
            setupDays();
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupDays();

    }

    private void savePrototype() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Prototyypit.getInstance());
        editor.putString("Prototyyppi", json);
        editor.apply();
    }

    private void loadPrototype(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared pref", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("shared pref", null);
        Type type = new TypeToken<ArrayList<Prototyypit>>() {}.getType();
    }

    /**
     * <p>Function will translate the English name of the day into Finnish</p>
     * @param SDFDay Abbreviation of the English name of the day ( Mon, Tue, Wed, Thu, Fri, Sat, Sun )
     * @return Name of the day in Finnish
     * @since 1.0
     * @author Aku Telimaa
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
     * <p>Setups 7 days to the front page
     * and parse existing meals to each day</p>
     * @author Aku Telimaa
     * @since 1.0
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
            for (int x = 0; x < ListaAteriat.getInstance().aterialista.size(); x++) {
                Ateria olio = ListaAteriat.getInstance().aterialista.get(x);

                if (olio.getDate().equals(date)) {
                    dateText = "" + dateText + "" + olio.getNimi() + "\n";
                }
            }

            ruoat.setText(dateText);
            day.setText(paiva);
            numberOfDate.setText(date);

        }
    }

        /**
         * <p>Clicking the date will open up new activity</p>
         * @param view Clicked day.
         * @author Aku Telimaa
         * @since 1.0
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

        @Override
        protected void onResume () {
            super.onResume();
            setupDays();
        }

    public void createNewMeal(View view) {
        Intent intent = new Intent(this, lisaaAteria.class);
        startActivity(intent);
    }

    public void goToShoppingList(View view) {
        Intent intent = new Intent(this, ostosLista.class);
        startActivity(intent);
    }



}
