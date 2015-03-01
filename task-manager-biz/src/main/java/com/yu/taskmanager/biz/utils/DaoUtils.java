package com.yu.taskmanager.biz.utils;

import com.yu.taskmanager.biz.dao.DurationDao;
import com.yu.taskmanager.biz.dao.StoryDao;
import com.yu.taskmanager.biz.dao.TaskDao;

/**
 * Created by yu on 15-2-16.
 */
public class DaoUtils {
    private static StoryDao storyDao;
    private static TaskDao taskDao;
    private static DurationDao durationDao;

    public static StoryDao getStoryDao() {
        if(storyDao == null) {
            storyDao = new StoryDao();
        }
        return storyDao;
    }

    public static TaskDao getTaskDao() {
        if(taskDao == null) {
            taskDao = new TaskDao();
        }
        return taskDao;
    }

    public static DurationDao getDurationDao() {
        if(durationDao == null) {
            durationDao = new DurationDao();
        }
        return durationDao;
    }
}
