package com.example.hbhims.common.utils;

import java.util.Calendar;

/**
 * 日期工具类
 *
 * @author qq1962247851
 * @date 2020/4/26 17:39
 */
public class DateUtil {

    public static Long getTodayStartTime() {
        Calendar calendar = Calendar.getInstance();
        generateCalender(calendar, 0, 0, 0, 0);
        return calendar.getTimeInMillis();
    }

    public static Long getYesterdayDate() {
        Calendar calendar = Calendar.getInstance();
        generateCalender(calendar, 0, 0, 0, 0);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTimeInMillis();
    }

    private static void generateCalender(Calendar calendar, int hourOfDay, int minute, int second, int millisecond) {
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, millisecond);
    }

    public static Long getTodayEndTime() {
        Calendar calendar = Calendar.getInstance();
        generateCalender(calendar, 23, 59, 59, 999);
        return calendar.getTimeInMillis();
    }

    public static Long getOnlyDate(Long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        generateCalender(calendar, 0, 0, 0, 0);
        return calendar.getTimeInMillis();
    }

    public static void main(String[] args) {
        System.out.println(getYesterdayDate());
    }

}
