package com.girlswearingleather.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.etsy.android.grid.util.DynamicHeightImageView;
import com.girlswearingleather.app.R;
import com.girlswearingleather.app.model.Category;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Dani on 26/09/2015.
 */
public class CategoryAdapter extends ArrayAdapter<Category> {

    private static final String TAG = "CategoryAdapter";

    private final LayoutInflater mLayoutInflater;

    public CategoryAdapter(Context context, int textViewResourceId, ArrayList<Category> objects) {
        super(context, textViewResourceId, objects);
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.category_item_layout,parent, false);
            vh = new ViewHolder();
            vh.picture = (DynamicHeightImageView) convertView.findViewById(R.id.picture);
            vh.text = (TextView)convertView.findViewById(R.id.name);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        ImageLoader.getInstance().displayImage("drawable://"+getItem(position).getImage(), vh.picture);
        vh.text.setText(getItem(position).getName());
        return convertView;
    }

    static class ViewHolder {
        DynamicHeightImageView picture;
        TextView text;
    }


}
