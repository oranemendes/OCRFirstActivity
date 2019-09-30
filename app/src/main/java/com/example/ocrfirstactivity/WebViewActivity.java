package com.example.ocrfirstactivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String article = intent.getStringExtra("article");

        setTitle(title);

        WebView webView = (WebView) findViewById(R.id.htmlContentWebView);
        webView.loadData(article, "text/html; charset=UTF-8", null);

    }


}
