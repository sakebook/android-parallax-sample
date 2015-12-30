package com.sakebook.android.sample.parallaxsample.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sakebook.android.sample.parallaxsample.R;

/**
 * Created by sakemotoshinya on 15/12/20.
 */
public class IndicatorFragment extends Fragment {
    private static final String ARG_STRING = "string";

    private String mString;

    public IndicatorFragment() {
    }

    public static IndicatorFragment newInstance(String str) {
        IndicatorFragment fragment = new IndicatorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_STRING, str);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mString = getArguments().getString(ARG_STRING);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_indicator_layout, container, false);
        ((TextView)view.findViewById(R.id.text_indicator)).setText(mString);
        view.setBackgroundColor(Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
        return view;
    }

}
