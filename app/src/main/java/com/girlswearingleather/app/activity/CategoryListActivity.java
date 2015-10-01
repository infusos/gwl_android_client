package com.girlswearingleather.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.girlswearingleather.app.R;
import com.girlswearingleather.app.adapter.AlbumItemAdapter;
import com.girlswearingleather.app.model.Album;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dani on 19/09/2015.
 */
@EActivity(R.layout.activity_category_list_layout)
public class CategoryListActivity extends AppCompatActivity{

    @ViewById(R.id.cardList)
    UltimateRecyclerView mCardList;

    private List<Album> mContent;
    private AlbumItemAdapter mAdapter;

    @AfterViews
    public void init(){
        mContent = new ArrayList<Album>();
        mCardList.setHasFixedSize(true);
        LinearLayoutManager mLlm = new LinearLayoutManager(this);
        mLlm.setOrientation(LinearLayoutManager.VERTICAL);
        mCardList.setLayoutManager(mLlm);

        for(int i = 0; i<10; i++){
            Album album = new Album(i,10,"http://www.leathercelebrities.com/images/resized/chloe-moretz-attends-the-coach-womens-spring-2016-fashion-show-150x225.jpg","test","test2");
            mContent.add(album);
        }

        mAdapter = new AlbumItemAdapter(mContent,this);
        mCardList.setAdapter(mAdapter);

    }

}
