package com.warungpintar.simpleapi.helper;

import java.util.Date;

public class Util {

    public static long getTimeMilis(){
        Date date = new Date();
        return date.getTime();
    }
}
