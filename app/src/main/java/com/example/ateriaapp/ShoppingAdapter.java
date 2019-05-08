package com.example.ateriaapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

    /**
     * <p>Custom ArrayAdapter, jotta listaan voidaan viedä aterialle sekä nimi, että
     * ilmoitetut ainesosat</p>
     * @author Aku Telimaa
     * @since 1.0 8.5.2019
     * @version 1.0 8.5.2019
     */

public class ShoppingAdapter extends ArrayAdapter<Ateria> {

    public String aineet;

    public ShoppingAdapter(Activity context, ArrayList<Ateria> position) {
        super(context, 0, position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;
        if(listView == null ) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.ostokset, parent, false);
        }
        Ateria getPos = getItem(position);

        TextView mealName = (TextView) listView.findViewById(R.id.mealName);
        mealName.setText(getPos.getNimi());

        TextView mealIngs = (TextView) listView.findViewById(R.id.mealIngredients);

        mealIngs.setText(getPos.getShopListString(getPos));
        return listView;
    }
}
