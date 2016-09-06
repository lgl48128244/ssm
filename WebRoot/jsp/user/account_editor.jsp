<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人账户</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function checkoldpassword() {
		var oldpassword = document.getElementById("oldpassword").value;
		var pwd = document.getElementById("pwd").value;
		var span8 = document.getElementById("soldpassword");
		if (oldpassword != pwd) {
			span8.innerHTML = "密码错误";
			return false;
		} else if (oldpassword == null || oldpassword == "") {
			span8.innerHTML = "密码不能为空";
			return false;
		} else {
			span8.innerHTML = "";
			return true;
		}
	}
	function checkpassword() {
		var password = document.getElementById("password").value;
		var span9 = document.getElementById("spassword");
		if (password == null || password == "") {
			span9.innerHTML = "密码不能为空";
			return false;
		} else {
			span9.innerHTML = "";
			return true;
		}
	}
	function checkrepassword() {
		var password = document.getElementById("password").value;
		var repassword = document.getElementById("repassword").value;
		var span10 = document.getElementById("srepassword");
		if (password != repassword) {
			span10.innerHTML = "两次密码不一样";
			return false;
		} else if (repassword == null || repassword == "") {
			span10.innerHTML = "密码不能为空";
			return false;
		} else {
			span10.innerHTML = "";
			return true;
		}
	}
	function checkform() {
		if (checkoldpassword() && checkpassword() && checkrepassword()) {
			return true;
		}
		return false;
	}
</script>
</head>

<body>
	<form id="myForm" name="myForm" action="/ssm/user/update" method="post" onsubmit="return checkform();">
		<div class="action">
			<div class="t">个人账户</div>
			<div class="pages">
				<table width="90%" border="0" cellspacing="12px" cellpadding="12px">
					<tr style="width: 30px; height: 15px;">
						<th align="right">用户名：</th>
						<td align="left"><input type="text" name="uname" value="${sessionScope.user.uname}" id="uname"/><input
							type="hidden" name="uId" value="${user.uId }" /></td>
					</tr>
					<tr style="width: 30px; height: 15px;">
						<th align="right">旧的密码：</th>
						<input type="hidden" id="pwd" value="${user.upassword}" />
						<td align="left"><input type="password" name="oldpassword" id="oldpassword" class="text"
							onblur="return checkoldpassword();" /> <span id="soldpassword" style="color: red; font-size: 12px">*</span></td>
					</tr>
					<tr>
						<th align="right">新的密码：</th>
						<td align="left"><input type="password" name="password" id="password" class="text" onblur="return checkpassword();" />
							<span id="spassword" style="color: red; font-size: 12px">*</span></td>
					</tr>
					<tr>
						<th align="right">确认密码：</th>
						<td align="left"><input type="password" name="repassword" id="repassword" class="text"
							onblur="return checkrepassword();" /> <span id="srepassword" style="color: red; font-size: 12px">*</span></td>
					</tr>
					<tr align="right" width="30%">
						<td align="center" colspan="2"><br /> <input type="submit" id="save" value="保存数据" /> <input type="button" value="返回"
							onclick="history.back();" /></br></br> <span style="color: indigo; font-size: 25px;">${message }</span></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>