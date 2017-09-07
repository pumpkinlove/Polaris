package org.ia.polaris.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by xu.nan on 2017/9/7.
 */

public class DateUtil {
    public static String getTodayStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 EEEE", Locale.CHINA);
        String s = sdf.format(new Date());
        return s;
    }
}
