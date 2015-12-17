package com.sakebook.android.sample.parallaxsample;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sakemotoshinya on 15/12/17.
 */
public class FragmentViewHolder {

    public FragmentViewHolder() {
    }

    public static class FirstViewHolder {

        public ImageView backImage;
        public TextView title;
        public TextView subTitle;

        public FirstViewHolder(View view) {
            this.backImage = (ImageView) view.findViewById(R.id.image_back);
            this.title = (TextView) view.findViewById(R.id.text_title);
            this.subTitle = (TextView) view.findViewById(R.id.text_sub_title);
        }
    }

    public static class SecondViewHolder {

        public ImageView backImage;
        public TextView title;
        public TextView subTitle;

        public SecondViewHolder(View view) {
            this.backImage = (ImageView) view.findViewById(R.id.image_back);
            this.title = (TextView) view.findViewById(R.id.text_title);
            this.subTitle = (TextView) view.findViewById(R.id.text_sub_title);
        }
    }

    public static class ThirdViewHolder {

        public ImageView backImage;
        public TextView title;
        public TextView subTitle;

        public ThirdViewHolder(View view) {
            this.backImage = (ImageView) view.findViewById(R.id.image_back);
            this.title = (TextView) view.findViewById(R.id.text_title);
            this.subTitle = (TextView) view.findViewById(R.id.text_sub_title);
        }
    }

    public static class FourthViewHolder {

        public ImageView backImage;
        public TextView title;
        public TextView subTitle;

        public FourthViewHolder(View view) {
            this.backImage = (ImageView) view.findViewById(R.id.image_back);
            this.title = (TextView) view.findViewById(R.id.text_title);
            this.subTitle = (TextView) view.findViewById(R.id.text_sub_title);
        }
    }

    public static class FifthViewHolder {

        public ImageView backImage;
        public TextView title;
        public TextView subTitle;

        public FifthViewHolder(View view) {
            this.backImage = (ImageView) view.findViewById(R.id.image_back);
            this.title = (TextView) view.findViewById(R.id.text_title);
            this.subTitle = (TextView) view.findViewById(R.id.text_sub_title);
        }
    }
}
