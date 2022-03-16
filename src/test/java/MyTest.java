import nyist.edu.pojo.Books;
import nyist.edu.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 *
 * @author 张志鹏
 * @date 2022/3/10 7:58
 * @email p2hemia@nyist.edu.cn
 **/
public class MyTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = context.getBean("BookServiceImpl", BookService.class);
        for (Books books : bookServiceImpl.queryBook()) {
            System.out.println(books);
        }

    }
    @Test
    public void testQuery() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = context.getBean("BookServiceImpl", BookService.class);
        Books books = bookServiceImpl.queryBookById(1);
        System.out.println(books);
    }

    @Test
    public void queryallbook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = context.getBean("BookServiceImpl", BookService.class);
        for (Books books : bookServiceImpl.queryBook()) {
            System.out.println(books);
        }

    }

    @Test
    public void deleteBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = context.getBean("BookServiceImpl", BookService.class);
        int i = bookServiceImpl.deleteBookById(5);
        System.out.println(i);
    }
}
