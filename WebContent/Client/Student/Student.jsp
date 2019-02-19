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
			
			<form action="${pageContext.request.contextPath }/UpdateStudent" method="post">
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
						<th>添加试听课</th>
						<th>删除</th>
						<th>修改</th>
					</thead>
					<%
						List<Student> sl = (List<Student>)request.getSession().getAttribute("StudentList");
						int i = 0;
						if(request.getSession().getAttribute("start") != null){
							i = (int)request.getSession().getAttribute("start");
						}
						
						request.getSession().setAttribute("StudentList", sl);
						request.getSession().setAttribute("start", request.getSession().getAttribute("start"));
						request.getSession().setAttribute("end", request.getSession().getAttribute("end"));
						request.getSession().setAttribute("now", request.getSession().getAttribute("now"));
						request.getSession().setAttribute("all", request.getSession().getAttribute("all"));
						request.getSession().setAttribute("size", request.getSession().getAttribute("size"));
						
					%>
					
					<c:set var="vEnter" value="\n" scope="request"/>
					<% request.setAttribute("vEnter", "\n"); %> 
					
						<c:forEach items="${StudentList }" var="s" begin="${start }" end="${end }">
							<tr>
								<td rowspan="${s.tsum }">${s.shuju_ly }</td>
								<td rowspan="${s.tsum }">${s.name }</td>
								<td rowspan="${s.tsum }">${s.grade }</td>
								<td rowspan="${s.tsum }">${s.phone }</td>
								<td rowspan="${s.tsum }">${s.next_time }</td>
								<td rowspan="${s.tsum }">${fn:replace(s.content,vEnter,"<br>")}</td>
								<c:if test="${s.point == true }">
									<td rowspan="${s.tsum }"><input type="checkbox" name="point" checked="checked" /></td>
								</c:if>
								<c:if test="${s.point == false }">
									<td rowspan="${s.tsum }"><input type="checkbox" name="point"/></td>
								</c:if>
						<%	int id = sl.get(i).getId();
							TclassDao dao = new TclassDao();
							List<T_Class> tl = dao.FindClassById(id);
							int va = 2;
							if(!tl.isEmpty()){
								for (T_Class t:tl){
										String date = t.getTtime();
										try{
											t.setTtime(new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyy-MM-dd").parse(date)));
										}catch (ParseException e) {  
								            e.printStackTrace();  
								        }  
								}
								request.setAttribute("TclassList", tl);
								request.setAttribute("va", 1);
								for (T_Class t:tl){
									System.out.println("TclassID:" + t.getId());
								}
								va = 1;
							}else{
								request.setAttribute("va", 0);
								va = 0;
							}
		
							System.out.println("VA:" + va);
						%>
							<c:if test="${va == 1 }">
								<c:forEach items= "${TclassList}" var="t" varStatus="status">
										<c:if test="${status.count == 1 }">
											<td>${t.ttime }</td>
											<td>${t.result }</td>
											<td rowspan="${s.tsum }"><button type="submit" name="addTclass" value="${s.id }" class="btn btn-primary" >添加试听课</button></td>
											<td rowspan="${s.tsum }"><button type="submit" name="delete" value="${s.id }" class="btn btn-primary" >删除客户</button></td>
											<td rowspan="${s.tsum }"><button type="submit" name="update" value="${s.id }" class="btn btn-primary" >修改客户数据</button></td>
											
											</tr>
										</c:if>
										<c:if test="${status.count > 1 }">
											<tr>
												<td>${t.ttime }</td>
												<td>${t.result }</td>
											</tr>
										</c:if>
								</c:forEach>
							</c:if>
							<c:if test="${va == 0 }">
								<td>null</td>
								<td>null</td>
								<td rowspan="${s.tsum }"><button type="submit" name="addTclass" value="${s.id }" class="btn btn-primary" >添加试听课</button></td>
								<td rowspan="${s.tsum }"><button type="submit" name="delete" value="${s.id }" class="btn btn-primary" >删除客户</button></td>
								<td rowspan="${s.tsum }"><button type="submit" name="update" value="${s.id }" class="btn btn-primary" >修改客户数据</button></td>
								</tr>
							</c:if>
						<%	System.out.println("I=" + i);
							i++;
						%>
						</c:forEach>
					</table>
					<table align="left">
						<tr>
							<td>第${now } 页/共${all } 页</td>
							
							<td>&nbsp;&nbsp;共${size } 位客户</td>
							<c:if test="${now != 1 }">
								<td><button type="sumbit" name="previous" value="11" class="btn btn-primary" >上一页</button></td>
							</c:if>
							<c:if test="${now != all }">
								<td><button type="sumbit" name="next" value="11" class="btn btn-primary" >下一页</button></td>
							</c:if>
						</tr>
					</table>
				</form>
		</div>
	</div>
	</div>
</section>
<!-- 表格信息  结束 -->

<c:if test="${Number != null }">
	<script>
		alert("共插入${Number}条数据！");
	</script>
</c:if>
	
</body>
</html>


