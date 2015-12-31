package com.sakebook.android.sample.parallaxsample.acitvities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;

import com.sakebook.android.sample.parallaxsample.fragments.ImageFragment;
import com.sakebook.android.sample.parallaxsample.views.ImageTransformer;
import com.sakebook.android.sample.parallaxsample.views.adapters.ParallaxPagerAdapter;
import com.sakebook.android.sample.parallaxsample.R;

public class ParallaxImageActivity extends AppCompatActivity{

    private SparseArray<Fragment> viewSparseArray = new SparseArray<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallax_image);
        initViewPager();
    }

    private void initViewPager() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        ParallaxPagerAdapter adapter = new ParallaxPagerAdapter(fragmentManager, this, makeFragments());
        viewPager.setAdapter(adapter);
        viewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.small_margin));
        viewPager.setPageTransformer(false, new ImageTransformer());
    }

    private SparseArray<Fragment> makeFragments() {
        viewSparseArray.put(0, ImageFragment.newInstance(getString(R.string.flickr_title_peterliuphoto), 0, R.layout.fragment_image_layout, R.drawable.peterliuphoto, getString(R.string.flickr_url_peterliuphoto)));
        viewSparseArray.put(1, ImageFragment.newInstance(getString(R.string.flickr_title_christopherf), 1, R.layout.fragment_image_layout, R.drawable.christopherf, getString(R.string.flickr_url_christopherf)));
        viewSparseArray.put(2, ImageFragment.newInstance(getString(R.string.flickr_title_ryandesiderio), 2, R.layout.fragment_image_layout, R.drawable.ryandesiderio, getString(R.string.flickr_url_ryandesiderio)));
        viewSparseArray.put(3, ImageFragment.newInstance(getString(R.string.flickr_title_omerunlu), 3, R.layout.fragment_image_layout, R.drawable.omerunlu, getString(R.string.flickr_url_omerunlu)));
        viewSparseArray.put(4, ImageFragment.newInstance(getString(R.string.flickr_title_malhotraxtreme), 4, R.layout.fragment_image_layout, R.drawable.malhotraxtreme, getString(R.string.flickr_url_malhotraxtreme)));
        return viewSparseArray;

    }
}
