package com.example.android.popularmovie;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Chen on 7/20/2015.
 */
public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> data;

    public GridViewAdapter(Context context, ArrayList<String> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = new ImageView(context);
        }

        String url = data.get(position);
        Picasso.with(context)
                .load(url)
                .placeholder(R.raw.placeholder_image)
                .into((ImageView) convertView);

        return convertView;
    }
}