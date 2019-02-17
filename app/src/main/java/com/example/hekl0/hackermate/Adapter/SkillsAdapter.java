package com.example.hekl0.hackermate.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.hekl0.hackermate.R;

import java.util.ArrayList;
import java.util.List;

public class SkillsAdapter extends BaseAdapter {
    public List<String> listSkills = new ArrayList<>();
    public Boolean[] checkItem;
    boolean clickable;

    public SkillsAdapter(boolean clickable) {
        this.clickable = clickable;

        listSkills.add("Javascript");
        listSkills.add("Fullstack");
        listSkills.add("Backend");
        listSkills.add("Frontend");
        listSkills.add("AI");
        listSkills.add("Python");

        checkItem = new Boolean[listSkills.size()];
        for (int i = 0; i < checkItem.length; i++)
            checkItem[i] = false;
    }

    public SkillsAdapter(boolean clickable, List<String> skills) {
        this.clickable = clickable;

        listSkills = skills;

        checkItem = new Boolean[listSkills.size()];
        for (int i = 0; i < checkItem.length; i++)
            checkItem[i] = false;
    }

    @Override
    public int getCount() {
        return listSkills.size();
    }

    @Override
    public Object getItem(int position) {
        return listSkills.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        convertView = layoutInflater.inflate(R.layout.round_border_item, parent, false);

        TextView textView = convertView.findViewById(R.id.text);
        textView.setText(listSkills.get(position));

        if (clickable) {
            final LinearLayout layout = convertView.findViewById(R.id.layout);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("xxx", "onClick: " + position + " " + checkItem[0]);
                    checkItem[position] = !checkItem[position];
                    if (checkItem[position] == false)
                        layout.setBackgroundResource(R.drawable.uncheck_empty_round_border);
                    else
                        layout.setBackgroundResource(R.drawable.check_empty_round_border);
                }
            });
        }

        return convertView;
    }
}
