package com.sakebook.android.sample.parallaxsample.acitvities;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.View;

import com.sakebook.android.sample.parallaxsample.R;
import com.sakebook.android.sample.parallaxsample.fragments.TransitionAnimationFragment;
import com.sakebook.android.sample.parallaxsample.views.adapters.ParallaxPagerAdapter;

public class TransitionAnimationActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager viewPager;
    private ParallaxPagerAdapter adapter;
    private SparseArray<Fragment> viewSparseArray = new SparseArray<>();
    private PathMeasure sunRisesPathMeasure = new PathMeasure();
    private PathMeasure sunSetsPathMeasure = new PathMeasure();
    private float[] morning = new float[2];
    private float[] noon = new float[2];
    private float[] evening = new float[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_animation);
        initViewPager();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        initSunPosition();
    }

    private void initSunPosition() {
        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        View sun = findViewById(R.id.sun);
        float x = sun.getWidth();
        float y = sun.getHeight();
        morning[0] = 0;
        morning[1] = (point.y - (y / 2)) / 2;
        noon[0] = ((point.x - x) / 2);
        noon[1] = ((point.y / 2) - (point.x / 2)) - (x / 2);
        evening[0] = point.x - x;
        evening[1] = (point.y - (y / 2)) / 2;
        sun.setX(morning[0]);
        sun.setY(morning[1]);
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new ParallaxPagerAdapter(fragmentManager, this, makeFragments());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
//        viewPager.setPageTransformer(false, new TransitionTransformer());
    }

    private SparseArray<Fragment> makeFragments() {
        viewSparseArray.put(0, TransitionAnimationFragment.newInstance("Sun Rises", 0, R.layout.fragment_transition_animation_layout));
        viewSparseArray.put(1, TransitionAnimationFragment.newInstance("Noon", 1, R.layout.fragment_transition_animation_layout));
        viewSparseArray.put(2, TransitionAnimationFragment.newInstance("Sun Sets", 2, R.layout.fragment_transition_animation_layout));
        return viewSparseArray;

    }

    private void sunRises(float fraction) {
        final Path path = new Path();
        final View v = findViewById(R.id.sun);
        v.setScaleX(1f - 1f * fraction / 2);
        v.setScaleY(1f - 1f * fraction / 2);
        float x = morning[0];
        float y = morning[1];
        path.moveTo(x + 0, y + 0);
        path.cubicTo(
                noon[0] / 3, morning[1] / 4 * 2,
                noon[0] / 3 * 2, morning[1] / 4,
                noon[0], noon[1]
        );
        sunRisesPathMeasure.setPath(path, false);
        float[] point = new float[2];
        sunRisesPathMeasure.getPosTan(sunRisesPathMeasure.getLength() * fraction, point, null);
        v.setX(point[0]);
        v.setY(point[1]);
    }

    private void sunSets(float fraction) {
        final Path path = new Path();
        final View v = findViewById(R.id.sun);
        v.setScaleX(1f - 1f * (1 - fraction) / 2);
        v.setScaleY(1f - 1f * (1 - fraction) / 2);
        float x = noon[0];
        float y = noon[1];
        path.moveTo(x + 0, y + 0);
        path.cubicTo(
                noon[0] / 3 * 4, morning[1] / 4,
                noon[0] / 3 * 5, morning[1] / 4 * 2,
                evening[0], evening[1]
        );
        sunSetsPathMeasure.setPath(path, false);
        float[] point = new float[2];
        sunSetsPathMeasure.getPosTan(sunSetsPathMeasure.getLength() * fraction, point, null);
        v.setX(point[0]);
        v.setY(point[1]);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d("onPageScrolled", "position: " + position + ", positionOffset: " + positionOffset + ", positionOffsetPixels: " + positionOffsetPixels);
        if (position == 0) {
            sunRises(positionOffset);
        } else if (position == 1) {
            sunSets(positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
