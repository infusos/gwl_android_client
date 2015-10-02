package com.girlswearingleather.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;

import com.etsy.android.grid.StaggeredGridView;
import com.girlswearingleather.app.R;
import com.girlswearingleather.app.activity.AlbumActivity;
import com.girlswearingleather.app.adapter.CategoryAdapter;
import com.girlswearingleather.app.model.Category;

import java.util.ArrayList;

/**
 * Created by Dani on 26/09/2015.
 */
public class CategoriesFragment extends Fragment implements /*AbsListView.OnScrollListener,*/ AbsListView.OnItemClickListener {

    private static final String TAG = "StaggeredGridActivity";
    public static final String SAVED_DATA_KEY = "SAVED_DATA";

    private StaggeredGridView mGridView;
    private boolean mHasRequestedMore;
    private CategoryAdapter mAdapter;

    private ArrayList<Category> mData;

    public static CategoriesFragment newInstance(){
        CategoriesFragment fragment = new CategoriesFragment();
        return fragment;
    }

    public CategoriesFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_categories_staggered_layout, container, false);

        mGridView = (StaggeredGridView)rootView.findViewById(R.id.gridView);
        mAdapter = new CategoryAdapter(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1, new ArrayList<Category>());
        // do we have saved data?

        //if (savedInstanceState != null) {
            //mData = savedInstanceState.getStringArrayList(SAVED_DATA_KEY);
        //}

        if (mData == null) {
            mData = generateData();
        }

        for (Category data : mData) {
            mAdapter.add(data);
        }

        mGridView.setAdapter(mAdapter);
        //mGridView.setOnScrollListener(this);
        mGridView.setOnItemClickListener(this);
        return rootView;
    }

    //@Override
    public void onScrollStateChanged(final AbsListView view, final int scrollState) {
        Log.d(TAG, "onScrollStateChanged:" + scrollState);
    }

    //@Override
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
        final ArrayList<Category> sampleData = generateData();
        for (Category data : sampleData) {
            mAdapter.add(data);
        }
        // stash all the data in our backing store
        mData.addAll(sampleData);
        // notify the adapter that we can update now
        mAdapter.notifyDataSetChanged();
        mHasRequestedMore = false;
    }

    private ArrayList<Category> generateData() {
        ArrayList<Category> listData = new ArrayList<Category>();
        listData.add(new Category("Boots",R.drawable.thumb_leather_boots));
        listData.add(new Category("Catsuit",R.drawable.thumb_leather_catsuit));
        listData.add(new Category("Coat",R.drawable.thumb_leather_coat));
        listData.add(new Category("Cropped Pants",R.drawable.thumb_leather_cropped_pants));
        listData.add(new Category("Dress",R.drawable.thumb_leather_dress));
        listData.add(new Category("Jacket",R.drawable.thumb_leather_jacket));
        listData.add(new Category("Leggings",R.drawable.thumb_leather_leggings));
        listData.add(new Category("Mini Dress",R.drawable.thumb_leather_mini_dress));
        listData.add(new Category("Mini Skirt",R.drawable.thumb_leather_mini_skirt));
        listData.add(new Category("Pants",R.drawable.thumb_leather_pants));
        listData.add(new Category("Pencil Dress",R.drawable.thumb_leather_pencil_dress));
        listData.add(new Category("Pencil Skirt",R.drawable.thumb_leather_pencil_skirt));
        listData.add(new Category("Pleated Skirt",R.drawable.thumb_leather_pleated_skirt));
        listData.add(new Category("Quilted Skirt",R.drawable.thumb_leather_quilted_skirt));
        listData.add(new Category("Shorts",R.drawable.thumb_leather_shorts));
        listData.add(new Category("Skinny Pants",R.drawable.thumb_leather_skinny_pants));
        listData.add(new Category("Skirt",R.drawable.thumb_leather_skirt));
        listData.add(new Category("Top",R.drawable.thumb_leather_top));
        return listData;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent i = new Intent(getActivity(), AlbumActivity.class);
        i.putExtra("category",position);
        startActivity(i);
    }
}
