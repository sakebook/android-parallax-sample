package com.sakebook.android.sample.parallaxsample.views;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.sakebook.android.sample.parallaxsample.R;

/**
 * Created by sakemotoshinya on 15/12/21.
 */
public class IndicatorTransformer implements ViewPager.PageTransformer{
    @Override
    public void transformPage(View view, float position) {
        float alpha = 0;
        int width = view.getWidth();
        if (position <= -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
        } else if (-1 < position && position < 0) {
            // 左側に表示されてるView
            alpha = position + 1;
            view.findViewById(R.id.layout_indicator_transformer).setTranslationX(-width * position);
            leftTransition(view, position, alpha);
        } else if (0 <= position && position <= 1) {
            // 右側に表示されてるView
            alpha = 1 - position;
            view.findViewById(R.id.layout_indicator_transformer).setTranslationX(-width * position);
            rightTransition(view, position, alpha);
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
        }
    }

    private void leftTransition(View view, float position, float alpha) {
        View indicator1 = view.findViewById(R.id.view_indicator_1);
        View indicator2 = view.findViewById(R.id.view_indicator_2);
        View indicator3 = view.findViewById(R.id.view_indicator_3);
        View indicator4 = view.findViewById(R.id.view_indicator_4);
        View indicator5 = view.findViewById(R.id.view_indicator_5);

        switch (Integer.parseInt((String) view.getTag())) {
            case 0:
                indicator1.setScaleX(2 + position);
                indicator1.setScaleY(2 + position);
                indicator2.setScaleX(1 - position);
                indicator2.setScaleY(1 - position);

                break;
            case 1:
                indicator2.setScaleX(2 + position);
                indicator2.setScaleY(2 + position);
                indicator3.setScaleX(1 - position);
                indicator3.setScaleY(1 - position);

                break;
            case 2:
                indicator3.setScaleX(2 + position);
                indicator3.setScaleY(2 + position);
                indicator4.setScaleX(1 - position);
                indicator4.setScaleY(1 - position);

                break;
            case 3:
                indicator4.setScaleX(2 + position);
                indicator4.setScaleY(2 + position);
                indicator5.setScaleX(1 - position);
                indicator5.setScaleY(1 - position);

                break;
            case 4:
                indicator5.setScaleX(2 + position);
                indicator5.setScaleY(2 + position);

                break;
        }
    }

    private void rightTransition(View view, float position, float alpha) {
        View indicator1 = view.findViewById(R.id.view_indicator_1);
        View indicator2 = view.findViewById(R.id.view_indicator_2);
        View indicator3 = view.findViewById(R.id.view_indicator_3);
        View indicator4 = view.findViewById(R.id.view_indicator_4);
        View indicator5 = view.findViewById(R.id.view_indicator_5);

        switch (Integer.parseInt((String) view.getTag())) {
            case 0:
                indicator1.setScaleX(2 - position);
                indicator1.setScaleY(2 - position);

                break;
            case 1:
                indicator1.setScaleX(1 + position);
                indicator1.setScaleY(1 + position);
                indicator2.setScaleX(2 - position);
                indicator2.setScaleY(2 - position);
                break;
            case 2:
                indicator2.setScaleX(1 + position);
                indicator2.setScaleY(1 + position);
                indicator3.setScaleX(2 - position);
                indicator3.setScaleY(2 - position);

                break;
            case 3:
                indicator3.setScaleX(1 + position);
                indicator3.setScaleY(1 + position);
                indicator4.setScaleX(2 - position);
                indicator4.setScaleY(2 - position);

                break;
            case 4:
                indicator4.setScaleX(1 + position);
                indicator4.setScaleY(1 + position);
                indicator5.setScaleX(2 - position);
                indicator5.setScaleY(2 - position);

                break;
        }
    }




}
