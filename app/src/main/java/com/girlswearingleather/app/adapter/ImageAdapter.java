package com.girlswearingleather.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.etsy.android.grid.util.DynamicHeightImageView;
import com.girlswearingleather.app.R;
import com.girlswearingleather.app.model.Image;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Dani on 26/09/2015.
 */
public class ImageAdapter extends ArrayAdapter<Image> {

    private static final String TAG = "ImageAdapter";

    private final LayoutInflater mLayoutInflater;

    public ImageAdapter(Context context, int textViewResourceId, ArrayList<Image> objects) {
        super(context, textViewResourceId, objects);
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.image_item_layout,parent, false);
            vh = new ViewHolder();
            vh.small = (DynamicHeightImageView) convertView.findViewById(R.id.small);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        ImageLoader.getInstance().displayImage(getItem(position).getSmall(), vh.small);
        return convertView;
    }

    static class ViewHolder {
        DynamicHeightImageView small;
    }


}
