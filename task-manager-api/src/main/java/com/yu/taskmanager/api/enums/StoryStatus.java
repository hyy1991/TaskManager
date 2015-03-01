package com.yu.taskmanager.api.enums;

/**
 * Created by yu on 15-2-10.
 */
public enum StoryStatus {

    DEFAULT(0, "默认错误"),
    INIT(1, "初始"),
    TODO(2, "待办"),
    DOING(3, "进行中"),
    DONE(4, "完成"),
    DELAY(5, "延迟");

    private int status;
    private String description;

    private StoryStatus(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public String toString(){
        return this.description;
    }

    public int valueOf() {
        return this.status;
    }

    public static StoryStatus getStatus(int status) {
        for(StoryStatus storyStatus : StoryStatus.values()) {
            if(storyStatus.valueOf() == status) {
                return storyStatus;
            }
        }
        return StoryStatus.DEFAULT;
    }
}
