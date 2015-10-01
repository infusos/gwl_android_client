package com.girlswearingleather.app;

import android.app.Application;
import android.content.Context;
import android.provider.ContactsContract;

import com.girlswearingleather.app.manager.DatabaseManager;
import com.girlswearingleather.app.manager.WebserviceManager;

/**
 * Created by hefesto on 1/10/15.
 */
public class BaseApplication extends Application {

    private static Context mContext;
    private static WebserviceManager mWebserviceManager;
    private static DatabaseManager mDatabaseManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        mWebserviceManager = new WebserviceManager();
        mDatabaseManager = new DatabaseManager();
    }

    public static Context getInstance(){
        return mContext;
    }

    public static WebserviceManager getWebserviceManagerInstance(){
        return mWebserviceManager;
    }

    public static DatabaseManager getDatabaseManagerInstance(){
        return mDatabaseManager;
    }

}
