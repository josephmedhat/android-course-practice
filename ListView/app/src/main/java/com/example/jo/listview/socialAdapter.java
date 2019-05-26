package com.example.jo.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class socialAdapter extends ArrayAdapter<social> {

    private Context context;
    private ArrayList<social> socials;
    public socialAdapter( Context context, ArrayList<social> list) {
        super(context, R.layout.item2,R.id.tv,list);
        this.context = context;
        this.socials = list;
        Log.d("adapter","constructed");
    }

    @NonNull
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item=inflater.inflate(R.layout.item2,parent,false);

        Log.d("adapter","inflated");
        TextView tv_name=(TextView)item.findViewById(R.id.tv);
        ImageView img=(ImageView)item.findViewById(R.id.img1);

        tv_name.setText(socials.get(position).getName());
        img.setImageResource(socials.get(position).getImage());
        Log.d("adapter","Content set");
        Log.d("adapter",tv_name.getText().toString());
        Log.d("adapter",img.getResources().toString());

        return item;

    }
}
