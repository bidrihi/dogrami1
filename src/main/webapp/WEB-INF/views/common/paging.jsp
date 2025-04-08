<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<c:set var="startPage" value="${ requestScope.paging.startPage }" />
<c:set var="endPage" value="${ requestScope.paging.endPage }" />
<c:set var="maxPage" value="${ requestScope.paging.maxPage }" />
<c:set var="currentPage" value="${ requestScope.paging.currentPage }" />
<c:set var="url" value="${ requestScope.paging.url }" />

<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/86f3c6d543.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 페이징 처리 -->
<div class="text-start py-4"> 
	<div class="custom-pagination" align="center">
<!-- 페이지 표시 영역 -->
		<!-- 1페이지로 이동하는 버튼 -->
		<c:if test="${ currentPage eq 1 }">
			&nbsp;
		</c:if>
		<c:if test="${ currentPage > 1 }">
			<c:url var="p1" value="${ url }">
				<c:param name="action" value="${ param.action }" />
    			<c:param name="keyword" value="${ param.keyword }" />
				<c:param name="page" value="1" />
			</c:url>
			<a href="${ p1 }"><i class="fa-solid fa-angles-left" style="color: #000000;"></i></a> &nbsp;
		</c:if>
		 <!-- 이전 페이지그룹으로 이동하는 버튼 -->
	   <c:if test="${ !((currentPage - 5) >= 1) }">
	      &nbsp;
	   </c:if>
	   <c:if test="${ (currentPage - 5) >= 1 }">
	      <c:url var="pbefore" value="${ url }">
	         <%-- <c:param name="page" value="${ startPage - 1 }" /> --%>
	        <c:param name="action" value="${ param.action }" />
    		<c:param name="keyword" value="${ param.keyword }" />
    		<c:param name="page" value="${ startPage - 1 }" />
	      </c:url>
	      <a href="${ pbefore }"><i class="fa-solid fa-angle-left" style="color: #000000;"></i></a> &nbsp;
	   </c:if>
		
		<!-- 현재 페이지가 속한 페이지 그룹 페이지 숫자 출력 -->
		<c:forEach var="p" begin="${ startPage }" end="${ endPage }" step="1">
			<c:if test="${ p eq currentPage }">
				<a class="active">${ p }</a>
			</c:if>
			<c:if test="${ p ne currentPage }">
				<c:url var="pp" value="${ url }">
					<%-- <c:param name="page" value="${ p }" /> --%>
					<c:param name="action" value="${ param.action }" />
    				<c:param name="keyword" value="${ param.keyword }" />
    				<c:param name="page" value="${ p }" />
				</c:url>
				<a href="${ pp }">${ p }</a>
			</c:if>
		</c:forEach>
		
		<!-- 다음 페이지그룹으로 이동하는 버튼 -->
	   <c:if test="${ !((startPage + 5) <= maxPage) }">
	      &nbsp;
	   </c:if>
	   <c:if test="${ (startPage + 5) <= maxPage }">
	      <c:url var="pafter" value="${ url }">
	         <%-- <c:param name="page" value="${ startPage + 5 }" /> --%>
	      	<c:param name="action" value="${ param.action }" />
    		<c:param name="keyword" value="${ param.keyword }" />
    		<c:param name="page" value="${ startPage + 5 }" />
	      </c:url>
	      <a href="${ pafter }"><i class="fa-solid fa-angle-right" style="color: #000000;"></i></a> &nbsp;
	   </c:if>
		
		<!-- 끝 페이지로 이동하는 버튼 -->
		<c:if test="${ currentPage eq maxPage }">
			&nbsp;
		</c:if>
		<c:if test="${ currentPage < maxPage }">
			<c:url var="pmax" value="${ url }">
				<%-- <c:param name="page" value="${ maxPage }" /> --%>
				<c:param name="action" value="${ param.action }" />
    			<c:param name="keyword" value="${ param.keyword }" />
    			<c:param name="page" value="${ maxPage }" />
			</c:url>
			<a href="${ pmax }"><i class="fa-solid fa-angles-right" style="color: #000000;"></i></a>
		</c:if>
	</div>
</div>

</body>
</html>