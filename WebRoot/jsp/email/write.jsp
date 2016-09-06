<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="email" class="com.ssm.project.model.Email" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>写邮件</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">
	function addemail() {
		var recipients = document.getElementById("recipients").value;
		var title = document.getElementById("title").value;
		var accessory = document.getElementById("accessory").value;
		if (recipients == null || recipients == "") {
			alert("收件人不能为空！");
		} else if (title == null || title == "") {
			alert("邮件标题不能为空！");
		} else if (accessory == null || accessory == "") {
			alert("附件不能为空！");
		} else {
			document.forms[0].submit();
		}
	}
</script>
</head>

<body>
	<form id="myForm" name="myForm" action="/ssm/email/upload" method="post" enctype="multipart/form-data">
		<input type="hidden" name="sender" value="${sessionScope.user.uname}" /> <input type="hidden" name="isread" value="未读" /> <input
			type="hidden" name="isdeleted" value="0" />
		<div class="action">
			<div class="t">写邮件</div>
			<div class="pages">
				<table width="90%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="right" width="30%">收件人：</td>
						<td align="left" colspan="2"><select name="recipients" id="recipients">
								<option value="">请选择</option>
								<c:forEach var="r" items="${list}">
									<option value="${r.nickname}">${r.nickname}</option>
								</c:forEach>
						</select> <font color="#FF0000">*</font></td>
					</tr>
					<tr>
						<td align="right" width="30%">邮件标题：</td>
						<td align="left" colspan="2"><input name="title" id="title" /> <font color="#FF0000">*</font></td>
					</tr>
					<tr>
						<td align="right" width="30%">邮件内容：</td>
						<td align="left" colspan="2"><textarea cols="40" rows="10" name="content" id="content"></textarea></td>
					</tr>
					<tr>
						<td align="right" width="30%">上传附件：</td>
						<td align="left" colspan="1"><input type="file" name="accessory" id="accessory" /> <font color="#FF0000">*</font>(上传附件不能大于9M)
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2"><br /> <input type="button" id="save" value="发送邮件" onclick="addemail()" /> </<br>
							<span style="color: indigo; font-size: 25px;">${message }</span></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>
