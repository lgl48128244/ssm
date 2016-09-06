<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人信息</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function editor() {
		window.location.href = "/ssm/user/info?uId=${user.uId }&upassword=${user.upassword }";
	}
</script>
</head>
<body>
	<form id="myForm" name="myForm">
		<div class="action">
			<div class="t">个人信息</div>
			<div class="pages">
				<table width="90%" border="0" cellspacing="0" cellpadding="0" style="margin-top: 15px">
					<tr>
						<td align="right" width="30%">昵称：</td>
						<td align="left"><input type="text" name="nickname" value="${user.nickname}" readonly="readonly" id="nickname" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">年龄：</td>
						<td align="left"><input type="text" name="u.age" value="${user.uage}" readonly="readonly" id="age" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">性别：</td>
						<td align="left"><input type="text" name="" value="${user.usex}" readonly="readonly" id="" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">手机：</td>
						<td align="left"><input type="text" name="u.mobile" value="${user.utelephone}" readonly="readonly" id="u_mobile" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">地址：</td>
						<td align="left"><input type="text" name="u.address" value="${user.uaddress}" readonly="readonly" id="u_address" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><br /> <input type="button" id="save" value="编辑数据" onclick="editor();" /></td>
					</tr>
				</table>
				<h1 style="color: indigo;">${message }</h1>
			</div>
		</div>
	</form>
</body>
</html>