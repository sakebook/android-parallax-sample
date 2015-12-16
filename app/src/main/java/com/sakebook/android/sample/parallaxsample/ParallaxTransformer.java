package com.sakebook.android.sample.parallaxsample;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sakemotoshinya on 15/12/16.
 */
public class ParallaxTransformer implements ViewPager.PageTransformer{
    @Override
    public void transformPage(View view, float position) {
        float alpha = 0;
        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
//            view.setAlpha(0);
        } else if (-1 < position && position < 0) {
            // 左にスワイプ
            alpha = position + 1;
            viewTransition(view, position, alpha);
        } else if (0 <= position && position <= 1) {
            // 右にスワイプ
            alpha = 1 - position;
            viewTransition(view, position, alpha);
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
//            view.setAlpha(0);
        }
    }

    private void viewTransition(View view, float position, float alpha) {
        switch (view.getId()) {
            case R.id.layout_first:
                firstTransition(view, position, alpha);
                break;
            case R.id.layout_second:
                secondTransition(view, position, alpha);
                break;
            case R.id.layout_third:
                thirdTransition(view, position, alpha);
                break;
            case R.id.layout_fourth:
                fourthTransition(view, position, alpha);
                break;
            case R.id.layout_fifth:
                fifthTransition(view, position, alpha);
                break;
        }

    }

    private void firstTransition(View view, float position, float alpha) {
        int width = view.getWidth();
        View image = view.findViewById(R.id.image_back);
        image.setTranslationX(- width / 2 * position);
    }

    private void secondTransition(View view, float position, float alpha) {
        int width = view.getWidth();
        View image = view.findViewById(R.id.image_back);
        image.setTranslationX(- width / 2 * position);
    }

    private void thirdTransition(View view, float position, float alpha) {
        int width = view.getWidth();
        View image = view.findViewById(R.id.image_back);
        image.setTranslationX(- width / 2 * position);
    }

    private void fourthTransition(View view, float position, float alpha) {
        int width = view.getWidth();
        View image = view.findViewById(R.id.image_back);
        image.setTranslationX(- width / 2 * position);
    }

    private void fifthTransition(View view, float position, float alpha) {
        int width = view.getWidth();
        View image = view.findViewById(R.id.image_back);
        image.setTranslationX(- width / 2 * position);
    }

}
