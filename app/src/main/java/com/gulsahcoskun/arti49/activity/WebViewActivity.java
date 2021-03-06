package com.gulsahcoskun.arti49.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gulsahcoskun.arti49.R;

/**
 * Created by Saadet on 8/11/2015.
 */
public class WebViewActivity extends Activity {
    private WebView webView;

    protected void onCreate(Bundle savedInstanceState ){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new MyWebViewClient());

        Bundle bundle = this.getIntent().getExtras();
        String url = bundle.getString("url");

        if(null != url){
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(url);
        }

    }

    private class MyWebViewClient extends WebViewClient {

        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }


}
