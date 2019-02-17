package com.example.hekl0.hackermate.Activity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hekl0.hackermate.R;

import org.w3c.dom.Text;

public class DataAdapter extends BaseAdapter {
    String[] hackathon;

    public DataAdapter(String[] items) {
        this.hackathon = items;
    }

    @Override
    public int getCount() {
        return hackathon.length;
    }

    @Override
    public Object getItem(int position) {
        return hackathon[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        view = inflater.inflate(R.layout.fragment_profile,parent,false);
//
//        TextView tvName = view.findViewById(R.id.hacks);
//        tvName.setText(hackathon[i]);
//
//        return view;
        return null;
    }
}
