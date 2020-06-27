package com.believemaster.ans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.parseColor("#FFFFFF"));
            }
        }catch(Exception e){
         e.printStackTrace();
        }

        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient()); // loading the site in app
        webView.loadUrl("https://ans.believemaster.com");

        WebSettings webSettings = webView.getSettings();
        webView.getSettings().setUserAgentString("https://ans.believemaster.com");
        webSettings.setJavaScriptEnabled(true);
    }

    // Require to use back button if want to go previous page
    @Override
    public void onBackPressed() {

        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
     }
}
