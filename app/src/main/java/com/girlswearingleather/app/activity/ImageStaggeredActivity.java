package com.girlswearingleather.app.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;

import com.etsy.android.grid.StaggeredGridView;
import com.girlswearingleather.app.R;
import com.girlswearingleather.app.adapter.AlbumStaggeredAdapter;
import com.girlswearingleather.app.adapter.ImageStaggeredAdapter;
import com.girlswearingleather.app.model.AlbumItem;
import com.girlswearingleather.app.model.ImageItem;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

/**
 * Created by Dani on 19/09/2015.
 */
public class ImageStaggeredActivity extends AppCompatActivity implements /*AbsListView.OnScrollListener, */AbsListView.OnItemClickListener {

    private static final String TAG = "ImageGridActivity";
    public static final String SAVED_DATA_KEY = "SAVED_DATA";

    private StaggeredGridView mGridView;
    private boolean mHasRequestedMore;
    private ImageStaggeredAdapter mAdapter;

    private ArrayList<ImageItem> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_staggered_layout);

        //setTitle("TechnoTalkative - SGV Demo");
        mGridView = (StaggeredGridView) findViewById(R.id.gridView);
        mAdapter = new ImageStaggeredAdapter(this,android.R.layout.simple_list_item_1, new ArrayList<ImageItem>());
        // do we have saved data?
        //if (savedInstanceState != null) {
        //    mData = savedInstanceState.getStringArrayList(SAVED_DATA_KEY);
        //}

        if (mData == null) {
            mData = generateData();
        }

        for (ImageItem data : mData) {
            mAdapter.add(data);
        }

        mGridView.setAdapter(mAdapter);
        //mGridView.setOnScrollListener(this);
        mGridView.setOnItemClickListener(this);
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
        final ArrayList<AlbumItem> sampleData = generateData();
        for (AlbumItem data : sampleData) {
            mAdapter.add(data);
        }
        // stash all the data in our backing store
        mData.addAll(sampleData);
        // notify the adapter that we can update now
        mAdapter.notifyDataSetChanged();
        mHasRequestedMore = false;
    }
     */
    private ArrayList<ImageItem> generateData() {
        ArrayList<ImageItem> listData = new ArrayList<ImageItem>();
        /*listData.add(new ImageItem(0,"http://i62.tinypic.com/2iitkhx.jpg","",""));
        listData.add(new ImageItem(0,"http://i61.tinypic.com/w0omeb.jpg","",""));
        listData.add(new ImageItem(0,"http://i60.tinypic.com/w9iu1d.jpg","",""));
        listData.add(new ImageItem(0,"http://i60.tinypic.com/iw6kh2.jpg","",""));
        listData.add(new ImageItem(0,"http://i57.tinypic.com/ru08c8.jpg","",""));
        listData.add(new ImageItem(0,"http://i60.tinypic.com/k12r10.jpg","",""));
        */
        listData.add(new ImageItem(0,"http://www.leathercelebrities.com/images/uploads/15485/dionne-bromfield-attends-catwalk-%281%29__thumb.jpg","",""));
        listData.add(new ImageItem(0,"http://www.leathercelebrities.com/images/uploads/15485/dionne-bromfield-attends-catwalk-%281%29__thumb.jpg","",""));
        return listData;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        //Toast.makeText(this, "Item Clicked: " + position, Toast.LENGTH_SHORT).show();
        Logger.d("DASDASD");
    }
}