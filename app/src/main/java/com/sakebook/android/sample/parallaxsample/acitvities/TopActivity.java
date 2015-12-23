package com.sakebook.android.sample.parallaxsample.acitvities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sakebook.android.sample.parallaxsample.R;

public class TopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        initListener();
    }

    private void initListener() {
        findViewById(R.id.button_gradation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopActivity.this, GradationActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button_indicator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopActivity.this, IndicatorActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button_transform_indicator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopActivity.this, TransformIndicatorActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopActivity.this, ImageActivity.class);
                startActivity(intent);
            }
        });

    }
}
