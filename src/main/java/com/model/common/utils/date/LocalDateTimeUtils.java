package com.model.common.utils.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Objects;

/**
 * @author kingboy--KingBoyWorld@163.com
 * @date 2017/7/23 下午9:16
 * @desc  java8日期工具.
 */
public final class LocalDateTimeUtils {

    private static final long COUNT = 12;

    private static final Integer ZERO = 0;

    private static final Integer HOUR = 23;

    private static final Integer MINUTE = 59;

    private static final Integer NANO = 999999999;

    private LocalDateTimeUtils() { }


    //比较日期先后
    //LocalDateTime.now().isBefore(),
    //LocalDateTime.now().isAfter(),

    //Date转换为LocalDateTime
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    //LocalDateTime转换为Date
    public static Date convertLDTToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }


    //获取指定日期的毫秒
    public static Long getMilliByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    //获取指定日期的秒
    public static Long getSecondsByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    //获取指定时间的指定格式
    public static String formatTime(LocalDateTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    //获取当前时间的指定格式
    public static String formatNow(String pattern) {
        return  formatTime(LocalDateTime.now(), pattern);
    }

    //日期加上一个数,根据field不同加不同值,field为ChronoUnit.*
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    //日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*
    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field) {
        return time.minus(number, field);
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     * @param startTime
     * @param endTime
     * @param field  单位(年月日时分秒)
     * @return
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS) {
            return period.getYears() * COUNT + period.getMonths();
        }
        return field.between(startTime, endTime);
    }

    //获取一天的开始时间，2017,7,22 00:00
    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(ZERO)
                .withMinute(ZERO)
                .withSecond(ZERO)
                .withNano(ZERO);
    }

    //获取一天的结束时间，2017,7,22 23:59:59.999999999
    public static LocalDateTime getDayEnd(LocalDateTime time) {
        return time.withHour(HOUR)
                .withMinute(MINUTE)
                .withSecond(MINUTE)
                .withNano(NANO);
    }

    //根据时间校验
    public static Boolean timeAuth(LocalDateTime time, Integer expiresnIn) {
        if (Objects.isNull(time) || Objects.isNull(expiresnIn) || LocalDateTime.now().compareTo(time.plusSeconds(expiresnIn)) > 0) {
            return false;
        }
        return true;
    }

}
