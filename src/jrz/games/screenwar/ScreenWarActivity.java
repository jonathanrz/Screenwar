package jrz.games.screenwar;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

public class ScreenWarActivity extends TabActivity {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        if(savedInstanceState != null)
        	Toast.makeText(ScreenWarActivity.this, "Bundle diferente de null", Toast.LENGTH_SHORT).show();

        Resources res = getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab

	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, OfflineActivity.class);

	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("offline").setIndicator("Offline",res.getDrawable(R.drawable.ic_tab_offline)).setContent(intent);
	    tabHost.addTab(spec);

	    intent = new Intent().setClass(this, OnlineActivity.class);
	    spec = tabHost.newTabSpec("online").setIndicator("Online",res.getDrawable(R.drawable.ic_tab_online)).setContent(intent);
	    tabHost.addTab(spec);

	    tabHost.setCurrentTab(0);
    }
}