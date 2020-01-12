package com.witcherhome.web.unit;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUnit {

    private static DataSource ds;

    static{

        try {
            //load DB config file
            Properties properties =new Properties();
            InputStream in = JDBCUnit.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(in);
            //Initial config file data
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * 获取connection对象
     */
    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
}
