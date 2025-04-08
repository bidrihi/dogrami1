<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
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
<c:import url="/WEB-INF/views/common/menubar.jsp"/>

<main id="main">
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <h1 style="font-family: 'siu'">사이트 수정</h1>
        </div>
    </div>
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <form action="shopupdate.do" enctype="multipart/form-data" method="post">
                <input type="hidden" name="shop_no" value="${shop.shop_no}">
                <c:if test="${!empty shop.site_image}">
                    <input type="hidden" name="site_image" value="${shop.site_image}">
                    <input type="hidden" name="site_image_rename" value="${shop.site_image_rename}">
                </c:if>
                <table class="table table-bordered" style="text-align: center;">
                    <tr>
                        <th>사이트 명</th>
                        <td colspan="3"><input type="text" name="site_name" value="${shop.site_name}"></td>
                    </tr>
                    <tr>
                        <th>사이트 이미지</th>
                        <td colspan="3">
                            ${shop.site_image}
                            <input type="checkbox" name="delfile" value="yes"> 파일삭제
                            <br>
                            <input type="file" name="upfile" accept="image/*" onchange="fileCheck(this);">
                        </td>
                    </tr>
                    <tr>
                        <th>사이트 주소</th>
                        <td colspan="3"><input type="url" name="site_url" value="${shop.site_url}"></td>
                    </tr>
                </table>
                <div class="col-12" align="right">
                    <input type="submit" value="수정" class="btn btn-primary"> &nbsp;
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
