package com.sakebook.android.sample.parallaxsample.fragments;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.sakebook.android.sample.parallaxsample.R;
import com.sakebook.android.sample.parallaxsample.views.AnimationTransformer;

/**
 * Created by sakemotoshinya on 15/12/23.
 */
public class ParallaxAnimationFragment extends Fragment{

    private static final String ARG_COUNT = "count";

    private int mCount;

    public ParallaxAnimationFragment() {
    }

    public static ParallaxAnimationFragment newInstance(int count) {
        ParallaxAnimationFragment fragment = new ParallaxAnimationFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COUNT, count);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCount = getArguments().getInt(ARG_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FrameLayout view = (FrameLayout) inflater.inflate(R.layout.fragment_parallax_animation_layout, container, false);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);

        for (int i = 0; i< mCount; i++) {
            ImageView v = new ImageView(getContext());
            setParameters(v, point.x, point.y);
            view.addView(v);
        }
        return view;
    }

    private void setParameters(ImageView v, int maxWidth, int maxHeight) {

        int width = (int)(Math.random() * maxWidth / 2);

        float accelerateX = (float) (Math.random() + Math.random() * ((Math.random() * 10) - 5));
        if (accelerateX < -0.1) {
            accelerateX = -0.1f;
        }
        float accelerateY = (float) (Math.random() + Math.random() * ((Math.random() * 10) - 5));

        AnimationTransformer.Accelerate accelerate = new AnimationTransformer.Accelerate(accelerateX, accelerateY);

        int tMargin = (int) (Math.random() * maxHeight);
        int lMargin = (int) (Math.random() * maxWidth);

        if ((tMargin + width > maxHeight) || (lMargin + width > maxWidth)) {
            tMargin = Math.abs(tMargin - width);
            lMargin = Math.abs(lMargin - width);
        }

        int topMargin = tMargin;
        int leftMargin = lMargin;

        int r = (int)(Math.random() * 255);
        int g = (int)(Math.random() * 255);
        int b = (int)(Math.random() * 255);
        int c = Color.rgb(r, g, b);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, width);
        params.topMargin = topMargin;
        params.leftMargin = leftMargin;
        v.setLayoutParams(params);
        v.setImageResource(R.drawable.star);
        v.setColorFilter(c, PorterDuff.Mode.SRC_ATOP);
        v.setTag(accelerate);
    }


}
