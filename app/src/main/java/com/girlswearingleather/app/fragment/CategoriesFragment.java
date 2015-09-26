package com.girlswearingleather.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.girlswearingleather.app.R;
import com.girlswearingleather.app.activity.CategoryListActivity;
import com.girlswearingleather.app.activity.CategoryListActivity_;
import com.girlswearingleather.app.adapter.CategoryAdapter;
import com.orhanobut.logger.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Dani on 12/09/2015.
 */

public class CategoriesFragment extends Fragment implements AdapterView.OnItemClickListener{

    @Bind(R.id.gridview)
    GridView mGridView;

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
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_categories_layout, container, false);
        ButterKnife.bind(this,rootView);
        //GridView gridView = (GridView)rootView.findViewById(R.id.gridview);
        mGridView.setAdapter(new CategoryAdapter(getActivity().getApplicationContext()));
        mGridView.setOnItemClickListener(this);
        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Logger.d("POS: "+position);
        Intent i = new Intent(getActivity(), CategoryListActivity_.class);
        i.putExtra("category",position);
        startActivity(i);
    }
}
