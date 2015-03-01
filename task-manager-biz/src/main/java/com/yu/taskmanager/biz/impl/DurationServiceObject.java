package com.yu.taskmanager.biz.impl;

import com.yu.taskmanager.api.dtos.DurationDTO;
import com.yu.taskmanager.api.datas.DurationData;
import com.yu.taskmanager.api.enums.DurationGenre;
import com.yu.taskmanager.api.services.DurationService;
import com.yu.taskmanager.biz.dao.DurationDao;
import com.yu.taskmanager.biz.utils.DaoUtils;

/**
 * Created by yu on 15-2-11.
 */
public class DurationServiceObject implements DurationService {

    private DurationDao durationDao = DaoUtils.getDurationDao();

    @Override
    public DurationDTO loadActualDuration(String outBizId) {
        DurationData durationData = durationDao.loadDuration(outBizId, DurationGenre.ACTUAL.valueOf());
        if(durationData == null) {
            return null;
        }
        return buildDurationBean(durationData);
    }

    @Override
    public DurationDTO loadEstimateDuration(String outBizId) {
        DurationData durationData = durationDao.loadDuration(outBizId, DurationGenre.ESTIMATE.valueOf());
        if(durationData == null) {
            return null;
        }
        return buildDurationBean(durationData);
    }

    @Override
    public void addDuration(DurationData durationData) {
        durationDao.addDuration(durationData);
    }

    @Override
    public void delDuration(String outBizId) {
        durationDao.delDuration(outBizId);
    }

    @Override
    public void adjustHour(String outBizId, double hour, int genre) {
        durationDao.updateHour(outBizId, hour, genre);
    }

    @Override
    public void increaseHour(String outBizId, double hour, int genre) {
        durationDao.increaseHour(outBizId, hour, genre);
    }

    private DurationDTO buildDurationBean(DurationData durationData) {
        DurationDTO durationBean = new DurationDTO();
        durationBean.setStartTime(durationData.getStartTime());
        durationBean.setEndTime(durationData.getEndTime());
        durationBean.setConsumingHour(durationData.getConsumingHour());
        return durationBean;
    }

    public void setDurationDao(DurationDao durationDao) {
        this.durationDao = durationDao;
    }
}
