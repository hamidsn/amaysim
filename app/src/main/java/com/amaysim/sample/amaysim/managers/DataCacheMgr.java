package com.amaysim.sample.amaysim.managers;

import com.amaysim.sample.amaysim.mappings.ItemCollection;

import java.util.List;

/**
 * Created by Hamid on 20/04/2017.
 * data is valid during life cycle of the app,
 * It is removed after killing the app
 */

public class DataCacheMgr {
    static String login_details;
    private static DataCacheMgr theInstance;
    private static List<ItemCollection> myCollections = null;
    private static ItemCollection myUserData = null;

    public static DataCacheMgr getInstance() {
        if (theInstance == null) {
            theInstance = new DataCacheMgr();
        }
        return theInstance;
    }

    public static boolean isInitialised() {
        return myCollections != null;
    }

    public static void cacheIncluded(List<ItemCollection> jsonObjects) {
        myCollections = jsonObjects;
    }

    public static List<ItemCollection> restoreIncluded() {
        if (isInitialised()) {
            return myCollections;
        }
        return null;
    }

    public static void cacheUserData(ItemCollection jsonObject) {
        myUserData = jsonObject;
    }

    public static ItemCollection restoreUserData() {
        if (isInitialised()) {
            return myUserData;
        }
        return null;
    }

    public static void setMSNLogin(String contact_number) {
        login_details = contact_number;
    }

    public static String getLogin_details() {
        return login_details;
    }
}
