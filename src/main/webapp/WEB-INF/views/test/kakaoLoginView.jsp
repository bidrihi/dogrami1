<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kakaoLoginView</title>
<script type="text/javascript" src="${ pageContext.servletContext.contextPath }/resources/js/jquery-3.6.3.min.js"></script>
<!-- 카카오 sdk js 파일 다운받아서 사용할 경우 -->
<%-- <script type="text/javascript" src="${ pageContext.servletContext.contextPath }/resources/js/kakao.min.js"></script> --%>
<!-- 카카오 sdk js 파일 url로 연결 : cdn 방식 -->
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">
	//애플리케이션 등록하고 발급받은 javascript 앱키를 사용해야 함
	Kakao.init('181f9239fb6a10a7af7bb8d679cc63b2');
	//kakao sdk 초기화여부 확인
	console.log(Kakao.isInitialized());
	
	//카카오 로그인 함수
	function kakaoLogin(){
		Kakao.Auth.login({
			success: function(response){
				console.log(response);
			},
			fail: function(error){
				console.log(error);
			},
		});
	}
	
	//카카오 로그아웃 함수
	function kakaoLogout(){
		if(Kakao.Auth.getAccessToken()){
			Kakao.API.request({
				url: '/v1/user/unlink',
				success: function(response){
					console.log(response)
				},
				fail: function(error){
					console.log(error);
				},
			});
			//로그인시 발급받은 토큰 제거함
			Kakao.Auth.setAccessToken(undefined);
		}
	}
</script>
</head>
<body>
<h2>[1단계] : 카카오 로그인 api 애플리케이션 설정</h2>
<pre>
1. 회원가입 : https://developers.kakao.com/
2. 또는 카카오계정으로 로그인
3. '내 애플리케이션' 선택 
	- 애플리케이션 추가하기 (임의대로 작성)
	- 저장
4. 저장된 앱 클릭
	- 플랫폼 클릭
	- web : 사이트 도메인에 url 등록 (http://localhost:8888)
5. url 등록 후 Redirect URL 등록 : 
	등록하러 가기(필수 : 등록해야 사용할 수 있음)
	- 활성화 설정 ON으로 바꿈
	- redirect uri : 
		http://localhost:포트번호/context-root명/로그인url-mapping
	- 로그아웃 url 도 같이 추가 등록함
6. (선택사항) 제품설정의 카카오로그인
	- 동의항목 선택
	- 필요한 동의항목 지정함 (컨트롤러로 전달되는 값이 됨)
7. 앱키에서 javascript 키를 복사함
</pre>

<h2>[2단계] : 뷰페이지 작성</h2>
<pre>
1. 카카오 로그인 버튼 만들기 (이미지 다운받아서 사용)
2. 자바스크립트용으로 사용할 카카오 로그인 자바스크립트 소스 추가함
   (뷰파일 script 태그 src 속성)
   - 방법 1 : cdn 방식 (제공된 sdk url 사용) :
     https://developers.kakao.com/sdk/js/kakao.js
   - 방법 2 : sdk 직접 다운받아서 js 파일을 webapp/resources/js 
     폴더 안에 저장함
     https://developers.kakao.com/docs/latest/ko/sdk-download/js
     script 태그 작성
     src="${ pageContext.servletContext.contextPath }/resources/js/kakao.min.js"
</pre>
<br>
<hr>
<a href="https://developers.kakao.com/docs/latest/ko/getting-started/sdk-js" target="_blank">
카카오 로그인 코드 설명 페이지로 이동</a>
<br>
<hr>
<h2>카카오 로그인 실행 흐름 : </h2>
<pre>
1. 카카오 로그인 버튼 클릭
2. 브라우저에 카카오 로그인 창이 나타남
3. 클라이언트가 로그인 정보 입력
4. 로그인 요청
5. 동의항목이 나타남 - 체크함
6. 카카오 api 서버로 넘겨짐
7. 카카오 서버는 전달받은 데이터를 식별하고 클라이언트에게 토큰 발급함
8. 발급된 토큰을 사용해서 로그인 코드를 작성함
</pre>
<hr>
<h1 align="center">first 로그인</h1>
<div id="loginForm">
	<form action="login.do" method="post">
		<label>아이디 : <input type="text" name="userid" class="pos"></label>
		<br>
		<label>암호 : <input type="password" name="userpwd" class="pos"></label>
		<br>
		<input type="submit" value="로그인">
	</form>
</div>
<hr>
<!-- 카카오 로그인 창으로 이동 -->
<center>
	<h3>1. 카카오 로그인 버튼 클릭시에 전송온 토큰과 정보 확인 테스트</h3>
	<img src="${pageContext.servletContext.contextPath }/resources/images/kakao_login.png"
		onclick="kakaoLogin();"> <br>
	<button onclick="kakaoLogout();">카카오 로그아웃</button>
</center>




<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>