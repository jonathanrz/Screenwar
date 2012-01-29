package jrz.games.screenwar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class PauseMenuActivity extends Activity {
	public static final int RESULT_CONTINUE = RESULT_FIRST_USER;
	public static final int RESULT_RESTART = RESULT_FIRST_USER + 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pausemenu);

		GridView gridview = (GridView) findViewById(R.id.gridPauseMenu);
        gridview.setAdapter(new PauseMenuAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                switch((int) id){
                case R.drawable.ic_menu_pause_continue:
                	setResult(RESULT_CONTINUE);
                	finish();
                	break;
                case R.drawable.ic_menu_pause_restart:
                	setResult(RESULT_RESTART);
                	finish();
                	break;
                }
            }
        });
	}
}
