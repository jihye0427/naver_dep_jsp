<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>   

<c:forEach var="re" items="${replyList }">
	<ul class="reply-item">
		<li>${re.writer }</li>
		<li>${re.content }</li>
		<li><span>${re.reg_date }</span> <span class="recommend" onclick="recom(${re.no })" >추천 ${re.recommend }</span></li>
	</ul>
</c:forEach>