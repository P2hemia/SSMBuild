package nyist.edu.controller;

import nyist.edu.pojo.Books;
import nyist.edu.service.BookService;
import nyist.edu.service.BookServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author 张志鹏
 * @date 2022/3/7 20:51
 * @email p2hemia@nyist.edu.cn
 **/
@Controller
@RequestMapping("/book")
public class BookController {
    //controller调service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService = new BookServiceImpl();

    //查询全部的书籍，并且返回一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model) {

        List<Books> books = bookService.queryBook();
        model.addAttribute("list",books);
        return "allBook";
    }

    // 跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    // 增加书籍的请求
    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
        // 重定向可以阻止重复提交表单
        //这里重定向是定向到/book/allbook的控制器这里，所以会在控制器做转发，访问的是查书的请求，而不是去访问.jsp
    }

    //跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdatePaper(int id, Model model) {
        Books books = bookService.queryBookById(id);
        model.addAttribute("Qbook",books);
        return "updateBook";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        System.out.println("updateBook==>"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    //删除书籍
    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model) {
        Books books = bookService.queryBookByName(queryBookName);
        System.out.println("quertbook=>"+books);
        List<Books> list = new ArrayList<Books>();
        list.add(books);

        if(books==null) {
            list=bookService.queryBook();
            model.addAttribute("error","未查到书籍");
        }
        model.addAttribute("list",list);
        return "allBook";
    }

}
