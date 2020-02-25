package com.chinasoft.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBUtils {

    public static DataSource dataSource;

    //静态块初始化JDBC连接池
    static {
        Properties pro = new Properties();
        InputStream in = DBUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }


}
