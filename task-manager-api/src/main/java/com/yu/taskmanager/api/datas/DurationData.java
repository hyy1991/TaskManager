package com.yu.taskmanager.api.datas;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yu on 15-2-6.
 */
public class DurationData implements Serializable {
    private String startTime;
    private String endTime;
    private double consumingHour;
    private String outBizId;
    private int genre;

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

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public String getOutBizId() {
        return outBizId;
    }

    public void setOutBizId(String outBizId) {
        this.outBizId = outBizId;
    }
}
