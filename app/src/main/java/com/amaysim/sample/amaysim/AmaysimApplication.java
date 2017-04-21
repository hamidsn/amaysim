package com.amaysim.sample.amaysim;

import android.app.Application;
import android.content.Context;

/**
 * Created by Hamid on 21/04/2017.
 */

public class AmaysimApplication extends Application {
    private static Context myContext;

    // This will give the whole app one unique context
    // It will be useful if we grow the app with lots of classes
    public static Context getAppContext() {
        return myContext;
    }

    @Override
    public void onCreate()

    {
        super.onCreate();
        myContext = this;
    }

}