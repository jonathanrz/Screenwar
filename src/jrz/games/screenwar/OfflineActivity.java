package jrz.games.screenwar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class OfflineActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.offline);

		GridView gridview = (GridView) findViewById(R.id.gridOffline);
        gridview.setAdapter(new MenuAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                startActivity(new Intent(OfflineActivity.this, WarActivity.class));
            }
        });
	}
}
