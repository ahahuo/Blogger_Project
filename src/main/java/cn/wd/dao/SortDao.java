package cn.wd.dao;

import cn.wd.model.Article;
import cn.wd.model.Sort;
import cn.wd.utils.jdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SortDao {
    //获得所有分类
    public ArrayList<Sort> getSorts(){
        Connection conn=null;
        PreparedStatement prestmt=null;
        ResultSet rs=null;
        ArrayList<Sort> list=new ArrayList<Sort>();
        try{
            //获得数据库连接
            conn= jdbcUtil.getConnection();
            String sql="select * from sorts";
            //创建执行SQL语句的prestmt对象
            prestmt=conn.prepareStatement(sql);
            rs=prestmt.executeQuery();
            //处理结果集
            while(rs.next()){
                Sort sort=new Sort();
                sort.setSort_id(rs.getInt("sort_id"));
                sort.setSort_name(rs.getString("sort_name"));
                sort.setIs_delete(rs.getBoolean("is_delete"));
                sort.setSort_articles_count(rs.getInt("sort_articles_count"));
                list.add(sort);
            }
            return list;
    }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.release(rs,prestmt,conn);
        }
        return null;
    }
}
