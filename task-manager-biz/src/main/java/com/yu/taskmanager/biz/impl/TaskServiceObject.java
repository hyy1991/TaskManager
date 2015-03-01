package com.yu.taskmanager.biz.impl;

import com.yu.taskmanager.api.datas.DurationData;
import com.yu.taskmanager.api.dtos.DurationDTO;
import com.yu.taskmanager.api.dtos.TaskBaseDTO;
import com.yu.taskmanager.api.dtos.TaskDetailDTO;
import com.yu.taskmanager.api.datas.TaskData;
import com.yu.taskmanager.api.enums.DurationGenre;
import com.yu.taskmanager.api.enums.TaskStatus;
import com.yu.taskmanager.api.services.DurationService;
import com.yu.taskmanager.api.services.TaskService;
import com.yu.taskmanager.biz.dao.TaskDao;
import com.yu.taskmanager.biz.utils.DaoUtils;
import com.yu.taskmanager.biz.utils.ServiceUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yu on 15-2-11.
 */
public class TaskServiceObject implements TaskService {

    private TaskDao taskDao = DaoUtils.getTaskDao();
    private DurationService durationService = ServiceUtils.getDurationService();

    @Override
    public List<TaskDetailDTO> findAllTaskByStory(String storyNo) {
        List<TaskData> taskDataList = taskDao.findAllTaskWithStory(storyNo);
        if(taskDataList == null || taskDataList.size() == 0) {
            return Collections.EMPTY_LIST;
        }

        List<TaskDetailDTO> taskDetailBeanList = new LinkedList<TaskDetailDTO>();
        for(TaskData taskData : taskDataList) {
            TaskDetailDTO detailBean = buildTaskDetailBean(taskData);
            taskDetailBeanList.add(detailBean);
        }

        return taskDetailBeanList;
    }

    @Override
    public void addTask(TaskData taskData, double estimateHour) {
        DurationData durationData = new DurationData();
        durationData.setOutBizId(taskData.getSerialNo());
        durationData.setConsumingHour(estimateHour);
        durationData.setGenre(DurationGenre.ESTIMATE.valueOf());
        durationService.addDuration(durationData);
        durationData.setConsumingHour(0);
        durationData.setGenre(DurationGenre.ACTUAL.valueOf());
        durationService.addDuration(durationData);
        durationService.increaseHour(taskData.getStoryNo(), estimateHour, DurationGenre.ESTIMATE.valueOf());
        taskDao.addTask(taskData);
    }

    @Override
    public void delTask(String taskNo) {
        TaskDetailDTO taskDetailDTO = loadTask(taskNo);
        String storyNo = taskDetailDTO.getTaskBaseBean().getStoryNo();
        durationService.delDuration(taskNo);
        durationService.increaseHour(storyNo, -taskDetailDTO.getEstimate().getConsumingHour(),
                DurationGenre.ESTIMATE.valueOf());
        durationService.increaseHour(storyNo, -taskDetailDTO.getActual().getConsumingHour(),
                DurationGenre.ACTUAL.valueOf());
        taskDao.delTask(taskNo);
    }

    @Override
    public void delTaskByStory(String storyNo) {
        List<TaskData> taskDataList = taskDao.findAllTaskWithStory(storyNo);
        if(taskDataList == null || taskDataList.size() == 0) {
            return;
        }

        for(TaskData taskData : taskDataList) {
            this.delTask(taskData.getSerialNo());
        }
    }

    @Override
    public void adjustSequence(String taskNo, int sequence) {
        taskDao.updateSequence(taskNo, sequence);
    }

    @Override
    public void startTask(String taskNo) {
        taskDao.updateStatus(taskNo, TaskStatus.DOING.valueOf());
    }

    @Override
    public void accomplishTask(String taskNo) {
        taskDao.updateStatus(taskNo, TaskStatus.DONE.valueOf());
    }

    @Override
    public TaskDetailDTO loadTask(String taskNo) {
        TaskData taskData = taskDao.loadTask(taskNo);
        if(taskData == null ){
            return null;
        }
        return buildTaskDetailBean(taskData);
    }

    @Override
    public int getTaskCountByStory(String storyNo) {
        return taskDao.loadTaskCountByStory(storyNo);
    }

    private TaskDetailDTO buildTaskDetailBean(TaskData taskData) {
        TaskDetailDTO taskDetailBean = new TaskDetailDTO();
        TaskBaseDTO taskBaseBean = buildTaskBaseBean(taskData);
        taskDetailBean.setTaskBaseBean(taskBaseBean);
        DurationDTO estimate = durationService.loadEstimateDuration(taskData.getSerialNo());
        DurationDTO actual = durationService.loadActualDuration(taskData.getSerialNo());
        taskDetailBean.setEstimate(estimate);
        taskDetailBean.setActual(actual);
        return taskDetailBean;
    }

    private TaskBaseDTO buildTaskBaseBean(TaskData taskData) {
        TaskBaseDTO baseBean = new TaskBaseDTO();
        baseBean.setContent(taskData.getContent());
        baseBean.setSerialNo(taskData.getSerialNo());
        baseBean.setStoryNo(taskData.getStoryNo());
        baseBean.setSequence(taskData.getSequence());
        baseBean.setStatus(taskData.getStatus());
        baseBean.setMemo(taskData.getMemo());
        return baseBean;
    }
}
