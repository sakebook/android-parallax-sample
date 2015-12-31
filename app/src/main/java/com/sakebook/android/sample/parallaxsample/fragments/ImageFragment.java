package com.sakebook.android.sample.parallaxsample.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sakebook.android.sample.parallaxsample.R;

/**
 * Created by sakemotoshinya on 15/12/28.
 */
public class ImageFragment extends Fragment {
    private static final String ARG_NUMBER = "number";
    private static final String ARG_LAYOUT = "layout";
    private static final String ARG_DRAWABLE = "drawable";
    private static final String ARG_TEXT = "text";
    private static final String ARG_AUTHOR = "author";

    private int number;
    private int layout;
    private int drawable;
    private String text;
    private String author;

    public ImageFragment() {
    }

    public static ImageFragment newInstance(String text, int number, @LayoutRes int layout, @DrawableRes int drawable, String author) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        args.putInt(ARG_NUMBER, number);
        args.putInt(ARG_LAYOUT, layout);
        args.putInt(ARG_DRAWABLE, drawable);
        args.putString(ARG_AUTHOR, author);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            number = getArguments().getInt(ARG_NUMBER);
            layout = getArguments().getInt(ARG_LAYOUT);
            text = getArguments().getString(ARG_TEXT);
            drawable = getArguments().getInt(ARG_DRAWABLE);
            author = getArguments().getString(ARG_AUTHOR);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(layout, container, false);

        ViewHolder holder = new ViewHolder(view);
        view.setTag(holder);

        holder.title.setText(number + "");
        holder.subTitle.setText(text);
        holder.backImage.setImageResource(drawable);
        holder.author.setText(author);
        view.setBackgroundColor(Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
        return view;
    }

    public static class ViewHolder {

        public ImageView backImage;
        public TextView title;
        public TextView subTitle;
        public TextView author;

        public ViewHolder(View view) {
            this.backImage = (ImageView) view.findViewById(R.id.image_back);
            this.title = (TextView) view.findViewById(R.id.text_title);
            this.subTitle = (TextView) view.findViewById(R.id.text_sub_title);
            this.author = (TextView) view.findViewById(R.id.text_author);
        }
    }

}
