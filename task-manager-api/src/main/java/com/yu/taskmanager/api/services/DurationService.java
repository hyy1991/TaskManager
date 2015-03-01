package com.yu.taskmanager.api.services;

import com.yu.taskmanager.api.dtos.DurationDTO;
import com.yu.taskmanager.api.datas.DurationData;

/**
 * Created by yu on 15-2-11.
 */
public interface DurationService {
    public DurationDTO loadActualDuration(String outBizId);

    public DurationDTO loadEstimateDuration(String outBizId);

    public void addDuration(DurationData durationData);

    public void delDuration(String outBizId);

    public void adjustHour(String outBizId, double hour, int genre);

    public void increaseHour(String outBizId, double hour, int genre);
}
