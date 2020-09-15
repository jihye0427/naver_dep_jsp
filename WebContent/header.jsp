<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<h1>헤더영역</h1>
	<div id="header-wrap">
		<section id="top-logo">
			<h1>브랜드로고</h1>
			<a href="<%=request.getContextPath() %>/index.jsp">
				<img src="https://s.pstatic.net/static/www/mobile/edit/2020/0622/mobile_165346773874.png">
			</a>
		</section>
		<nav id="top-menu">
			<h1>상단메뉴</h1>
			<ul>
				<li><a href="#"><span class="bold">P</span>roducts</a><div class="line"></div></li>
				<li><a href="#"><span class="bold">D</span>ocuments</a><div class="line"></div></li>
				<li><a href="#"><span class="bold">A</span>pplication</a><div class="line"></div></li>
				<li><a href="#"><span class="bold">N</span>AVER D2</a><div class="line"></div></li>
				<li><a href="list.bo"><span class="bold">S</span>upport</a><div class="line"></div></li>
				<li><a href="board.bo"><span class="bold">F</span>orum</a><div class="line"></div></li>
			</ul>
		</nav>
		<section id="user-menu">
			<h1>클라이언트메뉴</h1>
			<section class="api column-d">
				<h1>api</h1>
				<span>
				<img src="images/btn_check.svg"><span>API상태</span>
				</span>
			</section>
			<section class="search column-d">
				<h1>search-box</h1>
				<form>
					<input type="text" placeholder="Search Here">
					<button type="button"><img src="images/btn_search.svg"></button>
				</form>
			</section>
			<section class="login column-d">
				<h1>login</h1>
				<c:choose>
					<c:when test="${empty sessionScope.logInfo }">
						<a href="loginPage.me" class="log">로그인</a>
					</c:when>
					<c:otherwise>
						<div>
						<!-- 이름출력 -->
						<span><a href="mypage.me">${sessionScope.logInfo.name }</a></span>
						<!-- 로그아웃버튼 -->
						<a href="logout.me" class="log">LOG OUT</a>
						</div>
					</c:otherwise>
				</c:choose>
			</section>
		</section>
	</div>
</header>