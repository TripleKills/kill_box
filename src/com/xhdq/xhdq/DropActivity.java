package com.xhdq.xhdq;

import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import com.actionbarsherlock.app.ActionBar;
import com.andrew.apollo.R;

public class DropActivity extends SwipActivity implements
		ActionBar.OnNavigationListener {
	ActionBar mActionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mActionBar = getSupportActionBar();
		mActionBar.setDisplayShowTitleEnabled(false);
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		String[] titles = NavigationHelper.getTitles();
		SpinnerAdapter adapter = new ArrayAdapter<String>(
				mActionBar.getThemedContext(),
				R.layout.sherlock_spinner_dropdown_item, titles);
		mActionBar.setListNavigationCallbacks(adapter, this);

		mPager.addView(getPagerTitle());
		mPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				mActionBar.setSelectedNavigationItem(arg0);
				onPageChanged(arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	protected void onPageChanged(int pos) {
	}
	
	

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		System.out.println("onNavigationItemSelected:" + itemPosition);
		smoothTo(itemPosition);
		return true;
	}

	private PagerTitleStrip getPagerTitle() {
		PagerTabStrip pagerTabStrip = (PagerTabStrip) View.inflate(this,
				R.layout.pager_tab_title, null);
		android.support.v4.view.ViewPager.LayoutParams lp = new ViewPager.LayoutParams();
		lp.width = LayoutParams.MATCH_PARENT;
		lp.height = LayoutParams.WRAP_CONTENT;
		lp.gravity = Gravity.TOP;
		pagerTabStrip.setLayoutParams(lp);
		return pagerTabStrip;
	}
}
