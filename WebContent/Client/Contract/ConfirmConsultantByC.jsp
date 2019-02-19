<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <!-- #User Info -->
            <!-- Menu -->
            <div class="menu">
                <ul class="list">
                    <li class="header">信息查看</li>
                    <li class="active">
                        <a href="../Main.jsp">
                            <i class="material-icons">home</i>
                            <span>首页</span>
                        </a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath }/FindAllContract">
                            <i class="material-icons">text_fields</i>
                            <span>返回合同首页</span>
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
                  <h2>合同信息</h2>
              </div>
				<div class="col-xs-12 col-sm-6 align-right">
                     <div class="switch panel-switch-btn">
                         <form action="${pageContext.request.contextPath }/SearchConByTime" method="post">
							<ul class="nav nav-pills">
								<li>
								<input class="form-control" size="8px" type="date" name="StartDate" value="${StartDate }"   placeholder="起始日期 "/></li>	
								<li><font size="4">至</font></li>
								<li>
								<input class="form-control" size="8px" type="date" name="EndDate"  value="${EndDate }"  placeholder=" 截止日期"/></li>
								<li><button type="sumbit" class="btn btn-primary">  搜索  </button></li>
							</ul>
						</form>
                     </div>
                 </div>
              </div>
          </div>
            <div class="body">
	            <div class="table-responsive">
					<table class="table table-hover dashboard-task-infos">
						<thead>
							<th>日期</th>
							<th>签约顾问</th>
							<th>合同个数</th>
							<th>签约总金额</th>
							<th>提成比例</th>
							<th>现场签约个数</th>
							<th>每个奖金</th>
							<th>共计奖金</th>
							<th>确认</th>
						</thead>	
						<form action="${pageContext.request.contextPath }/UpdateConsultant" method="post">
							<c:forEach items="${ConsultantList }" var="c">
								<tr>
									<td>${c.sssj }</td>
									<td>${c.kcgw }</td>
									<td>${c.htgs }</td>
									<td>${c.qyzje }</td>
									
									<c:if test="${c.tcbl == null}">
										<td>暂时未输入</td>
									</c:if>
									<c:if test="${c.tcbl != null}">
										<td>${c.tcbl }</td>
									</c:if>
									<td>${c.xcqy }</td>
									<td>${c.mgjj }</td>
									<td>${c.gjjj }</td>
									<td><button type="text" name="ConFirmByC" value="${c.id }" class="btn btn-primary">确认</button></td>
								</tr>
							</c:forEach>
						</form>
					</table>
				</div>
             </div>
	</div>
</section>

</body>
</html>