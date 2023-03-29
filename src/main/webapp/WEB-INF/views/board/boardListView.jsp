<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    

<c:set var="listCount" value="${ requestScope.paging.listCount }" />
<c:set var="currentPage" value="${ requestScope.paging.currentPage }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript" 
	src="${ pageContext.servletContext.contextPath }/resources/js/jquery-3.6.3.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		showDiv();
		
		$('input[name=item]').on('change', function(){
			showDiv();
		});
		
	}); //document.ready	
	
	function showDiv(){
		if($('input[name=item]').eq(0).is(':checked')){
			$('#titleDiv').css('display', 'block');
			$('#writerDiv').css('display', 'none');
			$('#dateDiv').css('display', 'none');
		}
		if($('input[name=item]').eq(1).is(':checked')){
			$('#titleDiv').css('display', 'none');
			$('#writerDiv').css('display', 'block');
			$('#dateDiv').css('display', 'none');
		}
		if($('input[name=item]').eq(2).is(':checked')){
			$('#titleDiv').css('display', 'none');
			$('#writerDiv').css('display', 'none');
			$('#dateDiv').css('display', 'block');
		}
	} 
	
	function showWriteForm(){
		//게시원글 쓰기 페이지로 이동 처리
		location.href = "${ pageContext.servletContext.contextPath }/bwform.do";
	}
</script>
</head>
<body>
<!-- 상대경로로 대상 파일의 위치를 지정한 경우 -->
<c:import url="../common/menubar.jsp" />
<hr>
<h1 align="center">게시글 목록</h1>
<h3 align="center">총 게시글 수 : ${ listCount } 개</h3>
<!-- 로그인한 회원만 게시글 등록(글쓰기) 버튼이 보이게 함 -->
<center>
	<c:if test="${ !empty sessionScope.loginMember }">
		<button onclick="showWriteForm();">글쓰기</button>
	</c:if>
</center>
<!-- 검색 항목 영역 -->
<center>
<div>
	<h2>검색할 항목을 선택하세요.</h2>
	<input type="radio" name="item" value="title" checked> 제목
	&nbsp; &nbsp;
	<input type="radio" name="item" value="writer" > 작성자
	&nbsp; &nbsp;
	<input type="radio" name="item" value="date" > 날짜
</div>
<div id="titleDiv">
	<form action="bsearchTitle.do" method="post">
		<label>검색할 제목 키워드를 입력하세요 : 
			<input type="search" name="keyword">
		</label>
		<input type="submit" value="검색">
	</form>
</div>
<div id="writerDiv">
	<form action="bsearchWriter.do" method="post">
		<label>검색할 작성자 아이디를 입력하세요 : 
			<input type="search" name="keyword">
		</label>
		<input type="submit" value="검색">
	</form>
</div>
<div id="dateDiv">
	<form action="bsearchDate.do" method="post">
		<label>검색할 등록날짜를 입력하세요 : 
			<input type="date" name="begin"> ~ 
			<input type="date" name="end">
		</label>
		<input type="submit" value="검색">
	</form>
</div>
</center>
<br>

<!-- 목록 출력 영역 -->
<center>
	<button onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/blist.do?page=${ currentPage }';">
	목록 보기</button>
</center>
<br>
<table align="center" width="500" border="1" cellspacing="0" 
cellpadding="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>첨부파일</th>
		<th>조회수</th>
		<th>날짜</th>
	</tr>
	<c:forEach items="${ requestScope.list }" var="b">
		<tr align="center">
			<td>${ b.board_num }</td>
			<!-- 게시글 제목 클릭시 해당 게시글의 상세보기로 넘어가게 함 -->
			<c:url var="bdt" value="/bdetail.do">
				<c:param name="board_num" value="${ b.board_num }" />
				<c:param name="page" value="${ currentPage }" />
			</c:url>
			<td>
				<!-- 제목 글자 앞에 댓글과 대댓글 표시 기호 붙임
					들여쓰기 처리 : 원글과 구분지음
				 -->
				 <c:if test="${ b.board_lev eq 2 }">&nbsp; &nbsp; ▶ </c:if>
				 <c:if test="${ b.board_lev eq 3 }">&nbsp; &nbsp; &nbsp; &nbsp; ▶▶ </c:if>
				<!-- 로그인한 회원만 상세보기 할 수 있게 한다면 -->
				<c:if test="${ !empty sessionScope.loginMember }">
					<a href="${ bdt }">${ b.board_title }</a>
				</c:if>
				<c:if test="${ empty sessionScope.loginMember }">
					${ b.board_title }
				</c:if>
			</td>
			<td>${ b.board_writer }</td>
			<td>
				<c:if test="${ !empty b.board_original_filename }">◎</c:if>
				<c:if test="${ empty b.board_original_filename }">&nbsp;</c:if>
			</td>
			<td align="center">
				${ b.board_readcount }
			</td>
			<td>
				<fmt:formatDate value="${ b.board_date }" 
				 pattern="yyyy-MM-dd" />
			</td>
		</tr>
	</c:forEach>
</table>
<br>
<!-- 페이징 처리 -->
<c:import url="/WEB-INF/views/common/paging.jsp" />
<hr>
<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>


