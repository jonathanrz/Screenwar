package jrz.games.screenwar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class WarActivity extends Activity {
	private int mTotalClicksP1;
	private int mTotalClicksP2;
	private int mFator;
	
	public static final String KEY_TOTAL_CLICKS_P1	= "totalclicksP1";
	public static final String KEY_TOTAL_CLICKS_P2	= "totalclicksP2";
	public static final String KEY_FATOR			= "fator";
	public static final String KEY_WINNER			= "winner";
	public static final String KEY_LOSER			= "loser";
	public static final String KEY_TOTAL_CLICKS_W	= "totalclicksW";
	public static final String KEY_TOTAL_CLICKS_L	= "totalclicksL";
	
	public static final int ACTIVITY_PAUSE = 0;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.war);
        mTotalClicksP1 = 0;
        mTotalClicksP2 = 0;
        mFator = 1;
        
        if (savedInstanceState != null){
        	Toast.makeText(WarActivity.this, "Bundle não nulo", Toast.LENGTH_SHORT).show();
        	mTotalClicksP1	= savedInstanceState.getInt(KEY_TOTAL_CLICKS_P1);
        	mTotalClicksP2	= savedInstanceState.getInt(KEY_TOTAL_CLICKS_P2);
        	mFator 			= savedInstanceState.getInt(KEY_FATOR);
        }        
        
        AddOnClick(findViewById(R.id.ScreenPlayer1));
        AddOnClick(findViewById(R.id.ScreenPlayer2));
        
        AtualizaTela();
    }

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(KEY_TOTAL_CLICKS_P1, mTotalClicksP1);
		outState.putInt(KEY_TOTAL_CLICKS_P2, mTotalClicksP2);
		outState.putInt(KEY_FATOR, mFator);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode==ACTIVITY_PAUSE){
			TrataRetornoPause(resultCode);
			return;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onBackPressed() {
		Intent i = new Intent(WarActivity.this, PauseMenuActivity.class);
		startActivityForResult(i, ACTIVITY_PAUSE);
	}
    
    private void AddOnClick(View view){
    	view.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				ComputeClick(view.getId() == R.id.ScreenPlayer1);
			}
		});
    }
    
    private void ComputeClick(boolean bClickPlayer1){
    	if (bClickPlayer1)
    		mTotalClicksP1 += 1;
    	else
    		mTotalClicksP2 += 1;
    	
    	AtualizaTela();
    }
    
    private void AtualizaTela(){
    	int iDiferenca = mTotalClicksP1 - mTotalClicksP2;
    	
    	boolean bP1Vencendo = iDiferenca > 0;
    	
    	if(iDiferenca < 0)
    		iDiferenca *= -1;
    	
    	View viewW = bP1Vencendo ? findViewById(R.id.ScreenPlayer1) : findViewById(R.id.ScreenPlayer2);
    	View viewL = bP1Vencendo ? findViewById(R.id.ScreenPlayer2) : findViewById(R.id.ScreenPlayer1);
    	
    	LinearLayout.LayoutParams paramsW = (LinearLayout.LayoutParams)viewW.getLayoutParams();
    	LinearLayout.LayoutParams paramsL = (LinearLayout.LayoutParams)viewL.getLayoutParams();
    	
    	paramsW.weight = (50 - (iDiferenca * mFator));
    	paramsL.weight = (50 + (iDiferenca * mFator));
    	
    	viewW.setLayoutParams(paramsW);
    	viewL.setLayoutParams(paramsL);
    	
    	CheckWinner();
    }
    
    private void TrataRetornoPause(int iRetorno){
    	if(iRetorno == PauseMenuActivity.RESULT_RESTART){
    		ResetData();
    	}
    	
    	AtualizaTela();
    }
    
    private void ResetData(){
    	mTotalClicksP1 = 0;
    	mTotalClicksP2 = 0;
    }
    
    private void CheckWinner(){
    	LinearLayout.LayoutParams paramsP1 = (LinearLayout.LayoutParams)findViewById(R.id.ScreenPlayer1).getLayoutParams();
    	
    	boolean bHaVencedor = false;
    	
    	Intent i = new Intent(WarActivity.this, WinnerActivity.class);
    	
    	if (paramsP1.weight == 0){
    		bHaVencedor = true;
    		i.putExtra(KEY_WINNER, "Player1");
    		i.putExtra(KEY_LOSER, "Player2");
    		i.putExtra(KEY_TOTAL_CLICKS_W, mTotalClicksP1);
    		i.putExtra(KEY_TOTAL_CLICKS_L, mTotalClicksP2);
    	}
    	else if(paramsP1.weight == 100){
    		bHaVencedor = true;
    		i.putExtra(KEY_WINNER, "Player2");
    		i.putExtra(KEY_LOSER, "Player1");
    		i.putExtra(KEY_TOTAL_CLICKS_W, mTotalClicksP2);
    		i.putExtra(KEY_TOTAL_CLICKS_L, mTotalClicksP1);
    	}
    	
    	if (bHaVencedor){
    		startActivity(i);
    		finish();
    	}
    }
}
