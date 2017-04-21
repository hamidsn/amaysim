package com.amaysim.sample.amaysim.utils;

import java.io.IOException;
import java.io.InputStream;

import static com.amaysim.sample.amaysim.AmaysimApplication.getAppContext;

/**
 * Created by Hamid on 21/04/2017.
 */

public class AssetsUtils {
    private static String FILE_NAME = "collection.json";

    public static String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAppContext().getAssets().open(FILE_NAME);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}
