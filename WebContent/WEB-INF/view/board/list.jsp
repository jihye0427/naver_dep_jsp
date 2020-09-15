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
		<script type="text/javascript">
			$(function(){
				$.ajax({
					url:"boardList.bo",
					type:"post",
					success:function(result){
						
						$("#result").html(result);
					}
				});
			});
			
			
		</script>
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
					<div id="result">
					게시판을 뿌려줄영역
					</div>
				</section>
			</div>
		</main>
		<jsp:include page="/footer.jsp" />
		
	</body>
</html>