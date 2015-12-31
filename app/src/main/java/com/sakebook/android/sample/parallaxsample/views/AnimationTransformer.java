package com.sakebook.android.sample.parallaxsample.views;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sakemotoshinya on 15/12/23.
 */
public class AnimationTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View view, float position) {
        float alpha = 0;
        if (position <= -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
        } else if (-1 < position && position < 0) {
            // left side shown View
            alpha = position + 1;
            viewTransition(view, position, alpha);
        } else if (0 <= position && position <= 1) {
            // right side shown View
            alpha = 1 - position;
            viewTransition(view, position, alpha);
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
        }
    }

    private void viewTransition(View view, float position, float alpha) {
        int width = view.getWidth();
        int height = view.getHeight();
        ViewGroup viewGroup = (ViewGroup) view;
        int count = ((ViewGroup) view).getChildCount();
        for (int i = 0; i < count; i++) {
            View child = viewGroup.getChildAt(i);
            Accelerate accelerate = (Accelerate) child.getTag();
            child.setTranslationX(width * position * accelerate.getX());
            child.setTranslationY(height * position * accelerate.getY());
        }
    }

    public static class Accelerate {
        private float x;
        private float y;

        public Accelerate(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }
    }
}