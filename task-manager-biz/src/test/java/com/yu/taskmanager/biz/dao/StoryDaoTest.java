package com.yu.taskmanager.biz.dao;

import com.yu.taskmanager.api.datas.PageModel;
import com.yu.taskmanager.api.datas.StoryData;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StoryDaoTest {
    private StoryDao storyDao = new StoryDao();

    @Test
    public void testFindTodoStoryList() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int year = calendar.get(Calendar.YEAR);
        String todoWeek = String.format("%4d%02d", year, week);
        List<StoryData> list = storyDao.findTodoStoryList(todoWeek);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testAddStory() throws Exception {
        StoryData storyData = new StoryData();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        storyData.setAddTime(simpleDateFormat.format(new Date()));
        storyData.setTodoWeek("201508");
        storyData.setSummary("111");
        storyData.setContent("1111111111111");
        storyData.setSerialNo("serialNo");
        storyData.setStatus(1);

        storyDao.addStory(storyData);
        Assert.assertTrue(1 > 0);
    }

    @Test
    public void testUpdatePriority() throws Exception {
        String serialNo = "st1";
        int result = storyDao.updatePriority(serialNo, 3);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void testUpdateImportance() throws Exception {
        String serialNo = "st1";
        int result = storyDao.updateImportance(serialNo, 2);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void testUpdateStatus() throws Exception {
        String serialNo = "st1";
        int result = storyDao.updateStatus(serialNo, 3);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void testDelStory() throws Exception {
        String serialNo = "st4";
        int result = storyDao.delStory(serialNo);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void testLoadStory() throws Exception {
        String serialNo = "st2";
        StoryData storyData = storyDao.loadStory(serialNo);
        Assert.assertNotNull(storyData);
    }

    @Test
    public void testLoadTodoCount() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int year = calendar.get(Calendar.YEAR);
        String todoWeek = String.format("%4d%02d", year, week);
        int count = storyDao.loadTodoCount(todoWeek);
        Assert.assertTrue(count > 0);
    }

    @Test
    public void testFindInitStoryList() throws Exception {
        int page = 1;
        int pageSize = 2;
        PageModel pageModel = storyDao.paginateInitStory(page, pageSize);
        Assert.assertNotNull(pageModel);
    }

    @Test
    public void testUpdateTodoWeek() throws Exception {
        String storyNo = "st1";
        String week = "201101";
        int result = storyDao.updateStatusAndTodoWeek(storyNo, 4, week);

        Assert.assertTrue(result > 0);
    }
 }