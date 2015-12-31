package com.sakebook.android.sample.parallaxsample.acitvities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;

import com.sakebook.android.sample.parallaxsample.R;
import com.sakebook.android.sample.parallaxsample.fragments.ParallaxAnimationFragment;
import com.sakebook.android.sample.parallaxsample.views.AnimationTransformer;
import com.sakebook.android.sample.parallaxsample.views.adapters.ParallaxPagerAdapter;

public class ParallaxAnimationActivity extends AppCompatActivity{

    private SparseArray<Fragment> viewSparseArray = new SparseArray<>();
    private final static int COUNT = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallax_animation);
        initViewPager();
    }

    private void initViewPager() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        ParallaxPagerAdapter adapter = new ParallaxPagerAdapter(fragmentManager, this, makeFragments());
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(false, new AnimationTransformer());
    }

    private SparseArray<Fragment> makeFragments() {
        viewSparseArray.put(0, ParallaxAnimationFragment.newInstance(COUNT));
        viewSparseArray.put(1, ParallaxAnimationFragment.newInstance(COUNT));
        viewSparseArray.put(2, ParallaxAnimationFragment.newInstance(COUNT));
        viewSparseArray.put(3, ParallaxAnimationFragment.newInstance(COUNT));
        viewSparseArray.put(4, ParallaxAnimationFragment.newInstance(COUNT));
        return viewSparseArray;

    }
}
