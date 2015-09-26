package com.girlswearingleather.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.girlswearingleather.app.R;
import com.girlswearingleather.app.adapter.CardItemAdapter;
import com.girlswearingleather.app.model.CardItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dani on 13/09/2015.
 */
public class CardListFragment extends Fragment {

    public enum CardListType { LastUpdatesList, FilteredList }

    private RecyclerView mRecyclerView;
    private List<CardItem> mContent;

    public static CardListFragment newInstance(CardListType type){
        CardListFragment fragment = new CardListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public CardListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        populate(10);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cardview_main_layout, container, false);
        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.cardList);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLlm = new LinearLayoutManager(getActivity());
        mLlm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLlm);
        CardItemAdapter adapter = new CardItemAdapter(mContent);
        mRecyclerView.setAdapter(adapter);
        return rootView;
    }

    private List<CardItem> populate(int size){
        mContent = new ArrayList<CardItem>();
        for(int i=0; i<size; i++){
            CardItem ci = new CardItem();
            ci.name = "Name_"+i;
            ci.surname = "Surname_"+i;
            mContent.add(ci);
        }
        return mContent;
    }
}
