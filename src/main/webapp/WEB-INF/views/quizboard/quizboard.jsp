<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!--  퀴즈 게시판 상세보기용  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<c:import url="/WEB-INF/views/common/menubar.jsp"/>
<h2>퀴즈게시판 쳌쳌</h2>
<table align="center" width="500" border="1" cellspacing="0" 
cellpadding="1">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>질문</th>
		<th>날짜</th>
		<th>조회수</th>
		<th>좋아요</th>
	</tr>
	<c:forEach items="${ requestScope.list }" var="q">
		<tr align="center">
			<td>${ q.quiz_no }</td>
			<!-- 제목 클릭시 해당 공지의 상세보기로 넘어가게 함 -->
		<td>${ q.user_id }</td>
		
		<c:url var="qdt" value="/qdetail.do">
				<c:param name="quiz_no"  value="${ q.quiz_no }" />
			</c:url> 
			 <td><a href="${ qdt }">${ q.quiz }</a></td>	
			<td>
				<fmt:formatDate value="${ q.quiz_date }" 
				 pattern="yyyy-MM-dd" />
			</td>
			<td>${q.quiz_count }</td>
			<td>${q.like_count }</td>
		</tr>
	</c:forEach>
</table>


</body>
</html>