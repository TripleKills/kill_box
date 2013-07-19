package com.xhdq.xhdq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.andrew.apollo.R;

public class FragmentNavigationActivity extends NavigationActivity {

@Override
protected void onSlideMenuHide(SlideMenu slidemenu) {
	//SocialDemoConfig.nofifyConfigChange(this);
}

@Override
protected void fillMenuContent(View menu) {
	LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	ViewGroup vp = (ViewGroup) menu.findViewById(R.id.menu_content);
	View content = inflater.inflate(R.layout.slide_menu_content, vp, true);
	
	//user info
	content.findViewById(R.id.msg_user_parent).setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
		//	umSocialService.openUserCenter(FragmentNavigationActivity.this);
			slidemenu.hide();
		}
	});

	

}
}
