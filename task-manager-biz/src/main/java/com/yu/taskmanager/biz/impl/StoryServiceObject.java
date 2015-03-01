package com.yu.taskmanager.biz.impl;

import com.yu.taskmanager.api.datas.DurationData;
import com.yu.taskmanager.api.datas.PageModel;
import com.yu.taskmanager.api.dtos.DurationDTO;
import com.yu.taskmanager.api.dtos.StoryBaseDTO;
import com.yu.taskmanager.api.dtos.TaskDetailDTO;
import com.yu.taskmanager.api.enums.DurationGenre;
import com.yu.taskmanager.api.enums.StoryStatus;
import com.yu.taskmanager.biz.dao.StoryDao;
import com.yu.taskmanager.api.datas.StoryData;
import com.yu.taskmanager.api.services.TaskService;
import com.yu.taskmanager.api.dtos.StoryDetailDTO;
import com.yu.taskmanager.api.services.DurationService;
import com.yu.taskmanager.api.services.StoryService;
import com.yu.taskmanager.biz.utils.DaoUtils;
import com.yu.taskmanager.biz.utils.DateUtils;
import com.yu.taskmanager.biz.utils.ServiceUtils;

import java.util.*;

/**
 * Created by yu on 15-2-11.
 */
public class StoryServiceObject implements StoryService {

    private StoryDao storyDao = DaoUtils.getStoryDao();
    private TaskService taskService = ServiceUtils.getTaskService();
    private DurationService durationService = ServiceUtils.getDurationService();

    @Override
    public PageModel paginateInitStory(int page, int pageSize) {
        PageModel pageModel = storyDao.paginateInitStory(page, pageSize);
        if(pageModel == null || pageModel.getRecords().size() == 0) {
            return pageModel;
        }

        List<StoryData> storyDataList = (List<StoryData>) pageModel.getRecords();
        List<StoryBaseDTO> baseDTOList = new LinkedList<StoryBaseDTO>();
        for(StoryData storyData : storyDataList) {
            baseDTOList.add(buildStoryBaseDTO(storyData));
        }
        pageModel.setRecords(baseDTOList);
        return pageModel;
    }

    @Override
    public List<StoryDetailDTO> findTodoStoryList() {
        String todoWeek = DateUtils.getWeekOfYear();
        List<StoryData> storyDataList = storyDao.findTodoStoryList(todoWeek);
        if(storyDataList == null || storyDataList.size() == 0) {
            return Collections.emptyList();
        }

        List<StoryDetailDTO> detailBeanList = new LinkedList<StoryDetailDTO>();
        for(StoryData storyData : storyDataList) {
            StoryDetailDTO storyDetailBean = buildStoryDetailDTO(storyData);
            detailBeanList.add(storyDetailBean);
        }
        return detailBeanList;
    }

    private StoryDetailDTO buildStoryDetailDTO(StoryData storyData) {
        StoryBaseDTO baseBean = buildStoryBaseDTO(storyData);
        List<TaskDetailDTO> taskDetailBeanList = taskService.findAllTaskByStory(storyData.getSerialNo());
        DurationDTO actualDuration = durationService.loadActualDuration(storyData.getSerialNo());
        DurationDTO estimateDuration = durationService.loadEstimateDuration(storyData.getSerialNo());
        StoryDetailDTO storyDetailBean = new StoryDetailDTO();
        storyDetailBean.setBaseBean(baseBean);
        storyDetailBean.setTaskList(taskDetailBeanList);
        storyDetailBean.setActual(actualDuration);
        storyDetailBean.setEstimate(estimateDuration);
        return storyDetailBean;
    }

    private StoryBaseDTO buildStoryBaseDTO(StoryData storyData) {
        StoryBaseDTO baseBean = new StoryBaseDTO();
        baseBean.setSerialNo(storyData.getSerialNo());
        baseBean.setSummary(storyData.getSummary());
        baseBean.setContent(storyData.getContent());
        baseBean.setPriority(storyData.getPriority());
        baseBean.setStatus(storyData.getStatus());
        baseBean.setAddTime(storyData.getAddTime());
        baseBean.setImportance(storyData.getImportance());
        return baseBean;
    }

    @Override
    public void adjustImportance(String storyNo, int importance) {
        storyDao.updateImportance(storyNo, importance);
    }

    @Override
    public void adjustPriority(String storyNo, int priority) {
        storyDao.updatePriority(storyNo, priority);
    }

    @Override
    public void addStory(StoryData storyData) {
        DurationData durationData = new DurationData();
        durationData.setOutBizId(storyData.getSerialNo());
        durationData.setGenre(DurationGenre.ESTIMATE.valueOf());
        durationService.addDuration(durationData);
        durationData.setGenre(DurationGenre.ACTUAL.valueOf());
        durationService.addDuration(durationData);
        storyDao.addStory(storyData);
    }

    @Override
    public void removeStory(String storyNo) {
        storyDao.updateStatus(storyNo, StoryStatus.INIT.valueOf());
    }

    @Override
    public void startStory(String storyNo) {
        storyDao.updateStatus(storyNo, StoryStatus.DOING.valueOf());
    }

    @Override
    public void todoStory(String storyNo, String todoWeek) {
        storyDao.updateStatusAndTodoWeek(storyNo, StoryStatus.TODO.valueOf(), todoWeek);
    }

    @Override
    public void accomplishStory(String storyNo) {
        storyDao.updateStatus(storyNo, StoryStatus.DONE.valueOf());
    }

    @Override
    public void delStory(String storyNo) {
        taskService.delTaskByStory(storyNo);
        durationService.delDuration(storyNo);
        storyDao.delStory(storyNo);
    }

    @Override
    public StoryDetailDTO loadStory(String storyNo) {
        StoryData storyData = storyDao.loadStory(storyNo);
        if(storyData == null) {
            return null;
        }
        return buildStoryDetailDTO(storyData);
    }

    @Override
    public int getTodoCount(String todoWeek) {
        return storyDao.loadTodoCount(todoWeek);
    }
}
