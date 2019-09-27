package com.example.ocrfirstactivity;

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

        setTitle(this.getTitle());

        WebView webView = (WebView) findViewById(R.id.htmlContent);
        webView.loadData(getIntent().getStringExtra("htmlContent"), "text/html; charset=UTF-8", null);
       // webView.loadUrl("file:///android_asset/news.xml");
       // webView.setWebViewClient(new WebViewClient(){
        //    public boolean shouldOverrideUrlLoading(WebView viewx, String urlx)

    }


}
