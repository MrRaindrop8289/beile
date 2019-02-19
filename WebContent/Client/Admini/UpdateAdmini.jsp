<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%

    String path = request.getRequestURI();

    String basePath = request.getScheme() + "://"

            + request.getServerName() + ":" + request.getServerPort()

            + path;

%>

<base
href="<%=basePath%>">
	<meta charset="utf-8">
	<title>行政数据库</title>
	<link rel="stylesheet" href="../css/bootstrap.css">  
	
</head>
<body  background="../img/44.jpg"  >
	<div align="right" style="padding-top: 20px">

		<font size="3"  ><a href="../User/User.jsp" >${User.username }</a>
			&nbsp;
			<a href="${pageContext.request.contextPath }/QuitServlet" >退出</a></font>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	<h3>
		<ul class="nav nav-pills">
			<li><a href="../Main.jsp">返回首页</a></li>
			<c:if test="${User.yonghu_jb == 4}">
				<li><a href="${pageContext.request.contextPath }/FindAdminiByCon">课程顾问确认及查看</a></li>
			</c:if>
			<c:if test="${User.yonghu_jb < 2 }">
				<li><a href="">校长确认</a></li>
			</c:if>
			<li><a href="${pageContext.request.contextPath }/Excel_consultant_dowload">下载行政数据库</a></li>		
		</ul>
	</h3>
		<table class="table table-striped">
			<thead>
				<th> 编号</th>
				<th> 课程顾问 </th>
				<th> 日期 </th>
				<th> 学生名字 </th>
				<th> 现场奖励 </th>
				<th> 合同金额 </th>
				<th> 提交修改</th>
			</thead>
			
			<form action="${pageContext.request.contextPath }/UpdateAdmini" name="Updateadmini" method="post">
				<tr>
					<td><input type="text" value="${a.id }" name="id" readonly="readonly"/></td>
					<td><input type="text" value="${a.con }" name="con" /></td>
					<td><input type="text" value="${a.date }" name="date" /></td>
					<td><input type="text" value="${a.name }" name="name" /></td>
					<td><input type="text" value="${a.xcjl}" name="xcjl" /></td>
					<td><input type="text" value="${a.htje }" name="htje" /></td>
					<td><button type="submit" >提交修改</button></td>
				</tr>
			</form>
		</table>
</body>
</html>