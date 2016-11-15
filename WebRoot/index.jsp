<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>Login Page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
   
    <style type="text/css">
      #center{
         width:300px;
         margin:0px auto;
      }
    </style>
    
    <script language="javascript">
      function checkname() {
         var name1 = document.login.loginUN.value;
         if(name1 == "") {
            alert("姓名不能为空");
            return false;
         }
         if(name1 != "123") {
            alert("账户名不存在");
            return false;
         }
         return true;
      }
      
      function check() {
         if(checkname()) {
            return true;|
         }
         else {
            return false;
         }
      }
    </script>
</head>

  <body>
    <div id="center">
      <form name="login" action="test" method="post" onsubmit="return check()">
        <table width="300" height="120" border="1" cellpadding="5" cellspacing="0">
          <tr>
            <td colspan="2" height="20"><span class="STYLE1">${msg}</span></td>
          </tr>
          <tr>
            <td>UserName: </td>
            <td><input id="loginUN" type="text" name="username"/></td>
          </tr>
          <tr>
            <td>PssWord: </td>
            <td><input id="loginPW" type="password" name="password"/></td>
          </tr>
          <tr>
            <td colspan="2"><div align="center">
            <input type="submit" value="login"/>&nbsp;&nbsp;&nbsp;
            <input type="reset" value="reset" />
          </div></td>
          </tr>
        </table>
      </form>
    </div>
  </body>
</html>