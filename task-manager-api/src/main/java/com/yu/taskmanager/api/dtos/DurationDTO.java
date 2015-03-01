package com.yu.taskmanager.api.dtos;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yu on 15-2-11.
 */
public class DurationDTO implements Serializable {
    private String startTime;
    private String endTime;
    private double consumingHour;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getConsumingHour() {
        return consumingHour;
    }

    public void setConsumingHour(double consumingHour) {
        this.consumingHour = consumingHour;
    }
}
