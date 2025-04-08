<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    pageContext.setAttribute("crcn", "\r\n"); //Space, Enter
    pageContext.setAttribute("br", "<br/>"); //br 태그
%>
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
</head>
<body>
<c:import url="/WEB-INF/views/common/menubar.jsp"/>

<main id="main">
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <h1 style="font-family: 'siu'">퀴즈 상세보기</h1>
        </div>
    </div>
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <table class="table table-bordered" style="text-align: center; table-layout: fixed">
                <tr>
                    <th>문제</th>
                    <td colspan="3">${randomquiz.rd_quiz }</td>
                </tr>
                <tr>
                    <th>정답</th>
                    <td colspan="3">${randomquiz.rd_answer }</td>
                </tr>
                <tr>
                    <th style="vertical-align: middle">설명</th>
                    <td colspan="3" style="width: 85%; word-break: break-all; word-wrap: break-word;">
                        ${fn:replace(randomquiz.rd_explain, crcn, br)}
                    </td>
                </tr>
            </table>
            <div class="col-12" align="right">
                <c:url var="randomup" value="/moverdupquiz.do">
                    <c:param name="rd_num" value="${randomquiz.rd_num}"/>
                </c:url>
                <a href="${randomup}" class="btn btn-primary">수정</a> &nbsp;

                <c:url var="randomdel" value="/delete.do">
                    <c:param name="rd_num" value="${randomquiz.rd_num}"/>
                </c:url>
                <a href="${randomdel}" class="btn btn-primary">삭제</a> &nbsp;
                <a href="${ pageContext.servletContext.contextPath }/rdlist.do?page=${currentPage}"
                   class="btn btn-primary">목록</a>
            </div>
        </div>
    </div>
</main>
<br style="clear:both;">
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>