<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Insert title here</title>
		<script src="https://kit.fontawesome.com/a076d05399.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="js/myScript.js"></script>
		<link rel="stylesheet" type="text/css" href="css/mystyle.css">
		
	</head>
	<body>
		<jsp:include page="header.jsp" />
		<section>
			<h1>비주얼영역</h1>
			<div id="visual">
				<div id="area">
					<ul class="bg_1">
						<li></li>
					</ul>
					<ul class="bg_2">
						<li></li>
					</ul>
					<ul class="bg_3">
						<li></li>
					</ul>
					
				</div>
				<div id="moveBtn">
					<div>
						<button onclick="leftMove()"><i class="fas fa-angle-left"></i></button>
						<button onclick="rightMove()"><i class="fas fa-angle-right"></i></button>
					</div>
				</div>
			</div>
		</section>
		<main>
			<h1>메인영역</h1>
			<section id="service">
				<h1>제공서비스</h1>
				<ul class="main-wrap">
					<li>
						<a href="#">
						<span>Clova</span></a>
					</li>
					<li>
						<a href="#"><span>네이버 아이디로 로그인</span></a>
					</li>
					<li>
						<a href="#"><span>papago</span></a>
					</li>
					<li>
						<a href="#"><span>서비스API</span></a>
					</li>
					<li>
						<a href="#"><span>네이버 클라우드 플랫폼</span></a>
					</li>
				</ul>
			</section>
			<section id="notice">
				<h1>주요공지사항</h1>
				<ul class="main-wrap">
					<li>
						<a href="#">
							<span></span>
							<span>
								<span class="subject">
								4월22일부터 쇼핑 검색 API의 결과에 상품에 대한 정보가 추가됩니다.
								</span>
								<span class="d-c-wrap">
									<span class="date">
										<i class="fas fa-clock"></i>
										2020.04.16
									</span>
									<span class="count">
										<i class="fas fa-sort-amount-up"></i>
										123456
									</span>
								</span>
							</span>
						</a>
					</li>
					<li>
						<a href="#">
							<span></span>
							<span>
								<span class="subject">
								블로그 오픈 API 종료 안내
								</span>
								<span class="d-c-wrap">
									<span class="date">
										<i class="fas fa-clock"></i>
										2020.04.16
									</span>
									<span class="count">
										<i class="fas fa-sort-amount-up"></i>
										123456
									</span>
								</span>
							</span>
						</a>
					</li>
					<li>
						<a href="#">
							<span></span>
							<span>
								<span class="subject">
								[네이버 아이디로 로그인] 네이버 API 서비스 이용약관의 네아로 특약 조건 개정 공지(2020년 3월 5일 시행 예정)
								</span>
								<span class="d-c-wrap">
									<span class="date">
										<i class="fas fa-clock"></i>
										2020.04.16
									</span>
									<span class="count">
										<i class="fas fa-sort-amount-up"></i>
										123456
									</span>
								</span>
							</span>
						</a>
					</li>
					<li>
						<a href="#">
							<span></span>
							<span>
								<span class="subject">
								[네이버 아이디로 로그인] 사전 검수 신청 페이지 개선 및 가이드 오픈 공지
								</span>
								<span class="d-c-wrap">
									<span class="date">
										<i class="fas fa-clock"></i>
										2020.04.16
									</span>
									<span class="count">
										<i class="fas fa-sort-amount-up"></i>
										123456
									</span>
								</span>
							</span>
						</a>
					</li>
				</ul>
			</section>
		</main>
		<jsp:include page="footer.jsp" />
		
	</body>
</html>