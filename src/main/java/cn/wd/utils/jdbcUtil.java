package cn.wd.utils;

import java.sql.*;

public class jdbcUtil {
    //加载驱动，并建立数据库连接
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/wd";
        String username="root";
        String password="smallwang";
        Connection conn = DriverManager.getConnection(url, username, password);
        return  conn;
    }

    //释放数据库连接，释放资源
    public static void release(PreparedStatement prestmt , Connection conn){
        if (prestmt!=null){
            try {
                prestmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            prestmt=null;
        }
        if (conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            conn=null;
        }
    }

    public static void release(ResultSet rs, PreparedStatement prestmt, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            rs=null;
        }
        release(prestmt,conn);
    }

}