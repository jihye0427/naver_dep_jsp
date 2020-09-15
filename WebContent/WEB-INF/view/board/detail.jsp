<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>  
   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://kit.fontawesome.com/a076d05399.js"></script>
		<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/detail-style.css">
		<script src="<%=request.getContextPath() %>/js/myscript-detail.js"></script>
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
				<ul id="detail" class="board-width">
					<li class="subject">${dto.subject }</li><!-- 제목 -->
					<li class="wdc">
						<span>${dto.writer }</span><span>${dto.reg_date }</span><span>조회수 ${dto.count }</span>
					</li><!-- 작성자 , 날짜, 조회수 -->
					<li class="content">
						<textarea rows="10" cols="60" disabled>${dto.content }</textarea>
					</li><!-- 내용 -->
					<li>
						<span><a href="<%=request.getContextPath() %>>${fileInfo.stored_file_path}">${fileInfo.original_file_name }</a></span>&nbsp;<span></span> KB
					</li>
				</ul>
				
				<form id="edit" class="board-width" action="edit.bo" method="post">
					<input id="board_no" type="hidden" name="no" value="${dto.no }"/>
					<ul>
						<li>
							<span >제목</span>
							<input type="text" name="subject" value="${dto.subject }" required/>
						</li>
						<li>
							<textarea rows="10" cols="60" name="content" required>${dto.content }</textarea>
						</li>
						<li>
							<p>저작권 등 다른 사람의 권리를 침해하거나 명예를 훼손하는 게시글은 이용약관 및 관련법률에 의해 제제를 받으실수 있습니다.</p>
						</li>
						<li>
							<button type="submit" class="btn">수정완료</button>
							<a href="board.bo" class="btn">목록</a>
						</li>
					</ul>
				</form>
				
				
				<div id="btn" class="board-width">
					<div>
						<c:if test="${logInfo.id eq  dto.writer}">
						<a href="#" class="btn" onclick="btn_edit_click()">수정</a>
						<a href="delete.bo?no=${dto.no }" class="btn">삭제</a>
						</c:if>
					</div>
					<div>
						<a href="board.bo" class="btn">목록</a>
						<a href="#" class="btn"><i class="fas fa-caret-up"> </i>TOP</a>
					</div>
				</div>
				<!-- ??????????댓글??????????????????????????? -->
				<div id="reply" class="board-width">
					<div id="in">
						<input id="log-id" type="hidden" value="${logInfo.id }">
						<input id="reply-in" type="text" placeholder="댓글을 입력해주세요.남을 비방하거나 폄훼글은 동의없이 삭제 될수 있습니다." readonly="readonly">
						<button id="btn-reply">댓글</button>
					</div>
					<div>
						<button id="btn-recent">최근 댓글순서</button>&nbsp;|&nbsp;
						<button id="btn-recom">추천수 많은순서</button>
					</div>
					<div id="out">
					</div>
					
				</div>
				
			</div>
		</main>
		<jsp:include page="/footer.jsp" />
		
	</body>
</html>