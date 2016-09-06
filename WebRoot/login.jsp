<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyJsp.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/login.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">
	/**
	 * 登录验证
	 * @return {TypeName} 
	 */
	function checkName() {
		var username = document.getElementById("UId").value;
		var span1 = document.getElementById("name");
		if (username == null || username == "") {
			span1.innerHTML = "用户名不能为空";
			return false;
		} else {
			span1.innerHTML = "";
			return true;
		}
	}
	function checkPassword() {
		var password = document.getElementById("upassword").value;
		var span1 = document.getElementById("pass");
		if (password == null || password == "") {
			span1.innerHTML = "密码不能为空";
			return false;
		} else {
			span1.innerHTML = "";
			return true;
		}
	}
	function checklogin() {
		if (checkPassword() && checkName()) {
			return true;
		} else {
			return false;
		}
	}
</script>
</head>

<body>
	<div class="login-top"></div>
	<div class="login-area">
		<form action="user/login" method="post" name="login" onsubmit="return checklogin();">
			<label> 工&nbsp;&nbsp;号： </label> <input type="text" name="UId" id="UId" /><span id="name" style="color: red"></span> <label>
				密&nbsp;&nbsp;码： </label> <input type="password" name="upassword" id="upassword" /><span id="pass" style="color: red"></span> <input
				type="submit" class="login-sub" value="" /></br> <span style="color: red; font-size: 20px;">${message }</span>
		</form>
	</div>
	<div class="login-copyright"></div>
</body>
<script type="text/javascript">
	<c:choose>
	<c:when test="${param.type==5}">
	alert("用户未登录,请登录后再操作！");
	</c:when>
	<c:when test="${param.type==6}">
	alert("非法操作,请重新登录！");
	</c:when>
	<c:when test="${param.type==7}">
	alert("参数丢失,请重新登录！");
	</c:when>
	</c:choose>
</script>
</html>
