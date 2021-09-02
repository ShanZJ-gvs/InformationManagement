<%--
  Created by IntelliJ IDEA.
  User: 单子健
  Date: 2021/9/1
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>测试页面</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/Pretty-Registration-Form.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <script type="text/javascript">
        //编写一个JavaScript
        var user = {
            name:"shanzj",
            age:18,
            sex:"男"
        };

        //将js对象转换为json对象
        var json = JSON.stringify(user);

        console.log(json);

        //将 json 对象转换为 JavaScript对象
        var obj = JSON.parse(json);
        console.log(obj);
    </script>

</head>
<body>

test
</body>
</html>
