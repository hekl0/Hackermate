package com.example.hekl0.hackermate.Adapter;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.hekl0.hackermate.Model.Chat;
import com.example.hekl0.hackermate.R;

import com.squareup.picasso.Picasso;


import jp.wasabeef.picasso.transformations.CropCircleTransformation;

import java.util.List;


public class DataAdapterInBox extends BaseAdapter {
    List<Chat> items;
    Activity activity;
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public DataAdapterInBox(Activity a,List<Chat> s) {
        this.items = s;
        this.activity = a;

    }

    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = activity.getLayoutInflater();

        view = inflater.inflate(R.layout.messages, null);
        // Đặt chữ cho từng view trong danh sách.
        if(i%2==0) {
            view.findViewById(R.id.leftlo).setVisibility(view.GONE);
        }
        else view.findViewById(R.id.tv_name1).setVisibility(view.GONE);
        TextView tvName = view.findViewById(R.id.tv_name1);
        ImageView img = view.findViewById(R.id.img);
        Picasso.get()
                .load(R.mipmap.anhdeptrai)
                .transform(new CropCircleTransformation())
                .into(img);
        tvName.setText(items.get(i).Content);
        tvName = view.findViewById(R.id.tv_name0);
        tvName.setText(items.get(i).Content);
        // Trả về view kết quả.
        return view;
    }
}
