package com.yu.taskmanager.api.dtos;

/**
 * Created by yu on 15-2-10.
 */
public class TaskDetailDTO {
    private TaskBaseDTO taskBaseBean;
    private DurationDTO estimate;
    private DurationDTO actual;

    public TaskBaseDTO getTaskBaseBean() {
        return taskBaseBean;
    }

    public void setTaskBaseBean(TaskBaseDTO taskBaseBean) {
        this.taskBaseBean = taskBaseBean;
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
}
