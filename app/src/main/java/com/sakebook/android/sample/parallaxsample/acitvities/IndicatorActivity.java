package com.sakebook.android.sample.parallaxsample.acitvities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import com.sakebook.android.sample.parallaxsample.fragments.IndicatorFragment;
import com.sakebook.android.sample.parallaxsample.views.adapters.ParallaxPagerAdapter;
import com.sakebook.android.sample.parallaxsample.views.ParallaxTransformer;
import com.sakebook.android.sample.parallaxsample.R;
import com.sakebook.android.sample.parallaxsample.fragments.FifthFragment;
import com.sakebook.android.sample.parallaxsample.fragments.FirstFragment;
import com.sakebook.android.sample.parallaxsample.fragments.FourthFragment;
import com.sakebook.android.sample.parallaxsample.fragments.SecondFragment;
import com.sakebook.android.sample.parallaxsample.fragments.ThirdFragment;

public class IndicatorActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager viewPager;
    private ParallaxPagerAdapter adapter;
    private SparseArray<Fragment> viewSparseArray = new SparseArray<>();
    private View indicatorFloatView;
    private float indicatorSpace;
    private TextView back;
    private TextView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator);
        initViewPager();
        setupIndicator();
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new ParallaxPagerAdapter(fragmentManager, this, makeFragments());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
//        viewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.small_margin));
//        viewPager.setPageTransformer(false, new ParallaxTransformer());
    }

    private SparseArray<Fragment> makeFragments() {
        viewSparseArray.put(0, IndicatorFragment.newInstance("zero"));
        viewSparseArray.put(1, IndicatorFragment.newInstance("one"));
        viewSparseArray.put(2, IndicatorFragment.newInstance("two"));
        viewSparseArray.put(3, IndicatorFragment.newInstance("three"));
        viewSparseArray.put(4, IndicatorFragment.newInstance("four"));
        return viewSparseArray;
    }

    private void setupIndicator() {
        float scale = getResources().getDisplayMetrics().density;
        indicatorSpace = getResources().getDimensionPixelSize(R.dimen.middle_margin);// * scale;
        indicatorFloatView = findViewById(R.id.view_float_indicator);
        back = (TextView) findViewById(R.id.text_indicator_back);
        next = (TextView) findViewById(R.id.text_indicator_next);
        back.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        indicatorFloatView.setTranslationX((position * indicatorSpace) + (positionOffset * indicatorSpace));
    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            back.setText("skip");
        } else {
            back.setText("back");
        }

        if (viewSparseArray.size() == (position + 1)) {
            next.setText("Go!");
        } else {
            next.setText("next");
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.text_indicator_next) {
            next();
        } else if (v.getId() == R.id.text_indicator_back) {
            back();
        }
    }

    private void next() {
        if (viewPager.getCurrentItem() != viewSparseArray.size()) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
            return;
        }
    }

    private void back() {
        if (viewPager.getCurrentItem() == 0) {
            return;
        }
        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
    }
}
