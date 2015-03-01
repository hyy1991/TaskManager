package com.yu.taskmanager.api.datas;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yu on 15-2-5.
 */
public class StoryData implements Serializable {
    private String serialNo;
    private String summary;
    private String content;
    private int priority;
    private int importance;
    private int status;
    private String todoWeek;
    private String addTime;
    private String memo;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTodoWeek() {
        return todoWeek;
    }

    public void setTodoWeek(String todoWeek) {
        this.todoWeek = todoWeek;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
