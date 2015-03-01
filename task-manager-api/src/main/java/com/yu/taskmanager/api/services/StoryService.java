package com.yu.taskmanager.api.services;

import com.yu.taskmanager.api.datas.PageModel;
import com.yu.taskmanager.api.dtos.StoryBaseDTO;
import com.yu.taskmanager.api.datas.StoryData;
import com.yu.taskmanager.api.dtos.StoryDetailDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by yu on 15-2-10.
 */
public interface StoryService {
    public PageModel paginateInitStory(int page, int pageSize);

    public List<StoryDetailDTO> findTodoStoryList();

    public void adjustImportance(String storyNo, int importance);

    public void adjustPriority(String storyNo, int priority);

    public void addStory(StoryData storyData);

    public void removeStory(String storyNo);

    public void startStory(String storyNo);

    public void todoStory(String storyNo, String todoWeek);

    public void accomplishStory(String storyNo);

    public void delStory(String storyNo);

    public StoryDetailDTO loadStory(String storyNo);

    public int getTodoCount(String todoWeek);
}
