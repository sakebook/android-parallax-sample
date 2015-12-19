package com.sakebook.android.sample.parallaxsample.fragments;


import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sakebook.android.sample.parallaxsample.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GradationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GradationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_COLOR = "color";

    private int mColor;

    public GradationFragment() {
    }

    public static GradationFragment newInstance(@ColorRes int colorId) {
        GradationFragment fragment = new GradationFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLOR, colorId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColor = getArguments().getInt(ARG_COLOR);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gradation_layout, container, false);
        view.findViewById(R.id.layout_gradation).setBackgroundColor(ContextCompat.getColor(getContext(), mColor));
        return view;
    }

}
