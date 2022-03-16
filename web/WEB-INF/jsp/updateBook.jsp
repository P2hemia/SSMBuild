<%--
  Created by IntelliJ IDEA.
  User: 张志鹏
  Date: 2022/3/10
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
<%--        出现的问题，提交了SQL请求，但是修改失败，发现是bookID没有传入，导致修改语句无法执行--%>
<%--        前端传递隐藏域--%>
        <input type="hidden" name="bookID" value="${Qbook.bookID}">


        <div class="form-group">
            <label>书籍名称：</label>
            <input type="text" name="bookName" class="form-control" value="${Qbook.bookName}" required>
        </div>
        <div class="form-group">
            <label>书籍数量：</label>
            <input type="text" name="bookCounts" class="form-control" value="${Qbook.bookCounts}" required>
        </div>
        <div class="form-group">
            <label>书籍描述：</label>
            <input type="text" name="detail" class="form-control" value="${Qbook.detail}" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="修改">
        </div>

    </form>
</div>
</body>
</html>
