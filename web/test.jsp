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

    <script>

        function checkUserPwd(){
            $.post({
                url:"${pageContext.request.contextPath}/checkUserPwd",
                data:{"pwd":$("#pwd").val(),"username":$("#username").val()},
                success:function (data) {

                    if (data.toString()=="UserPwdError"){
                        $("#info").css("color","red");
                        $("#info").html("用户名或密码错误");
                        console.log(data);
                        //alert(222);
                    };
                    if (data.toString()=="UserPwdOK"){
                        // document.getElementById("loginButton").setAttribute("type","submit");
                        $("#info").html("");
                        console.log(data);
                        //alert(111);
                        $(window).attr("location","${pageContext.request.contextPath}/tohome");
                    };
                }
            })

        }

    </script>

</head>
<body>

test
</body>
</html>
