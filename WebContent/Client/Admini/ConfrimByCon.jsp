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
			<th>时间</th>
			<th>课程顾问</th>
			<th>合同个数</th>
			<th>提成比例</th>
			<th>现场签约个数</th>
			<th>共计奖金</th>
			<th>顾问确认</th>	
			<th>校长确认</th>		
		</thead>
		
		<form action="${pageContext.request.contextPath }/checkCon" method="post">
			<c:forEach items="${ConsultantList}" var="c">
				<tr>
					<td > ${c.sssj }</td>
					<td > ${c.kcgw }</td>
					<td > ${c.htgs }</td>
					<td > ${c.tcbl }</td>
					<td > ${c.xcqy }</td>
					<td > ${c.gjjj }</td>
					<td > ${c.gwqr }</td>
					<c:if	test="${c.gwqr == true }">
						<td > 是</td>
					</c:if>
					<c:if	test="${c.gwqr == false }">
						<td >尚未确认是否确认？<button type="submit" value="1" name="gwqr">确认</button></td>
					</c:if>
					<c:if	test="${c.xzqr == true }">
						<td > 是</td>
					</c:if>
					<c:if	test="${c.xzqr == false }">
						<c:if test="${User.yonghu_jb < 2 }">
							<td >尚未确认&nbsp;&nbsp;是否确认？<button type="submit" value="1" name="xzqr">确认</button></td>
						</c:if>
						<c:if test="${User.yonghu_jb > 1 }">
							<td>否</td>
						</c:if>
					</c:if>
				</tr>
			</c:forEach>
		</form>
	</table>
</body>
</html>