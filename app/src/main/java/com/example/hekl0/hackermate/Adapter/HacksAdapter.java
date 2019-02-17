package com.example.hekl0.hackermate.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.hekl0.hackermate.Model.HackModel;
import com.example.hekl0.hackermate.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HacksAdapter extends BaseAdapter {
    List<HackModel> hackModelList = new ArrayList<>();

    public HacksAdapter() {
        hackModelList.add(new HackModel("BrickHack", "Hackermate", Arrays.asList("1", "2", "3", "4")));
        hackModelList.add(new HackModel("DandyHack", "Drawing Graph", Arrays.asList("1", "2")));
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
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        convertView = layoutInflater.inflate(R.layout.hack_item, parent, false);

        TextView hackName = convertView.findViewById(R.id.hack_name);
        TextView projectName = convertView.findViewById(R.id.project_name);
        ImageView ava1 = convertView.findViewById(R.id.ava1);
        ImageView ava2 = convertView.findViewById(R.id.ava2);
        ImageView ava3 = convertView.findViewById(R.id.ava3);
        ImageView ava4 = convertView.findViewById(R.id.ava4);

        hackName.setText(hackModelList.get(position).hackName);
        projectName.setText(hackModelList.get(position).project);

        if (hackModelList.get(position).team.size() == 2) {
            ava3.setVisibility(View.GONE);
            ava4.setVisibility(View.GONE);
        }

        return convertView;
    }
}
