package com.example.hekl0.hackermate.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.hekl0.hackermate.Model.ProfileModel;
import com.example.hekl0.hackermate.R;

import java.util.ArrayList;
import java.util.List;

public class CardstackViewAdapter extends RecyclerView.Adapter<CardstackViewAdapter.CardstackViewHolder>  {
    List<ProfileModel> profileModelList = new ArrayList<>();

    public CardstackViewAdapter() {
        for (int i = 0; i < 10; i++)
            profileModelList.add(new ProfileModel("", "Loc Bui " + i, "University of Rochester", "Computer Science"));
    }

    @NonNull
    @Override
    public CardstackViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = layoutInflater.inflate(R.layout.cardstack_item, viewGroup, false);
        return new CardstackViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardstackViewHolder cardstackViewHolder, int i) {
        cardstackViewHolder.setData(profileModelList.get(i));
    }

    @Override
    public int getItemCount() {
        return profileModelList.size();
    }

    public class CardstackViewHolder extends RecyclerView.ViewHolder {
        View view;

        public CardstackViewHolder(View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setData(ProfileModel profileModel) {
            TextView name = view.findViewById(R.id.name);
            TextView majorSchool = view.findViewById(R.id.major_and_school);
            ImageView badge = view.findViewById(R.id.iv_badge);

            name.setText(profileModel.name);
            majorSchool.setText(profileModel.major + ", " + profileModel.school);
            badge.setImageResource(R.drawable.badge_5);
        }
    }
}
