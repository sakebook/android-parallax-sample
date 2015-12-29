package com.sakebook.android.sample.parallaxsample.views;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.sakebook.android.sample.parallaxsample.FragmentViewHolder;
import com.sakebook.android.sample.parallaxsample.R;
import com.sakebook.android.sample.parallaxsample.fragments.ImageFragment;

/**
 * Created by sakemotoshinya on 15/12/28.
 */
public class ImageTransformer implements ViewPager.PageTransformer{
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
        ImageFragment.ViewHolder holder;
        if (view.getTag() == null) {
            holder = new ImageFragment.ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ImageFragment.ViewHolder) view.getTag();
        }

        int width = view.getWidth();
        holder.title.setTranslationX(- width * position);
        holder.subTitle.setTranslationX(width * 2 * position);
        holder.backImage.setTranslationX(- width / 2 * position);
    }

}
