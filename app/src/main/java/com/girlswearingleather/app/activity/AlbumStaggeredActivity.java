package com.girlswearingleather.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;

import com.etsy.android.grid.StaggeredGridView;
import com.girlswearingleather.app.R;
import com.girlswearingleather.app.adapter.AlbumItemAdapter;
import com.girlswearingleather.app.adapter.AlbumStaggeredAdapter;
import com.girlswearingleather.app.model.AlbumItem;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.orhanobut.logger.Logger;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dani on 19/09/2015.
 */
public class AlbumStaggeredActivity extends AppCompatActivity implements /*AbsListView.OnScrollListener, */AbsListView.OnItemClickListener {

    private static final String TAG = "AlbumGridActivity";
    public static final String SAVED_DATA_KEY = "SAVED_DATA";

    private StaggeredGridView mGridView;
    private boolean mHasRequestedMore;
    private AlbumStaggeredAdapter mAdapter;

    private ArrayList<AlbumItem> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_staggered_layout);

        //setTitle("TechnoTalkative - SGV Demo");
        mGridView = (StaggeredGridView) findViewById(R.id.gridView);
        mAdapter = new AlbumStaggeredAdapter(this,android.R.layout.simple_list_item_1, new ArrayList<AlbumItem>());
        // do we have saved data?
        //if (savedInstanceState != null) {
        //    mData = savedInstanceState.getStringArrayList(SAVED_DATA_KEY);
        //}

        if (mData == null) {
            mData = generateData();
        }

        for (AlbumItem data : mData) {
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
    */
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

    private ArrayList<AlbumItem> generateData() {
        ArrayList<AlbumItem> listData = new ArrayList<AlbumItem>();
        listData.add(new AlbumItem(0,10,"http://www.leathercelebrities.com/images/resized/chloe-moretz-attends-the-coach-womens-spring-2016-fashion-show-150x225.jpg","This is a name","This is a description"));
        /*
        listData.add("http://i62.tinypic.com/2iitkhx.jpg");
        listData.add("http://i61.tinypic.com/w0omeb.jpg");
        listData.add("http://i60.tinypic.com/w9iu1d.jpg");
        listData.add("http://i60.tinypic.com/iw6kh2.jpg");
        listData.add("http://i57.tinypic.com/ru08c8.jpg");
        listData.add("http://i60.tinypic.com/k12r10.jpg");
        listData.add("http://i58.tinypic.com/2e3daug.jpg");
        listData.add("http://i59.tinypic.com/2igznfr.jpg");
        */
        return listData;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent i = new Intent(this, ImageStaggeredActivity.class);
        i.putExtra("category",position);
        startActivity(i);
    }
}