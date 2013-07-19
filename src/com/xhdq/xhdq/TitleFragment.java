package com.xhdq.xhdq;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andrew.apollo.R;

public class TitleFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_title_fragment, null);
		TextView s = (TextView) v.findViewById(R.id.s);
		s.setText(getArguments().getString("title"));
		return v;
	}
}