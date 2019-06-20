package demo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author allen
 * @date 2019/6/20 15:03
 **/
public class DateUtil {

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd";

    private static final String FULL_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final ThreadLocal<DateFormat> DATE_FORMAT_THREAD_LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat(DEFAULT_PATTERN));


    /**
     * 转换 Date 为 ‘yyyy-MM-dd’ 格式
     *
     * @param date 当前日期
     * @return yyyy-MM-dd
     */
    public static String defaultFormat(Date date) {
        String formatDate = "";
        try {
            formatDate = DATE_FORMAT_THREAD_LOCAL.get().format(date);
        }finally {
            DATE_FORMAT_THREAD_LOCAL.remove();
        }
        return formatDate;
    }

    /**
     * 装换字符串格式为 ‘yyyy-MM-dd’ 的日期为Date格式
     *
     * @param strDate 字符串日期
     * @return Date
     */
    public static Date defaultParse(String strDate) {
        Date date;
        try {
            date = DATE_FORMAT_THREAD_LOCAL.get().parse(strDate);
        } catch (ParseException e) {
            date = new Date();
        } finally {
            DATE_FORMAT_THREAD_LOCAL.remove();
        }
        return date;
    }

    /**
     * 增加分钟数
     *
     * @param date    当前时间
     * @param seconds 分钟数
     * @return
     */
    public static Date addSeconds(Date date, int seconds) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, seconds);
        return cal.getTime();
    }

    /**
     * 增加天数
     *
     * @param date 当前时间
     * @param day  天数
     * @return Date
     */
    public static Date addDay(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    /**
     * 增加月数
     *
     * @param date  当前时间
     * @param month 月份数
     * @return Date
     */
    public static Date addMonth(Date date, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }

}
