package com.yu.taskmanager.api.services;

import com.yu.taskmanager.api.datas.TaskData;
import com.yu.taskmanager.api.dtos.TaskBaseDTO;
import com.yu.taskmanager.api.dtos.TaskDetailDTO;

import java.util.List;

/**
 * Created by yu on 15-2-11.
 */
public interface TaskService {
    List<TaskDetailDTO> findAllTaskByStory(String storyNo);

    void addTask(TaskData taskData, double estimateHour);

    void delTask(String taskNo);

    void delTaskByStory(String storyNo);

    void adjustSequence(String taskNo, int sequence);

    void startTask(String taskNo);

    void accomplishTask(String taskNo);

    TaskDetailDTO loadTask(String taskNo);

    int getTaskCountByStory(String storyNo);
}
