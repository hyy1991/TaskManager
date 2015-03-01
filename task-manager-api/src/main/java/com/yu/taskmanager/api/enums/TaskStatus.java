package com.yu.taskmanager.api.enums;

/**
 * Created by yu on 15-2-10.
 */
public enum TaskStatus {

    DEFAULT(0, "默认错误"),
    TODO(1, "待办"),
    DOING(2, "进行中"),
    DONE(3, "完成"),
    DELAY(4, "延迟");

    private int status;
    private String description;

    private TaskStatus(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public String toString() {
        return this.description;
    }

    public int valueOf() {
        return this.status;
    }

    public static TaskStatus getStatus(int status) {
        for(TaskStatus taskStatus : TaskStatus.values()) {
            if(taskStatus.valueOf() == status) {
                return taskStatus;
            }
        }
        return TaskStatus.DEFAULT;
    }
}
