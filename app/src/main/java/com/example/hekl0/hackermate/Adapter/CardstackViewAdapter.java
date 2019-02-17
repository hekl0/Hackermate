package com.example.hekl0.hackermate.Adapter;

import android.support.annotation.NonNull;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.hekl0.hackermate.Model.ProfileModel;
import com.example.hekl0.hackermate.R;
import com.google.firebase.database.*;
import com.squareup.picasso.Picasso;
import okhttp3.internal.cache.DiskLruCache;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardstackViewAdapter extends RecyclerView.Adapter<CardstackViewAdapter.CardstackViewHolder>  {
    public static List<ProfileModel> profileModelList = new ArrayList<>();

    public CardstackViewAdapter(List<ProfileModel> list) {
        profileModelList = list;
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
        cardstackViewHolder.setData(profileModelList.get(i), i);
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

        public void setData(ProfileModel profileModel, int position) {
            TextView name = view.findViewById(R.id.name);
            TextView majorSchool = view.findViewById(R.id.major_and_school);
            ImageView badge = view.findViewById(R.id.iv_badge);
            ImageView ava = view.findViewById(R.id.ava);

            Picasso.get()
                    .load(profileModel.image)
                    .into(ava);
            name.setText(profileModel.name);
            majorSchool.setText(profileModel.major + ", " + profileModel.school);

            switch (position) {
                case 0:
                    badge.setImageResource(R.drawable.badge_1);
                    break;
                case 1:
                    badge.setImageResource(R.drawable.badge_2);
                    break;
                case 2:
                    badge.setImageResource(R.drawable.badge_3);
                    break;
                case 3:
                    badge.setImageResource(R.drawable.badge_5);
                    break;
            }
        }
    }
}
