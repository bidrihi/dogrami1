<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style>
        #tbl {
            border-collapse: separate;
            border-spacing: 0 10px;
            font-size: 18pt;
        }

        tr {
            text-align: center;
        }

        th {
            width: 400px;
            background-color: #f2f2f2;
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
            <h1 style="font-family: 'siu'">성향테스트 결과</h1>
        </div>
    </div>
    <br>
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <table id="tbl">
                <tr>
                    <th style="text-align: center;">해당 조건에 맞는 강이지가 없습니다. <br> 더 많은 정보로 찾아 뵙겠습니다.</th>
                </tr>
                <tr>
                    <td>
                        <img src="${ pageContext.servletContext.contextPath }/resources/images/dogimg/nresult.jpg"
                             style="margin: 0 auto; display: block; width: 200px">
                    </td>
                </tr>
            </table>
        </div>
    </div>
</main>
<br style="clear: both">
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>