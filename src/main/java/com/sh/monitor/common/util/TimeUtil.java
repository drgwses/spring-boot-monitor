package com.sh.monitor.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * @author kuangxz
 */
public class TimeUtil {
    /**
     * 日期 年月日
     */
    public static final String date = "yyyy-MM-dd";
    /**
     * 年月日时分秒毫秒
     */
    public static final String TIME = "yyyyMMddHHmmssSSS";
    /**
     * 年-月-日 时:分:秒:毫秒
     */
    public static final String TIME_LINE = "yyyy-MM-dd HH:mm:ss";

    /**
     * Date转LocalDateTime.
     *
     * @param date Date对象
     * @return LocalDateTime 时间对象
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转Date.
     *
     * @param localDateTime 时间对象
     * @return Date Date对象
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 通过传入的时间字符串以及格式序列化时间
     *
     * @param time      时间字符串
     * @param formatter 格式化字符串
     * @return LocalDateTime对象
     * @throws ParseException 时间转换异常
     */
    public static LocalDateTime getLocalDateTimeFormatter(String time, String formatter) throws ParseException {
        return dateToLocalDateTime(new SimpleDateFormat(formatter).parse(time));
    }


    /**
     * 获取当前时间(yyyyMMddHHmmssSSS)
     *
     * @return 当前时间字符串
     */
    public static String getCurrentTime() {
        return getCurrentTime(TIME);
    }

    /**
     * 字符串转时间（宽松模式）
     *
     * @param dateStr 时间字符串
     * @param format  字符串格式
     * @return 时间
     */
    public static Date toDate(String dateStr, String format) {
        try {
            SimpleDateFormat datteFormat = new SimpleDateFormat(format);
            return datteFormat.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 自定义格式获取时间
     *
     * @param formatter 格式字符串
     * @return 格式化后的时间字符串
     */
    public static String getCurrentTime(String formatter) {
        return getFormatter(LocalDateTime.now(), formatter);
    }

    /**
     * 自定义格式获取时间
     *
     * @param formatter 格式字符串
     * @return 格式化后的时间字符串
     */
    public static String getFormatter(Date date, String formatter) {
        return dateToLocalDateTime(date).format(DateTimeFormatter.ofPattern(formatter));
    }

    /**
     * 自定义格式获取时间
     *
     * @param formatter 格式字符串
     * @return 格式化后的时间字符串
     */
    public static String getFormatter(LocalDateTime localDateTime, String formatter) {
        return localDateTime.format(DateTimeFormatter.ofPattern(formatter));
    }

    /**
     * 获取当天到当前时间的秒数
     *
     * @return 毫秒数
     */
    public static Long getDaySecond() {
        return LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")) - LocalDateTime.of(LocalDate.now(), LocalTime.MIN).toEpochSecond(ZoneOffset.of("+8"));
    }


    public static int getCurrentWeek() {
        return LocalDate.now().getDayOfWeek().getValue();
    }

    public static int getDayOfMonth() {
        return LocalDate.now().getDayOfMonth();
    }

    /**
     * @param fromWeek 周几 1,2,3
     * @return java.lang.Long
     * @description 计算当前周几和传入的周几的差值
     * @author juyuw
     * @date 2021/6/1
     */
    public static int calcWeekTime(int fromWeek) {
        return fromWeek - getCurrentWeek();
    }

    public static int calcMonthTime(int fromDayOfMonth) {
        return fromDayOfMonth - getCurrentWeek();
    }
    /**
     * @description  获取指定日期所在月有多少天
     * @author juyuw
     * @date 2021/6/1
     * @param date
     * @return int
     */
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    /**
     * @description  获取指定日期所在下个月月有多少天
     * @author juyuw
     * @date 2021/6/1
     * @param date
     * @return int
     */
    public static int getDaysOfNextMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
