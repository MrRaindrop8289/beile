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
    <link href="plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="plugins/animate-css/animate.css" rel="stylesheet" />

    <!-- Morris Chart Css-->
    <link href="plugins/morrisjs/morris.css" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="css/style.css" rel="stylesheet">

    <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
    <link href="css/themes/all-themes.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css">
	<style type="text/css">
	html,
	body {
	    height: 100%;
	}
	html {
	    display: table;
	    margin: auto;
	}
	body {
	    display: table-cell;
	    vertical-align: middle;
		color:#404d5b;
	}

	.margin {
	  margin: 0 !important;
	}
	
	.card-panel{ min-width:350px;}
	</style>
</head>
<body class="red">

<div id="login-page" class="row">
	    <div class="col s12 z-depth-6 card-panel">
	      <form class="login-form" action="${pageContext.request.contextPath }/LoginServlet" method="post" >
	        <div class="row">
	          <div class="input-field col s12 center">
	            <img src="http://w3lessons.info/logo.png" alt="" class="responsive-img valign profile-image-login">
	            <p class="center login-form-text">贝乐登录系统</p>
	          </div>
	        </div>
	        <div class="row margin">
	          <div class="input-field col s12">
	            <i class="mdi-social-person-outline prefix"></i>
	            <input class="validate" type="text" name="userName"    placeholder="用户名">
	          </div>
	        </div>
	        <div class="row margin">
	          <div class="input-field col s12">
	            <i class="mdi-action-lock-outline prefix"></i>
	            <input id="password" type="password" name="passWord" placeholder="密码">
	          </div>
	        </div>
	        <div class="row">
	          <div class="input-field col s12">
	            <button type="sumbit" class="btn waves-effect waves-light col s12" data-toggle="button">  登录  </button>
	          </div>
	        </div>         

	      </form>
	    </div>
	  </div>
	  </div>


<c:if test="${UserNameError != null }">
	<script>
		alert("用户名不存在！");
	</script>
</c:if>
<c:if test="${PassWordError != null }">
	<script>
		alert("用密码错误！");
	</script>
</c:if>

	

</body>
</html>