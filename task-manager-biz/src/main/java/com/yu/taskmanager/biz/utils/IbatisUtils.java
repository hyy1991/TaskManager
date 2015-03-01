package com.yu.taskmanager.biz.utils;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by yu on 15-2-9.
 */
public class IbatisUtils {
    private static SqlMapClient sqlMapClient = null;

    static {
        try {
            File dbFile = new File("taskmanager.db");
            boolean needInit = !dbFile.exists();
            //加载配置文件
            Reader reader = Resources.getResourceAsReader("sqlmap/SqlMapConfig.xml");
            sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
            if (needInit) {
                //createTable
                DBUtils.createTable();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private IbatisUtils() {
    }

    public static SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }
}
