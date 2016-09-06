<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>北大青鸟办公管理系统</title>
<base href="<%=basePath%>">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function user() {
		document.getElementById("iframe").src = "${pageContext.request.contextPath}/jsp/user/user.jsp";
	}
	function write_e() {
		document.getElementById("iframe").src = "email/write";
	}
	function receiving() {
		document.getElementById("iframe").src = "email/reveive?nickname=${user.nickname}";
	}
	function deleted() {
		document.getElementById("iframe").src = "email/recycle?r=${user.nickname}";
	}
	function vacation() {
		document.getElementById("iframe").src = "vacation/list";
	}
	function personal() {
		document.getElementById("iframe").src = "${pageContext.request.contextPath}/jsp/user/account.jsp";
	}
	function management() {
		document.getElementById("iframe").src = "user/list";
	}
	function exit() {
		if (confirm("确定要注销吗？")) {
			//window.open("login.jsp?type=2", "_parent");
			window.location.href = "/ssm/user/logout";
		}
	}
</script>
</head>
<body>
	<div class="top">
		<div class="global-width">
			<img src="Images/logo.gif" class="logo" />
		</div>
	</div>
	<div class="status">
		<div class="global-width">
			${message}--${user.nickname} 你好！欢迎访问青鸟办公管理系统！
			<button onclick="window.location.href='javascript:exit()'">注销</button>
			<div style="float: right;">
				<a style="color: indigo;">当前时间：</a> <a id="time"></a>

				<script type="text/javascript">
					window.onload = function() {
						setInterval("document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());", 1000);
					}
				</script>
			</div>
		</div>
	</div>
	<div class="main">
		<div class="global-width">
			<div class="nav" id="nav">
				<div class="t"></div>
				<dl>
					<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">信息管理</dt>
					<dd>
						<a href="javascript:user()">个人信息</a>
					</dd>
				</dl>
				<dl>
					<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">邮件管理</dt>
					<dd>
						<a href="javascript:write_e()">写邮件</a>
					</dd>
					<dd>
						<a href="javascript:receiving()">收邮件</a>
					</dd>
					<dd>
						<a href="javascript:deleted()">垃圾邮件</a>
					</dd>
				</dl>
				<dl>
					<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">考勤管理</dt>
					<dd>
						<a href="javascript:vacation()">休假</a>
					</dd>
				</dl>
				<dl>
					<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">权限管理</dt>
					<dd>
						<a href="javascript:personal()">个人账户</a>
					</dd>
					<c:if test="${user.role=='经理'}">
						<dd>
							<a href="javascript:management()">管理账户</a>
						</dd>
					</c:if>
				</dl>
			</div>
			<div style="float: right">
				<iframe id="iframe" width="760" height="600" onload="this.height=this.Document.body.scrollHeight"
					src="${pageContext.request.contextPath}/jsp/user/user.jsp" frameborder="0" name="frame"> </iframe>
			</div>
		</div>
	</div>
	<div class="copyright">Copyright &nbsp; &copy; &nbsp; 北大青鸟</div>
</body>
</html>
