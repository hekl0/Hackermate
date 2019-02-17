package com.example.hekl0.hackermate.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

        final BottomNavigationBar bottomNavigationBar = findViewById(R.id.bottom_navigation);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.item_chat, "Chat").setActiveColorResource(R.color.fbutton_color_emerald))
                .addItem(new BottomNavigationItem(R.drawable.item_search, "search").setActiveColorResource(R.color.fbutton_color_carrot))
                .addItem(new BottomNavigationItem(R.drawable.item_profile, "Profile").setActiveColorResource(R.color.fbutton_default_color))
                .setFirstSelectedPosition(0)
                .setMode(BottomNavigationBar.MODE_SHIFTING)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
                .initialise();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        final ViewPager viewPager = findViewById(R.id.viewpager);
        viewPagerAdapter.addFragment(new ChatListFragment());
        viewPagerAdapter.addFragment(new SearchFragment());
        viewPagerAdapter.addFragment(new ProfileFragment());
        viewPager.setAdapter(viewPagerAdapter);

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                Log.d("navigation", "onTabSelected: " + position);
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                bottomNavigationBar.setFirstSelectedPosition(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
