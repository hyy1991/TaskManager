package com.yu.taskmanager.api.dtos;

import java.io.Serializable;

/**
 * Created by yu on 15-2-10.
 */
public class TaskBaseDTO implements Serializable {
    private String serialNo;
    private String content;
    private String storyNo;
    private int sequence;
    private int status;
    private String memo;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStoryNo() {
        return storyNo;
    }

    public void setStoryNo(String storyNo) {
        this.storyNo = storyNo;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
