package com.girlswearingleather.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.etsy.android.grid.util.DynamicHeightImageView;
import com.girlswearingleather.app.R;
import com.girlswearingleather.app.model.Album;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Dani on 26/09/2015.
 */
public class AlbumStaggeredAdapter extends ArrayAdapter<Album> {

    private static final String TAG = "AlbumStaggeredAdapter";

    private final LayoutInflater mLayoutInflater;

    public AlbumStaggeredAdapter(Context context, int textViewResourceId, ArrayList<Album> objects) {
        super(context, textViewResourceId, objects);
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.album_item_layout,parent, false);
            vh = new ViewHolder();
            vh.thumbnail = (DynamicHeightImageView) convertView.findViewById(R.id.thumbnail);
            vh.name = (TextView)convertView.findViewById(R.id.name);
            vh.description = (TextView)convertView.findViewById(R.id.description);
            vh.pictures = (TextView)convertView.findViewById(R.id.pictures);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        ImageLoader.getInstance().displayImage(getItem(position).getThumbnail(), vh.thumbnail);
        vh.name.setText(getItem(position).getName());
        vh.description.setText(getItem(position).getDescription());
        vh.pictures.setText(String.valueOf(getItem(position).getPictures()));
        //vh.text.setText(getItem(position).getName());
        return convertView;
    }

    static class ViewHolder {
        DynamicHeightImageView thumbnail;
        TextView description;
        TextView name;
        TextView pictures;
    }


}
