<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>  
<%
String context=request.getContextPath();
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="<%=context %>/js/jquery-3.5.1.min.js"></script>
		<script src="https://kit.fontawesome.com/a076d05399.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/member-style.css">
		<script type="text/javascript">
			$(function(){
				
				//input태그중 id값이"reg-id"인태그
				//focusout이 발생했을때 실행..
				$("#reg-id").focusout(function(){
					//ajax처리
					$.ajax({
						url:'idCheck.me',
						type: 'post',
						data:{ id : $("#reg-id").val() },
						success: function(result){
							if(result=="0"){
								$(".id-msg").text("사용가능한 ID입니다.");
								$(".id-msg").css("color", "blue");
							}else{
								$(".id-msg").text("이미 존해하는 ID입니다. 사용불가!");
								$(".id-msg").css("color", "red");
							}
						}
					});
				});
				
				/* 비밀번호 자리수 체크 */
				$("#reg-pw").focusout(function(){
					var input_pw=$(this).val();
					if(input_pw.length < 4){
						$(".pw-msg").text("비밀번호는 4글자 이상이어야 합니다");
						$(".pw-msg").css("color","red");
					}else{
						$(".pw-msg").text("");
					}
					
				});
				//비밀번호 재확인 체크
				$("#reg-pw-check").focusout(function(){
					var input_pw=$("#reg-pw").val();
					var input_pw_check=$("#reg-pw-check").val();
					if(input_pw != input_pw_check){
						$(".check-msg").text("비밀번호가 일치하지 않습니다.");
						$(".check-msg").css("color","red");
					}else{
						$(".check-msg").text("");
					}
				});
			});
			/* /////check-form///////////////// */
			function check_form(){
				var id=$("#reg-id").val().trim();
				var pw=$("#reg-pw").val().trim();
				var name=$("#reg-name").val().trim();
				var email=$("#reg-email").val().trim();
				
				if(blank_check("아이디", id)){
					$("#reg-id").focus();
					return false;
				}
				if(blank_check("비밀번호", pw)){
					$("#reg-pw").focus();
					return false;
				}
				if(blank_check("이름", name)){
					$("#reg-name").focus();
					return false;
				}
				if(blank_check("이메일", email)){
					$("#reg-email").focus();
					return false;
				}
				
				return true;
			}
			function blank_check(name, value){
				if(value==""){
					alert(name+" 영역이 비어있거나 공백입니다.");
					return true;
				}
				
				return false;
			}
		</script>
	</head>
	<body>
		<!-- jsp:include "/" getContextPath() 와 동일 -->
		<jsp:include page="/header.jsp" />
		<section class="title">
			<h1>타이틀</h1>
			<div class="main-wrap">
				<span>회원가입</span>
				<span>회원전용 서비스를 이용하실수 있습니다.</span>
			</div>
		</section>
		<main>
			<h1>메인영역</h1>
			<div class="main-wrap">
				<form id="reg-form" action="member-reg.me" method="post" onsubmit="return check_form()">
					<ul>
						<li class="reg-logo">
							<img src="<%=request.getContextPath() %>/images/naverlogo_green.svg" alt="로고">
						</li>
						<li class="reg-id">
							<label for="reg-id">아이디</label>
							<input type="text" name="id" id="reg-id" />
							<span class="id-msg"></span>
						</li>
						<li class="reg-pw">
							<label for="reg-pw">비밀번호</label>
							<input type="password" name="pw" id="reg-pw" />
							<span class="pw-msg"></span>
						</li>
						<li class="reg-pw-check">
							<label for="reg-pw-check">비밀번호 재확인</label>
							<input type="password" id="reg-pw-check" />
							<span class="check-msg"></span>
						</li>
						<li class="reg-name">
							<label for="reg-name">이름</label>
							<input type="text" name="name" id="reg-name" />
						</li>
						<li class="reg-email">
							<label for="reg-email">이메일</label>
							<input type="email" name="email" id="reg-email" />
						</li>
						<li class="reg-btn">
							
							<input type="submit" value="가입하기"/>
						</li>						
					</ul>
				</form>
			</div>
		</main>
		<jsp:include page="/footer.jsp" />
		
	</body>
</html>