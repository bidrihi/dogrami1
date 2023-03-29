<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<style type="text/css">
table th { background-color: #99ffff; }
table#tbl { border: 2px solid navy;  }
</style>
<script type="text/javascript" 
	src="${ pageContext.servletContext.contextPath }/resources/js/jquery-3.6.3.min.js"></script>
<script type="text/javascript">
	function validate(){
		//전송 보내기전 (submit 버튼 클릭시) 입력값들이 유효한지 검사
		
		//암호와 암호 확인이 일치하는지 체크
		var pwd1 = document.getElementById("upwd1").value;
		var pwd2 = $('#upwd2').val();
		
		if(pwd1 !== pwd2){
			alert("암호와 암호 확인이 일치하지 않습니다.\n"
					+ "다시 입력하세요.");
			document.getElementById("upwd1").select();
			return false;  //전송 안 함
		}
		
		return true;  //전송함
	}
	
	//아이디 중복을 확인하기 위한 ajax 요청 처리용 함수
	//ajax(Asynchronous Javascript And Xml) : 
	//페이지를 바꾸거나 새로고침하지 않고, 서버와 통신하는 기술임
	//서버로 서비스 요청하고 결과받음
	function dupCheckId(){
		$.ajax({
			url: "idchk.do",
			type: "post",
			data: { userid: $('#userid').val() },
			success: function(data){
				console.log("success : " + data);
				if(data == 'ok'){
					alert("사용 가능한 아이디입니다.");
					$('#upwd1').focus();
				}else{
					alert("이미 사용중인 아이디입니다.\n다시 입력하세요.");
					$('#userid').select();
				}
			},
			error: function(jqXHR, textStatus, errorThrown){
				console.log("error : " + jqXHR + ", " + textStatus + ", "
						+ errorThrown);
			}
		});
		
		return false;  //클릭 이벤트 해제함
	}
</script>
</head>
<body>
<h1 align="center">회원 가입 페이지</h1>
<br>
<form action="enroll.do" method="post" onsubmit="return validate();">
<table id="tbl" align="center" width="500" cellspacing="5" 
cellpadding="0">
	<tr><th colspan="2">
		회원정보를 입력해 주세요. (* 표시는 필수입력 항목입니다)
	</th></tr>
	<tr>
		<th width="120">* 이 름</th>
		<td><input type="text" name="username" required></td>
	</tr>
	<tr>
		<th width="120">* 아이디</th>
		<td><input type="text" name="userid" id="userid" required>
			&nbsp; &nbsp;
			<input type="button" value="중복확인" onclick="return dupCheckId();">
		</td>
	</tr>
	<tr>
		<th width="120">* 비밀번호</th>
		<td><input type="password" name="userpwd" id="upwd1" required></td>
	</tr>
	<tr>
		<th width="120">* 비밀번호 확인</th>
		<td><input type="password" id="upwd2" required></td>
	</tr>
	<tr>
		<th width="120">* 나 이</th>
		<td><input type="number" name="age" min="19" value="19" required></td>
	</tr>
	<tr>
		<th width="120">* 성 별</th>
		<td><input type="radio" name="gender" value="M"> 남자
		&nbsp; <input type="radio" name="gender" value="F"> 여자
		</td>
	</tr>
	<tr>
		<th width="120">전화번호</th>
		<td><input type="tel" name="phone" placeholder="-빼고 입력"></td>
	</tr>
	<tr>
		<th width="120">* 이메일</th>
		<td><input type="email" name="email" required></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" value="가입하기"> &nbsp; 
			<input type="reset" value="작성취소"> &nbsp; 
			<a href="main.do">시작페이지로 이동</a>
		</th>		
	</tr>
</table>
</form>
<hr>
<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>