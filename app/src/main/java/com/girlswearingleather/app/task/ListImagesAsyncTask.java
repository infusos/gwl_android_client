package com.girlswearingleather.app.task;

import android.os.AsyncTask;

import com.girlswearingleather.app.BaseApplication;
import com.girlswearingleather.app.manager.WebserviceManager;
import com.girlswearingleather.app.model.Album;
import com.girlswearingleather.app.model.Category;
import com.girlswearingleather.app.model.Image;

import java.util.List;

/**
 * Created by hefesto on 1/10/15.
 */
public class ListImagesAsyncTask extends AsyncTask<Album, Void, List<Image>> {

    private WebserviceManager.OnImagesUpdated listener;

    public ListImagesAsyncTask(WebserviceManager.OnImagesUpdated listener){
        this.listener = listener;
    }

    @Override
    protected List<Image> doInBackground(Album... albums) {
        return BaseApplication.getWebserviceManagerInstance().listImages(albums[0]);
    }

    @Override
    protected void onPostExecute(List<Image> images){
        super.onPostExecute(images);
        listener.onImagesUpdated(images);
    }

}
