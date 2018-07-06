package com.lipy.common.bean;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Created by lipy on 2018/5/23.
 */
public class CalendarHolidays {
    public static HashMap<String, int[]> mSpecialDays = new HashMap();
    public static HashMap<String, int[]> nonWorkDays = new HashMap();
    public static HashMap<String, int[]> workDays = new HashMap();

    static {
        mSpecialDays.put("元旦", new int[]{20180101, 20190101, 20200101});
        mSpecialDays.put("除夕", new int[]{20180215, 20190204, 20200124});
        mSpecialDays.put("春节", new int[]{20180216, 20190205, 20200125});
        mSpecialDays.put("元宵节", new int[]{20180302, 20190219, 20200208});
        mSpecialDays.put("清明节", new int[]{20180405, 20190405, 20200404});
        mSpecialDays.put("劳动节", new int[]{20180501, 20190501, 20200501});
        mSpecialDays.put("端午节", new int[]{20180618, 20190607, 20200625});
        mSpecialDays.put("中秋节", new int[]{20180924, 20190913, 20201001});
        mSpecialDays.put("国庆节", new int[]{20181001, 20191001, 20201001});
        mSpecialDays.put("情人节", new int[]{20180214, 20190214, 20200214});
        mSpecialDays.put("劳动节", new int[]{20180501, 20190501, 20200501});
        mSpecialDays.put("圣诞节", new int[]{20181225, 20191225, 20201225});
        mSpecialDays.put("七夕", new int[]{20180817, 20190807, 20200825});
        mSpecialDays.put("春节", new int[]{20180216});
        mSpecialDays.put("初二", new int[]{20180217});
        mSpecialDays.put("初三", new int[]{20180218});
        mSpecialDays.put("初四", new int[]{20180219});
        mSpecialDays.put("初五", new int[]{20180220});
        mSpecialDays.put("初六", new int[]{20180221});
        mSpecialDays.put("立春", new int[]{20180204});
        workDays.put("上班", new int[]{20180211, 20180224, 20180408, 20180428, 20180929, 20180930});
        nonWorkDays.put("放假", new int[]{20180101, 20180215, 20180216, 20180217, 20180218, 20180219, 20180220, 20180221, 20180405, 20180406, 20180407, 20180429, 20180430, 20180501, 20180616, 20180617, 20180618, 20180922, 20180923, 20180924, 20181001, 20181002, 20181003, 20181004, 20181005, 20181006, 20181007});
    }

    public static String getCalendarSpecial(Calendar calendar) {
        int i = ((calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100)) + calendar.get(5);
        for (Entry entry : mSpecialDays.entrySet()) {
            for (int i2 : (int[]) entry.getValue()) {
                if (i == i2) {
                    return (String) entry.getKey();
                }
            }
        }
        return null;
    }

    public static String getCalendarSpecial(int year, int month, int day) {
        int i = ((year * 10000) + (month * 100)) + day;
        for (Entry entry : mSpecialDays.entrySet()) {
            for (int i2 : (int[]) entry.getValue()) {
                if (i == i2) {
                    return (String) entry.getKey();
                }
            }
        }
        return null;
    }

    public static String getWorkDay(int year, int month, int day) {
        int i = ((year * 10000) + (month * 100)) + day;
        for (Entry entry : workDays.entrySet()) {
            for (int i2 : (int[]) entry.getValue()) {
                if (i == i2) {
                    return (String) entry.getKey();
                }
            }
        }
        return null;
    }

    public static String getNonWorkDay(int year, int month, int day) {
        int i = ((year * 10000) + (month * 100)) + day;
        for (Entry entry : nonWorkDays.entrySet()) {
            for (int i2 : (int[]) entry.getValue()) {
                if (i == i2) {
                    return (String) entry.getKey();
                }
            }
        }
        return null;
    }

    public static String getWorkDay(Calendar calendar) {
        int i = ((calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100)) + calendar.get(5);
        for (Entry entry : workDays.entrySet()) {
            for (int i2 : (int[]) entry.getValue()) {
                if (i == i2) {
                    return (String) entry.getKey();
                }
            }
        }
        return null;
    }

    public static String getNonWorkDay(Calendar calendar) {
        int i = ((calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100)) + calendar.get(5);
        for (Entry entry : nonWorkDays.entrySet()) {
            for (int i2 : (int[]) entry.getValue()) {
                if (i == i2) {
                    return (String) entry.getKey();
                }
            }
        }
        return null;
    }

//    public static List<CalendarInfo> getRangeHolidays(Date date, Date date2) throws ParseException {
//        Calendar instance = Calendar.getInstance();
//        instance.setTime(date);
//        Calendar instance2 = Calendar.getInstance();
//        instance2.setTime(date2);
//        List<CalendarInfo> arrayList = new ArrayList();
//        int i = ((instance.get(1) * 10000) + ((instance.get(2) + 1) * 100)) + instance.get(5);
//        int i2 = ((instance2.get(1) * 10000) + ((instance2.get(2) + 1) * 100)) + instance2.get(5);
//        for (Entry entry : mSpecialDays.entrySet()) {
//            for (int i3 : (int[]) entry.getValue()) {
//                if (i3 < i2 && i3 > i) {
//                    CalendarInfo calendarInfo = new CalendarInfo();
//                    calendarInfo.holiday = (String) entry.getKey();
//                    calendarInfo.date = String.valueOf(i3);
//                    arrayList.add(calendarInfo);
//                }
//            }
//        }
//        return arrayList;
//    }
}