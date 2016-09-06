<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>个人信息</title>
		<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
function setit() {
	var tel = /^1[0-9]{10}$/;
	var age = /^[0-9]{2,3}$/;
	var uage = document.getElementById("uage").value;
	var name = document.getElementById("nickname").value;
	var telephone = document.getElementById("utelephone").value;
	if (name == null || name == "") {
		alert("昵称不能为空！");
		return false;
	} else if (!age.test(uage)) {
		alert("年龄输入不合法！");
		return false;
	} else if (telephone == null || telephone == "") {
		alert("手机号不能为空！");
		return false;
	} else if (!tel.test(telephone)) {
		alert("手机号不合法！");
		return false;
	} else if (confirm("您确定要保存数据吗（y/n）？")) {
		document.forms[0].submit();
		return true;
	}
}

function back() {
	if (confirm("您是否确定要返回（y/n）？")) {
		history.go(-1);
	}
}
</script>
	</head>
	<body>
		<form id="myForm" name="myForm" action="/ssm/user/edit?uid=${user.uId}" method="post"> 
			<div class="action">
				<div class="t">
					个人信息
				</div>
				<div class="pages">
					<table width="90%" border="0" cellspacing="0" cellpadding="0" style="margin-top: 15px">
						<tr>
							<td align="right" width="30%">
								昵称：
							</td>
							<td align="left">
								<input type="text" name="nickname" value="${user.nickname}" id="nickname" />
								<input type="hidden" name="uId" value="${user.uId}"/>
								<input type="hidden" name="uname" value="${user.uname}"/>
								<input type="hidden" name="upassword" value="${user.upassword}"/>
								<input type="hidden" name="role" value="${user.role}"/>
								<input type="hidden" name="isdeleted" value="${user.isdeleted}"/>
								<font color="red">*</font>
							</td>
						</tr>
						<tr>
							<td align="right" width="30%">
								年龄：
							</td>
							<td align="left">
								<input type="text" name="uage" value="${user.uage}" id="uage" maxlength="3" />
							</td>
						</tr>
						<tr>
							<td align="right" width="30%">
								性别：
							</td>
							<td align="left">
								<select id="usex" name="usex">
									<option value='${user.usex}'>
										${user.usex}
									</option>
									<c:if test="${user.usex=='男'}">
										<option value="女">
											女
										</option>
									</c:if>
									<c:if test="${user.usex=='女'}">
										<option value="男">
											男
										</option>
									</c:if>
								</select>
							</td>
						</tr>
						<tr>
							<td align="right" width="30%">
								手机：
							</td>
							<td align="left">
								<input type="text" name="utelephone" value="${user.utelephone}" id="utelephone" maxlength="11" />
								<font color="red">*</font>
							</td>
						</tr>
						<tr>
							<td align="right" width="30%">
								地址：
							</td>
							<td align="left">
								<input type="text" name="uaddress" value="${user.uaddress}" id="uaddress" />
							</td>
						</tr>
						<tr>
							<td align="center" colspan="2">
								<br />
								<input type="button" id="save" value="保存数据" onclick="setit();" />
								<input type="button" id="re_to" value="返回" onclick="back();" />
							</td>
						</tr>
					</table>
				</div>
			</div>
		</form>
	</body>
</html>