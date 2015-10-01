package com.girlswearingleather.app.manager;

import android.media.Image;

import com.girlswearingleather.app.model.AlbumItem;
import com.girlswearingleather.app.model.CategoryItem;
import com.girlswearingleather.app.model.ImageItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hefesto on 1/10/15.
 */
public class WebserviceManager {

    public WebserviceManager(){

    }

    public List<AlbumItem> listAlbums(CategoryItem category){
        List<AlbumItem> albums = new ArrayList<AlbumItem>();
        for(int i = 0; i<10; i++){
            albums.add(new AlbumItem(i,10,"http://www.leathercelebrities.com/images/resized/chloe-moretz-attends-the-coach-womens-spring-2016-fashion-show-150x225.jpg","test","test2"));
        }
        return albums;
    }

    public List<ImageItem> listImages(AlbumItem album){
        List<ImageItem> images = new ArrayList<ImageItem>();
        for(int i = 0; i<10; i++){
            images.add(new ImageItem(0,"http://www.leathercelebrities.com/images/uploads/15485/dionne-bromfield-attends-catwalk-%281%29__thumb.jpg","",""));
        }
        return images;
    }
}
