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
public class ConfigurationFragment extends Fragment {

    private ConfigurationItem mConfigurationItem;

    public static ConfigurationFragment newInstance(){
        ConfigurationFragment fragment = new ConfigurationFragment();
        return fragment;
    }

    public ConfigurationFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_configuration_layout, container, false);
        return rootView;
    }

    private void populate(){
        mConfigurationItem = new ConfigurationItem();
    }
}
