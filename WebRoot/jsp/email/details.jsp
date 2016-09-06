<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>邮件信息详情</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
	function back() {
		window.location = "/ssm/email/update?_method=put&EId=${email.eId}&r=${sessionScope.user.nickname}";
	}
	function setit() {
		document.forms[0].submit();
		//window.location.href = "/ssm/email/download?fileName=" + encodeURIComponent("${email.accessory}");
	}
</script>
<body>
	<form id="myForm" name="myForm" method="post" action="/ssm/email/download?fileName=${email.accessory}">
		<input type="hidden" name="EId" value="${email.eId}" />
		<div class="action">
			<div class="t">邮件信息详情</div>
			<div class="pages">
				<table width="90%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="right" width="30%">邮件标题：</td>
						<td align="left"><input type="text" name="title" value="${email.title}" readonly="readonly" id="title" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">邮件内容：</td>
						<td align="left"><textarea cols="40" rows="10" readonly="readonly" name="content" id="content">${email.content}</textarea></td>
					</tr>
					<tr>
						<td align="right" width="30%">发件时间：</td>
						<td align="left">${email.time}</td>
					</tr>
					<tr>
						<td align="right" width="30%">来自：</td>
						<td align="left"><input type="text" name="sender" value="${email.sender}" readonly="readonly" id="sender" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">文件：</td>
						<td align="left"><c:if test="${email.accessory!=null}">
								<!-- 	<button onclick="setit();" style="color: red;">下载</button> -->
								${email.accessory}<a href="/ssm/email/download?fileName=${email.accessory}" style="color: red;">下载</a>
							</c:if></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><br /> <input type="button" id="re_to" value="返回" onclick="back();" /></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>