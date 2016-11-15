<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>list</title>
      <meta http-equiv="pragma" content="no-cache">
      <meta http-equiv="cache-control" content="no-cache">
      <meta http-equiv="expires" content="0">
      <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
      <meta http-equiv="description" content="This is my page">
  </head>
  <%--
  <c:redirect <c:if test="${list!=null}">url="http://www.baidu.com"</c:if>></c:redirect> --%>

  <body>
    <table border="1">
      <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
      </tr>

      <c:forEach items="${list}" var="stu">
        <tr>
          <td>${stu.id }</td>
          <td>${stu.name }</td>
          <td>${stu.age}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
