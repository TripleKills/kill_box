package com.andrew.apollo.umeng;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.andrew.apollo.R;
import com.umeng.fb.FeedbackAgent;
import com.umeng.update.UmengUpdateAgent;
import com.umeng.update.UmengUpdateListener;
import com.umeng.update.UpdateResponse;
import com.xhdq.xhdq.SlideMenu;

public class SlideMenuUtil {
	public static View getSlideView(final Context context, final SlideMenu menu) {
		View view = LayoutInflater.from(context).inflate(R.layout.slide_menu_content, null);
		ListView list_view = (ListView) view.findViewById(R.id.sile_menu_list);
		BaseAdapter adapter = new BaseAdapter() {
			
			private String[] items = new String[]{"反馈", "检查更新"};
			
			@Override
			public View getView(int arg0, View arg1, ViewGroup arg2) {
				TextView text_view = new TextView(context);
				text_view.setText(items[arg0]);
				text_view.setTextColor(context.getResources().getColor(android.R.color.black));
				return text_view;
			}
			
			@Override
			public long getItemId(int arg0) {
				return arg0;
			}
			
			@Override
			public Object getItem(int arg0) {
				return items[arg0];
			}
			
			@Override
			public int getCount() {
				return items.length;
			}
		};
		list_view.setAdapter(adapter);
		list_view.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				switch(arg2) {
				case 0:
					FeedbackAgent agent = new FeedbackAgent(context);
	                agent.startFeedbackActivity();
	                menu.hide();
					break;
				case 1:
					menu.hide();
					UmengUpdateListener updateListener = new UmengUpdateListener() {
	        			@Override
	        			public void onUpdateReturned(int updateStatus,
	        					UpdateResponse updateInfo) {
	        				Log.i("--->", "callback result =>" + updateStatus);
	        				switch (updateStatus) {
	        				
	        				case 0: // has update
	        					UmengUpdateAgent.showUpdateDialog(context, updateInfo);
	        					break;
	        				case 1: // has no update
	        					Toast.makeText(context, "已是最新版本", Toast.LENGTH_SHORT)
	        							.show();
	        					break;
	        				}

	        			}
	        		};
	            	UmengUpdateAgent.update(context);
	            	UmengUpdateAgent.setUpdateListener(updateListener);
	            	Toast.makeText(context, "正在检查更新...", Toast.LENGTH_SHORT)
					.show();
					break;
				}
				
			}
		});
		return view;
	}
}
