package com.girlswearingleather.app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.girlswearingleather.app.R;

/**
 * Created by Dani on 26/09/2015.
 */
public class ImageDetailActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail_layout);
        mWebView = (WebView)this.findViewById(R.id.webView);
        mWebView.loadUrl("http://www.leathercelebrities.com/images/uploads/Pixie-Lott-attends-Launch-of-new-hair-product-range2010.jpg");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
