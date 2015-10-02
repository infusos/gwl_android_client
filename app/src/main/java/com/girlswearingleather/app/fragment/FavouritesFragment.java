package com.girlswearingleather.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.girlswearingleather.app.R;


/**
 * Created by Dani on 12/09/2015.
 */
public class FavouritesFragment extends Fragment {

    public static FavouritesFragment newInstance(){
        FavouritesFragment fragment = new FavouritesFragment();
        return fragment;
    }

    public FavouritesFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_favourites_layout, container, false);
        GridView gridView = (GridView)rootView.findViewById(R.id.gridview);
        gridView.setAdapter(new CategoryAdapter(getActivity().getApplicationContext()));
        return rootView;
    }

}
