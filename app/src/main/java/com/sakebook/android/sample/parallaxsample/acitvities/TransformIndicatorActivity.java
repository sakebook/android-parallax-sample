package com.sakebook.android.sample.parallaxsample.acitvities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;

import com.sakebook.android.sample.parallaxsample.R;
import com.sakebook.android.sample.parallaxsample.fragments.TransformIndicatorFragment;
import com.sakebook.android.sample.parallaxsample.views.IndicatorTransformer;
import com.sakebook.android.sample.parallaxsample.views.adapters.ParallaxPagerAdapter;

public class TransformIndicatorActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager viewPager;
    private ParallaxPagerAdapter adapter;
    private SparseArray<Fragment> viewSparseArray = new SparseArray<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transform_indicator);
        initViewPager();
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new ParallaxPagerAdapter(fragmentManager, this, makeFragments());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
        viewPager.setPageTransformer(false, new IndicatorTransformer());
    }

    private SparseArray<Fragment> makeFragments() {
        viewSparseArray.put(0, TransformIndicatorFragment.newInstance("0"));
        viewSparseArray.put(1, TransformIndicatorFragment.newInstance("1"));
        viewSparseArray.put(2, TransformIndicatorFragment.newInstance("2"));
        viewSparseArray.put(3, TransformIndicatorFragment.newInstance("3"));
        viewSparseArray.put(4, TransformIndicatorFragment.newInstance("4"));
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
