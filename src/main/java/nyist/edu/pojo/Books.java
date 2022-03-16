package nyist.edu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author 张志鹏
 * @date 2022/3/6 16:14
 * @email p2hemia@nyist.edu.cn
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;

}
