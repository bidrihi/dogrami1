<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <script type="text/javascript"
            src="${ pageContext.servletContext.contextPath }/resources/js/jquery-3.6.3.min.js"></script>
    <script type="text/javascript">
        function send() {
            if ($('#notice_title').val() == '') {
                alert("제목을 입력하세요");
                return false;
            }
            if ($('#notice_content').val() == '') {
                alert("내용을 입력하세요");
                return false;
            }
            return true;
        }

        $(document).ready(function () {
            $('#notice_content').on('keyup', function () {
                $('#text_cnt').html("(" + $(this).val().length + " / 600)");

                if ($(this).val().length > 600) {
                    $(this).val($(this).val().substring(0, 600));
                    $('#text_cnt').html("(600 / 600)");
                    alert('글자수는 600자를 초과할 수 없습니다.');
                }
            });
        });
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
            <h1 style="font-family: 'siu'">공지글 수정</h1>
        </div>
    </div>
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <form action="noticeupdate.do" enctype="multipart/form-data" method="post">
                <input type="hidden" name="notice_no" value="${notice.notice_no}">
                <c:if test="${!empty notice.notice_old_file}">
                    <input type="hidden" name="notice_old_file" value="${notice.notice_old_file}">
                    <input type="hidden" name="notice_new_file" value="${notice.notice_new_file}">
                </c:if>
                <table class="table table-bordered" style="text-align: center;">
                    <tr>
                        <th>제목</th>
                        <td colspan="3"><input type="text" id="notice_title" name="notice_title" value="${notice.notice_title}"></td>
                    </tr>

                    <tr>
                        <th>작성자</th>
                        <td>${notice.member.user_nick}</td>
                    </tr>

                    <tr>
                        <th>첨부파일</th>
                        <td colspan="3">
                            <c:if test="${ !empty notice.notice_old_file }">
                                ${ notice.notice_old_file } &nbsp;
                                <input type="checkbox" name="delfile" value="yes"> 파일삭제
                                <br>
                            </c:if>
                            <input type="file" name="upfile">
                        </td>
                    </tr>
                    <script type="text/javascript">$('#notice_content').val().replace(/(?:\r\n|\r|\n)/g, '<br/>')</script>
                    <tr>
                        <th style="vertical-align: middle; width: 20%">내용</th>
                        <td colspan="3" style="width: 85%">
                            <textarea id="notice_content" name="notice_content" cols="77"
                                                                     rows="5">${notice.notice_content}</textarea>
                            <br>
                            <p id="text_cnt" style="text-align: right; margin-bottom: 0;">(0 / 600) &nbsp;</p>
                        </td>
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