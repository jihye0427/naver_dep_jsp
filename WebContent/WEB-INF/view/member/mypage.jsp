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
				<span>Mypage</span>
				<span>회원전용 서비스를 이용하실수 있습니다.</span>
			</div>
		</section>
		<main>
			<h1>메인영역</h1>
			<div class="main-wrap">
				<p>
					아이디 : <span>${logInfo.id }</span>
				</p>
				<p>
					 이름 : <span>${logInfo.name }</span>
				</p>
				<p>
					비밀번호 : <input type="password" value="${logInfo.pw }"> 
				</p>
				<p>
					이메일 : <span>${logInfo.email }</span>
				</p>
			</div>
		</main>
		<jsp:include page="/footer.jsp" />
		
	</body>
</html>