package com.example.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

// this adapter only works for cities
public class CityArrayAdapter extends ArrayAdapter<City> {
    public CityArrayAdapter(Context context, ArrayList<City> cities) {
        super(context, 0, cities);  // 0 because want to manually handle rendering views
    }

    // return view for each element in array
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // position is index of element want to get view for in array
        // Nullable is pointer to View that may or may not exist
        // parent is reference to parent ListView?

        View view;
        if (convertView == null) {  // create own View if pointer doesn't exist
            view = LayoutInflater.from(getContext()).inflate(R.layout.content, parent, false);
        } else {  // already have entirety of context.xml which is single element in list
            view = convertView;
        }

        City city = getItem(position);
        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getName());
        provinceName.setText(city.getProvince());

        return view;
    }
}
