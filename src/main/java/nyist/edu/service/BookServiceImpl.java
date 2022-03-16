package nyist.edu.service;

import nyist.edu.dao.BookMapper;
import nyist.edu.pojo.Books;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author 张志鹏
 * @date 2022/3/6 16:43
 * @email p2hemia@nyist.edu.cn
 **/
public class BookServiceImpl implements BookService{

    //Service层调Dao层，组合Dao
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryBook() {
        return bookMapper.queryBook();
    }

    @Override
    public Books queryBookByName(String BookName) {
        return bookMapper.queryBookByName(BookName);
    }
}
