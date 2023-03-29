<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<c:import url="/WEB-INF/views/common/menubar.jsp"/>
<h2>랜덤 퀴즈 게임!!</h2>
<table align="center" width="500" border="1" cellspacing="0" 
cellpadding="1">


<center>
	<%-- <c:if test="${ !empty sessionScope.loginMember && sessionScope.loginMember.user_admin eq 'Y'}">
		<button onclick="javascript:location.href='moverdquiz.do';">퀴즈 등록</button>
	</c:if> --%>
	<button onclick="javascript:location.href='moverdquiz.do';">퀴즈 등록</button>
</center>

<table align="center" width="500" border="1" cellspacing="0" 
cellpadding="1">
	<tr>
		<th>문제</th>
		<th>정답</th>
		<th>설명</th>
	</tr>
	<c:forEach items="${ requestScope.list }" var="rd">
		<tr align="center">
			<td>${ rd.rd_quiz }</td>
			<!-- 제목 클릭시 해당 공지의 상세보기로 넘어가게 함 -->
		<td>${ rd.rd_answer }</td>
		 <td>${ rd.rd_explain }</td>	
		</tr>
	</c:forEach>
</table>

</body>
</html>