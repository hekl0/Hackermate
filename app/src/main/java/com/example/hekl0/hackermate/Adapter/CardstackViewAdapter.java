package com.example.hekl0.hackermate.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.hekl0.hackermate.Model.ProfileModel;
import com.example.hekl0.hackermate.R;

import java.util.ArrayList;
import java.util.List;

public class CardstackViewAdapter extends RecyclerView.Adapter<CardstackViewAdapter.CardstackViewHolder>  {
    List<ProfileModel> profileModelList = new ArrayList<>();

    @NonNull
    @Override
    public CardstackViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CardstackViewHolder cardstackViewHolder, int i) {
        cardstackViewHolder.setData(profileModelList.get(i));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CardstackViewHolder extends RecyclerView.ViewHolder {
        View view;

        public CardstackViewHolder(View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setData(ProfileModel profileModel) {
            TextView name = view.findViewById(R.id.name);
            TextView school = view.findViewById(R.id.school);
            TextView major = view.findViewById(R.id.major);
        }
    }
}
