<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>��ҳ����</title>
  </head>
  
  
  <body>
  <table border="1"  width="50%">
  <tr>
  <th>ID</th>
  <th>����</th>
  <th>����</th>
  </tr>
 
  <c:forEach items="${pageObject.list }" var="student" >                  <!---->
  		<tr>
  			<td>${student.id }</td>
  			<td>${student.name }</td>
  			<td>${student.sex }</td>
  		<td><a href="student?action=delete&sid=${student.id}">ɾ��</a></td>  <!--=path-->
        <td><a href="student?action=findedit&sid=${student.id}">�޸�</a></td>	 
  		</tr>
  </c:forEach>
  
  </table>
  ${ pageObject.pageModel}
  <a href="student?action=findadd">���ѧ��</a>
  </body>
</html>
