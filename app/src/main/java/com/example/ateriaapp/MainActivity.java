package com.example.ateriaapp;

import androidx.appcompat.app.AppCompatActivity;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupDays();
    }

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

    private void setupDays(){
        for (int i = 0 ; i < 7; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd", Locale.US);
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, i);
            String newDate = sdf.format(cal.getTime());
            Log.d(TAG, "setupDays: " +newDate);
            SimpleDateFormat sdf1 = new SimpleDateFormat("E", Locale.US);
            String newDate1 = sdf1.format(cal.getTime());
            newDate1 = convertDayName(newDate1);
            Log.d(TAG, "setupDays: " +newDate1);

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

            String dateText = ""+newDate1+" "+newDate;

            day.setText(dateText);

        }
    }

    public void addMeal(View view) {

    }
}
