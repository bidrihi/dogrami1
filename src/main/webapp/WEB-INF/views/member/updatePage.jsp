<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript" 
	src="${ pageContext.servletContext.contextPath }/resources/js/jquery-3.6.3.min.js"></script>
<script type="text/javascript">
	function validate(){
		//암호확인의 포커스가 사라질 때 		
		//암호와 암호 확인이 일치하는지 체크
		var pwd1 = document.getElementById("upwd1").value;
		var pwd2 = $('#upwd2').val();
		
		if(pwd1 !== pwd2){
			alert("암호와 암호 확인이 일치하지 않습니다.\n"
					+ "다시 입력하세요.");
			document.getElementById("upwd1").select();			
		}
	}
</script>	
</head>
<body>
<h1 align="center">회원 정보 수정 페이지</h1>
<br>
<form action="mupdate.do" method="post">
	<!-- 원래 암호도 함께 전송함 -->
	<input type="hidden" name="origin_userpwd" value="${member.userpwd }">
	
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
		<td><input type="text" name="username" value="${ requestScope.member.username }" readonly></td>
	</tr>
	<tr>
		<th width="120">아이디</th>
		<td><input type="text" name="userid" value="${ member.userid }" readonly></td>
	</tr>	
	<tr>
		<th width="120">비밀번호</th>
		<td><input type="password" name="userpwd" id="upwd1" ></td>
	</tr>
	<tr>
		<th width="120">비밀번호 확인</th>
		<td><input type="password" id="upwd2" onblur="validate();"></td>
	</tr>
	<tr>
		<th width="120">나 이</th>
		<td><input type="number" name="age" value="${ member.age }" min="19"></td>
	</tr>
	<tr>
		<th width="120">성 별</th>
		<td>
		<c:if test="${ member.gender eq 'M' }">
			<input type="radio" name="gender" value="M" checked> 남자
		&nbsp; <input type="radio" name="gender" value="F"> 여자
		</c:if>
		<c:if test="${ member.gender eq 'F' }">
			<input type="radio" name="gender" value="M" > 남자
		&nbsp; <input type="radio" name="gender" value="F" checked> 여자
		</c:if>
		</td>
	</tr>
	<tr>
		<th width="120">전화번호</th>
		<td><input type="tel" name="phone" value="${ member.phone }"></td>
	</tr>
	<tr>
		<th width="120">이메일</th>
		<td><input type="email" name="email" value="${ member.email }"></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" value="수정하기"> &nbsp;
			<input type="reset" value="수정취소"> &nbsp;
			<a href="javascript:history.go(-1);">이전 페이지로 이동</a> &nbsp;
			<a href="main.do">시작페이지로 이동</a>
		</th>		
	</tr>
</table>
</form>
<hr>
<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>