<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    pageContext.setAttribute("crcn", "\r\n"); //Space, Enter
    pageContext.setAttribute("br", "<br/>"); //br 태그
%>

<c:set var="listCount" value="${ requestScope.listCount }"/>
<c:set var="currentPage" value="${ requestScope.currentPage }"/>

<!DOCTYPE html>
<html lang="ko">
<head>
    <title></title>
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

        .star {
            -webkit-text-fill-color: #fff58c
        }

        .star {
            display: flex;
            flex-direction: row-reverse;
            font-size: 2.25rem;
            line-height: 2.5rem;
            justify-content: space-around;
            padding: 0 0.2em;
            text-align: center;
            width: 5em;
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
            document.getElementById("ref_content_frm_" + i).action = "creplyDelete3.do";
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
            if ("${sessionScope.loginMember.user_id}" == "${requestScope.careboard.user_id}") {
                alert("본인이 작성한 게시글입니다.");
                return false;
            }

            //로그인했으면
            else {
                location.href = "carelikeCountUp.do?board_no=${careBoard.board_no}&user_id=${loginMember.user_id}";
            }
        }

        function clickUnLikeBtn() {
            location.href = "carelikeCountDown.do?board_no=${careBoard.board_no}&user_id=${loginMember.user_id}";
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
            <h1 style="font-family: 'siu'">${careBoard.board_title}</h1>
        </div>
    </div>
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <table class="table table-bordered" style="text-align: center; table-layout: fixed">
                <tr>
                    <th style="width: 20%;">작성자</th>
                    <td style="width: 20%;">${careBoard.member.user_nick}</td>

                    <th style="width: 20%;">작성날짜</th>
                    <td><fmt:formatDate value="${careBoard.board_date}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
                <tr>
                    <th>분류</th>
                    <td colspan="3">${careBoard.category}</td>
                </tr>
                <tr>
                    <th style="vertical-align: middle">지역</th>
                    <td style="vertical-align: middle">${careBoard.location}</td>
                    <th style="vertical-align: middle">별점</th>
                    <td>
                        <div class="star">
                            <c:if test="${careBoard.star_point eq 0}">&nbsp;</c:if>
                            <c:if test="${careBoard.star_point eq 1}">★</c:if>
                            <c:if test="${careBoard.star_point eq 2}">★★</c:if>
                            <c:if test="${careBoard.star_point eq 3}">★★★</c:if>
                            <c:if test="${careBoard.star_point eq 4}">★★★★</c:if>
                            <c:if test="${careBoard.star_point eq 5}">★★★★★</c:if>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th style="vertical-align: middle">사진</th>
                    <td colspan="3">
                        <!-- 사진이 있으면 보여줌 -->
                        <c:if test="${!empty careBoard.new_image}">
                            <img src="${pageContext.servletContext.contextPath}/resources/careBoard_upfiles/${careBoard.new_image}"
                                 width="200px">
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <th style="vertical-align: middle">내용</th>
                    <td colspan="3" style="width: 85%; word-break: break-all; word-wrap: break-word;">
                        ${fn:replace(careBoard.board_content, crcn, br)}
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
                             style="width: 30px; height: 30px;"/>
                    </a>
                </c:if>

                <p align="center" style="font-size: 10pt;">${careBoard.like_count}</p>

            </div>
            <br>
            <div class="col-12" align="right">
                <!-- 로그인 했고 유저아이디랑 로그인멤버 유저아이디랑 같을시 수정 삭제기능 -->
                <c:if test="${ !empty sessionScope.loginMember and careBoard.user_id eq loginMember.user_id}">
                    <c:url var="cupdate" value="/cupdate3.do">
                        <c:param name="board_no" value="${careBoard.board_no}"/>
                        <c:param name="page" value="${currentPage}"/>
                    </c:url>
                    <a href="${cupdate}" class="btn btn-primary">수정</a> &nbsp;

                    <c:url var="cdelete" value="/cdelete3.do">
                        <c:param name="board_no" value="${careBoard.board_no}"/>
                        <c:param name="page" value="${currentPage}"/>
                    </c:url>
                    <a href="${cdelete}" class="btn btn-primary">삭제</a> &nbsp;
                </c:if>
                <!-- 관리자일시 삭제처리만 가능하게끔 -->
                <c:if test="${loginMember.user_admin eq 'Y' and loginMember.user_id ne careBoard.user_id }">
                    <c:url var="cdelete" value="/cdelete3.do">
                        <c:param name="board_no" value="${careBoard.board_no}"/>
                        <c:param name="page" value="${currentPage}"/>
                    </c:url>
                    <a href="${cdelete}" class="btn btn-primary">삭제</a> &nbsp;
                </c:if>

                <a href="${ pageContext.servletContext.contextPath }/clist3.do?page=${currentPage}"
                   class="btn btn-primary">목록</a>
            </div>
        </div>
    </div>


    <!-- 댓글창 -->
    <div class="container" align="center">
        <div class="col-9" style="text-align: left">
            <div class="comments">
                <h5 class="comment-title py-4" style="font-family: 'siu'">댓글 갯수 ${replyCount}개</h5>
                <c:forEach items="${careReply}" var="reply" varStatus="status">
                    <div class="comment d-flex mb-4">
                        <!-- 댓글 업데이트 form -->
                        <form action="creplyUpdate3.do" method="post" id="ref_content_frm_${reply.ref_no}">
                            <div class="flex-grow-1 ms-2 ms-sm-3">
                                <div class="comment-meta d-flex align-items-baseline">
                                    <h6 class="me-2">${reply.member.user_nick}</h6>
                                    <input type="hidden" name="ref_no" value="${reply.ref_no}">
                                    <input type="hidden" name="board_no" value="${reply.board_no}">
                                    <input type="hidden" name="page" value="${currentPage}">


                                    <span class="text-muted"><fmt:formatDate value="${reply.ref_date}" type="date"
                                                                             pattern="yyyy-MM-dd HH:mm:ss"/></span>
                                    &nbsp;

                                    <!-- 수정 삭제버튼  -->
                                    <c:if test="${ !empty loginMember and loginMember.user_id eq reply.ref_writer }">
                                        <span class="text-muted"><a href="#" onclick="updateBtn(${reply.ref_no});"
                                                                    id="ref_content_upbtn_${reply.ref_no}">수정</a></span> &nbsp;

                                        <c:url var="cdelete" value="creplyDelete3.do">
                                            <c:param name="page" value="${currentPage }"/>
                                            <c:param name="ref_no" value="${ reply.ref_no }"/>
                                            <c:param name="board_no" value="${ careBoard.board_no }"/>
                                        </c:url>

                                        <span class="text-muted"><a href="#"
                                                                    onclick="javascript:location.href='${cdelete}'"
                                                                    id="ref_content_delbtn_${reply.ref_no}">삭제</a></span>
                                    </c:if>

                                    <!-- 관리자 일시 삭제버튼만 추가 -->
                                    <c:if test="${loginMember.user_admin eq 'Y' and loginMember.user_id ne reply.ref_writer  }">
                                        <c:url var="cdelete" value="creplyDelete3.do">
                                            <c:param name="page" value="${currentPage }"/>
                                            <c:param name="ref_no" value="${ reply.ref_no }"/>
                                            <c:param name="board_no" value="${ careBoard.board_no }"/>
                                        </c:url>

                                        <span class="text-muted"><a href="#"
                                                                    onclick="javascript:location.href='${cdelete}'"
                                                                    id="ref_content_delbtn_${reply.ref_no}">삭제</a></span>

                                    </c:if>
                                </div>
                                <div class="comment-body">
                                    <a id="ref_content_ori_${reply.ref_no}"> ${reply.ref_content}</a>
                                        <%-- <input type="textarea" id="ref_content_tmp_${dailyreply.ref_no }" style="display:block; border:0 solid black;" value="${dailyreply.ref_content}" readonly/> --%>
                                    <textarea id="ref_content_tmp_${reply.ref_no}" style="display:none;"
                                              name="ref_content">${reply.ref_content}</textarea>
                                    <span class="text-muted"><a href="#" onclick="replySave(${reply.ref_no});"
                                                                id="ref_content_savebtn_${reply.ref_no}"
                                                                style="display:none;">저장</a></span> &nbsp;
                                    <span class="text-muted"><a href="#" onclick="replyCancel(${reply.ref_no});"
                                                                id="ref_content_cancelbtn_${reply.ref_no}"
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
    <c:if test="${ !empty sessionScope.loginMember }">
    <form action="crepinsert3.do" method="post">
        <input type="hidden" name="board_no" value="${careBoard.board_no}">
        <input type="hidden" name="page" value="${currentPage}">
        <div align="center" style="text-align: center;">
            <div class="" style="display: inline-block;">
                <input type="hidden" class="form-control" id="ref_writer" size="6" style="float:left;"
                       name="ref_writer" value="${sessionScope.loginMember.user_id}">
            </div>
            <div class="col-4" style="display: inline-block;">
                <textarea class="form-control" id="comment-message" placeholder="댓글을 입력해 주세요" cols="7" rows="1"
                          style="float:left;" name="ref_content"></textarea>
            </div>
            <div style="display: inline-block; vertical-align: top;">
                <input type="submit" class="btn btn-primary" value="입력">
                </c:if>
            </div>
        </div>
    </form>
</main>
<br style="clear:both;">

<%-- footer --%>
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>