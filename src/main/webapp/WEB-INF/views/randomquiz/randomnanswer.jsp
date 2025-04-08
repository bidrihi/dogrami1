<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <c:import url="/WEB-INF/views/common/menubar.jsp"/>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<main id="main">
    <br>
    <div class="container" align="center">
        <div class="col-9">
        </div>
    </div>
    <br>
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <h1 style="font-family: 'siu'">틀렸습니다</h1>
            <br>
            <br>
            <div>
                <h4 style="font-family: 'siu'">문제 : ${ randomquiz.rd_quiz }</h4>
            </div>
            <div>
                <h4 style="font-family: 'siu'">설명 : ${fn:replace(randomquiz.rd_explain, crcn, br)}</h4>
            </div>
            <br>
            <br>
            <input type="button" class="btn btn-primary" onclick="javascript:location.href='movegame.do';" value="다음문제"> &nbsp;
            <input type="button" class="btn btn-primary" onclick="javascript:location.href='main.do';" value="그만하기(홈으로 이동)">
        </div>
    </div>
</main>
<br><br><br><br>
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>