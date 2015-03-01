package com.yu.taskmanager.api.dtos;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yu on 15-2-10.
 */
public class StoryDetailDTO implements Serializable {
    private StoryBaseDTO baseBean;
    private DurationDTO estimate;
    private DurationDTO actual;
    private List<TaskDetailDTO> taskList;

    public StoryBaseDTO getBaseBean() {
        return baseBean;
    }

    public void setBaseBean(StoryBaseDTO baseBean) {
        this.baseBean = baseBean;
    }

    public DurationDTO getEstimate() {
        return estimate;
    }

    public void setEstimate(DurationDTO estimate) {
        this.estimate = estimate;
    }

    public DurationDTO getActual() {
        return actual;
    }

    public void setActual(DurationDTO actual) {
        this.actual = actual;
    }

    public List<TaskDetailDTO> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<TaskDetailDTO> taskList) {
        this.taskList = taskList;
    }
}
