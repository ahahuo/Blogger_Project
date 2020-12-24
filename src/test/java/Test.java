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
        /*ArrayList<Article> articles=ad.getArticles();
        for (Article article:articles){
            System.out.println(article.getIs_delete());
        }*/
        Article article=new Article();
        article.setArticle_title("我和我的祖国");
        article.setArticle_content("七位导演分别取材新中国成立70周年以来，祖国经历的无数个历史性经典瞬间。讲述普通人与国家之间息息相关密不可分的动人故事。聚焦大时代大事件下，小人物和国家之间，看似遥远实则密切的关联，唤醒全球华人共同回忆。");
        article.setArticle_date("2020-6-2");
        article.setSort_name("分享");
        System.out.println(ad.addArticle(article));
    }
}
