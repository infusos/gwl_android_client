package com.girlswearingleather.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.girlswearingleather.app.R;
import com.girlswearingleather.app.model.DashboardItem;


/**
 * Created by Dani on 12/09/2015.
 */
public class SearchFragment extends Fragment {

    public static SearchFragment newInstance(){
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    public SearchFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_search_layout, container, false);
        return rootView;
    }

}
