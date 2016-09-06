<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,java.util.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>账户管理列表</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function addaccount() {
		window.location.href = "/ssm/jsp/user/account_add.jsp";
	}

	function delaccount(id) {
		if (confirm("确定要删除吗？")) {
			window.location.href = "/ssm/user/userdelete?id=" + id;
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
		document.forms[0].action = "/ssm/user/selectNextPage?page=" + next;
		document.forms[0].submit();
	}
</script>
</head>
<body>
	<div class="action">
		<div class="t">账户管理列表</div>
		<div class="pages">
			<table width="90%" border="1" cellpadding="0" cellspacing="0" style="border:thin solid #666;">
				<tr>
					<th width="18%">用户名</th>
					<th width="18%">昵称</th>
					<th width="29%">手机</th>
					<th>地址</th>
					<th>职务</th>
					<th>操作</th>
				</tr>
				<c:forEach var="u" items="${userslist}">
					<tr>
						<td align="center">${u.uname}</td>
						<td align="center">${u.nickname}</td>
						<td align="center">${u.utelephone}</td>
						<td align="center">${u.uaddress}</td>
						<td align="center">${u.role}</td>
						<td align="center">[<a href="javascript:delaccount('${u.uId}')" style="color:red">删除</a>]
						</td>
					</tr>
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
			</br>
			<form id="myForm" name="myForm">
				<input type="button" id="save" value="添加数据" onclick="addaccount()" />
				<div align="center">
					<span style="color: indigo; font-size: 25px; ">${message }</span>
				</div>
			</form>
		</div>
	</div>
</body>
</html>