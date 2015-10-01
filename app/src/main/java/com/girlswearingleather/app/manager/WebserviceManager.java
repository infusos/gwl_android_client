package com.girlswearingleather.app.manager;

import com.girlswearingleather.app.model.Album;
import com.girlswearingleather.app.model.Category;
import com.girlswearingleather.app.model.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hefesto on 1/10/15.
 */
public class WebserviceManager {

    public WebserviceManager(){

    }

    public List<Album> listAlbums(Category category){
        List<Album> albums = new ArrayList<Album>();
        for(int i = 0; i<10; i++){
            albums.add(new Album(i,10,"http://www.leathercelebrities.com/images/resized/chloe-moretz-attends-the-coach-womens-spring-2016-fashion-show-150x225.jpg","test","test2"));
        }
        return albums;
    }

    public List<Image> listImages(Album album){
        List<Image> images = new ArrayList<Image>();
        for(int i = 0; i<10; i++){
            images.add(new Image(0,"http://www.leathercelebrities.com/images/uploads/15485/dionne-bromfield-attends-catwalk-%281%29__thumb.jpg","",""));
        }
        return images;
    }

    public interface OnAlbumsUpdated{
        void onAlbumsUpdated(List<Album> albums);
    }

    public interface OnImagesUpdated{
        void onImagesUpdated(List<Image> images);
    }

    public interface OnImageLoaded{
        void onImageLoaded(Image image);
    }
}
