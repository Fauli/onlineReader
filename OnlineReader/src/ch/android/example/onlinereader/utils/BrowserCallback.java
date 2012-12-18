package ch.android.example.onlinereader.utils;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BrowserCallback extends WebViewClient {  //HERE IS THE MAIN CHANGE. 

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return (false);
    }
    

}
