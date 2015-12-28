package com.sakebook.android.sample.parallaxsample.views;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.sakebook.android.sample.parallaxsample.R;

/**
 * Created by sakemotoshinya on 15/12/27.
 */
public class TransitionTransformer implements ViewPager.PageTransformer{
    @Override
    public void transformPage(View view, float position) {
        float alpha = 0;
        int width = view.getWidth();
        if (position <= -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
//            view.setAlpha(0);
        } else if (-1 < position && position < 0) {
            // 左側に表示されてるView
            alpha = position + 1;
            leftTransition(view, position, alpha);
        } else if (0 <= position && position <= 1) {
            // 右側に表示されてるView
            alpha = 1 - position;
            rightTransition(view, position, alpha);
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
//            view.setAlpha(0);
        }
    }

    private void leftTransition(View view, float position, float alpha) {
        switch ((int) view.getTag()) {
            case 0:
//                View view0 = view.findViewById(R.id.view_0);
//                view0.setTranslationX(-view.getWidth() * 1.5f * position);
//                view0.setTranslationY(view.getHeight() * position * 0.5f);
//                view0.setScaleX(1f + 5f * position);
//                view0.setScaleY(1f + 5f * position);
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }

    private void rightTransition(View view, float position, float alpha) {
        switch ((int) view.getTag()) {
            case 0:
                break;
            case 1:
//                View view0 = view.findViewById(R.id.view_0);
//                view0.setTranslationX(view.getWidth() / 1.5f * -position);
//                view0.setTranslationY(view.getHeight() / -position * 0.5f);
//                view0.setScaleX(1f + 5f * -position);
//                view0.setScaleY(1f + 5f * -position);


//                View view1 = view.findViewById(R.id.view_1);
//                view1.setTranslationX(view.getWidth() / 2  * position);
//                view1.setTranslationY(view.getHeight() / 2 * position);
//                view1.setScaleX(1f * (1 - position));
//                view1.setScaleY(1f * (1 - position));

                break;
            case 2:
                break;
        }
    }




}
