package com.sakebook.android.sample.parallaxsample.acitvities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;

import com.sakebook.android.sample.parallaxsample.views.GradationTransformer;
import com.sakebook.android.sample.parallaxsample.views.adapters.ParallaxPagerAdapter;
import com.sakebook.android.sample.parallaxsample.views.ParallaxTransformer;
import com.sakebook.android.sample.parallaxsample.R;
import com.sakebook.android.sample.parallaxsample.fragments.GradationFragment;

public class GradationActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager viewPager;
    private ParallaxPagerAdapter adapter;
    private SparseArray<Fragment> viewSparseArray = new SparseArray<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradation);
        initViewPager();
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new ParallaxPagerAdapter(fragmentManager, this, makeFragments());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
        viewPager.setPageTransformer(false, new GradationTransformer());
    }

    private SparseArray<Fragment> makeFragments() {
        viewSparseArray.put(0, GradationFragment.newInstance(R.color.red));
        viewSparseArray.put(1, GradationFragment.newInstance(R.color.green));
        viewSparseArray.put(2, GradationFragment.newInstance(R.color.purple));
        viewSparseArray.put(3, GradationFragment.newInstance(R.color.orange));
        viewSparseArray.put(4, GradationFragment.newInstance(R.color.blue));
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
