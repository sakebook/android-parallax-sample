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

public class ImageActivity extends AppCompatActivity{

    private ViewPager viewPager;
    private ParallaxPagerAdapter adapter;
    private SparseArray<Fragment> viewSparseArray = new SparseArray<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        initViewPager();
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new ParallaxPagerAdapter(fragmentManager, this, makeFragments());
        viewPager.setAdapter(adapter);
        viewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.small_margin));
        viewPager.setPageTransformer(false, new ImageTransformer());
    }

    private SparseArray<Fragment> makeFragments() {
        viewSparseArray.put(0, ImageFragment.newInstance("Sunset Sky", 0, R.layout.fragment_image_layout, R.drawable.peterliuphoto, "https://www.flickr.com/photos/peterliuphoto/"));
        viewSparseArray.put(1, ImageFragment.newInstance("Nothing Like a Litte Blue Skies", 1, R.layout.fragment_image_layout, R.drawable.christopherf, "https://www.flickr.com/photos/christopherf/"));
        viewSparseArray.put(2, ImageFragment.newInstance("HDR Skies", 2, R.layout.fragment_image_layout, R.drawable.ryandesiderio, "https://www.flickr.com/photos/ryandesiderio/"));
        viewSparseArray.put(3, ImageFragment.newInstance("SKY and MILKWAY", 3, R.layout.fragment_image_layout, R.drawable.omerunlu, "https://www.flickr.com/photos/55293400@N07/"));
        viewSparseArray.put(4, ImageFragment.newInstance("Lovely sky", 4, R.layout.fragment_image_layout, R.drawable.malhotraxtreme, "https://www.flickr.com/photos/malhotraxtreme/"));
        return viewSparseArray;

    }
}
