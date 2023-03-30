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
<h2> 디테일뷰 쳌ㅊ케</h2>
<table align="center" width="500"  cellspacing="0" 
cellpadding="5">
<tr>
<th>퀴즈</th><td>${ requestScope.quiz.quiz }</td>
</tr>
</table>
<table align="center" width="500" border="1" cellspacing="0" 
cellpadding="5">
<tr>
		<th>퀴즈</th><td>${quiz.quiz }</td>
</tr>
<tr><th>정답</th><td>${quiz.quiz_right }</td></tr>
<tr><th>설명</th><td>${quiz.quiz_explain }</td></tr>
<tr>
		<th colspan="2">
			<button onclick="javascript:history.go(-1);">목록</button>
		</th>
	</tr>
</table>
<br>

</body>
</html>