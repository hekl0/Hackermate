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
    List<String> listHackathons = new ArrayList<>();
    Boolean[] checkItem;

    public SkillsAdapter() {
        listHackathons.add("Javascript");
        listHackathons.add("Web Development");
        listHackathons.add("Backend");
        listHackathons.add("Frontend");
        listHackathons.add("Machine Learning");
        listHackathons.add("Python");

        checkItem = new Boolean[listHackathons.size()];
        for (int i = 0; i < checkItem.length; i++)
            checkItem[i] = false;
    }

    @Override
    public int getCount() {
        return listHackathons.size();
    }

    @Override
    public Object getItem(int position) {
        return listHackathons.get(position);
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
        textView.setText(listHackathons.get(position));

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

        return convertView;
    }
}
