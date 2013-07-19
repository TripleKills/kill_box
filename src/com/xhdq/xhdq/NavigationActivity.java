package com.xhdq.xhdq;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.andrew.apollo.R;

public class NavigationActivity extends DropActivity {
	int meId_setting;
	SlideMenu slidemenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mActionBar.setIcon(R.drawable.ic_launcher);
		 slidemenu = new SlideMenu(this){
		    	@Override
		    	public void show() {
		    		onSlideMenuShow(slidemenu);
		    		super.show();
		    	}
		    	
		    	@Override
		    	public void hide() {
		    		onSlideMenuHide(slidemenu);
		    		super.hide();
		    	}
		    	@Override
		    	public void fillContent(View menu) {
		    		NavigationActivity.this.fillMenuContent(menu);
		    	}
		    };
		    slidemenu.checkEnabled();
		    
	}

	@Override
	protected void onPageChanged(int pos) {
		if (pos > 0) {
			mActionBar.setDisplayHomeAsUpEnabled(true);
		} else
			mActionBar.setDisplayHomeAsUpEnabled(false);

	}

	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		System.out.println("onCreateOptionsMenu");
		com.actionbarsherlock.view.MenuItem settingItem = menu.add("Action Button");
		settingItem.setShowAsAction(com.actionbarsherlock.view.MenuItem.SHOW_AS_ACTION_IF_ROOM);
		settingItem.setIcon(R.drawable.umeng_socialize_example_setting);
		meId_setting = settingItem.getItemId();
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem item) {
		if (android.R.id.home == item.getItemId()) {
			mPager.setCurrentItem(0, true);
		} else if (item.getItemId() == meId_setting) {
			if(slidemenu.isShow())
				slidemenu.hide();
			else
				slidemenu.show();
		}
		return true;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (slidemenu.isShow()) {
				slidemenu.hide();
				return true;
			}
		} else if (keyCode == KeyEvent.KEYCODE_MENU) {
			if(slidemenu.isShow())
				slidemenu.hide();
			else
				slidemenu.show();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	protected void fillMenuContent(View menu) {
	}
	protected void onSlideMenuShow(SlideMenu slidemenu) {
	}
	protected void onSlideMenuHide(SlideMenu slidemenu) {
	}
}
