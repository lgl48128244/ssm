<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>错误页面</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function back() {
		window.location.href="/ssm/index.jsp";
	}
</script>
</head>
<body>
	<div class="action">
		<div class="t">出错了</div>
		<div class="pages" style=" padding-top:30px; font-size:18px">
			操作出现错误,点击<a href="javascript:back()" style="font-size:24px; color:#F00">这里</a>返回?
		</div>
	</div>
</body>
</html>