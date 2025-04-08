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

        function updateBtn(i) {
            <%-- console.log(i); --%>
            document.getElementById("ref_content_tmp_" + i).style.display = "block";
            document.getElementById("ref_content_ori_" + i).style.display = "none";
            document.getElementById("ref_content_upbtn_" + i).style.display = "none";
            document.getElementById("ref_content_delbtn_" + i).style.display = "none";
            document.getElementById("ref_content_savebtn_" + i).style.display = "inline";
            document.getElementById("ref_content_cancelbtn_" + i).style.display = "inline";
        }

        function replyCancel(i) {
            document.getElementById("ref_content_savebtn_" + i).style.display = "none";
            document.getElementById("ref_content_cancelbtn_" + i).style.display = "none";
            document.getElementById("ref_content_tmp_" + i).style.display = "none";
            document.getElementById("ref_content_ori_" + i).style.display = "block";
            document.getElementById("ref_content_upbtn_" + i).style.display = "inline";
            document.getElementById("ref_content_delbtn_" + i).style.display = "inline";
        }

        function replySave(i) {
            document.getElementById("ref_content_frm_" + i).submit();
        }

        function deleteBtn(i) {
            document.getElementById("ref_content_frm_" + i).action = "replyDelete.do";
            document.getElementById("ref_content_frm_" + i).method = "get";
            document.getElementById("ref_content_frm_" + i).submit();
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
            <h1 style="font-family: 'siu'">${notice.notice_title}</h1>
        </div>
    </div>
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <table class="table table-bordered" style="text-align: center; table-layout: fixed">
                <tr>
                    <th style="width: 20%">작성자</th>
                    <td style="width: 20%">${notice.member.user_nick}</td>

                    <th style="width: 20%">작성날짜</th>
                    <td><fmt:formatDate value="${notice.notice_date}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td colspan="3">
                        <!-- 첨부파일이 있다면, 파일명 클릭시 다운로드 실행 처리 -->
                        <c:if test="${!empty notice.notice_old_file }">
                            <c:url var="noticefd" value="/noticefdown.do">
                                <c:param name="oldfile" value="${notice.notice_old_file }"/>
                                <c:param name="newfile" value="${notice.notice_new_file }"/>
                            </c:url>
                            <a href="${noticefd}">${notice.notice_old_file }</a>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <th style="vertical-align: middle">내용</th>
                    <td colspan="3" style="width: 85%; word-break: break-all; word-wrap: break-word;">
                        <c:if test="${not empty notice.notice_old_file and (notice.notice_old_file.endsWith('.jpg') or notice.notice_old_file.endsWith('.jpeg')
                        or notice.notice_old_file.endsWith('.png') or notice.notice_old_file.endsWith('.gif'))}">
                            <img src="${pageContext.servletContext.contextPath}/resources/notice_upfiles/${notice.notice_new_file}"
                                 width="200px" alt=""><br>
                        </c:if>
                        ${fn:replace(notice.notice_content, crcn, br)}
                    </td>
                </tr>
            </table>
            <div class="col-12" align="right">
                <c:if test="${loginMember.user_admin eq 'Y'}">
                    <c:url var="noticeup" value="/noticeupview.do">
                        <c:param name="notice_no" value="${notice.notice_no}"/>
                    </c:url>
                    <a href="${noticeup}" class="btn btn-primary">수정</a> &nbsp;

                    <c:url var="noticedel" value="/noticedelete.do">
                        <c:param name="notice_no" value="${notice.notice_no }"/>
                        <c:param name="notice_new_file" value="${notice.notice_new_file}"/>
                    </c:url>
                    <a href="${noticedel}" class="btn btn-primary">삭제</a> &nbsp;
                </c:if>
                <a href="${ pageContext.servletContext.contextPath }/nlist.do?page=${currentPage}"
                   class="btn btn-primary">목록</a>
            </div>
        </div>
    </div>
    <br>
</main>
<br style="clear:both;">
<%-- footer --%>
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>

