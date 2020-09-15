<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/board-style.css">
		
	</head>
	<body>
		<table >
			<tr>
				<th>No</th>
				<th>제목</th>
				<th>조회수</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="board" items="${boardList }">
			<tr>
				<td>${board.no }</td>
				<td>${board.subject }</td>
				<td>${board.count }</td>
				<td>${board.writer }</td>
				<td>${board.reg_date }</td>
			</tr>
			</c:forEach>
		</table>
		
	</body>
</html>