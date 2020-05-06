package org.ithan.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Date 2020/5/4 13:42
 **/
public class DateUtils {

    /**
     * 日期转换成字符串
     * @param date 要转换的日期
     * @param pattern 要转换的格式
     * @return 转换成的字符串
     */
    public static String date2String(Date date,String pattern){
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String format = dateFormat.format(date);
        return format;
    }

    /**
     * 字符串转换成日期
     * @param str  要转换的字符串
     * @param pattern 要转换的格式
     * @return 转换成的日期
     */
    public static Date string2Date(String str,String pattern) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = dateFormat.parse(str);
        return date;
    }

}
