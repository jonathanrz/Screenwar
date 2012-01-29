package jrz.games.screenwar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MenuAdapter extends BaseAdapter {
	private Context mContext;
	
	public MenuAdapter(Context c) {
        mContext = c;
    }

	@Override
	public int getCount() {
		return mThumbIds.length;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	// create a new ImageView for each item referenced by the Adapter
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 100));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(12, 12, 12, 12);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
	}
	
	public Context GetContext(){
		return mContext;
	}

    private Integer[] mThumbIds = {
            R.drawable.ic_menu_start
    };
}
