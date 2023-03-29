<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
</head>
<body>
<h1 align="center">마이 페이지</h1>
<br>
<table id="tbl" align="center" width="500" cellspacing="5" 
cellpadding="0" border="1">	
	<tr>
		<th width="120">이 름</th>
		<%--
			<%@ page import="org.ict.first.member.model.vo.Member %>
			<% 
				Member member = (Member)request.getAttribute("member");
			%>
			<td><%= member.getUsername() %></td>
		 --%>
		<td>${ requestScope.member.username }</td>
	</tr>
	<tr>
		<th width="120">아이디</th>
		<td>${ member.userid }</td>
	</tr>	
	<tr>
		<th width="120">나 이</th>
		<td>${ member.age }</td>
	</tr>
	<tr>
		<th width="120">성 별</th>
		<td>
		<c:if test="${ member.gender eq 'M' }">
			남자
		</c:if>
		<c:if test="${ member.gender eq 'F' }">
			여자
		</c:if>
		</td>
	</tr>
	<tr>
		<th width="120">전화번호</th>
		<td>${ member.phone }</td>
	</tr>
	<tr>
		<th width="120">이메일</th>
		<td>${ member.email }</td>
	</tr>
	<tr>
		<th colspan="2">
			<c:url var="moveup" value="/moveup.do">
				<c:param name="userid" value="${ member.userid }" />
			</c:url>
			<a href="${ moveup }">수정페이지로 이동</a> &nbsp;
			
			<c:url var="mdel" value="/mdel.do">
				<c:param name="userid" value="${ member.userid }" />
			</c:url>
			<a href="${ mdel }">탈퇴하기</a> &nbsp;
			<a href="main.do">시작페이지로 이동</a>
		</th>		
	</tr>
</table>
<hr>
<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>