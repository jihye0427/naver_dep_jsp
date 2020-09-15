<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://kit.fontawesome.com/a076d05399.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/write-style.css">
		<script type="text/javascript">
			history.forward();
		</script>
	</head>
	<body>
		<!-- jsp:include "/" getContextPath() 와 동일 -->
		<jsp:include page="/header.jsp" />
		<section id="title">
			<h1>타이틀</h1>
			<div class="main-wrap">
				<span>글쓰기 페이지</span>
				<span>회원끼리 궁금한 점을 서로 묻고 답할 수 있는 열린 공간입니다.</span>
			</div>
		</section>
		<main>
			<h1>메인영역</h1>
			<div class="main-wrap">
				<form id="write" class="board-width" action="write.fi" method="post" enctype="multipart/form-data">
					<input type="text" name="writer" value="${logInfo.id }" readonly="readonly"/>
					<!-- <input type="hidden" name="writer" value="guest"/> -->
					<ul>
						<li>
							<span >제목</span>
							<input type="text" name="subject" placeholder="게시글 제목을 입력하세요" required/>
						</li>
						<li>
							<textarea rows="10" cols="60" name="content" required></textarea>
						</li>
						<li>
							<input type="file" name="file">
						</li>
						<li>
							<p>저작권 등 다른 사람의 권리를 침해하거나 명예를 훼손하는 게시글은 이용약관 및 관련법률에 의해 제제를 받으실수 있습니다.</p>
						</li>
						<li>
							<button type="submit" class="btn">확인</button>
						</li>
					</ul>
				</form>
			</div>
		</main>
		<jsp:include page="/footer.jsp" />
		
	</body>
</html>