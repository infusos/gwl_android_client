package com.girlswearingleather.app.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;

import com.etsy.android.grid.StaggeredGridView;
import com.girlswearingleather.app.R;
import com.girlswearingleather.app.adapter.ImageAdapter;
import com.girlswearingleather.app.manager.WebserviceManager;
import com.girlswearingleather.app.model.Album;
import com.girlswearingleather.app.model.Image;
import com.girlswearingleather.app.task.ListImagesAsyncTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dani on 19/09/2015.
 */
public class ImageActivity extends AppCompatActivity implements DialogInterface.OnCancelListener, WebserviceManager.OnImagesUpdated, /*AbsListView.OnScrollListener, */AbsListView.OnItemClickListener {

    private StaggeredGridView mGridView;
    private ImageAdapter mAdapter;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_staggered_layout);

        mGridView = (StaggeredGridView) findViewById(R.id.gridView);
        mAdapter = new ImageAdapter(this,android.R.layout.simple_list_item_1, new ArrayList<Image>());


        mGridView.setAdapter(mAdapter);
        //mGridView.setOnScrollListener(this);
        mGridView.setOnItemClickListener(this);

        mProgressDialog = ProgressDialog.show(this,"Title","Loading...",false,true,this);
        mProgressDialog.show();

        ListImagesAsyncTask loadData = new ListImagesAsyncTask(this);
        loadData.execute(new Album());
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putStringArrayList(SAVED_DATA_KEY, mData);
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

    private void onLoadMoreItems() {
        final ArrayList<Album> sampleData = generateData();
        for (Album data : sampleData) {
            mAdapter.add(data);
        }
        // stash all the data in our backing store
        mData.addAll(sampleData);
        // notify the adapter that we can update now
        mAdapter.notifyDataSetChanged();
        mHasRequestedMore = false;
    }
     */

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent i = new Intent(this, ImageDetailActivity.class);
        i.putExtra("category", position);
        startActivity(i);
    }

    @Override
    public void onImagesUpdated(List<Image> images) {
        mAdapter.addAll(images);
        mAdapter.notifyDataSetChanged();
        mProgressDialog.dismiss();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public void onCancel(DialogInterface dialogInterface) {
        mProgressDialog.dismiss();
        super.onBackPressed();
    }
}