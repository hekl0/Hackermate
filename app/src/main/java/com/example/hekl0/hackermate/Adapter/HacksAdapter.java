package com.example.hekl0.hackermate.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.hekl0.hackermate.Model.HackModel;

import java.util.ArrayList;
import java.util.List;

public class HacksAdapter extends BaseAdapter {
    List<HackModel> hackModelList = new ArrayList<>();

    public HacksAdapter() {
        hackModelList.add(new HackModel("BrickHack", "Hackermate"));
        hackModelList.add(new HackModel("DandyHack", "Drawing Graph"));
    }

    @Override
    public int getCount() {
        return hackModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return hackModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
