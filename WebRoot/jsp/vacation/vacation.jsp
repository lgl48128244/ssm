<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>休假信息列表</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function check(vname, name, VId) {
		if (name == vname) {
			alert("不能为自己审核！");
		} else {
			document.getElementById("VId").value = VId;
			document.forms[0].submit();
		}
	}
	function show(next, total) {
		if (next <= 0) {
			alert("已经是首页了");
			return;
		}
		if (next > total) {
			alert("已经是尾页了");
			return;
		}
		document.forms[1].action = "/ssm/vacation/selectNextPage?page=" + next;
		document.forms[1].submit();
	}
	function del(id,operation) {
		if (confirm("确定操作？")) {
			window.location.href = "/ssm/vacation/delete?id=" + id+"&oper="+operation;
		}
	}
</script>
</head>
<body>
	<div class="action">
		<div class="t">休假信息列表</div>
		<div class="pages">
			<table width="90%" border="1" cellpadding="0" cellspacing="0" style="border: thin solid #666; margin-top: 20px">
				<tr>
					<th>申请人</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>请假天数</th>
					<th>审批状态</th>
					<th>请假原因</th>
					<th>审核人</th>
					<th>操作</th>
				</tr>
				<c:forEach var="v" items="${list}">
					<form id="myForm" name="myForm" action="/ssm/vacation/detail" method="post">
						<input type="hidden" id="VId" name="VId" value="${v.vId}" />
						<tr>
							<td align="center">${v.name}</td>
							<td align="center">${v.starttime}</td>
							<td align="center">${v.endtime}</td>
							<td align="center">${v.totalday}</td>
							<td align="center">${v.isstatus}</td>
							<td align="center">${v.reason}</td>
							<td align="center">${v.examiner}</td>
							<c:if test="${user.role=='经理'}">
								<td align="center">
									<c:if test="${v.isstatus=='未审核'}">
										[<a href="javascript:check('${v.name}','${user.uname}','${v.vId}')" style="color: red">审核</a>]
                       				 </c:if>
                       				  <c:if test="${v.isdeleted==0 && v.name == user.uname}">
										[<a href="javascript:del('${v.vId }','app')" style="color:red">取消申请</a>]
									 </c:if> 
									 <c:if test="${v.isdeleted!=0 && v.name == user.uname}">
										[<a href="javascript:del('${v.vId }','del')" style="color:red">删除</a>]
									 </c:if> 
                       			 </td>
							</c:if>
							<c:if test="${user.role=='普通用户'}">
								<td align="center">
									<c:if test="${v.isstatus=='未审核'}">
										[<a href="javascript:check('${v.name}','${user.uname}','${v.vId}')" style="color: red">审核</a>]
                       				 </c:if>
                       				 <c:if test="${v.isdeleted==0 && v.name == user.uname}">
										[<a href="javascript:del('${v.vId }','app')" style="color:red">取消申请</a>]
									 </c:if> 
									 <c:if test="${v.isdeleted!=0 && v.name == user.uname}">
										[<a href="javascript:del('${v.vId }','del')" style="color:red">删除</a>]
									 </c:if> 
                       			 </td>
							</c:if>
						</tr>
					</form>
				</c:forEach>
			</table>
			<form id="myForm" name="myForm" method="post">
				<div>
					第${currentPage }页 <input type="hidden" id="tpage" name="tpage" value="${totalPage} "></input>
					<c:if test="${currentPage>1 }">
						<input type="button" value="首页" onclick="show(1)"></input>
						<input type="button" value="上一页" onclick="show(${currentPage-1})"></input>
					</c:if>
					<c:if test="${currentPage<totalPage }">
						<input type="button" value="下一页" onclick="show(${currentPage+1},${totalPage })"></input>
						<input type="button" value="尾页" onclick="show(${totalPage})"></input>
					</c:if>
					共${totalPage }页
				</div>
			</form>
			<br />
			<form id="addForm" name="addForm" action="/ssm/vacation/apply" method="post">
				<input type="submit" id="add" value="申请休假" />
				<div align="center">
					<span style="color: indigo; font-size: 25px; ">${message }</span>
				</div>
			</form>
		</div>
	</div>
</body>
</html>