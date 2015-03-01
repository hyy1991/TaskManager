package com.yu.taskmanager.biz.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yu.taskmanager.api.datas.TaskData;
import com.yu.taskmanager.biz.utils.IbatisUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yu on 15-2-11.
 */
public class TaskDao {
    private SqlMapClient sqlMapClient = IbatisUtils.getSqlMapClient();
    private final String NAMESPACE = "TaskInfo";

    public List<TaskData> findAllTaskWithStory(String storyNo) {
        try {
            Map<String, Object> map = new HashMap();
            map.put("storyNo", storyNo);
            List<TaskData> taskDataList = sqlMapClient.queryForList(NAMESPACE + "." + "findAllTaskWithStory", map);
            return taskDataList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public void addTask(TaskData taskData) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("taskData", taskData);
            sqlMapClient.insert(NAMESPACE + "." + "addTask", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int updateSequence(String serialNo, int sequence) {
        int result = 0;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("serialNo", serialNo);
            map.put("sequence", sequence);
            result = sqlMapClient.update(NAMESPACE + "." + "updateSequence", map);
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateStatus(String serialNo, int status) {
        int result = 0;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("serialNo", serialNo);
            map.put("status", status);
            result = sqlMapClient.update(NAMESPACE + "." + "updateStatus", map);
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return result;
    }

    public int delTask(String serialNo) {
        int result = 0;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("serialNo", serialNo);
            result = sqlMapClient.delete(NAMESPACE + "." + "delTask", map);
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return result;
    }

    public int delTaskByStory(String storyNo) {
        int result = 0;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("storyNo", storyNo);
            result = sqlMapClient.delete(NAMESPACE + "." + "delTaskByStory", map);
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return result;
    }

    public TaskData loadTask(String taskNo) {
        TaskData taskData = null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("taskNo", taskNo);
            taskData = (TaskData) sqlMapClient.queryForObject(NAMESPACE + "." + "loadTask", map);
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return taskData;
    }

    public int loadTaskCountByStory(String storyNo) {
        int count = 0;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("storyNo", storyNo);
            count = Integer.parseInt(sqlMapClient.queryForObject(NAMESPACE + "." + "loadTaskCountByStory", map).toString());
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return count;
    }
}
