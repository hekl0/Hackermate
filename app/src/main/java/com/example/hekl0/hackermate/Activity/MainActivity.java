package com.example.hekl0.hackermate.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.hekl0.hackermate.Adapter.ViewPagerAdapter;
import com.example.hekl0.hackermate.Fragment.SearchFragment;
import com.example.hekl0.hackermate.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationBar bottomNavigationBar = findViewById(R.id.bottom_navigation);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.item_chat, "Chat").setActiveColorResource(R.color.fbutton_color_emerald))
                .addItem(new BottomNavigationItem(R.drawable.item_search, "search").setActiveColorResource(R.color.fbutton_color_carrot))
                .addItem(new BottomNavigationItem(R.drawable.item_profile, "Profile").setActiveColorResource(R.color.fbutton_default_color))
                .setFirstSelectedPosition(0)
                .setMode(BottomNavigationBar.MODE_SHIFTING)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
                .initialise();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPagerAdapter.addFragment(new ChatListFragment());
        viewPager.setAdapter(viewPagerAdapter);
    }
}
