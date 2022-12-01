package com.example.exercise_11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Integer> images;
    LayoutInflater inflter;
    public CustomAdapter(Context applicationContext, ArrayList<Integer> images) {
        this.context = applicationContext;
        this.images = images;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return images.size();
    }
    @Override
    public Object getItem(int i) {
        return images.get(i);
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_gridview, null); // inflate the layout
        ImageView icon = (ImageView) view.findViewById(R.id.icon); // get the reference of ImageView
        Random rand = new Random();
        int pickedImg = rand.nextInt(images.size());
        icon.setImageResource(images.get(pickedImg)); // set logo images
        return view;
    }
}