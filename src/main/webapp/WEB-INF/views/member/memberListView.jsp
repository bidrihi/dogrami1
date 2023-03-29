<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<style type="text/css">
form.sform {
	display: none;  /* 안 보이게 설정 */
	background: lightgray;
}
</style>
<script type="text/javascript" 
	src="${ pageContext.servletContext.contextPath }/resources/js/jquery-3.6.3.min.js"></script>
<script type="text/javascript">
	//jQuery 로 이벤트 처리 : 검색 form 을 보이게/안보이게 처리
	//태그의 이벤트 적용 방식 1 : <태그명 on이벤트="함수명();">
	//태그의 이벤트 적용 방식 2 : 
	//window.onload = function(){  이벤트 적용과 작동 코드 작성 };
	//$(function(){ 이벤트 적용과 작동 코드 작 }); 과 동일함
	$(function(){
		//$('선택자').이벤트함수(function(){ 실행 코드 });
		//$('선택자').on('이벤트종류', function(){ 실행 코드 });
		//작성한 이벤트 실행 코드는 이벤트가 발생될 때까지 대기상태임
		
		//검색할 항목을 선택하면, 해당 항목에 대한 폼이 보여지게 함
		//보여지고 있는 다른 폼은 다시 안 보이게 함
		$('input[name=item]').on('change', function(){
			//change 이벤트가 발생한 radio 와 연결된 폼만
			//보여지게 하고, 나머지 폼들은 안보이게 처리함
			$('input[name=item]').each(function(index){
				//해당 index번째 radio 가 checked 인지 확인하고
				if($(this).is(':checked')){
					$('form.sform').eq(index).css('display', 'block');
				}else{
					$('form.sform').eq(index).css('display', 'none');
				}
			});  //each
		});  //on
		
	}); //document.ready
	
	//로그인 제한/가능 라디오 체크가 변경되었을 때 실행되는 함수임
	function changeLogin(element){
		//선택한 radio의 name 속성의 이름에서 userid 분리 추출함
		var userid = element.name.substring(9);
		console.log("changeLogin : " + userid);
		
		if(element.checked == true && element.value == "N"){
			//로그인 제한을 체크했다면
			console.log("로그인 제한 체크함");
			location.href = "${ pageContext.servletContext.contextPath }/loginok.do?userid=" 
						+ userid + "&login_ok=N";
		}else{
			//로그인 가능을 체크했다면
			console.log("로그인 가능 체크함");
			location.href = "${ pageContext.servletContext.contextPath }/loginok.do?userid=" 
						+ userid + "&login_ok=Y";
		}
	}
</script>
</head>
<body>
<c:import url="/WEB-INF/views/common/menubar.jsp" />
<hr>
<h1 align="center">회원 관리 페이지</h1>
<h2 align="center">현재 회원수 : ${ requestScope.list.size() } 명</h2>
<center>
	<button onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/mlist.do';">전체 보기</button>
	<br><br>
	<!-- 항목별 검색 기능 추가 -->
	<fieldset id="ss">
		<legend>검색할 항목을 선택하세요.</legend>
		<input type="radio" name="item" id="uid"> 회원아이디 &nbsp;
		<input type="radio" name="item" id="ugen"> 성별 &nbsp;
		<input type="radio" name="item" id="uage"> 연령대 &nbsp;
		<input type="radio" name="item" id="uenroll"> 가입날짜 &nbsp;
		<input type="radio" name="item" id="ulogin"> 로그인제한 
	</fieldset>
	<!-- 검색 항목 제공 끝 -->
	<br>
	<!-- 회원아이디로 검색 폼 -->
	<form action="${ pageContext.servletContext.contextPath }/msearch.do" 
	method="post" id="idform" class="sform">
		<input type="hidden" name="action" value="id">
		<input type="search" name="keyword"> &nbsp;
		<input type="submit" value="검색">
	</form>
	
	<!-- 성별로 검색 폼 -->
	<form action="${ pageContext.servletContext.contextPath }/msearch.do" 
	method="post" id="genderform" class="sform">
		<input type="hidden" name="action" value="gender">
		<input type="radio" name="keyword" value="M"> 남자 
		&nbsp; <input type="radio" name="keyword" value="F"> 여자
		<input type="submit" value="검색">
	</form>
	
	<!-- 연령대로 검색 폼 -->
	<form action="${ pageContext.servletContext.contextPath }/msearch.do" 
	method="post" id="ageform" class="sform">
		<input type="hidden" name="action" value="age">
		<input type="radio" name="keyword" value="20"> 20대 &nbsp;
		<input type="radio" name="keyword" value="30"> 30대 &nbsp;
		<input type="radio" name="keyword" value="40"> 40대 &nbsp;
		<input type="radio" name="keyword" value="50"> 50대 &nbsp;
		<input type="radio" name="keyword" value="60"> 60대이상 &nbsp;
		<input type="submit" value="검색">
	</form>
	
	<!-- 가입날짜로 검색 폼 -->
	<form action="${ pageContext.servletContext.contextPath }/msearch.do" 
	method="post" id="enrollform" class="sform">
		<input type="hidden" name="action" value="enroll">
		<input type="date" name="begin"> ~ 
			<input type="date" name="end"> &nbsp;
		<input type="submit" value="검색">
	</form>
	
	<!-- 로그인 제한/가능 여부로 검색 폼 -->
	<form action="${ pageContext.servletContext.contextPath }/msearch.do" 
	method="post" id="lokform" class="sform">
		<input type="hidden" name="action" value="login">
		<input type="radio" name="keyword" value="Y"> 로그인 가능 회원 &nbsp;
		<input type="radio" name="keyword" value="N"> 로그인 제한 회원 &nbsp;
		<input type="submit" value="검색">
	</form>
	
</center>
<br><br>
<!-- 조회해 온 회원 리스트 출력 처리 -->
<table align="center" border="1" cellspacing="0" cellpadding="3">
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>성별</th>
		<th>나이</th>
		<th>전화번호</th>
		<th>이메일</th>
		<th>가입날짜</th>
		<th>마지막 정보수정날짜</th>
		<th>로그인 제한여부</th>
	</tr>
	<c:forEach items="${ requestScope.list }" var="m">
		<tr>
			<td>${ m.userid }</td>
			<td>${ m.username }</td>
			<td>${ m.gender }</td>
			<td>${ m.age }</td>
			<td>${ m.phone }</td>
			<td>${ m.email }</td>
			<td>
				<fmt:formatDate value="${ m.enroll_date }" 
				type="date" dateStyle="medium" />
			</td>
			<td>
				<fmt:formatDate value="${ m.lastmodified }"
				type="date" dateStyle="medium" />
			</td>
			<td>
				<c:if test="${ m.login_ok eq 'Y' }">
					<input type="radio" name="login_ok_${ m.userid }" 
					value="Y" checked onchange="changeLogin(this);"> 가능 &nbsp;
					<input type="radio" name="login_ok_${ m.userid }" 
					value="N" onchange="changeLogin(this);"> 제한
				</c:if>
				<c:if test="${ m.login_ok eq 'N' }">
					<input type="radio" name="login_ok_${ m.userid }" 
					value="Y" onchange="changeLogin(this);"> 가능 &nbsp;
					<input type="radio" name="login_ok_${ m.userid }" 
					value="N" checked onchange="changeLogin(this);"> 제한
				</c:if>
			</td>
		</tr>
	</c:forEach>
</table>
<hr>
<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>







