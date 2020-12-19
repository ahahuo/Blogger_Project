package cn.wd.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class c3p0Util {
    private static DataSource ds;
    static {
        ComboPooledDataSource cp=new ComboPooledDataSource();
        try {
            cp.setDriverClass("com.mysql.jdbc.Driver");
            cp.setJdbcUrl("jdbc:mysql://localhost:3306/wd");
            cp.setUser("root");
            cp.setPassword("smallwang");
            //设置连接池参数
            cp.setInitialPoolSize(5);
            cp.setMaxPoolSize(15);
            ds=cp;
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    public static DataSource getDataSource(){
        return ds;
    }
}