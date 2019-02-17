package com.example.hekl0.hackermate.Adapter;

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

import com.example.hekl0.hackermate.Activity.ChatActivity;
import com.example.hekl0.hackermate.Model.ChatPerson;
import com.example.hekl0.hackermate.R;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

import java.io.File;
import java.util.List;

public class DataAdapterChatBox extends BaseAdapter {
    Fragment fragment;
    List<ChatPerson> cp;
    public static String src,src1,src2,src3;
    @Override
    public int getCount() {
        return cp.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public DataAdapterChatBox(Fragment a, List<ChatPerson> CP) {
        this.fragment = a;
        this.cp = CP;
        Log.d("xxx", "getView:" + " " + cp.size());
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = fragment.getLayoutInflater();

        view = inflater.inflate(R.layout.chatsquare, null);
        // Đặt chữ cho từng view trong danh sách.
        TextView tvName = view.findViewById(R.id.PersonName);
        ImageView img = view.findViewById(R.id.avatar);
        src1 = "https://firebasestorage.googleapis.com/v0/b/hackermate-b2f98.appspot.com/o/ava_bao.jpg?alt=media&token=c99f06db-39f6-4272-afd1-56e8b1c25ec0";
        src2 = "https://firebasestorage.googleapis.com/v0/b/hackermate-b2f98.appspot.com/o/ava_phanh.jpg?alt=media&token=49752088-947a-469c-9485-3ad5015bf042";
        src2 = "https://firebasestorage.googleapis.com/v0/b/hackermate-b2f98.appspot.com/o/ava_ash.jpg?alt=media&token=a992b408-4562-4644-8497-a9df077c74d7";
        final LinearLayout chatsquare = view.findViewById(R.id.ChatSquare);
        src = "https://firebasestorage.googleapis.com/v0/b/hackermate-b2f98.appspot.com/o/ava_bao.jpg?alt=media&token=c99f06db-39f6-4272-afd1-56e8b1c25ec0";
        if(i==1) src = "https://firebasestorage.googleapis.com/v0/b/hackermate-b2f98.appspot.com/o/ava_phanh.jpg?alt=media&token=49752088-947a-469c-9485-3ad5015bf042";
        if(i==2) src = "https://firebasestorage.googleapis.com/v0/b/hackermate-b2f98.appspot.com/o/ava_ash.jpg?alt=media&token=a992b408-4562-4644-8497-a9df077c74d7";
        Picasso.get()
                .load(src)
                .transform(new CropCircleTransformation())
                .into(img);
        tvName.setText(cp.get(i).Name);
        tvName = view.findViewById(R.id.PersonLastMess);
        tvName.setText(cp.get(i).LastMess);
        chatsquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0) src = "https://firebasestorage.googleapis.com/v0/b/hackermate-b2f98.appspot.com/o/ava_bao.jpg?alt=media&token=c99f06db-39f6-4272-afd1-56e8b1c25ec0";
                if(i==1) src = "https://firebasestorage.googleapis.com/v0/b/hackermate-b2f98.appspot.com/o/ava_phanh.jpg?alt=media&token=49752088-947a-469c-9485-3ad5015bf042";
                if(i==2) src = "https://firebasestorage.googleapis.com/v0/b/hackermate-b2f98.appspot.com/o/ava_ash.jpg?alt=media&token=a992b408-4562-4644-8497-a9df077c74d7";
                Intent intent = new Intent(fragment.getContext(), ChatActivity.class);
                fragment.getActivity().overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
                fragment.getContext().startActivity(intent);
            }
        });
        // Trả về view kết quả.
        return view;
    }
}
