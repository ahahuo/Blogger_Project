package cn.wd.dao;

import cn.wd.utils.jdbcUtil;
import cn.wd.model.User;

import java.sql.*;
import java.text.SimpleDateFormat;

public class UserDao {
    //添加用户
    public boolean addUser(User user)throws SQLException {
        Connection conn=null;
        PreparedStatement prestmt=null;
        ResultSet rs=null;
        try{
            //获取连接
            conn=jdbcUtil.getConnection();
            //创建sql语句
            String sql="insert into users(user_name,user_password,user_email)"+"values(?,?,?)";
            prestmt=conn.prepareStatement(sql);

            //为sql语句参数赋值
            prestmt.setString(1,user.getUser_name());
            prestmt.setString(2,user.getUser_password());
            prestmt.setString(3,user.getUser_email());
            //执行sql语句
            int num=prestmt.executeUpdate();
            if (num>0){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.release(rs,prestmt,conn);
        }
        return false;
    }
    //删除用户
    public boolean deleteUser(int user_id){
        Connection conn=null;
        PreparedStatement prestmt=null;
        ResultSet rs=null;
        try{
            //获取连接
            conn=jdbcUtil.getConnection();
            //创建sql语句
            String sql="update users set is_delete=? where user_id=?";
            prestmt=conn.prepareStatement(sql);
            prestmt.setBoolean(1,true);
            prestmt.setInt(2,user_id);

            int num=prestmt.executeUpdate();
            if (num>0){
                return true;
            }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            jdbcUtil.release(rs, prestmt,conn);
            }
                return false;
        }
        //修改密码
    public boolean updateUser_password(String user_password ,int user_id){
        Connection conn=null;
        PreparedStatement prestmt=null;
        ResultSet rs=null;
        try{
            //获取连接
            conn=jdbcUtil.getConnection();
            //创建sql语句
            String sql="update users set user_password=? where user_id=?";
            prestmt=conn.prepareStatement(sql);
            prestmt.setString(1,user_password);
            prestmt.setInt(2,user_id);

            int num=prestmt.executeUpdate();
            if (num>0){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.release(rs, prestmt,conn);
        }
        return false;
    }
    //修改用户信息
    public boolean updateUser(User user){
            Connection conn=null;
            PreparedStatement prestmt=null;
            ResultSet rs=null;
            try{
                //获取连接
                conn=jdbcUtil.getConnection();
                //创建sql语句
                String sql="update users set user_name=?,user_email=?,user_profile_photo=?,user_age=?,user_sex=?,user_birthday=?where user_id=?";
                prestmt=conn.prepareStatement(sql);
                prestmt.setString(1,user.getUser_name());
                prestmt.setString(2,user.getUser_email());
                prestmt.setString(3,user.getUser_profile_photo());
                prestmt.setInt(4,user.getUser_age());
                prestmt.setString(5,user.getUser_sex());
                prestmt.setString(6,user.getUser_birthday());
                prestmt.setInt(7,user.getUser_id());

                int num=prestmt.executeUpdate();
                if (num>0){
                    return true;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                jdbcUtil.release(rs, prestmt,conn);
            }
            return false;
    }
    //返回用户信息
    public User getUser(int user_id){
        Connection conn=null;
        PreparedStatement prestmt=null;
        ResultSet rs=null;
        try {
            conn=jdbcUtil.getConnection();
            String sql="select * from users where user_id="+user_id;
            prestmt=conn.prepareStatement(sql);
            rs=prestmt.executeQuery();

            //处理结果集
            while(rs.next()){
                User user=new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUser_name(rs.getString("user_name"));
                user.setUser_email(rs.getString("user_email"));
                user.setUser_profile_photo(rs.getString("user_profile_photo"));
                user.setUser_age(rs.getInt("user_age"));
                user.setUser_sex(rs.getString("user_sex"));
                user.setUser_birthday(rs.getString("user_birthday"));
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.release(rs,prestmt,conn);
        }
        return null;
    }

}
