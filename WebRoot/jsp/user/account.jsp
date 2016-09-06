<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人账户</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function editor1() {
		window.location.href = "/ssm/jsp/user/account_editor.jsp";
	}
</script>
</head>

<body>
	<form id="myForm" name="myForm">
		<div class="action">
			<div class="t">个人账户</div>
			<div class="pages">
				<table width="90%" border="0" cellspacing="0" cellpadding="0" style="margin-top:30px">
					<tr>
						<td align="right" width="30%">用户名：</td>
						<td align="left"><input type="text" style="width:140px;height:20px" name="uname" value="${user.uname}"
							readonly="readonly" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">密码：</td>
						<td align="left"><input type="password" style="width:140px;height:20px" name="upassword" value="${user.upassword}"
							readonly="readonly" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><br /> <input type="button" id="editor" value="编辑数据" onclick="editor1();" /></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>