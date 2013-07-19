package com.xhdq.xhdq;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.andrew.apollo.R;

public class SwipActivity extends SherlockFragmentActivity {

	ViewPager mPager;
	SectionsPagerAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Theme_Sherlock);
		setContentView(R.layout.activity_swipe);
		mAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);
	}
	
	class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fragmentManager) {
			super(fragmentManager);
		}

		@Override
		public Fragment getItem(int arg0) {
			Fragment fg = new TitleFragment();
			Bundle args = new Bundle();
			args.putString("title", NavigationHelper.getTitles()[arg0]);
			fg.setArguments(args);
			return fg;
		}

		@Override
		public int getCount() {
			return NavigationHelper.getTitles().length;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return NavigationHelper.getTitles()[position];
		}

	}

	public void smoothTo(int pos) {
		mPager.setCurrentItem(pos, true);
	}

}
