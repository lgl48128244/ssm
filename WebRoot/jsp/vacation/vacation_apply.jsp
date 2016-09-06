<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>申请休假</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function submiter() {
		var starttime = document.getElementById("starttime").value;
		var endtime = document.getElementById("endtime").value;
		var totalday = document.getElementById("totalday").value;
		var examiner = document.getElementById("examiner").value;
		var start = starttime.split("-");
		var end = endtime.split("-");
		if (start[2] < 10) {
			start[2] = 0 + start[2];
		}
		if (starttime == null || starttime == "") {
			alert("开始时间不能为空");
		} else if (endtime == null || endtime == "") {
			alert("结束时间不能为空");
		} else if (totalday == null || totalday == "") {
			alert("请假天数不能为空");
		} else if (start[0] > end[0]) {
			alert("请选择正确的结束时间");
		} else if (start[0] >= end[0] && start[1] > end[1]) {
			alert("请选择正确的结束时间");
		} else if (start[0] >= start[0] && start[1] >= end[1] && start[2] > end[2]) {
			alert("请选择正确的结束时间");
		} else if (examiner == null || examiner == "") {
			alert("请选择审批人");
		} else if (confirm("您确定要提交申请吗（y/n）？")) {
			document.forms[0].submit();
		}
	}

	function back() {
		window.location.href = "/ssm/vacation/list";
	}
</script>
</head>
<body>
	<form name="myform" action="/ssm/vacation/add" method="post">
		<input type="hidden" name="applicant" value="${user.nickname}" /> <input type="hidden" name="isstatus" value="未审核" /> <input
			type="hidden" name="isdeleted" value="0" />
		<div class="action">
			<div class="t">申请休假</div>
			<div class="pages">
				<table width="90%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="right" width="30%">姓名：</td>
						<td align="left"><input type="text" name="name" value="${user.uname}" id="name" readonly="readonly" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">开始时间：</td>
						<td align="left"><input class="Wdate required validate-date-yyyy-MM-dd" onClick="WdatePicker()" readonly="readonly"
							type="text" id="starttime" name="starttime"><font color="red">*</font></td>
					</tr>
					<tr>
						<td align="right" width="30%">结束时间：</td>
						<td align="left"><input class="Wdate required validate-date-yyyy-MM-dd" onClick="WdatePicker()" readonly="readonly"
							type="text" id="endtime" name="endtime"><font color="red">*</font></td>
					</tr>
					<tr>
						<td align="right" width="30%">请假天数：</td>
						<td align="left"><input type="text" name="totalday" id="totalday" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<td align="right" width="30%">请假原因：</td>
						<td align="left"><textarea cols="30" rows="4" name="reason" id="reason"></textarea></td>
					</tr>
					<tr>
						<td align="right" width="30%">审批人：</td>
						<td align="left"><select id="examiner" name="examiner">
								<option value="">请选择</option>
								<c:forEach var="e" items="${list}">
									<option value="${e.name}">${e.name}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><br /> <input type="button" id="save" value="提交申请" onclick="submiter();" /> <input
							type="button" id="re_to" value="返回" onclick="back();" /></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>