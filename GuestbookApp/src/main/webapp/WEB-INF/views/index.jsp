<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project 게시판</title>
</head>
<body>


	<table width="510" border="1">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>작성자</td>
			<td>작성일</td>
		</tr>
		<c:forEach var="item" items="${items}">
			<tr>
				<!-- jstl을 사용하여  map에 있는 값을 가져오기 -->
				<td>${item.bno}</td>
				<td>${item.title}</td>
				<td>${item.content }</td>
				<td>${item.writer}</td>
				<td>${item.regdate}</td>
			</tr>
			<tr>
				<td colspan="5">${item.content}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<form action="UpdateAction" method="post">
	<p>수정하려는 게시글의 번호를 선택하세요.</p>
		<select name = "bno">
			<c:forEach var="item" items="${items}" >
				<option value="${item.bno}" >${item.bno }</option>
			</c:forEach>
		</select>
		<p>
			작성자 <input name="writer" type="text">
		<p>
			제목 <input name="title" type="text">
		<p>
			내용
			<input name="content" type="text">
		<input name="게시글 수정" type="submit">
	</form>
	<hr>
	<form action="DeleteAction" method="post">
		<p>지우고 싶은 게시글의 번호를 선택하세요.</p>
		<select name="bno">
			<c:forEach var="item" items="${items}">
				<option value="${item.bno}">${item.bno }</option>
			</c:forEach>
		</select> <input name="게시글 삭제" type="submit">
	</form>
	<hr>
	<form action="CreateAction" method="post">
		<p>작성하려는 게시글의 내용을 입력해주세요.</p>
		<p>
			작성자 <input name="writer" type="text">
		<p>
			제목 <input name="title" type="text">
		<p>
			내용 <input name="content" type="text"> 
			<input name="게시글 등록" type="submit">
	</form>
</body>
</html>