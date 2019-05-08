package com.example.ateriaapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class ShoppingAdapter extends ArrayAdapter<Ateria> {
    public String aineet;

    public ShoppingAdapter(Activity context, ArrayList<Ateria> position) {
        super(context, 0, position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null ) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.ostokset, parent, false);
        }
        Ateria getPos = getItem(position);

        TextView mealName = (TextView) listItemView.findViewById(R.id.mealName);
        mealName.setText(getPos.getNimi());

        TextView mealIngs = (TextView) listItemView.findViewById(R.id.mealIngredients);

        mealIngs.setText(getPos.getShopListString());
        return listItemView;
    }
}
