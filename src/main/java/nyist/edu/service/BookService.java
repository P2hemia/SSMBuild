package nyist.edu.service;

import nyist.edu.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:
 *
 * @author 张志鹏
 * @date 2022/3/6 16:42
 * @email p2hemia@nyist.edu.cn
 **/
public interface BookService {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(int id);

    //查询所有本书
    List<Books> queryBook();

    Books queryBookByName(String BookName);
}
