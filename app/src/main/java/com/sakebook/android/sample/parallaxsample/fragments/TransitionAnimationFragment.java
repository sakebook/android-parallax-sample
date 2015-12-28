package com.sakebook.android.sample.parallaxsample.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sakebook.android.sample.parallaxsample.R;

/**
 * Created by sakemotoshinya on 15/12/27.
 */
public class TransitionAnimationFragment extends Fragment {
    private static final String ARG_NUMBER = "number";
    private static final String ARG_LAYOUT = "layout";

    private int number;
    private int layout;

    public TransitionAnimationFragment() {
    }

    public static TransitionAnimationFragment newInstance(int number, @LayoutRes int layout) {
        TransitionAnimationFragment fragment = new TransitionAnimationFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_NUMBER, number);
        args.putInt(ARG_LAYOUT, layout);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            number = getArguments().getInt(ARG_NUMBER);
            layout = getArguments().getInt(ARG_LAYOUT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(layout, container, false);
        ((TextView)view.findViewById(R.id.text_transition)).setText("" + number);
        view.setBackgroundColor(Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
        view.setTag(number);
        return view;
    }

}
