package com.yu.taskmanager.biz.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yu.taskmanager.api.datas.PageModel;
import com.yu.taskmanager.api.datas.StoryData;
import com.yu.taskmanager.api.datas.TaskData;
import com.yu.taskmanager.biz.utils.IbatisUtils;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.*;

/**
 * Created by yu on 15-2-11.
 */
public class StoryDao {
    private SqlMapClient sqlMapClient = IbatisUtils.getSqlMapClient();
    private final String NAMESPACE = "StoryInfo";

    public List<StoryData> findTodoStoryList(String todoWeek) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("todoWeek", todoWeek);
            List<StoryData> storyList = sqlMapClient.queryForList(NAMESPACE + "." + "findTodoStoryList", map);
            return storyList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public PageModel paginateInitStory(int page, int pageSize) {
        PageModel pageModel = new PageModel();
        try {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("start", page * pageSize);
            map.put("pageSize", pageSize);
            List<StoryData> storyList = sqlMapClient.queryForList(NAMESPACE + "." + "paginateInitStory", map);
            if(storyList == null) {
                storyList = Collections.EMPTY_LIST;
            }
            int count = Integer.valueOf(sqlMapClient.queryForObject(NAMESPACE + "." + "paginateInitStory_COUNT").toString());
            pageModel.setPage(page);
            pageModel.setPageSize(pageSize);
            pageModel.setRecords(storyList);
            pageModel.setTotalCount(count);
            int pageCount = (int)Math.ceil((double)count/pageSize);
            pageModel.setPageCount(pageCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageModel;
    }

    public void addStory(StoryData storyData) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("storyData", storyData);
            sqlMapClient.insert(NAMESPACE + "." + "addStory", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int delStory(String serialNo) {
        int result = 0;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("serialNo", serialNo);
            result = sqlMapClient.delete(NAMESPACE + "." + "delStory", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updatePriority(String serialNo, int priority) {
        int result = 0;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("serialNo", serialNo);
            map.put("priority", priority);
            result = sqlMapClient.update(NAMESPACE + "." + "updatePriority", map);
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateImportance(String serialNo, int importance) {
        int result = 0;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("serialNo", serialNo);
            map.put("importance", importance);
            result = sqlMapClient.update(NAMESPACE + "." + "updateImportance", map);
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

    public int updateStatusAndTodoWeek(String serialNo, int status, String todoWeek) {
        int result = 0;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("serialNo", serialNo);
            map.put("status", status);
            map.put("todoWeek", todoWeek);
            result = sqlMapClient.update(NAMESPACE + "." + "updateStatusAndTodoWeek", map);
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return result;
    }

    public StoryData loadStory(String storyNo) {
        StoryData storyData = null;
        try{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("serialNo", storyNo);
            storyData = (StoryData) sqlMapClient.queryForObject(NAMESPACE + "." + "loadStory", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storyData;
    }

    public int loadTodoCount(String todoWeek) {
        int count = 0;
        try{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("todoWeek", todoWeek);
            count = Integer.parseInt(sqlMapClient.queryForObject(NAMESPACE + "." + "loadTodoCount", map).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
