package com.soyokra.learn.kernel.support.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * 时间工具类
 * Date, String, LocalDate, LocalDateTime, Instant 转来转去
 */
public class DateTimeUtils {

    private final Instant instant;

    private final ZoneId zoneId;

    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    public DateTimeUtils(Instant instant, ZoneId zoneId) {
        this.instant = instant;
        this.zoneId = zoneId;
    }

    public static DateTimeUtils valueOf() {
        return new DateTimeUtils(Instant.now(), ZoneId.systemDefault());
    }

    public static DateTimeUtils valueOf(ZoneId zoneId) {
        return new DateTimeUtils(Instant.now(), zoneId);
    }

    public static DateTimeUtils valueOf(String time) {
        return DateTimeUtils.valueOf(time, ZoneId.systemDefault());
    }

    public static DateTimeUtils valueOf(String time, ZoneId zoneId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        LocalDateTime localDateTime = LocalDateTime.parse(time, formatter);
        return DateTimeUtils.valueOf(localDateTime, zoneId);
    }

    public static DateTimeUtils valueOf(Date date) {
        return DateTimeUtils.valueOf(date, ZoneId.systemDefault());
    }

    public static DateTimeUtils valueOf(Date date, ZoneId zoneId) {
        return new DateTimeUtils(date.toInstant(), zoneId);
    }

    public static DateTimeUtils valueOf(String time, String pattern) {
        return DateTimeUtils.valueOf(time, pattern, ZoneId.systemDefault());
    }

    public static DateTimeUtils valueOf(String time, String pattern, ZoneId zoneId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.parse(time, formatter);
        return DateTimeUtils.valueOf(localDateTime, zoneId);
    }

    public static DateTimeUtils valueOf(LocalDateTime localDateTime) {
       return DateTimeUtils.valueOf(localDateTime, ZoneId.systemDefault());
    }

    public static DateTimeUtils valueOf(LocalDateTime localDateTime, ZoneId zoneId) {
        return new DateTimeUtils(localDateTime.atZone(zoneId).toInstant(), zoneId);
    }

    public static DateTimeUtils valueOf(LocalDate localDate) {
       return DateTimeUtils.valueOf(localDate, ZoneId.systemDefault());
    }

    public static DateTimeUtils valueOf(LocalDate localDate, ZoneId zoneId) {
        return new DateTimeUtils(localDate.atStartOfDay().atZone(zoneId).toInstant(), zoneId);
    }

    public static DateTimeUtils valueOf(Long epochSecond) {
        return DateTimeUtils.valueOf(epochSecond, ZoneId.systemDefault());
    }

    public static DateTimeUtils valueOf(Long epochSecond, ZoneId zoneId) {
        return new DateTimeUtils(Instant.ofEpochSecond(epochSecond), zoneId);
    }

    public static DateTimeUtils valueOf(Instant instant) {
        return DateTimeUtils.valueOf(instant, ZoneId.systemDefault());
    }

    public static DateTimeUtils valueOf(Instant instant, ZoneId zoneId) {
        return new DateTimeUtils(instant, zoneId);
    }

    public Long epochSecond() {
        return this.instant.getEpochSecond();
    }

    public LocalDateTime localDateTime() {
        return instant.atZone(zoneId).toLocalDateTime();
    }

    public LocalDate localDate() {
        return instant.atZone(zoneId).toLocalDate();
    }

    public Instant instant() {
        return instant;
    }

    public Date date() {
        return new Date(instant.toEpochMilli());
    }

    public String format() {
        return instant.atZone(zoneId).format(DateTimeFormatter.ofPattern(PATTERN));
    }

    public String format(String pattern) {
        return instant.atZone(zoneId).format(DateTimeFormatter.ofPattern(pattern));
    }


    public static CountDown countDownValueOf(Long value) {
        long days = value / (60 * 60 * 24);
        long hours = (value % (60 * 60 * 24)) / (60 * 60);
        long minutes = (value % (60 * 60)) / 60;
        long seconds = value % 60;

        CountDown countDown = new CountDown();
        countDown.setDays(days);
        countDown.setHours(hours);
        countDown.setMinutes(minutes);
        countDown.setSeconds(seconds);

        return countDown;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CountDown {
        private Long days;
        private Long hours;
        private Long minutes;
        private Long seconds;
    }
}
