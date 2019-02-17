package com.example.hekl0.hackermate.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hekl0.hackermate.R;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class DataAdapterChatBox extends BaseAdapter {
    Fragment fragment;
    ChatPerson[] cp;
    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public DataAdapterChatBox(Fragment a, ChatPerson[] CP) {
        this.fragment = a;
        this.cp = CP;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = fragment.getLayoutInflater();

        view = inflater.inflate(R.layout.chatsquare, null);
        // Đặt chữ cho từng view trong danh sách.
        TextView tvName = view.findViewById(R.id.PersonName);
        ImageView img = view.findViewById(R.id.avatar);
        LinearLayout chatsquare = view.findViewById(R.id.ChatSquare);
        Picasso.get()
                .load(R.mipmap.anhdeptrai)
                .transform(new CropCircleTransformation())
                .into(img);
        Log.d("xxx", "getView:" + i);
        tvName.setText(cp[i].Name);
        tvName = view.findViewById(R.id.PersonLastMess);
        tvName.setText(cp[i].LastMess);
        chatsquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(fragment.getContext(), ChatActivity.class);

                fragment.getActivity().overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
                fragment.getContext().startActivity(intent);
            }
        });
        // Trả về view kết quả.
        return view;
    }
}
