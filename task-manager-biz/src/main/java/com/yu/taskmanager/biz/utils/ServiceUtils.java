package com.yu.taskmanager.biz.utils;

import com.yu.taskmanager.api.services.DurationService;
import com.yu.taskmanager.api.services.StoryService;
import com.yu.taskmanager.api.services.TaskService;
import com.yu.taskmanager.biz.impl.DurationServiceObject;
import com.yu.taskmanager.biz.impl.StoryServiceObject;
import com.yu.taskmanager.biz.impl.TaskServiceObject;

/**
 * Created by yu on 15-2-16.
 */
public class ServiceUtils {
    private static StoryServiceObject storyServiceObject;
    private static TaskServiceObject taskServiceObject;
    private static DurationServiceObject durationServiceObject;

    public static StoryService getStoryService() {
        if(storyServiceObject == null) {
            storyServiceObject = new StoryServiceObject();
        }
        return storyServiceObject;
    }

    public static TaskService getTaskService() {
        if(taskServiceObject == null) {
            taskServiceObject = new TaskServiceObject();
        }
        return taskServiceObject;
    }

    public static DurationService getDurationService() {
        if(durationServiceObject == null) {
            durationServiceObject = new DurationServiceObject();
        }
        return durationServiceObject;
    }
}
