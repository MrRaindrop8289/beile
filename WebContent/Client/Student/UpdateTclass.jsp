<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "java.util.*, cn.gamers.domain.*, cn.gamers.dao.*, java.text.*,java.io.PrintWriter"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<body class="theme-red">
<!-- 顶部状态栏 开始 -->
	
	<nav class="navbar">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false"></a>
                <a href="javascript:void(0);" class="bars" style="display: none;"></a>
            	<a class="navbar-brand">贝乐后台操作系统</a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-collapse">
                
            </div>
        </div>
    </nav>
    
	<!-- 顶部状态栏  结束-->
	
	<!-- 左侧导航栏  开始 -->
	<aside id="leftsidebar" class="sidebar">
            <!-- User Info -->
            <div class="user-info">
                <div class="image">
                	<a href="../User/User.jsp" >
                    	<img src="../images/user.png" width="48" height="48" alt="User" />
               		</a>
                </div>
                <div class="info-container">
                    <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${User.username }</div>


                </div>
            </div>
            <!-- #User Info	-->
            <!-- Menu -->
            <div class="menu">
                <ul class="list">
                    <li class="header">信息查看</li>
                    <li>
                        <a href="../Main.jsp">
                            <i class="material-icons">home</i>
                            <span>首页</span>
                        </a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath }/AddStudent">
                            <i class="material-icons">text_fields</i>
                            <span>添加客户</span>
                        </a>
                    </li>
                 <c:if test="${User.yonghu_jb < 2 }">
                    <li>
                        <a href="sumbit_Excel.jsp">
                            <i class="material-icons">layers</i>
                            <span>批量导入客户数据</span>
                        </a>
                    </li>
                  </c:if>
                    <li>
                        <a href="${pageContext.request.contextPath }/Excel_student_dowload">
                            <i class="material-icons">widgets</i>
                            <span>下载客户数据</span>
                        </a>
                    </li>
                </ul>
            </div>
            <!-- #Menu -->
            <!-- Footer -->
            <!-- #Footer -->
        </aside>
	<!-- 左侧导航栏  结束 -->
<!-- 表格信息  开始-->
<section class="content">
	<div class="card">
		<div class="header">
          <div class="row clearfix">
              <div class="col-xs-12 col-sm-6">
                  <h2>客户信息</h2>
              </div>
           </div>
       </div>
		<div class="body">
		     <div class="table-responsive">
			
				<table class="table table-hover dashboard-task-infos">
					<thead>
						<th>渠道</th>
						<th>姓名</th>
						<th>年级</th>
						<th>联系方式</th>
						<th>下次联系时间</th>
						<th>沟通内容</th>
						<th>重点</th>
						<th>试听时间</th>
						<th>试听结果</th>
						<th>提交试听课修改</th>
						
					</thead>
					<form action="${pageContext.request.contextPath }/AddStudent" method="post">
						<tr >
							<td rowspan="${Student.tsum }"><input type="text" name="shuju_ly" value="${Student.shuju_ly }" /></td>
							<td rowspan="${Student.tsum }"><input type="text" name="name" value="${Student.name }" /></td>
							<td rowspan="${Student.tsum }"><input type="text" name="grade" value="${Student.grade }" /></td>
							<td rowspan="${Student.tsum }"><input type="text" name="phone" value="${Student.phone }" /></td>
							<td rowspan="${Student.tsum }"><input type="date" name="next_time" value="${Student.next_time }" /></td>
							<td rowspan="${Student.tsum }"><textarea rows="15" cols="90"  name="content"
																style="border-bottom:#000000 1px solid;border-left::#000000 1px solid;
																border-right:#000000 1px solid;border-top:#000000 1px solid;font-size:9pt;
																height:100px;width:300px" >${Student.content }</textarea></td>
							<c:if test="${Student.point == true }">
								<td rowspan="${Student.tsum }"><input type="checkbox" name="point" cheched="checked" /></td>
							</c:if>
							<c:if test="${Student.point == false }">
								<td rowspan="${Student.tsum }"><input type="checkbox" name="point"/></td>
							</c:if>
							<td><input type="text" name="ttime" value="${Tclass.ttime }" list="ManageList"/></td>
							<td><input type="text" name="result" value="${Tclass.result }" 
																style="border-bottom:#000000 1px solid;border-left::#000000 1px solid;
																border-right:#000000 1px solid;border-top:#000000 1px solid;font-size:9pt;
																height:100px;width:300px"/></td>
							<td><button type="submit" name="UpdateTclass" value="${Tclass.mid }" class="btn btn-primary">提交修改</button>
						</form>
				
						<datalist id="ManageList">
							<c:forEach items="${ManageList }" var="m">
								<option>${m.date}</option>
							</c:forEach>
						</datalist>
				</table>
		</div>
	</div>
	</div>
</section>
<!-- 表格信息  结束 -->
		
			
</body>
</html>
</body>
</html>