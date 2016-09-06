<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加账号</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.js"></script>
<script type="text/javascript">
	function setit() {
		var tel = /^1[0-9]{10}$/;
		var age = /^[0-9]{2,3}$/;
		var uname = document.getElementById("uname").value;
		var upassword = document.getElementById("upassword").value;
		var nickname = document.getElementById("nickname").value;
		var uage = document.getElementById("uage").value;
		var usex = document.getElementById("usex").value;
		var utelephone = document.getElementById("utelephone").value;
		if (uname == null || uname == "") {
			alert("用户名不能为空！");
			return false;
		} else if (upassword == null || upassword == "") {
			alert("密码不能为空！");
			return false;
		} else if (nickname == null || nickname == "") {
			alert("昵称不能为空！");
			return false;
		} else if (uage == null || uage == "") {
			alert("年龄不能为空！");
			return false;
		} else if (!age.test(uage)) {
			alert("年龄输入不合法！");
			return false;
		} else if (usex == null || usex == "") {
			alert("性别不能为空！");
			return false;
		} else if (utelephone == null || utelephone == "") {
			alert("手机号不能为空！");
			return false;
		} else if (!tel.test(utelephone)) {
			alert("手机号不合法！");
			return false;
		} else if (confirm("您确定要保存数据吗（y/n）？")) {
			document.forms[0].submit();
		}
	}

	function back() {
		window.location.href = "/ssm/user/list";
	}

	function checkName() {
		var uname = document.getElementById("uname").value;
		var formParam = $("#myForm").serialize();//序列化表格内容为字符串    
		$.ajax({
			type : 'post',
			url : '/ssm/user/checkName?uname=' + uname,
			cache : false,
			success : function(result) {
				if (result == "false") {
					document.getElementById("unameSpan").innerHTML = "用户[" + uname + "]已存在,请更换一个新的";
				} else {
					document.getElementById("unameSpan").innerHTML = "";
				}
			}
		});
	}
</script>
</head>
<body>
	<form id="myForm" name="myForm" action="/ssm/user/add" method="post">
		<input type="hidden" name="role" value="普通用户" /> <input type="hidden" name="isdeleted" value="0" />
		<div class="action">
			<div class="t">添加账号</div>
			<div class="pages">
				<table width="90%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="right" width="30%">用户名：</td>
						<td align="left"><input type="text" name="uname" id="uname" onblur="checkName()" /> <span id="unameSpan"
							style="color: red;"></span></td>
					</tr>
					<tr>
						<td align="right" width="30%">密码：</td>
						<td align="left"><input type="text" name="upassword" id="upassword" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<td align="right" width="30%">昵称：</td>
						<td align="left"><input type="text" name="nickname" id="nickname" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<td align="right" width="30%">年龄：</td>
						<td align="left"><input type="text" name="uage" id="uage" maxlength="3" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">性别：</td>
						<td align="left"><select id="usex" name="usex">
								<option value="">请选择</option>
								<option value="男">男</option>
								<option value="女">女</option>
						</select></td>
					</tr>
					<tr>
						<td align="right" width="30%">手机：</td>
						<td align="left"><input type="text" name="utelephone" id="utelephone" maxlength="11" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<td align="right" width="30%">地址：</td>
						<td align="left"><input type="text" name="uaddress" id="uaddress" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><br /> <input type="button" id="save" value="保存数据" onclick="setit();" /> <input
							type="button" id="re_to" value="返回" onclick="back();" /></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>