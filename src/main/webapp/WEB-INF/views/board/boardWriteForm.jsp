<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<!-- 상대경로로 대상 파일의 위치를 지정한 경우 -->
<c:import url="../common/menubar.jsp" />
<hr>
<h2 align="center">새 게시 원글 등록 페이지</h2>
<!-- form 태그에서 입력값들과 첨부파일을 같이 전송하려면
	 반드시 enctype="multipart/form-data" 속성을 추가해야 함
	 이 속성 사용시에는 method="post" 로 지정해야 함
 -->
<form action="binsert.do" method="post" enctype="multipart/form-data">
<table align="center" width="500" border="1" cellspacing="0"
cellpadding="5">
	<tr><th>제목</th><td><input type="text" name="board_title"></td></tr>
	<tr><th>작성자</th>
		<td><input type="text" name="board_writer" readonly
			value="${sessionScope.loginMember.userid }">
		</td>
	</tr>
	<tr><th>첨부파일</th>
		<td><input type="file" name="upfile" multiple></td>
	</tr>
	<tr><th>내용</th><td><textarea name="board_content" rows="5" cols="50"></textarea></td></tr>
	<tr><th colspan="2">
		<button onclick="javascript:history.go(-1); return false;">목록</button>
		&nbsp;
		<input type="submit" value="등록하기"> &nbsp;
		<input type="reset" value="작성취소">
	</th></tr>
</table>
</form>
<br>
<hr>
<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>