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
    <script type="text/javascript"
            src="${ pageContext.servletContext.contextPath }/resources/js/jquery-3.6.3.min.js"></script>
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
            console.log(document.getElementById("ref_content_tmp_" + i));
            console.log($("#ref_content_tmp_" + i).val()); // textarea
            console.log($("#ref_content_tmp_" + i).val() == ""); // textarea == ""

            if ($("#ref_content_tmp_" + i).val() == "") {
                alert("내용을 입력하세요");
            } else {
                document.getElementById("ref_content_frm_" + i).submit();
            }
        }

        function deleteBtn(i) {
            document.getElementById("ref_content_frm_" + i).action = "diaryreplyDelete.do";
            document.getElementById("ref_content_frm_" + i).method = "get";
            document.getElementById("ref_content_frm_" + i).submit();
        }

        function clickLikeBtn() {

            //비회원일때
            if ("${sessionScope.loginMember}" == "") {
                alert("로그인 후 이용할 수 있습니다.");
                return false;
            }
            //본인이 작성한 게시글이면
            if ("${sessionScope.loginMember.user_id}" == "${requestScope.diary.board_writer}") {
                alert("본인이 작성한 게시글입니다.");
                return false;
            }
            //로그인했으면
            else {
                location.href = "diarylikeCountUp.do?board_no=${diary.board_no}&user_id=${sessionScope.loginMember.user_id}";
            }
        }

        function clickUnLikeBtn() {

            location.href = "diarylikeCountDown.do?board_no=${diary.board_no}&user_id=${sessionScope.loginMember.user_id}";
        }

        function replySend() {

            if ($('#ref_content').val() == '') {
                alert("내용을 입력하세요");
                return false;
            }
            return true;
        }

    </script>
</head>
<body>
<%-- header --%>
<c:import url="/WEB-INF/views/common/menubar.jsp"/>

