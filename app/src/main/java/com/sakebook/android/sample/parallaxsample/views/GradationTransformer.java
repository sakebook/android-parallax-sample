package com.sakebook.android.sample.parallaxsample.views;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.sakebook.android.sample.parallaxsample.FragmentViewHolder;
import com.sakebook.android.sample.parallaxsample.R;

/**
 * Created by sakemotoshinya on 15/12/19.
 */
public class GradationTransformer implements ViewPager.PageTransformer{
    @Override
    public void transformPage(View view, float position) {
        float alpha = 0;
        int width = view.getWidth();
        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
        } else if (-1 < position && position < 0) {
            // 左にスワイプ
            alpha = position + 1;
            view.setTranslationX(-width * position);
            view.setAlpha(alpha * 2);
        } else if (0 <= position && position <= 1) {
            // 右にスワイプ
            alpha = 1 - position;
            view.setAlpha(alpha * 2);
            view.setTranslationX(- width * position);
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
        }
    }
}
