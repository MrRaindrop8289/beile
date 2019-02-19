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
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<title>贝乐后台操作系统</title>
    <!-- Favicon-->
    <link rel="icon" href="favicon.ico" type="image/x-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

    <!-- Bootstrap Core Css -->
    <link href="../plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="../plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="../plugins/animate-css/animate.css" rel="stylesheet" />

    <!-- Morris Chart Css-->
    <link href="../plugins/morrisjs/morris.css" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="../css/style.css" rel="stylesheet">

    <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
    <link href="../css/themes/all-themes.css" rel="stylesheet" />

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
			<li><a href="AddAdmini.jsp">添加行政信息</a></li>
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
		<tr>
			<td> 课程顾问</td>
			<td> 日期</td>
			<td> 客户姓名</td>
			<td> 现场奖励</td>
			<td> 合同金额</td>
			<td> 提交</td>
		</tr>
		<form action="${pageContext.request.contextPath }/AddAdmini" method="post">
			<tr>
				<td> <input type="text" name="con" /></td>
				<td> <input type="text" name="date" /></td>
				<td> <input type="text" name="name" /></td>
				<td> <input type="text" name="xcjl" /></td>
				<td> <input type="text" name="htje" /></td>
				<td> <button type="submit">提交</button></td>
			</tr>
		</form>
	</table>
</body>
</html>