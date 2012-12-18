package ch.android.example.onlinereader.fragments;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import ch.android.example.onlinereader.DetailActivity;
import ch.android.example.onlinereader.R;

public class MyListFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/*
		 * TODO: replace with Data collected from the Database, make it
		 * configurable
		 */
		List<String> urlList = new ArrayList<String>();
		urlList.add("http://nzz.ch");
		urlList.add("http://www.tagesanzeiger.ch");
		urlList.add("http://reddit.com");
		urlList.add("http://vereinoffen.org");

		View view = inflater.inflate(R.layout.fragment_online_reader_overview,
				container, false);

		// getActivity() ?
		// getFragmentManager().beginTransaction().add(new ListFragment(),
		// listView.toString()).commit();
		// (ListView) view.findViewById(R.id.linkList);

		ListAdapter adapter = new ArrayAdapter<String>(getActivity()
				.getApplicationContext(), R.layout.list_black_text,R.id.list_content,
				urlList);

		final ListView listView = (ListView) view.findViewById(R.id.linkList);
		listView.setAdapter(adapter);

		/*
		 * Listener
		 */

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// Intent intent = new Intent();
				// intent.setClassName(getActivity().getPackageName(),
				// getActivity().getPackageName()
				// + ".TutorialListViewActivityAnzeige");
				// intent.putExtra("selected", lv.getAdapter().getItem(arg2)
				// .toString());
				// startActivity(intent);

				openURL(listView.getAdapter().getItem(arg2).toString());
			}
		});

		/*
		 * Button etc
		 */

		Button button = (Button) view.findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				updateDetail();
			}
		});
		return view;
	}

	// May also be triggered from the Activity
	public void updateDetail() {
		String newTime = String.valueOf(System.currentTimeMillis());
		DetailFragment fragment = (DetailFragment) getFragmentManager()
				.findFragmentById(R.id.detailFragment);
		if (fragment != null && fragment.isInLayout()) {
			fragment.setText(newTime);
		} else {
			Intent intent = new Intent(getActivity().getApplicationContext(),
					DetailActivity.class);
			intent.putExtra("value", newTime);
			startActivity(intent);

		}
	}

	public void openURL(String url) {
		String newTime = String.valueOf(System.currentTimeMillis());
		DetailFragment fragment = (DetailFragment) getFragmentManager()
				.findFragmentById(R.id.detailFragment);
		if (fragment != null && fragment.isInLayout()) {
			fragment.setText(url);
		} else {
			Intent intent = new Intent(getActivity().getApplicationContext(),
					DetailActivity.class);
			intent.putExtra("value", url);
			startActivity(intent);

		}
	}
}