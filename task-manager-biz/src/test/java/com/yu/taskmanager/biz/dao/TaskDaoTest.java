package com.yu.taskmanager.biz.dao;

import com.yu.taskmanager.api.datas.TaskData;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TaskDaoTest {

    private TaskDao taskDao = new TaskDao();

    @Test
    public void testFindAllTaskWithStory() throws Exception {
        String storyNo = "st1111111";
        List<TaskData> taskDataList = taskDao.findAllTaskWithStory(storyNo);
        Assert.assertTrue(taskDataList.size() > 0);
    }

    @Test
    public void testAddTask() throws Exception {
        TaskData taskData = new TaskData();
        taskData.setStatus(1);
        taskData.setSerialNo("task11");
        taskData.setContent("111111111");
        taskData.setStoryNo("st01");
        taskData.setMemo("");

        taskDao.addTask(taskData);
    }

    @Test
    public void testUpdateSequence() throws Exception {
        String taskNo = "tk01";
        int result = taskDao.updateSequence(taskNo, 2);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void testUpdateStatus() throws Exception {
        String taskNo = "tk01";
        int result = taskDao.updateStatus(taskNo, 2);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void testDelTask() throws Exception {
        String taskNo = "tk01";
        int result = taskDao.delTask(taskNo);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void testDelTaskByStory() throws Exception {
        String storyNo = "st01";
        int result = taskDao.delTaskByStory(storyNo);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void testLoadTask() throws Exception {
        String taskNo = "task11";
        TaskData taskData = taskDao.loadTask(taskNo);
        Assert.assertNotNull(taskData);
    }

    @Test
    public void testLoadTaskCountByStory() throws Exception {
        String storyNo = "st01";
        int count = taskDao.loadTaskCountByStory(storyNo);
        Assert.assertTrue(count > 0);
    }
}