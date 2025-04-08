<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>도그라미</title>
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
    <script type="text/javascript">
        //이미지 체크
        function fileCheck(el) {

            if (!/\.(jpeg|jpg|png|gif|bmp)$/i.test(el.value)) {

                alert('이미지 파일만 업로드 가능합니다.');
                el.value = '';
                el.focus();

            }

        }
    </script>
</head>
<body>
<%-- header --%>
<c:import url="/WEB-INF/views/common/menubar.jsp"/>

<%-- main --%>
<main id="main">
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <h1 style="font-family: 'siu'">사이트 추가</h1>
        </div>
    </div>
    <br>
    <div class="container" align="center">
        <div class="col-8">
            <form action="shopinsert.do" enctype="multipart/form-data" method="post">
                <table class="table table-bordered" style="text-align: center;">
                    <tr>
                        <th>사이트 명</th>
                        <td colspan="3"><input type="text" name="site_name"></td>
                    </tr>
                    <tr>
                        <th>사이트 이미지</th>
                        <td colspan="3">
                            <input type="file" name="upfile" accept="image/*" onchange="fileCheck(this);" required/>
                        </td>
                    </tr>
                    <tr>
                        <th>사이트 주소</th>
                        <td colspan="3"><input type="url" name="site_url"></td>
                    </tr>
                </table>
                <div class="col-12" align="right">
                    <input type="submit" value="등록" class="btn btn-primary"> &nbsp;
                    <input type="reset" value="취소" class="btn btn-primary"> &nbsp;
                    <button onclick="javascript:history.go(-1); return false;"
                            class="btn btn-primary">이전 페이지로 이동
                    </button> &nbsp;
                </div>
            </form>
        </div>
    </div>
</main>
<br style="clear:both;">

<%-- footer --%>
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>