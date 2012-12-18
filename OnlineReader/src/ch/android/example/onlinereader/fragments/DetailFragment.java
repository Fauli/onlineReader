package ch.android.example.onlinereader.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import ch.android.example.onlinereader.R;
import ch.android.example.onlinereader.utils.BrowserCallback;


public class DetailFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_online_reader_detail,
        container, false);
    return view;
  }

  public void setText(String item) {
		TextView view = (TextView) getView().findViewById(R.id.detailsText);
//		HTTPLoader httpLoader = new HTTPLoader(item);
//		String result = httpLoader.connect();
		view.setTextSize(10);
//		view.setTextColor(Color.BLUE);
		
		
//		view.setText(Html.fromHtml(result));
		view.setText(item);
		
		
    
	  	WebView webView = (WebView) getView().findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);

		WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
		
		webView.setWebViewClient(new BrowserCallback());
		webView.loadUrl(item);
//		getActivity().getWindow().requestFeature(Window.FEATURE_PROGRESS);
		
//		webView.loadData(result, "text/html", null);
    
		
  }
} 