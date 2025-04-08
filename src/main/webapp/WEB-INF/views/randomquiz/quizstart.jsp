<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<c:import url="/WEB-INF/views/common/menubar.jsp"/>
<main id="main">
    <br>
    <br><br>
    <c:forEach items="${ requestScope.list }" var="rd">
        <div class="container" align="center">
            <div class="col-9">
                <h1 style="font-family: 'siu'">${rd.rd_quiz }</h1>
            </div>
        </div>
        <br><br><br>
        <div class="container" align="center">
            <c:url var="asw" value="answer.do">
                <c:param name="rd_quiz" value="${ rd.rd_quiz }"/>
                <c:param name="rd_explain" value="${ rd.rd_explain }"/>
            </c:url>
            <c:url var="nasw" value="nanswer.do">
                <c:param name="rd_quiz" value="${ rd.rd_quiz }"/>
                <c:param name="rd_explain" value="${ rd.rd_explain }"/>
            </c:url>
            <c:if test="${rd.rd_answer eq 'O' }">
                <div class="col-9 d-flex justify-content-center">
                    <a href="${asw}">
                        <img src="${ pageContext.servletContext.contextPath }/resources/images/rdquiz/O.jpg"
                             width="300" height="300">
                    </a>
                    <div class="col-2">
                    </div>
                    <a href="${nasw}">
                        <img src="${ pageContext.servletContext.contextPath }/resources/images/rdquiz/X.jpg"
                             height="300">
                    </a>
                </div>
            </c:if>
            <c:if test="${rd.rd_answer eq 'X' }">
                <div class="col-9 d-flex justify-content-center">
                    <a href="${nasw}">
                        <img src="${ pageContext.servletContext.contextPath }/resources/images/rdquiz/O.jpg"
                             width="300" height="300">
                    </a>
                    <div class="col-2">
                    </div>
                    <a href="${asw}">
                        <img src="${ pageContext.servletContext.contextPath }/resources/images/rdquiz/X.jpg"
                             height="300">
                    </a>
                </div>
            </c:if>
        </div>
    </c:forEach>
    <br><br><br><br><br>
</main>
<br style="clear: both">
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>