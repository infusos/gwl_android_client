package com.girlswearingleather.app.task;

import android.os.AsyncTask;

import com.girlswearingleather.app.BaseApplication;
import com.girlswearingleather.app.manager.DatabaseManager;
import com.girlswearingleather.app.manager.WebserviceManager;
import com.girlswearingleather.app.model.Album;
import com.girlswearingleather.app.model.Category;

import java.util.List;
import java.util.Observable;

/**
 * Created by hefesto on 1/10/15.
 */
public class ListAlbumsAsyncTask extends AsyncTask<Category, Void, List<Album>> {

    private WebserviceManager.OnAlbumsUpdated listener;

    public ListAlbumsAsyncTask(WebserviceManager.OnAlbumsUpdated listener){
        this.listener = listener;
    }

    @Override
    protected List<Album> doInBackground(Category... category) {
        return BaseApplication.getWebserviceManagerInstance().listAlbums(category[0]);
    }

    @Override
    protected void onPostExecute(List<Album> albums){
        super.onPostExecute(albums);
        listener.onAlbumsUpdated(albums);
    }

}
