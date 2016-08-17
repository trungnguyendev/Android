package dev.trung.sun.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trungnv on 8/17/2016.
 */

public class SimpleDate {
    @SerializedName("tz_long")
    private String tzLong;
    @SerializedName("weekday_short")
    private String weekdayShort;
    @SerializedName("day")
    private int day;
    @SerializedName("monthname_short")
    private String monthnameShort;
    @SerializedName("year")
    private int year;
    @SerializedName("hour")
    private int hour;
    @SerializedName("min")
    private int min;
    @SerializedName("ampm")
    private String ampm;

    public SimpleDate() {
    }

    public String getTzLong() {
        return tzLong;
    }

    public String getWeekdayShort() {
        return weekdayShort;
    }

    public int getDay() {
        return day;
    }

    public String getMonthnameShort() {
        return monthnameShort;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public String getAmpm() {
        return ampm;
    }
}
