package com.yu.taskmanager.biz.dao;

import com.yu.taskmanager.api.datas.DurationData;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DurationDaoTest {

    private DurationDao durationDao = new DurationDao();

    @Test
    public void testLoadDuration() throws Exception {
        String outBizId = "st111";
        int genre = 1;
        DurationData durationData = durationDao.loadDuration(outBizId, genre);
        Assert.assertNotNull(durationData);
    }

    @Test
    public void testAddDuration() throws Exception {
        DurationData durationData = new DurationData();
        durationData.setConsumingHour(2.11);
        durationData.setGenre(1);
        durationData.setOutBizId("tk02");
        durationDao.addDuration(durationData);
    }

    @Test
    public void testDelDuration() throws Exception {
        String outBizId = "tk01";
        int result = durationDao.delDuration(outBizId);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void testAdjustHour() throws Exception {
        String outBizId = "tk02";
        int genre = 2;
        double hour = 3.12;
        int result = durationDao.updateHour(outBizId, hour, genre);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void testIncreaseHour() throws Exception {
        String outBizId = "tk02";
        int genre = 1;
        double hour = 3.12;
        int result = durationDao.increaseHour(outBizId, hour, genre);
        Assert.assertTrue(result > 0);
    }
}