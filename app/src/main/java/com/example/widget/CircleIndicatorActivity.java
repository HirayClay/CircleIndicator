package com.example.widget;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.example.widget.fragment.AccentPage;
import com.example.widget.fragment.CyanPage;
import com.example.widget.fragment.TintPage;
import com.example.widget.fragment.YellowPage;
import com.example.widget.widget.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CircleIndicatorActivity extends AppCompatActivity {

    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.circleindicator)
    CircleIndicator circleindicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_indicator);
        ButterKnife.bind(this);
        final List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(YellowPage.newInstance());
        fragmentList.add(TintPage.newInstance());
        fragmentList.add(CyanPage.newInstance());
        fragmentList.add(AccentPage.newInstance());

        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        circleindicator.setViewPager(viewpager);
    }
}
