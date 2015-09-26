package com.girlswearingleather.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.girlswearingleather.app.R;
import com.girlswearingleather.app.model.CategoryItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dani on 19/09/2015.
 */
public class CategoryAdapter extends BaseAdapter {

        private List<CategoryItem> items = new ArrayList<CategoryItem>();
        private LayoutInflater inflater;
        private Context mContext;

        public CategoryAdapter(Context context)
        {
            inflater = LayoutInflater.from(context);

            this.mContext = context;
            items.add(new CategoryItem("Image 1", R.drawable.thumb_leather_boots));
            items.add(new CategoryItem("Image 2", R.drawable.thumb_leather_catsuit));
            items.add(new CategoryItem("Image 3", R.drawable.thumb_leather_coat));
            items.add(new CategoryItem("Image 4", R.drawable.thumb_leather_cropped_pants));
            items.add(new CategoryItem("Image 5", R.drawable.thumb_leather_dress));
            items.add(new CategoryItem("Image 1", R.drawable.thumb_leather_jacket));
            items.add(new CategoryItem("Image 2", R.drawable.thumb_leather_leggings));
            items.add(new CategoryItem("Image 3", R.drawable.thumb_leather_mini_dress));
            items.add(new CategoryItem("Image 4", R.drawable.thumb_leather_mini_skirt));
            items.add(new CategoryItem("Image 5", R.drawable.thumb_leather_pants));
            items.add(new CategoryItem("Image 2", R.drawable.thumb_leather_pencil_dress));
            items.add(new CategoryItem("Image 3", R.drawable.thumb_leather_pencil_skirt));
            items.add(new CategoryItem("Image 4", R.drawable.thumb_leather_pleated_skirt));
            items.add(new CategoryItem("Image 5", R.drawable.thumb_leather_quilted_skirt));
            items.add(new CategoryItem("Image 2", R.drawable.thumb_leather_shorts));
            items.add(new CategoryItem("Image 3", R.drawable.thumb_leather_skinny_pants));
            items.add(new CategoryItem("Image 4", R.drawable.thumb_leather_skirt));
            items.add(new CategoryItem("Image 5", R.drawable.thumb_leather_top));
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i)
        {
            return items.get(i);
        }

        @Override
        public long getItemId(int i)
        {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            View v = view;
            ImageView picture;
            TextView name;

            if(v == null)
            {
                v = inflater.inflate(R.layout.section_item_layout, viewGroup, false);
                v.setTag(R.id.picture, v.findViewById(R.id.picture));
                v.setTag(R.id.text, v.findViewById(R.id.text));
            }

            picture = (ImageView)v.getTag(R.id.picture);
            name = (TextView)v.getTag(R.id.text);

            CategoryItem item = (CategoryItem)getItem(i);

            picture.setImageResource(R.drawable.thumb_leather_catsuit);
            Picasso.with(mContext).load(item.getImage()).resize(200,200).into(picture);
            name.setText(item.getName());

            return v;
        }


}
