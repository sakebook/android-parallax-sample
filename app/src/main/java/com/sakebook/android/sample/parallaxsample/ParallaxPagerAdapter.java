package com.sakebook.android.sample.parallaxsample;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

/**
 * Created by sakemotoshinya on 15/12/14.
 */
public class ParallaxPagerAdapter extends FragmentPagerAdapter{

    private Context mContext;
    private SparseArray<Fragment> sparseArray = new SparseArray<>();

    public ParallaxPagerAdapter(FragmentManager fm, Context context, SparseArray<Fragment> fragments) {
        super(fm);
        mContext = context;
        this.sparseArray = fragments;
    }

    @Override
    public int getCount() {
        return sparseArray.size();
    }


    @Override
    public Fragment getItem(int position) {
        return this.sparseArray.get(position);
    }
}
