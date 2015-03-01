package com.yu.taskmanager.biz.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by yu on 15-2-10.
 */
public class DBUtils {
    final static String JDBC_URL = "jdbc:sqlite:taskmanager.db";
    final static String TABLE_STORY_CREATE_SQL =
            "CREATE TABLE STORY_INFO ("
                    + "ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "SerialNO VARCHAR(50) NOT NULL, "
                    + "Summary VARCHAR(100) NOT NULL, "
                    + "Content VARCHAR(500) NOT NULL, "
                    + "Priority INT, "
                    + "Importance INT, "
                    + "Status INT NOT NULL, "
                    + "TodoWeek VARCHAR(10) NOT NULL, "
                    + "AddTime VARCHAR(50) NOT NULL, "
                    + "Memo VARCHAR(100)"
            + ")";

    final static String TABLE_TASK_CREATE_SQL =
            "CREATE TABLE TASK_INFO ("
                    + "ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "SerialNO VARCHAR(50) NOT NULL, "
                    + "Content VARCHAR(500) NOT NULL, "
                    + "StoryNO VARCHAR(50) NOT NULL, "
                    + "Sequence INT NOT NULL, "
                    + "Status INT NOT NULL, "
                    + "Memo VARCHAR(100)"
            + ")";

    final static String TABLE_DURATION_CREATE_SQL =
            "   CREATE TABLE DURATION_INFO ("
                    + "ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "OutbizID VARCHAR(50) NOT NULL, "
                    + "StartTime DATE, "
                    + "EndTime DATE, "
                    + "ConsumingHour DOUBLE, "
                    + "Genre INT NOT NULL"
            + ")";

    public static void createTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(JDBC_URL);
            statement = connection.createStatement();
            statement.execute(TABLE_STORY_CREATE_SQL);
            statement.execute(TABLE_TASK_CREATE_SQL);
            statement.execute(TABLE_DURATION_CREATE_SQL);
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
