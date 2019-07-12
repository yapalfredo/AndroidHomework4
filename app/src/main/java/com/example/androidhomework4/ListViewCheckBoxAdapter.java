package com.example.androidhomework4;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import java.util.ArrayList;
import java.util.List;

public class ListViewCheckBoxAdapter extends ArrayAdapter<String> {

    Context context;
    ArrayList<String> hobbies;
    LayoutInflater lInflater;


    public ListViewCheckBoxAdapter(Context context, ArrayList<String> hobbies) {
        super(context, 0, hobbies);

        this.context = context;
        this.hobbies = hobbies;
        lInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return hobbies.size();
    }

    @Override
    public String getItem(int position) {
        return hobbies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null)
        {
            view = lInflater.inflate(R.layout.listview_hobbies_layout,parent,false  );


        }

        return view;
    }

}
