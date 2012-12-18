package ch.android.example.onlinereader;

import org.apache.http.client.HttpClient;

import ch.android.example.onlinereader.utils.HTTPLoader;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class DetailActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Need to check if Activity has been switched to landscape mode
		// If yes, finished and go back to the start Activity
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			finish();
			return;
		}
		setContentView(R.layout.activity_detail);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			String s = extras.getString("value");
			TextView view = (TextView) findViewById(R.id.detailsText);
			// WebView webView = (WebView) findViewById(R.id.webView);
			// webView.getSettings().setJavaScriptEnabled(true);
			// webView.loadUrl(s);
			HTTPLoader httpLoader = new HTTPLoader(s);
			String result = httpLoader.connect();
			view.setTextSize(10);
			view.setText(Html.fromHtml(result));
		}
	}
}