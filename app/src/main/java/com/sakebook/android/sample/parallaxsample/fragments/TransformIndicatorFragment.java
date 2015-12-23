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
 * Created by sakemotoshinya on 15/12/21.
 */
public class TransformIndicatorFragment extends Fragment {
    private static final String ARG_STRING = "string";

    private String mString;

    public TransformIndicatorFragment() {
    }

    public static TransformIndicatorFragment newInstance(String str) {
        TransformIndicatorFragment fragment = new TransformIndicatorFragment();
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
        View view = inflater.inflate(R.layout.fragment_transform_indicator_layout, container, false);
        ((TextView)view.findViewById(R.id.text_transform_indicator)).setText(mString);
        view.setBackgroundColor(Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
        view.setTag(mString);
        return view;
    }

}
