<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>  
<%
String context=request.getContextPath();
%>
<%-- 
<% 
	

Cookie[] cookies=request.getCookies();
String cookie_id=null;
String cookie_pw=null;
for(Cookie c:cookies){
	if(c.getName().equals("cookie_id")){
		cookie_id=c.getValue();
	}
	if(c.getName().equals("cookie_pw")){
		cookie_pw=c.getValue();
	}
}
 
%>
 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://kit.fontawesome.com/a076d05399.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/login-style.css">
		
	</head>
	<body>
		<!-- jsp:include "/" getContextPath() 와 동일 -->
		<jsp:include page="/header.jsp" />
		<section class="title">
			<h1>타이틀</h1>
			<div class="main-wrap">
				<span>로그인 페이지</span>
				<span>회원전용 서비스를 이용하실수 있습니다.</span>
			</div>
		</section>
		<main>
			<h1>메인영역</h1>
			<div class="main-wrap">
				<form id="login-form" action="login.me" method="post">
					<ul>
						<li class="login-logo">
							<img src="<%=context %>/images/naverlogo_green.svg" alt="로고">
						</li>
						<li>
							<span>${info }</span>
						</li>
						<li class="inp">
						<!-- scope 는 page,request,session,application중하나 선택하지않으면 page-->
							<input  type="text" name="id"  value="${cookie.cookie_id.value }" placeholder="아이디">
							
						</li>
						<li class="inp">
							<input  type="password" name="pw"  value="${cookie.cookie_pw.value }" placeholder="비밀번호">
						</li>
						<li class="msg">
							<span>${msg }</span>
						</li>
						<li>
							<input type="submit" value="로그인">
						</li>
						<li class="check-info">
							<div>
								<input id="chk" type="checkbox" name="login-status">
								<label for="chk">
									<span>로그인 정보저장	</span>
								</label>
							</div>
							<span>
								<span>IP보안<a href="#">on</a></span>
								<span>일회용 로그인</span>
							</span>
						</li>
						<li class="find-info">
							<a href="#">아이디 찾기</a><span>|</span>
							<a href="#">비밀번호 찾기</a><span>|</span>
							<a href="member.jsp">회원가입</a>
						</li>
						
					</ul>
				</form>
			</div>
		</main>
		<jsp:include page="/footer.jsp" />
		
	</body>
</html>