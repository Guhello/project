<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 引入jstl的核心标签库 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--  shiro标签库 -->
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>所有员工信息</title>
		<style type="text/css">
			table td {
				text-align: center;
			}
			/*合并表格的边框*/
			
			table {
				width: 700px;
				border-collapse: collapse;
			}
			
			h3 {
				text-align: center;
			}
			
			div {
				margin: 0 auto;
				width: 700px;
			}
		</style>
		<script type="text/javascript"  src="js/jquery-1.12.2.min.js"></script>
	</head>

	<body>
	<!-- 展示合法登录的用户名 -->
	<shiro:principal></shiro:principal>
	<a href="logout.do">退出</a>
	<button onclick="btnClick()">test</button>
		<div>
			<h3>所有员工信息</h3>
			<a href="add.jsp">添加员工信息</a><br/>
			<table border="1">

				<tr>
					<th>序号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
				
			<c:forEach var="emp" items="${empList }">
				<tr>
					<td>${emp.id }</td>
					<td>${emp.name }</td>
					<td>${emp.sex }</td>
					<td>${emp.age }</td>
					<td>${emp.phone }</td>
					<td>
						<a href="query.do?id=${emp.id }">修改</a>&nbsp;
						<!-- 判断是否有指定权限 -->
						<shiro:hasPermission name="user:delete">
							<a href="delete.do?id=${emp.id }">删除</a>
						</shiro:hasPermission>
						<!-- 判断是否没有指定权限 -->
						<shiro:lacksPermission name="user:delete">
							删除
						</shiro:lacksPermission>
					</td>
				</tr>
			</c:forEach>	

			</table>
		</div>



	</body>




</html>