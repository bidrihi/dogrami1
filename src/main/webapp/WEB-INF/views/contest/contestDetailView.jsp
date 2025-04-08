<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    pageContext.setAttribute("crcn", "\r\n"); //Space, Enter
    pageContext.setAttribute("br", "<br/>"); //br 태그
%>
<c:set var="currentPage" value="${ requestScope.currentPage }"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style>
        body table {
            font-size: 15pt;
            background-color: #f2f2f2;
            border-color: rgba(255, 255, 255, 0.2);
        }

        body table tr td {
            padding-left: 20px !important;
            text-align: left;
            background-color: white !important;
        }

        .main div h5, h6 {
            font-family: 'siu' !important;
        }
    </style>
    <script type="text/javascript"
            src="${ pageContext.servletContext.contextPath }/resources/js/jquery-3.6.3.min.js"></script>
    <script>
        function clickLikeBtn() {
            //비회원일때
            if ("${sessionScope.loginMember}" == "") {
                alert("로그인 후 이용할 수 있습니다.");
                return false;
            }
            //본인이 작성한 게시글이면
            if ("${sessionScope.loginMember.user_id}" == "${requestScope.contest.user_id}") {
                alert("본인이 작성한 게시글입니다.");
                return false;
            }

            //로그인했으면
            else {
                location.href = "contestlikeCountUp.do?contest_no=${contest.contest_no}&user_id=${sessionScope.loginMember.user_id}";
            }
        }

        function clickUnLikeBtn() {
            location.href = "contestlikeCountDown.do?contest_no=${contest.contest_no}&user_id=${sessionScope.loginMember.user_id}";
        }
    </script>
    <c:import url="/WEB-INF/views/common/menubar.jsp"/>
</head>
<body>
<main id="main">
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <h1 style="font-family: 'siu'">${contest.contest_title }</h1>
        </div>
    </div>
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <table class="table table-bordered" style="text-align: center;">
                <tr>
                    <th style="width: 20%;">작성자</th>
                    <td style="width: 20%;">${contest.member.user_nick}</td>
                    <th style="width: 20%;">작성날짜</th>
                    <td><fmt:formatDate value="${contest.contest_date}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>

                <tr>
                    <th>첨부파일</th>
                    <td colspan="3">
                        <c:url var="contestfd" value="/contestfdown.do">
                            <c:param name="oldfile" value="${contest.contest_oldfile }"/>
                            <c:param name="newfile" value="${contest.contest_newfile }"/>
                        </c:url>
                        <a href="${contestfd}">${contest.contest_oldfile }</a>
                    </td>
                </tr>
                <tr>
                    <th style="vertical-align: middle">내용</th>
                    <td colspan="3">
                        <img src="${pageContext.servletContext.contextPath}/resources/contest_upfiles/${contest.contest_newfile}"
                             alt="" width="200px"><br>
                        ${fn:replace(contest.contest_content, crcn, br)}
                    </td>
                </tr>
            </table>

            <!-- 좋아요 구현 -->
            <div style="text-align: left; float: left">
                <!-- 해당 게시글에 좋아요를 누른 기록이 없으면(증가) -->
                <c:if test="${likeResult eq 'N'}">
                    <a id="LikeBtn" onclick="return clickLikeBtn();" style="display:block;">
                        <img src="${pageContext.servletContext.contextPath}/resources/images/emptyheart.png"
                             style="width: 40px; height: 40px;"/>
                    </a>
                </c:if>
                <!-- 해당 게시글에 좋아요를 눌렀다면(취소) -->
                <c:if test="${likeResult eq 'Y'}">
                    <a id="UnLikeBtn" onclick="clickUnLikeBtn();" style="display:block;">
                        <img src="${pageContext.servletContext.contextPath}/resources/images/heart.png"
                             style="width: 40px; height: 40px;"/>
                    </a>
                </c:if>
                <p align="center" style="font-size: 10pt;">${contest.like_count}</p>
            </div>

            <div class="col-12" align="right">
                <c:if test="${requestScope.contest.user_id eq sessionScope.loginMember.user_id}">
                    <c:url var="contestup" value="/contestupview.do">
                        <c:param name="contest_no" value="${contest.contest_no}"/>
                    </c:url>
                    <a href="${contestup}" class="btn btn-primary">수정</a> &nbsp;

                    <c:url var="contestdel" value="/contestdelete.do">
                        <c:param name="contest_no" value="${contest.contest_no }"/>
                        <c:param name="contest_newfile" value="${contest.contest_newfile}"/>
                    </c:url>
                    <a href="${contestdel}" class="btn btn-primary">삭제</a> &nbsp;
                </c:if>
                <a href="${ pageContext.servletContext.contextPath }/contestlist.do?page=${currentPage}"
                   class="btn btn-primary">목록</a>
            </div>
        </div>
    </div>
</main>
<br style="clear:both;">
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>