<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="listCount" value="${ requestScope.paging.listCount }"/>
<c:set var="currentPage" value="${ requestScope.paging.currentPage }"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title></title>
    <c:import url="/WEB-INF/views/common/menubar.jsp"/>
    <style type="text/css">
        .main table tr th {
            font-size: 20px;
        }

        .main table tr td {
            font-size: 18px;
        }
    </style>
    <script type="text/javascript"
            src="${ pageContext.servletContext.contextPath }/resources/js/jquery-3.6.3.min.js"></script>
    <script src="https://kit.fontawesome.com/86f3c6d543.js" crossorigin="anonymous"></script>
</head>
<body>
<main id="main">
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <a href="${ pageContext.servletContext.contextPath }/contestlist.do">
                <h1 style="font-family: 'siu'">컨테스트</h1>
            </a>
        </div>
    </div>
    <br>
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <table class="table table-striped" style="text-align: center;">
                <thead>
                <tr>
                    <th>번호</th>
                    <th style="min-width: 100px;">제목</th>
                    <th>작성자</th>
                    <th>날짜</th>
                    <th>조회수</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${ requestScope.list }" var="contest" varStatus="status">
                    <tr>
                        <td>${contest.contest_no}</td>
                        <c:url var="dbdt" value="/contestdetail.do">
                            <c:param name="contest_no" value="${ contest.contest_no }"/>
                            <c:param name="page" value="${currentPage}"/>
                        </c:url>
                        <td><a href="${dbdt}">${ contest.contest_title }</a></td>
                        <td>${contest.member.user_nick}</td>
                        <td><fmt:formatDate value="${ contest.contest_date }" pattern="yyyy-MM-dd"/></td>
                        <td>${ contest.contest_count}</td>
                        <!-- 관리자일때 삭제버튼 보이게끔-->
                        <c:if test="${loginMember.user_admin eq 'Y'}">
                            <td style="width: 70px;">
                                <c:url var="contestdel" value="contestdelete.do">
                                    <c:param name="contest_no" value="${contest.contest_no }"/>
                                    <c:param name="contest_newfile" value="${contest.contest_newfile}"/>
                                </c:url>
                                <a href="${contestdel}" class="btn btn-primary">삭제</a>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <hr/>

            <!-- 로그인한 회원만 게시글 등록(글쓰기) 버튼이 보이게 함 -->
            <div class="col-12" align="right">
                <c:if test="${!empty sessionScope.loginMember}">
                    <input type="button" onclick="javascript:location.href='contestwrite.do';" class="btn btn-primary" value="글쓰기">
                </c:if>
            </div>

            <form action="contestsearch.do" name="search" method="post">
                <table>
                    <tr>
                        <td>
                            <select name="action" style="height: 30px">
                                <option value="contest_title">제목</option>
                                <option value="user_nick">작성자</option>
                                <option value="contest_content">내용</option>
                            </select>
                        </td>
                        <td>
                            <input type="search" name="keyword" placeholder="Search">
                        </td>
                        <td>
                            <input type="submit" value="검색">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</main>

<c:import url="/WEB-INF/views/common/paging.jsp"/>
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>