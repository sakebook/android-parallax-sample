package com.sakebook.android.sample.parallaxsample.fragments;


import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sakebook.android.sample.parallaxsample.R;

public class GradationFragment extends Fragment {
    private static final String ARG_STRING = "string";

    private int mStringRes;

    public GradationFragment() {
    }

    public static GradationFragment newInstance(@StringRes int stringId) {
        GradationFragment fragment = new GradationFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STRING, stringId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mStringRes = getArguments().getInt(ARG_STRING);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gradation_layout, container, false);
        ((TextView)view.findViewById(R.id.text_gradation)).setText(mStringRes);
        return view;
    }

}
