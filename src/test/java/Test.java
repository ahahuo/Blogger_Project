import cn.wd.dao.UserDao;
import cn.wd.model.User;

import java.sql.SQLException;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws SQLException {
     UserDao ud=new UserDao();
     User user=ud.getUser(1);
        System.out.println(user);
    }
}
