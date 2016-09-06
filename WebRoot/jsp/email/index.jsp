<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>邮件信息列表</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function show(next, total) {
		if (next <= 0) {
			alert("已经是首页了");
			return;
		}
		if (next > total) {
			alert("已经是尾页了");
			return;
		}
		document.forms[0].action = "/ssm/email/selectNextPage?page=" + next;
		document.forms[0].submit();
	}
</script>
</head>
<body>
	<div class="action">
		<div class="t">邮件信息列表</div>
		<div class="pages">

			<table width="90%" border="1" cellpadding="0" cellspacing="0" style="border:thin solid #666; margin-top:20px">
				<tr>
					<th>邮件标题</th>
					<th width="230">内容</th>
					<th>是否已读</th>
					<th>时间</th>
					<th>操作</th>
				</tr>
				<c:forEach var="e" items="${list}">
					<tr>
						<td align="center">${e.title}</td>
						<td align="center">${e.content}</td>
						<td align="center">${e.isread}</td>
						<td align="center">${e.time}</td>
						<td align="center">
							<button onclick="window.location.href='/ssm/email/detail?EId=${e.eId}'">详情</button>
							<button
								onclick="if(window.confirm( '确定要删除[${e.title}]吗?')==true){
												window.location.href='/ssm/email/deleteVirtual?EId=${e.eId}&nickname=${sessionScope.user.nickname}'}">删除</button>
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
			<h1>${message }</h1>
		</div>
	</div>
</body>
</html>