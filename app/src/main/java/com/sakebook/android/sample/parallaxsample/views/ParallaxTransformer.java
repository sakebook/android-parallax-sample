package com.sakebook.android.sample.parallaxsample.views;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by sakemotoshinya on 15/12/16.
 */
public class ParallaxTransformer implements ViewPager.PageTransformer{
    @Override
    public void transformPage(View view, float position) {
        float alpha = 0;
        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
        } else if (-1 < position && position < 0) {
            // 左側に表示されてるView
            alpha = position + 1;
            viewTransition(view, position, alpha);
        } else if (0 <= position && position <= 1) {
            // 右側に表示されてるView
            alpha = 1 - position;
            viewTransition(view, position, alpha);
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
        }
    }

    private void viewTransition(View view, float position, float alpha) {
//        switch (view.getId()) {
//            case R.id.layout_first:
//                firstTransition(view, position, alpha);
//                break;
//            case R.id.layout_second:
//                secondTransition(view, position, alpha);
//                break;
//            case R.id.layout_third:
//                thirdTransition(view, position, alpha);
//                break;
//            case R.id.layout_fourth:
//                fourthTransition(view, position, alpha);
//                break;
//            case R.id.layout_fifth:
//                fifthTransition(view, position, alpha);
//                break;
//        }
    }

    /*
    private void firstTransition(View view, float position, float alpha) {
        FragmentViewHolder.FirstViewHolder holder;
        if (view.getTag() == null) {
            holder = new FragmentViewHolder.FirstViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (FragmentViewHolder.FirstViewHolder) view.getTag();
        }

        int width = view.getWidth();
        holder.title.setTranslationX(- width * position);
        holder.backImage.setTranslationX(- width / 2 * position);
    }

    private void secondTransition(View view, float position, float alpha) {
        FragmentViewHolder.SecondViewHolder holder;
        if (view.getTag() == null) {
            holder = new FragmentViewHolder.SecondViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (FragmentViewHolder.SecondViewHolder) view.getTag();
        }

        int width = view.getWidth();
        holder.title.setTranslationX(- width * position);
        holder.backImage.setTranslationX(- width / 2 * position);
    }

    private void thirdTransition(View view, float position, float alpha) {
        FragmentViewHolder.ThirdViewHolder holder;
        if (view.getTag() == null) {
            holder = new FragmentViewHolder.ThirdViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (FragmentViewHolder.ThirdViewHolder) view.getTag();
        }

        int width = view.getWidth();
        holder.title.setTranslationX(- width * position);
        holder.backImage.setTranslationX(- width / 2 * position);
    }

    private void fourthTransition(View view, float position, float alpha) {
        FragmentViewHolder.FourthViewHolder holder;
        if (view.getTag() == null) {
            holder = new FragmentViewHolder.FourthViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (FragmentViewHolder.FourthViewHolder) view.getTag();
        }

        int width = view.getWidth();
        holder.title.setTranslationX(- width * position);
        holder.backImage.setTranslationX(- width / 2 * position);
    }

    private void fifthTransition(View view, float position, float alpha) {
        FragmentViewHolder.FifthViewHolder holder;
        if (view.getTag() == null) {
            holder = new FragmentViewHolder.FifthViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (FragmentViewHolder.FifthViewHolder) view.getTag();
        }

        int width = view.getWidth();
        holder.title.setTranslationX(- width * position);
        holder.backImage.setTranslationX(- width / 2 * position);
    }
    */
}
