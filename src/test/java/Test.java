import cn.wd.dao.ArticleDao;
import cn.wd.dao.UserDao;
import cn.wd.model.Article;
import cn.wd.model.User;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws SQLException {

        //SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        //String date=format.format(new Date());

        ArticleDao ad=new ArticleDao();
        ArrayList<Article> articles=ad.getArticles();
        for (Article article:articles){
            System.out.println(article.getIs_delete());
        }
    }
}
