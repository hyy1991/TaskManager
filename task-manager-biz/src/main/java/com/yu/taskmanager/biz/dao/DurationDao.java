package com.yu.taskmanager.biz.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yu.taskmanager.api.datas.DurationData;
import com.yu.taskmanager.biz.utils.IbatisUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yu on 15-2-11.
 */
public class DurationDao {
    private SqlMapClient sqlMapClient = IbatisUtils.getSqlMapClient();
    private final String NAMESPACE = "DurationInfo";

    public DurationData loadDuration(String outBizId, int genre) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("outBizId", outBizId);
            map.put("genre", genre);
            DurationData durationData = (DurationData) sqlMapClient.queryForObject(NAMESPACE + "." + "loadDuration", map);
            return durationData;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addDuration(DurationData durationData) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("duration", durationData);
            sqlMapClient.insert(NAMESPACE + "." + "addDuration", map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int delDuration(String outBizId) {
        int result = 0;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("outBizId", outBizId);
            result = sqlMapClient.delete(NAMESPACE + "." + "delDuration", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateHour(String outBizId, double hour, int genre) {
        int result = 0;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("outBizId", outBizId);
            map.put("hour", hour);
            map.put("genre", genre);
            result = sqlMapClient.update(NAMESPACE + "." + "updateHour", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int increaseHour(String outBizId, double hour, int genre) {
        int result = 0;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("outBizId", outBizId);
            map.put("hour", hour);
            map.put("genre", genre);
            result = sqlMapClient.update(NAMESPACE + "." + "increaseHour", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
