/*
 * Copyright (C) 2012 Andrew Neal Licensed under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package com.andrew.apollo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Application;
import android.os.StrictMode;

import com.andrew.apollo.cache.ImageCache;
import com.andrew.apollo.utils.ApolloUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.onlineconfig.UmengOnlineConfigureListener;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;

/**
 * Used to turn off logging for jaudiotagger and free up memory when
 * {@code #onLowMemory()} is called on pre-ICS devices. On post-ICS memory is
 * released within {@link ImageCache}.
 * 
 * @author Andrew Neal (andrewdneal@gmail.com)
 */
@SuppressLint("NewApi")
public class ApolloApplication extends Application {

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate() {
        // Enable strict mode logging
        enableStrictMode();
        // Turn off logging for jaudiotagger.
        Logger.getLogger("org.jaudiotagger").setLevel(Level.OFF);
        
        //ad by qy
        MobclickAgent.setDebugMode(true);
		MobclickAgent.updateOnlineConfig(this);
		MobclickAgent.setOnlineConfigureListener(new UmengOnlineConfigureListener(){
		      @Override
		      public void onDataReceived(JSONObject data) {
		    	String be_open =  MobclickAgent.getConfigParams(getApplicationContext(), "be_open");
		    	if (be_open.equalsIgnoreCase("true")) {
		    		// open be
		    		
		    	}
		      }
		});
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onLowMemory() {
        ImageCache.getInstance(this).evictAll();
        super.onLowMemory();
    }

    @TargetApi(11)
    private void enableStrictMode() {
        if (ApolloUtils.hasGingerbread() && BuildConfig.DEBUG) {
            final StrictMode.ThreadPolicy.Builder threadPolicyBuilder = new StrictMode.ThreadPolicy.Builder()
                    .detectAll().penaltyLog();
            final StrictMode.VmPolicy.Builder vmPolicyBuilder = new StrictMode.VmPolicy.Builder()
                    .detectAll().penaltyLog();

            if (ApolloUtils.hasHoneycomb()) {
                threadPolicyBuilder.penaltyFlashScreen();
            }
            StrictMode.setThreadPolicy(threadPolicyBuilder.build());
            StrictMode.setVmPolicy(vmPolicyBuilder.build());
        }
    }
}
