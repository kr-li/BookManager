import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.IBookDao;
import org.example.pojo.Book;
import org.example.service.IBookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

public class TestSpring {

    @Test
    public void run1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IBookService bookService = (IBookService) ac.getBean("bookService");
        bookService.queryAllBook();
    }

    @Test
    public void run2() throws Exception {
        //加载mybatis配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        IBookDao dao = session.getMapper(IBookDao.class);
        //查询所有
        List<Book> list = dao.queryAllBook();
        for (Book book: list){
            System.out.println(book);
        }

        //关闭资源
        session.close();
        in.close();
    }
}
