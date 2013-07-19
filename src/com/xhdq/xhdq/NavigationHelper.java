package com.xhdq.xhdq;

import android.support.v4.app.Fragment;

public class NavigationHelper {
	public static final String SHARE_MOD = "分享接口";
	public static final String COMMENT_MOD = "评论接口";
	public static final String SOCIAL_MOD = "整体接口";
	public static final String OTHER_MOD = "其他接口";
	public static final String CUSTOM_MOD = "自定义接口(微信)";
	private static final String[] titles = new String[] { SHARE_MOD,
			COMMENT_MOD, SOCIAL_MOD, OTHER_MOD, CUSTOM_MOD };

	public static String[] getTitles() {
		return titles;
	}

	public static int getItemCount() {
		return titles.length;
	}

	public static String getTitle(int pos) {
		return titles[pos];
	}

	public static Fragment getFragment(String title) {
		Fragment fragment = null;
		if (title.equals(NavigationHelper.SHARE_MOD)) {
			fragment = new TitleFragment();
		} else if (title.equals(NavigationHelper.COMMENT_MOD)) {
			fragment = new TitleFragment();
		} else if (title.equals(NavigationHelper.SOCIAL_MOD)) {
			fragment = new TitleFragment();
		} else if (title.equals(NavigationHelper.OTHER_MOD)) {
			fragment = new TitleFragment();
		} else if (title.equals(NavigationHelper.CUSTOM_MOD)) {
			fragment = new TitleFragment();
		}

		return fragment;
	}
}
