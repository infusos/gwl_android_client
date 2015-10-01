package com.girlswearingleather.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;

import com.etsy.android.grid.StaggeredGridView;
import com.girlswearingleather.app.BaseApplication;
import com.girlswearingleather.app.R;
import com.girlswearingleather.app.adapter.AlbumStaggeredAdapter;
import com.girlswearingleather.app.manager.WebserviceManager;
import com.girlswearingleather.app.model.Album;
import com.girlswearingleather.app.model.Category;
import com.girlswearingleather.app.model.Image;
import com.girlswearingleather.app.task.ListAlbumsAsyncTask;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Dani on 19/09/2015.
 */
public class AlbumStaggeredActivity extends AppCompatActivity implements WebserviceManager.OnAlbumsUpdated, /*AbsListView.OnScrollListener, */AbsListView.OnItemClickListener{

    private String mCategoryName;
    private int mCategoryId;

    private StaggeredGridView mGridView;
    private AlbumStaggeredAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_staggered_layout);

        mCategoryId = (getIntent().getExtras().getInt("categoryId", 0) == 0) ? 1 : getIntent().getExtras().getInt("categoryId");
        mCategoryName = (getIntent().getExtras().getString("categoryName", null) == null) ? "N/A" : getIntent().getExtras().getString("categoryName");

        setTitle(mCategoryName);

        mGridView = (StaggeredGridView) findViewById(R.id.gridView);
        mAdapter = new AlbumStaggeredAdapter(this,android.R.layout.simple_list_item_1, new ArrayList<Album>());

        mGridView.setAdapter(mAdapter);
        //mGridView.setOnScrollListener(this);
        mGridView.setOnItemClickListener(this);

        ListAlbumsAsyncTask loadData = new ListAlbumsAsyncTask(this);
        loadData.execute(new Category(mCategoryName, mCategoryId));
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /*
    @Override
    public void onScrollStateChanged(final AbsListView view, final int scrollState) {
        Log.d(TAG, "onScrollStateChanged:" + scrollState);
    }

    @Override
    public void onScroll(final AbsListView view, final int firstVisibleItem, final int visibleItemCount, final int totalItemCount) {
        Log.d(TAG, "onScroll firstVisibleItem:" + firstVisibleItem +
                " visibleItemCount:" + visibleItemCount +
                " totalItemCount:" + totalItemCount);
        // our handling
        if (!mHasRequestedMore) {
            int lastInScreen = firstVisibleItem + visibleItemCount;
            if (lastInScreen >= totalItemCount) {
                Log.d(TAG, "onScroll lastInScreen - so load more");
                mHasRequestedMore = true;
                onLoadMoreItems();
            }
        }
    }
    */

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent i = new Intent(this, ImageStaggeredActivity.class);
        i.putExtra("category",position);
        startActivity(i);
    }

    @Override
    public void onAlbumsUpdated(List<Album> albums) {
        mAdapter.addAll(albums);
        mAdapter.notifyDataSetChanged();
    }
}