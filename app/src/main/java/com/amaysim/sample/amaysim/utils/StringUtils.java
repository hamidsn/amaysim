package com.amaysim.sample.amaysim.utils;

import java.text.DecimalFormat;

public class StringUtils {

    public static String formatToCurrency(int value) {
        String prefixChar = "";
        if (value < 0) {
            prefixChar = "-";
        }
        DecimalFormat format = new DecimalFormat("#,##0.00");
        return prefixChar + "$" + format.format(Math.abs(value));
    }
}
