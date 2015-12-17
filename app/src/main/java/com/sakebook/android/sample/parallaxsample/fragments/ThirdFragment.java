package com.sakebook.android.sample.parallaxsample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sakebook.android.sample.parallaxsample.R;

/**
 * Created by sakemotoshinya on 15/12/15.
 */
public class ThirdFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third_layout, null);
    }


    public static class ViewHolder {

        public TextView title;

        public ViewHolder(View view) {
            title = (TextView) view.findViewById(R.id.text_title);
        }
    }
}
