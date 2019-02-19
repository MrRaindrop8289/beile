<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/Excel_student_sumbit" enctype="multipart/form-data" method="post">
	<input name="excel" type="file" />
	<br/>
	<button type="submit">提交</button>
</form>

<a href="${pageContext.request.contextPath }/Excel_student_dowload">下载客户信息文件</a>
</body>
</html>