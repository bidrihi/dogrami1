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
            document.getElementById("ref_content_frm_" + i).action = "dailyreplyDelete.do";
            document.getElementById("ref_content_frm_" + i).method = "get";
            document.getElementById("ref_content_frm_" + i).submit();
        }

        function clickLikeBtn() {
            /* 	    	$('#LikeBtn').css('display', 'none');
                        $('#UnLikeBtn').css('display', 'block'); */
            //console.log("${sessionScope.loginMember}" == null);

            //비회원일때
            if ("${sessionScope.loginMember}" == "") {
                alert("로그인 후 이용할 수 있습니다.");
                return false;
            }
            //본인이 작성한 게시글이면
            if ("${sessionScope.loginMember.user_id}" == "${requestScope.daily.board_writer}") {
                alert("본인이 작성한 게시글입니다.");
                return false;
            }

            //로그인했으면
            else {
                location.href = "dailylikeCountUp.do?board_no=${daily.board_no}&user_id=${sessionScope.loginMember.user_id}";
            }
        }

        function clickUnLikeBtn() {
            /* 	    	$('#LikeBtn').css('display', 'block');
                        $('#UnLikeBtn').css('display', 'none'); */
            location.href = "dailylikeCountDown.do?board_no=${daily.board_no}&user_id=${sessionScope.loginMember.user_id}";
        }

        function replySend() {

            if ($('#ref_content').val() == '') {
                alert("내용을 입력하세요");
                return false;
            }

            var content = $('ref_content').val()
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
            <h1 style="font-family: 'siu'">${daily.board_title }</h1>
        </div>
    </div>
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <table class="table table-bordered" style="text-align: center; table-layout: fixed">
                <tr>
                    <th>작성자</th>
                    <td>${daily.member.user_nick}</td>

                    <th>작성날짜</th>
                    <td><fmt:formatDate value="${daily.board_date}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>

                <tr>
                    <th>첨부파일</th>
                    <td colspan="3">
                        <!-- 첨부파일이 있다면, 파일명 클릭시 다운로드 실행 처리 -->
                        <c:if test="${!empty daily.board_old_file }">
                            <c:url var="dailyfd" value="/dailyfdown.do">
                                <c:param name="oldfile" value="${daily.board_old_file }"/>
                                <c:param name="newfile" value="${daily.board_new_file }"/>
                            </c:url>
                            <a href="${dailyfd}">${daily.board_old_file }</a>
                        </c:if>
                    </td>
                </tr>

                <tr>
                    <th style="vertical-align: middle">내용</th>
                    <td colspan="3" style="width: 85%; word-break: break-all; word-wrap: break-word;">
                        <c:if test="${not empty daily.board_old_file and (daily.board_old_file.endsWith('.jpg') or daily.board_old_file.endsWith('.jpeg')
                        or daily.board_old_file.endsWith('.png') or daily.board_old_file.endsWith('.gif'))}">
                            <img src="${pageContext.servletContext.contextPath}/resources/daily_upfiles/${daily.board_new_file}"
                                 width="200px" alt=""><br>
                        </c:if>
                        ${fn:replace(daily.board_content, crcn, br)}
                    </td>
                </tr>
            </table>

            <!-- 좋아요 구현 -->
            <div style="text-align: left; float: left">

                <!-- 해당 게시글에 좋아요를 누른 기록이 없으면(증가) -->
                <c:if test="${likeResult eq 'N'}">
                    <a id="LikeBtn" onclick="return clickLikeBtn();" style="display:block;">
                        <img src="${pageContext.servletContext.contextPath}/resources/images/emptyheart.png"
                             style="width: 40px; height: 40px;"/>
                    </a>

                </c:if>

                <!-- 해당 게시글에 좋아요를 눌렀다면(취소) -->
                <c:if test="${likeResult eq 'Y'}">
                    <a id="UnLikeBtn" onclick="clickUnLikeBtn();" style="display:block;">
                        <img src="${pageContext.servletContext.contextPath}/resources/images/heart.png"
                             style="width: 40px; height: 40px;"/>
                    </a>
                </c:if>

                <p align="center" style="font-size: 10pt;">${daily.like_count}</p>

            </div>


            <div class="col-12" align="right">
                <c:if test="${requestScope.daily.board_writer eq sessionScope.loginMember.user_id}">
                    <c:url var="dailyup" value="/dailyupview.do">
                        <c:param name="board_no" value="${daily.board_no}"/>
                    </c:url>
                    <a href="${dailyup}" class="btn btn-primary">수정</a> &nbsp;

                    <c:url var="dailydel" value="/dailydelete.do">
                        <c:param name="board_no" value="${daily.board_no }"/>
                        <c:param name="board_new_file" value="${daily.board_new_file}"/>
                    </c:url>
                    <a href="${dailydel}" class="btn btn-primary">삭제</a> &nbsp;
                </c:if>

                <!-- 관리자일 경우 -->
                <c:if test="${requestScope.daily.board_writer ne sessionScope.loginMember.user_id && sessionScope.loginMember.user_admin eq 'Y'}">
                    <c:url var="dailydel" value="/dailydelete.do">
                        <c:param name="board_no" value="${daily.board_no }"/>
                        <c:param name="board_new_file" value="${daily.board_new_file}"/>
                    </c:url>
                    <a href="${dailydel}" class="btn btn-primary">삭제</a> &nbsp;
                </c:if>

                <a href="${ pageContext.servletContext.contextPath }/dailylist.do?page=${currentPage}"
                   class="btn btn-primary">목록</a>
            </div>

        </div>
    </div>

    <!-- 댓글창 -->

    <div class="container" align="center">
        <div class="col-9" style="text-align: left">
            <div class="comments">
                <h5 class="comment-title py-4" style="font-family: 'siu'">댓글 갯수 ${replycount}개</h5>
                <c:forEach items="${ requestScope.dailyreply }" var="dailyreply" varStatus="status">
                    <div class="comment d-flex mb-4">

                        <!-- 댓글 form -->
                        <form action="dailyReplyupdate.do" method="post" id="ref_content_frm_${dailyreply.ref_no }">
                            <div class="flex-grow-1 ms-2 ms-sm-3">
                                <div class="comment-meta d-flex align-items-baseline">
                                    <h6 class="me-2">${dailyreply.member.user_nick}</h6>
                                    <input type="hidden" name="ref_no" value="${dailyreply.ref_no}">
                                    <input type="hidden" name="board_no" value="${dailyreply.board_no}">
                                    <span class="text-muted"><fmt:formatDate value="${dailyreply.ref_date}" type="date"
                                                                             pattern="yyyy-MM-dd HH:mm:ss"/></span>
                                    &nbsp;

                                    <c:if test="${dailyreply.ref_writer eq sessionScope.loginMember.user_id}">
                                        <span class="text-muted"><a href="#" onclick="updateBtn(${dailyreply.ref_no});"
                                                                    id="ref_content_upbtn_${dailyreply.ref_no}">수정</a></span> &nbsp;
                                        <span class="text-muted"><a href="#"
                                                                    onclick="javascript:location.href='dailyreplyDelete.do?ref_no=${dailyreply.ref_no}&board_no=${dailyreply.board_no}';"
                                                                    id="ref_content_delbtn_${dailyreply.ref_no}">삭제</a></span>
                                    </c:if>

                                    <!-- 관리자일 경우 -->
                                    <c:if test="${dailyreply.ref_writer ne sessionScope.loginMember.user_id && sessionScope.loginMember.user_admin eq 'Y'}">
                                        <span class="text-muted"><a href="#"
                                                                    onclick="javascript:location.href='dailyreplyDelete.do?ref_no=${dailyreply.ref_no}&board_no=${dailyreply.board_no}';"
                                                                    id="ref_content_delbtn_${dailyreply.ref_no}">삭제</a></span>
                                    </c:if>

                                </div>

                                <div class="comment-body">
                                    <a id="ref_content_ori_${dailyreply.ref_no}">${fn:replace(dailyreply.ref_content, crcn, br)}</a>
                                        <%-- <input type="textarea" id="ref_content_tmp_${dailyreply.ref_no }" style="display:block; border:0 solid black;" value="${dailyreply.ref_content}" readonly/> --%>
                                    <textarea id="ref_content_tmp_${dailyreply.ref_no}" style="display:none;"
                                              name="ref_content">${dailyreply.ref_content}</textarea>
                                    <span class="text-muted"><a href="#" onclick="replySave(${dailyreply.ref_no});"
                                                                id="ref_content_savebtn_${dailyreply.ref_no}"
                                                                style="display:none;">저장</a></span> &nbsp;
                                    <span class="text-muted"><a href="#" onclick="replyCancel(${dailyreply.ref_no});"
                                                                id="ref_content_cancelbtn_${dailyreply.ref_no}"
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
        <form action="dailyreplyinsert.do" method="post">
            <input type="hidden" name="board_no" value="${daily.board_no}">
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