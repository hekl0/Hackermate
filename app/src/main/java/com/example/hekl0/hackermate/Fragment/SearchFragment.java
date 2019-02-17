package com.example.hekl0.hackermate.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import com.example.hekl0.hackermate.Adapter.CardstackViewAdapter;
import com.example.hekl0.hackermate.R;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.StackFrom;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements View.OnClickListener {
    CardStackView cardStackView;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        CardstackViewAdapter cardstackViewAdapter = new CardstackViewAdapter();
        cardStackView = view.findViewById(R.id.cardstack_view);
        cardStackView.setAdapter(cardstackViewAdapter);

        CardStackLayoutManager cardStackLayoutManager = new CardStackLayoutManager(this.getContext());
        cardStackLayoutManager.setStackFrom(StackFrom.Top);
        cardStackView.setLayoutManager(cardStackLayoutManager);

        ImageView iv_setting = view.findViewById(R.id.iv_setting);
        ImageView iv_undo = view.findViewById(R.id.iv_undo);
        ImageView iv_info = view.findViewById(R.id.iv_info);
        ImageView iv_inbox = view.findViewById(R.id.iv_inbox);

        iv_undo.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_undo:
                cardStackView.rewind();
                break;
            case R.id.iv_setting:
                break;
            case R.id.iv_info:
                break;
            case R.id.iv_inbox:
                break;
        }
    }
}
