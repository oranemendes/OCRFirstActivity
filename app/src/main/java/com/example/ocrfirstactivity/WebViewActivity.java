package com.example.ocrfirstactivity;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        WebView webView = (WebView) findViewById(R.id.htmlContent);
        webView.loadData(getIntent().getStringExtra("htmlContent"), "text/html; charset=UTF-8", null);
    }


}
