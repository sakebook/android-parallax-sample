package com.sakebook.android.sample.parallaxsample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;

import com.sakebook.android.sample.parallaxsample.fragments.FifthFragment;
import com.sakebook.android.sample.parallaxsample.fragments.FirstFragment;
import com.sakebook.android.sample.parallaxsample.fragments.FourthFragment;
import com.sakebook.android.sample.parallaxsample.fragments.SecondFragment;
import com.sakebook.android.sample.parallaxsample.fragments.ThirdFragment;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager viewPager;
    private ParallaxPagerAdapter adapter;
    private SparseArray<Fragment> viewSparseArray = new SparseArray<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewPager();
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new ParallaxPagerAdapter(fragmentManager, this, makeFragments());
        viewPager.setAdapter(adapter);
        viewPager.setPageMargin(16);
//        viewPager.setPageMarginDrawable(R.mipmap.ic_launcher);
//        viewPager.setOffscreenPageLimit(4);
        viewPager.addOnPageChangeListener(this);
        viewPager.setPageTransformer(false, new ParallaxTransformer());
    }

    private SparseArray<Fragment> makeFragments() {
        viewSparseArray.put(0, new FirstFragment());
        viewSparseArray.put(1, new SecondFragment());
        viewSparseArray.put(2, new ThirdFragment());
        viewSparseArray.put(3, new FourthFragment());
        viewSparseArray.put(4, new FifthFragment());
        return viewSparseArray;

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
