<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/board-style.css">
		<style type="text/css">
		</style>
	</head>
	<body>
		<!-- jsp:include "/" getContextPath() 와 동일 -->
		<jsp:include page="/header.jsp" />
		<section id="title">
			<h1>타이틀</h1>
			<div class="main-wrap">
				<span>게시판 페이지</span>
				<span>회원끼리 궁금한 점을 서로 묻고 답할 수 있는 열린 공간입니다.</span>
			</div>
		</section>
		<main>
			<h1>메인영역</h1>
			<div class="main-wrap">
				
				<section id="board">
					<h1>게시판view</h1>
					<div class="btn-write">
						<!-- 글쓰기버튼 로그인시만 사용가능 -->
						<c:if test="${!empty logInfo }">
						<a href="writePage.bo" class="btn">글쓰기</a>
						</c:if>
					</div>
					<ul>
						<li class="l1">NO
						<li class="l2">제목
						<li class="l3">조회수
						<li class="l4">작성자
						<li class="l5">작성일<br>IP
					</ul>
					<!-- 게시글 표현할 영역 시작-->
					<%@ page import="java.time.LocalDate" %>
					<c:forEach var="board" items="${list }">
						<ul>
							<li class="l1">${board.no }
							<li class="l2"><a href="detail.bo?no=${board.no }">${board.subject }</a>
							<li class="l3">${board.count }
							<li class="l4">${board.writer }
							<li class="l5">
							
							<c:choose>
								<c:when test="${board.reg_date.toLocalDate() eq LocalDate.now() }">
								${board.reg_date.toLocalTime() }
								</c:when>
								<c:otherwise>
								${board.reg_date.toLocalDate() }
								</c:otherwise>
							</c:choose>
							<br>${board.user_ip }
						</ul>
					</c:forEach>
					<!-- 게시글 표현할 영역 끝-->
					<div class="paging">
					 
						<c:if test="${pageInfo.pageStart > 1}">
						<a href="board.bo?pageNo=1">&lt;&lt;</a>
						<a href="board.bo?pageNo=${pageInfo.pageStart-1 }">&lt;</a>
						</c:if>
												
						<c:forEach begin="${pageInfo.pageStart }" end="${pageInfo.pageEnd }" varStatus="status" >
							<c:choose>
								<c:when test="${pageInfo.pageNo eq status.index }">
									<a class="calledPage" href="board.bo?pageNo=${status.index }">${status.index }</a>
								</c:when>
								<c:otherwise>
									<a href="board.bo?pageNo=${status.index }">${status.index }</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						 
						<c:if test="${pageInfo.pageEnd < pageInfo.pageTotal}">
						<a href="board.bo?pageNo=${pageInfo.pageEnd+1 }">&gt;</a>
						<a href="board.bo?pageNo=${pageInfo.pageTotal }">&gt;&gt;</a>
						</c:if>
						
					</div>
				</section>
			</div>
		</main>
		<jsp:include page="/footer.jsp" />
		
	</body>
</html>