<%-- main --%>
<%-- vscode --%>
<main id="main">
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <h1 style="font-family: 'siu'">${diary.board_title }</h1>
        </div>
    </div>
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <table class="table table-bordered" style="text-align: center; table-layout: fixed">
                <tr>
                    <th>작성자</th>
                    <td>${diary.member.user_nick}</td>

                    <th>작성날짜</th>
                    <td><fmt:formatDate value="${diary.board_date}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
                <c:if test="${requestScope.diary.board_writer eq sessionScope.loginMember.user_id || sessionScope.loginMember.user_admin eq 'Y'}">
                    <tr>
                        <th>공개여부</th>
                        <td colspan="3">
                            <c:if test="${diary.open eq 'Y'}">공개</c:if>
                            <c:if test="${diary.open eq 'N'}">비공개</c:if>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <th>첨부파일</th>
                    <td colspan="3">
                        <!-- 첨부파일이 있다면, 파일명 클릭시 다운로드 실행 처리 -->
                        <c:if test="${!empty diary.board_old_file }">
                            <c:url var="diaryfd" value="/diaryfdown.do">
                                <c:param name="oldfile" value="${diary.board_old_file }"/>
                                <c:param name="newfile" value="${diary.board_new_file }"/>
                            </c:url>
                            <a href="${diaryfd}">${diary.board_old_file }</a>
                        </c:if>
                    </td>
                </tr>

                <tr>
                    <th style="vertical-align: middle">내용</th>
                    <td colspan="3" style="width: 85%; word-break: break-all; word-wrap: break-word;">
                        <c:if test="${not empty diary.board_old_file and (diary.board_old_file.endsWith('.jpg') or diary.board_old_file.endsWith('.jpeg')
                        or diary.board_old_file.endsWith('.png') or diary.board_old_file.endsWith('.gif'))}">
                            <img src="${pageContext.servletContext.contextPath}/resources/diary_upfiles/${diary.board_new_file}"
                                 width="200px" alt=""><br>
                        </c:if>
                        ${fn:replace(diary.board_content, crcn, br) }
                    </td>
                </tr>
            </table>

            <!-- 좋아요 구현 -->
            <div style="text-align: left; float: left">
                <c:if test="${likeResult eq 'N'}">
                    <a id="LikeBtn" onclick="return clickLikeBtn();" style="display:block;">
                        <img src="${pageContext.servletContext.contextPath}/resources/images/emptyheart.png"
                             style="width: 40px; height: 40px;"/>
                    </a>
                </c:if>
                <c:if test="${likeResult eq 'Y'}">
                    <a id="UnLikeBtn" onclick="clickUnLikeBtn();" style="display:block;">
                        <img src="${pageContext.servletContext.contextPath}/resources/images/heart.png"
                             style="width: 40px; height: 40px;"/>
                    </a>
                </c:if>
                <p align="center" style="font-size: 10pt;">${diary.like_count}</p>
            </div>

            <div class="col-12" align="right">
                <c:if test="${requestScope.diary.board_writer eq sessionScope.loginMember.user_id}">
                    <c:url var="diaryup" value="/diaryupview.do">
                        <c:param name="board_no" value="${diary.board_no}"/>
                    </c:url>
                    <a href="${diaryup}" class="btn btn-primary">수정</a> &nbsp;

                    <c:url var="diarydel" value="/diarydelete.do">
                        <c:param name="board_no" value="${diary.board_no }"/>
                        <c:param name="board_new_file" value="${diary.board_new_file}"/>
                    </c:url>
                    <a href="${diarydel}" class="btn btn-primary">삭제</a> &nbsp;
                </c:if>
                <!-- 관리자일 경우 -->
                <c:if test="${requestScope.diary.board_writer ne sessionScope.loginMember.user_id && sessionScope.loginMember.user_admin eq 'Y'}">
                    <c:url var="diarydel" value="/diarydelete.do">
                        <c:param name="board_no" value="${diary.board_no }"/>
                        <c:param name="board_new_file" value="${diary.board_new_file}"/>
                    </c:url>
                    <a href="${diarydel}" class="btn btn-primary">삭제</a> &nbsp;
                </c:if>
                <a href="${ pageContext.servletContext.contextPath }/diarylist.do?page=${currentPage}"
                   class="btn btn-primary">목록</a>
            </div>
        </div>
    </div>

    <!-- 댓글창 -->

    <div class="container" align="center">
        <div class="col-9" style="text-align: left">
            <div class="comments">
                <h5 class="comment-title py-4" style="font-family: 'siu'">댓글 갯수 ${replycount}개</h5>
                <c:forEach items="${ requestScope.diaryreply }" var="diaryreply" varStatus="status">
                    <div class="comment d-flex mb-4">

                        <!-- 댓글 form -->
                        <form action="diaryReplyupdate.do" method="post" id="ref_content_frm_${diaryreply.ref_no }">
                            <div class="flex-shrink-0">
                                <div class="avatar avatar-sm rounded-circle">

                                    <!-- 사용자 프로필사진 있을경우 -->

                                    <!-- 사용자 프로필사진 없을경우 기본이미지 -->
                                    <img src="${pageContext.servletContext.contextPath}/resources/images/logo-b.png"
                                         style="width: 45px; height: 45px;">

                                </div>
                            </div>

                            <div class="flex-grow-1 ms-2 ms-sm-3">
                                <div class="comment-meta d-flex align-items-baseline">
                                    <h6 class="me-2">${diaryreply.member.user_nick}</h6>
                                    <input type="hidden" name="ref_no" value="${diaryreply.ref_no}">
                                    <input type="hidden" name="board_no" value="${diaryreply.board_no}">
                                    <span class="text-muted"><fmt:formatDate value="${diaryreply.ref_date}" type="date"
                                                                             pattern="yyyy-MM-dd HH:mm:ss"/></span>
                                    &nbsp;

                                    <c:if test="${diaryreply.ref_writer eq sessionScope.loginMember.user_id}">
                                        <span class="text-muted"><a href="#" onclick="updateBtn(${diaryreply.ref_no});"
                                                                    id="ref_content_upbtn_${diaryreply.ref_no}">수정</a></span> &nbsp;
                                        <span class="text-muted"><a href="#"
                                                                    onclick="javascript:location.href='diaryreplyDelete.do?ref_no=${diaryreply.ref_no}&board_no=${diaryreply.board_no}';"
                                                                    id="ref_content_delbtn_${diaryreply.ref_no}">삭제</a></span>
                                    </c:if>

                                    <!-- 관리자일 경우 -->
                                    <c:if test="${diaryreply.ref_writer ne sessionScope.loginMember.user_id && sessionScope.loginMember.user_admin eq 'Y'}">
                                        <span class="text-muted"><a href="#"
                                                                    onclick="javascript:location.href='diaryreplyDelete.do?ref_no=${diaryreply.ref_no}&board_no=${diaryreply.board_no}';"
                                                                    id="ref_content_delbtn_${diaryreply.ref_no}">삭제</a></span>
                                    </c:if>

                                </div>

                                <div class="comment-body">
                                    <a id="ref_content_ori_${diaryreply.ref_no}">${fn:replace(diaryreply.ref_content, crcn, br)}</a>
                                        <%-- <input type="textarea" id="ref_content_tmp_${diaryreply.ref_no }" style="display:block; border:0 solid black;" value="${diaryreply.ref_content}" readonly/> --%>
                                    <textarea id="ref_content_tmp_${diaryreply.ref_no}" style="display:none;"
                                              name="ref_content">${diaryreply.ref_content}</textarea>
                                    <span class="text-muted"><a href="#" onclick="replySave(${diaryreply.ref_no});"
                                                                id="ref_content_savebtn_${diaryreply.ref_no}"
                                                                style="display:none;">저장</a></span> &nbsp;
                                    <span class="text-muted"><a href="#" onclick="replyCancel(${diaryreply.ref_no});"
                                                                id="ref_content_cancelbtn_${diaryreply.ref_no}"
                                                                style="display:none;">취소</a></span>
                                </div>

                            </div>
                        </form>

                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <br>

    <!-- 댓글 입력창 -->
    <c:if test="${!empty sessionScope.loginMember}">
        <form action="diaryreplyinsert.do" method="post">
            <input type="hidden" name="board_no" value="${diary.board_no}">
            <div align="center" style="text-align: center;">
                <div class="" style="display: inline-block;">
                    <input type="hidden" class="form-control" id="ref_writer" size="6" style="float:left;"
                           name="ref_writer" value="${sessionScope.loginMember.user_id}">
                </div>
                <div class="col-4" style="display: inline-block;">
                    <script type="text/javascript">$('#ref_content').val().replace(/(?:\r\n|\r|\n)/g, '<br/>')</script>
                    <textarea class="form-control" id="ref_content" placeholder="댓글을 입력해 주세요" cols="7" rows="1"
                              style="float:left;" name="ref_content"></textarea>
                </div>
                <div style="display: inline-block; vertical-align: top;">
                    <input type="submit" class="btn btn-primary" value="입력" onclick="return replySend();">
                </div>
            </div>
        </form>
    </c:if>
</main>
<br style="clear:both;">

<%-- footer --%>
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>