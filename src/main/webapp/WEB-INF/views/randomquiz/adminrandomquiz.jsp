<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style type="text/css">

        #admintable tr th {
            font-size: 20px;
        }

        #admintable tr td {
            font-size: 18px;
        }
    </style>
</head>
<body>
<c:import url="/WEB-INF/views/common/menubar.jsp"/>
<main id="main">
    <br>
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <h1 style="font-family: 'siu'">랜덤 퀴즈 게임!!</h1>
        </div>
    </div>
    <br>
    <br>
    <!-- 관리자가 볼화면 -->
    <c:if test="${!empty sessionScope.loginMember && sessionScope.loginMember.user_admin eq 'Y' }">
        <div class="container" align="center">
            <div class="col-9">
                <div class="col-12" align="right">
                    <input type="button" onclick="javascript:location.href='moverdquiz.do';" class="btn btn-primary"
                           value="퀴즈 등록">
                </div>
                <table id="admintable" class="table table-striped" style="text-align: center;">
                    <thead>
                    <tr>
                        <th style="width: 400px;">문제</th>
                        <th style="width: 100px;">정답</th>
                        <th style="width: 400px;">설명</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${ requestScope.list }" var="rd">
                        <tr align="center">
                            <c:url var="rdt" value="/rddetail.do">
                                <c:param name="rd_quiz" value="${ rd.rd_quiz }"/>
                            </c:url>
                            <td><a href="${ rdt }">${ rd.rd_quiz }</a></td>
                            <td>${ rd.rd_answer }</td>
                            <td>${ rd.rd_explain }</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <form action="rdsearch.do" name="search" method="post">
                    <table>
                        <tr>
                            <td>
                                <select name="action" style="height: 30px; width: 50px">
                                    <option value="rd_quiz">문제</option>
                                    <option value="rd_explain">설명</option>
                                </select>
                            </td>
                            <td>
                                <input type="search" name="keyword" placeholder="Search">
                            </td>
                            <td>
                                <input type="submit" class="btn btn-primary" value="검색">
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </c:if>
    <!-- 관리자가 아닌 사람이 볼 화면 -->

    <c:if test="${sessionScope.loginMember.user_admin ne 'Y' }">
        <div class="container" align="center">
            <br><br><br><br>
            <input style="width:250px; height:70px; font-size: 18pt;" type="button"
                   onclick="javascript:location.href='movegame.do';" class="btn btn-primary" value="게임 스타트~!!">
            <br><br><br><br><br><br><br><br>
        </div>
    </c:if>
</main>
<br style="clear: both">
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>