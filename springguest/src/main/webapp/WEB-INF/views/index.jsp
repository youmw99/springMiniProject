<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="addAction" method="post">
	<table border="1" width="500">
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<td colspan="4"><textarea name="content" cols="60" rows="5"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="right"><input type="submit" value=" 확인 "></td>
		</tr>
	</table>
	</form>
		<br>
		<table width="510" border="1">
			<c:forEach var="item" items="${items}">
				<tr>
					<!-- jstl을 사용하여  map에 있는 값을 가져오기 -->
					<td>${item.name}</td>
					<td>${item.pw}</td>
					<td>${item.content }</td>
					<td>${item.regdate}</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>