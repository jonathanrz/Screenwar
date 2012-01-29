package jrz.games.screenwar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WinnerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.winner);
		
		Intent i = getIntent();
		
		String winner = i.getStringExtra(WarActivity.KEY_WINNER);
		String loser = i.getStringExtra(WarActivity.KEY_LOSER);
		int TotalClicksW = i.getIntExtra(WarActivity.KEY_TOTAL_CLICKS_W, 0);
		int TotalClicksL = i.getIntExtra(WarActivity.KEY_TOTAL_CLICKS_L, 0);
		
		TextView text = (TextView)findViewById(R.id.name_winner);
		text.setText(winner);
		text = (TextView)findViewById(R.id.total_clicks_winner);
		text.setText("" + TotalClicksW);
		
		text = (TextView)findViewById(R.id.name_loser);
		text.setText(loser);
		text = (TextView)findViewById(R.id.total_clicks_loser);
		text.setText("" + TotalClicksL);
	}
}
