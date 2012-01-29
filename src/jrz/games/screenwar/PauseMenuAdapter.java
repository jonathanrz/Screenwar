package jrz.games.screenwar;

import android.content.Context;

public class PauseMenuAdapter extends MyBaseAdapter {
	
	public PauseMenuAdapter(Context c) {
        super(c);
    }
	
	@Override
	public int getCount() {
		return mThumbIds.length;
	}
	
	@Override
	public long getItemId(int position) {
		return mThumbIds[position].longValue();
	}
	
	private Integer[] mThumbIds = {
            R.drawable.ic_menu_pause_continue,
            R.drawable.ic_menu_pause_restart
    };
}
