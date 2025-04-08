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
        #tbl {
            border-collapse: separate;
            border-spacing: 0 10px;
            font-size: 18pt;
        }

        tr {
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
            width: 100px;
        }

        td {
            width: 150px;
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
            <h1 style="font-family: 'siu'">성향테스트</h1>
        </div>
    </div>
    <br>
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <form action="dogresult.do" method="post">
                <table id="tbl">
                    <tr>
                        <th>크기</th>
                        <td>
                            <input type="radio" name="dog_size" value="소형"> 소형
                        </td>
                        <td>
                            <input type="radio" name="dog_size" value="중형"> 중형
                        </td>
                        <td>
                            <input type="radio" name="dog_size" value="대형"> 대형
                        </td>
                    </tr>
                    <tr>
                        <th>털빠짐</th>
                        <td>
                            <input type="radio" name="dog_hair" value="적음"> 적음
                        </td>
                        <td>
                            <input type="radio" name="dog_hair" value="보통"> 보통
                        </td>
                        <td>
                            <input type="radio" name="dog_hair" value="많음"> 많음
                        </td>
                    </tr>
                    <tr>
                        <th>활동량</th>
                        <td>
                            <input type="radio" name="dog_stamina" value="적음"> 적음
                        </td>
                        <td>
                            <input type="radio" name="dog_stamina" value="보통"> 보통
                        </td>
                        <td>
                            <input type="radio" name="dog_stamina" value="많음"> 많음
                        </td>
                    </tr>
                    <tr>
                        <th>성격</th>
                        <td>
                            <input type="radio" name="dog_char" value="온순하다"> 온순하다
                        </td>
                        <td>
                            <input type="radio" name="dog_char" value="예민하다"> 예민하다
                        </td>
                        <td>
                            <input type="radio" name="dog_char" value="활발하다"> 활발하다
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <input type="submit" class="btn btn-primary" value="확인"> &nbsp;
                            <input type="reset" class="btn btn-primary" value="리셋">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</main>
<br style="clear: both">
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>