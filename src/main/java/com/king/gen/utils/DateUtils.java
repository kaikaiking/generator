package com.king.gen.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类DateUtils的功能描述:
 * 日期处理
 *
 * @auther king
 * @date 2017-08-25 16:12:36
 */
public class DateUtils {
	/**
	 * 时间格式(yyyy-MM)
	 */
	public final static String MONTH_PATTERN = "yyyy-MM";

    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT_THREAD_LOCAL = new ThreadLocal<>();

    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = DATE_FORMAT_THREAD_LOCAL.get();
            if (null == df) {
                df = new SimpleDateFormat();
                DATE_FORMAT_THREAD_LOCAL.set(df);
            }
            df.applyPattern(pattern);
            return df.format(date);
        }
        return null;
    }
    
    /**
     * 获得指定格式日期
     * @param text
     * @param format
     * @return
     * Date
     */
    public static Date parse(String text, String format) {
    	if(StringUtils.isEmpty(text)) {
    		return null;
    	}
    	if(StringUtils.isEmpty(format)) {
    		format = DATE_TIME_PATTERN;
    	}
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	try {
			return sdf.parse(text);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }


}
