package org.landy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String DATE_PATTERN_DEFAULT = "MM/dd/yyyy";
    public static final String DATE_PATTERN_DASH_1 = "MM-dd-yyyy";
    public static final String DATE_PATTERN_DASH_2 = "yyyy-MM-dd";
    public static final String DATE_TIME_PATTERN_DEFAULT = "MM/dd/yyyy HH:mm:ss";
    public static final String DATE_TIME_PATTERN_1 = "yyyyMMdd_HHmmss";
    public static final String DATE_TIME_PATTERN_2 = "yyyy-MM-dd HH:mm:ss";

    public static String getCurrentDateTime() {
        return getCurrentDateTime(new SimpleDateFormat(DATE_TIME_PATTERN_DEFAULT));
    }

    public static String getCurrentDateTime(SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date());
    }

    public static Date string2Date(String originalValue) {
        return string2Date(originalValue, DATE_PATTERN_DEFAULT);
    }

    public static Date string2Date(String originalValue, String format) {
        return string2Date(originalValue, format, true);
    }

    public static Date string2Date(String originalValue, String format, boolean lenient) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(lenient);
        try {
            return dateFormat.parse(originalValue);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String date2String(Date originalValue) {
        return date2String(originalValue, DATE_PATTERN_DEFAULT);
    }

    public static String date2String(Date originalValue, String format) {
        if (originalValue == null) return null;

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(originalValue);
    }

    public static Date getDateIgnoreTime(Date date) {
        return string2Date(date2String(date, DATE_PATTERN_DEFAULT), DATE_PATTERN_DEFAULT);
    }

    public static boolean isValidDate(String dateStr, String format) {
        return isValidDate(dateStr, format, true);
    }

    public static boolean isValidDate(String dateStr, String format, boolean lenient) {
        if (string2Date(dateStr, format, false) == null) return false;

        if (!lenient) {
            Date date = string2Date(dateStr, format);
            String nStr = date2String(date, format);
            if (!dateStr.equals(nStr)) return false;
        }

        return true;
    }

    public static int dayDifference(Date date1, Date date2) {
        int compare = date1.compareTo(date2);

        if (compare == 0) return 0;

        Calendar past = Calendar.getInstance();
        Calendar future = Calendar.getInstance();
        if (compare < 0) {
            past.setTime(date1);
            future.setTime(date2);
        } else {
            past.setTime(date2);
            future.setTime(date1);
        }

        return (int)Math.round((double)(future.getTimeInMillis() - past.getTimeInMillis()) / 8.64E7D);
    }

    public static int dayDifferenceIgnoreTime(Date date1, Date date2) {
        date1 = string2Date(date2String(date1, DATE_PATTERN_DEFAULT), DATE_PATTERN_DEFAULT);
        date2 = string2Date(date2String(date2, DATE_PATTERN_DEFAULT), DATE_PATTERN_DEFAULT);
        return dayDifference(date1, date2);
    }

    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.YEAR);
    }

    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.MONTH);
    }

    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static Date plusMonths(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);

        return calendar.getTime();
    }

    public static Date plusDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);

        return calendar.getTime();
    }

    public static Date getSysDate() {
        return getDateIgnoreTime(new Date());
    }

    public static boolean between(Date date, Date startDate, Date endDate) {
        return date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0;
    }

    //compute age through birthDay
    public static int getAge(Date birthDay) {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            }else{
                age--;
            }
        }
        return age;
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.string2Date("09/14/2017",DATE_TIME_PATTERN_DEFAULT));
    }
}
