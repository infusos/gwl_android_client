package com.girlswearingleather.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.girlswearingleather.app.R;
import com.girlswearingleather.app.model.Album;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dani on 13/09/2015.
 */
public class AlbumItemAdapter extends UltimateViewAdapter<AlbumItemAdapter.AlbumItemViewHolder> {

    private List<Album> itemList;
    private Context mContext;

    public AlbumItemAdapter(List<Album> itemList, Context context){
        this.itemList = itemList;
        this.mContext = context;
    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }

    @Override
    public AlbumItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View item = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_item_layout,viewGroup,false);
        return new AlbumItemViewHolder(item,mContext);
    }

    @Override
    public int getAdapterItemCount() {
        return 0;
    }

    @Override
    public long generateHeaderId(int i) {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup viewGroup) {
        return null;
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public AlbumItemViewHolder getViewHolder(View view) {
        return new AlbumItemViewHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(AlbumItemViewHolder albumItemViewHolder, int i) {
        Album ci = itemList.get(i);
        albumItemViewHolder.id = ci.getId();
        albumItemViewHolder.name.setText(ci.getName());
        albumItemViewHolder.description.setText(ci.getDescription());
        albumItemViewHolder.pictures.setText("5");
        albumItemViewHolder.loadThumbnail(ci.getThumbnail());
    }

    public static class AlbumItemViewHolder extends UltimateRecyclerviewViewHolder{

        protected int id;
        @Bind(R.id.name)
        protected TextView name;
        @Bind(R.id.description)
        protected TextView description;
        @Bind(R.id.thumbnail)
        protected ImageView thumbnail;
        @Bind(R.id.pictures)
        protected TextView pictures;

        private Context mContext;

        public AlbumItemViewHolder(View v, Context context){
            super(v);
            ButterKnife.bind(this, v);
            this.mContext = context;
        }

        public void loadThumbnail(String url){
            Picasso.with(mContext).load(url).into(thumbnail);
        }
    }
}
