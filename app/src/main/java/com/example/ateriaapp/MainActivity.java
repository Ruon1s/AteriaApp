/**
 * @author Aku Telimaa
 */


package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public TextView day;
    public Aterialistatesti lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = Aterialistatesti.getInstance();
        Ateria ateria = new Ateria("Laatikko");
        ateria.setDate("04.05.2019");
        lista.aterialista.add(ateria);
        Ateria ateria4 = new Ateria("Kaapo");
        ateria4.setDate("05.05.2019");
        lista.aterialista.add(ateria4);
        Ateria ateria1 = new Ateria("Pihvi");
        ateria1.setDate("05.05.2019");
        lista.aterialista.add(ateria1);
        Ateria ateria2 = new Ateria("Kukkakaali");
        ateria2.setDate("06.05.2019");
        lista.aterialista.add(ateria2);
        Ateria ateria5 = new Ateria("Laatikko");
        ateria5.setDate("07.05.2019");
        lista.aterialista.add(ateria5);
        Ateria ateria6 = new Ateria("Laatikko");
        ateria6.setDate("08.05.2019");
        lista.aterialista.add(ateria6);
        Ateria ateria7 = new Ateria("Laatikko");
        ateria7.setDate("09.05.2019");
        lista.aterialista.add(ateria7);
        for (int w = 0; w < lista.aterialista.size() ; w++) {
            Log.d(TAG, "onCreate: "+lista.getAteria(w).toString());
        }





        setupDays();
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
    private void setupDays(){
        for (int i = 0 ; i < 7; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.US);
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, i);
            String newDate = sdf.format(cal.getTime());
            Log.d(TAG, "setupDays: " +newDate);
            SimpleDateFormat sdf1 = new SimpleDateFormat("E", Locale.US);
            String newDate1 = sdf1.format(cal.getTime());
            newDate1 = convertDayName(newDate1);
            Log.d(TAG, "setupDays: " +newDate1+" Size of List is "+lista.aterialista.size());
            if (i==0) {
                day = (TextView) findViewById(R.id.viikonpaiva1);
            } else if (i==1) {
                day = (TextView) findViewById(R.id.viikonpaiva2);
            } else if (i==2) {
                day = (TextView) findViewById(R.id.viikonpaiva3);
            } else if (i==3) {
                day = (TextView) findViewById(R.id.viikonpaiva4);
            } else if (i==4) {
                day = (TextView) findViewById(R.id.viikonpaiva5);
            } else if (i==5) {
                day = (TextView) findViewById(R.id.viikonpaiva6);
            } else {
                day = (TextView) findViewById(R.id.viikonpaiva7);
            }
            String dateText = ""+newDate1+" "+newDate+"\n";

            for (int x = 0 ; x < lista.aterialista.size() ; x++) {
                Ateria olio = lista.getAteria(x);
                Log.d(TAG, "setupDays: Olion Date on: " +olio.getDate());

                if (olio.getDate().equals(newDate)) {
                    Log.d(TAG, "setupDays: Olio Found.");
                    dateText = ""+dateText+ ""+ olio.getNimi()+"\n";
                } else {
                    Log.d(TAG, "setupDays: Olio not found");
                }
            }
            dateText = ""+dateText+"Klikkaa Lisätäksesi Ateria";
            day.setText(dateText);

        }
    }

    /**
     * <p>Clicking the date will open up new activity</p>
     * @param view Clicked TextView
     * @author Aku Telimaa
     * @since 1.0
     */
    public void addMeal(View view) {
        Log.d(TAG, "addMeal: " +view.getId() );
        TextView textView = (TextView) findViewById(view.getId());
        Log.d(TAG, "addMeal: "+ textView.getText());
        String fulldate = textView.getText().toString();
        String[] date = fulldate.split(" ", 3);
        Log.d(TAG, "addMeal: "+date[0]+" "+date[1]);
        String dateish =  ""+date[0]+" "+date[1];
        Intent intent = new Intent(this, AteriaNakyma.class);
        intent.putExtra("date", dateish);
        startActivity(intent);

    }


}
