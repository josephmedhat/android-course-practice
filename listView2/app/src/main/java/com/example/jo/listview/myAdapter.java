package com.example.jo.listview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class myAdapter extends BaseAdapter {
    private Activity activity;
    private String names [];
    private int images [];

    public myAdapter(Activity activity, String[] names, int[] images) {
        this.activity = activity;
        this.names = names;
        this.images = images;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =activity.getLayoutInflater();
        View item = inflater.inflate(R.layout.item,null,false);

        TextView tv=item.findViewById(R.id.tv);
        ImageView img=item.findViewById(R.id.img);

        tv.setText(names[position]);
        img.setImageResource(images[position]);
        return item;
    }
}
