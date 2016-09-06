<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>休假审核</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function yes() {
		document.getElementById("isstatus").value = "已审核";
		document.forms[0].submit();
	}
	function no() {
		document.getElementById("isstatus").value = "审核拒绝";
		document.forms[0].submit();
	}
</script>
</head>

<body>
	<form id="myForm" name="myForm" action="/ssm/vacation/audit" method="post">
		<input type="hidden" id="isstatus" name="isstatus" value="" /> <input type="hidden" id="VId" name="VId" value="${vacation.vId}" />
		<input type="hidden" id="examiner" name="examiner" value="${vacation.examiner}" />
		<input type="hidden" id="isdeleted" name="isdeleted" value="0" />
		<div class="action">
			<div class="t">休假审核</div>
			<div class="pages">
				<table width="90%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="right" width="30%">姓名：</td>
						<td align="left"><input type="text" name="name" value="${vacation.name}" readonly="readonly" id="name" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">开始时间：</td>
						<td align="left"><input type="text" name="starttime" value="${vacation.starttime}" readonly="readonly" id="starttime" />
						</td>
					</tr>
					<tr>
						<td align="right" width="30%">结束时间：</td>
						<td align="left"><input type="text" name="endtime" value="${vacation.endtime}" readonly="readonly" id="endtime" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">请假天数：</td>
						<td align="left"><input type="text" name="totalday" value="${vacation.totalday}" readonly="readonly" id="totalday" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">请假原因：</td>
						<td align="left"><input type="text" name="reason" value="${vacation.reason}" readonly="readonly" id="reason" /></td>
					</tr>
					<tr>
						<td align="right" width="30%">申请人：</td>
						<td align="left"><input type="text" name="applicant" value="${vacation.applicant}" readonly="readonly" id="applicant" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><br /> <input type="button" value="审核通过" onclick="yes()" /> <input type="button"
							value="审核不通过" onclick="no()" /></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>