package jrz.games.screenwar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public abstract class MyBaseAdapter extends BaseAdapter {
	private Context mContext;
	
	public MyBaseAdapter(Context c) {
        mContext = c;
    }

	@Override
	public Object getItem(int arg0) {
		return null;
	}
	
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

        imageView.setImageResource((int) getItemId(position));
        return imageView;
	}
}
