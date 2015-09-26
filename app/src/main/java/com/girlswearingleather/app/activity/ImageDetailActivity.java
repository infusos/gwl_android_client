package com.girlswearingleather.app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.girlswearingleather.app.R;

/**
 * Created by Dani on 26/09/2015.
 */
public class ImageDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail_layout);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
