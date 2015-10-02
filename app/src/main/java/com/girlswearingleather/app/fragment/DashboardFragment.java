package com.girlswearingleather.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.girlswearingleather.app.R;


/**
 * Created by Dani on 12/09/2015.
 */
public class DashboardFragment extends Fragment {

    private DashboardItem mDashboardItem;

    public static DashboardFragment newInstance(){
        DashboardFragment fragment = new DashboardFragment();
        return fragment;
    }

    public DashboardFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_dashboard_layout, container, false);
        //GridView gridView = (GridView)rootView.findViewById(R.id.gridview);
        //gridView.setAdapter(new CategoryAdapter(getActivity().getApplicationContext()));
        return rootView;
    }

    private void populate(){
        mDashboardItem = new DashboardItem();
    }
}
