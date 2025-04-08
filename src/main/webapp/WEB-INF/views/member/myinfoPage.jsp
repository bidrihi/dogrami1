<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <script type="text/javascript"
            src="${ pageContext.servletContext.contextPath }/resources/js/jquery-3.6.3.min.js"></script>
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style type="text/css">
        body table {
            font-size: 15pt;
            background-color: #f2f2f2;
            border-color: rgba(255, 255, 255, 0.2);
            border-radius: 12px;
        }

        body table tr td th {
            padding-left: 20px !important;
            text-align: left;
            background-color: white !important;
        }

        h1 {
            font-family: 'siu' !important;
        }

        #tbl {
            border-collapse: separate;
            border-spacing: 0 8px;
        }

        #tbl th {
            width: 180px;
            text-align: center;
        }
    </style>
    <script type="text/javascript">
        function withdraw() {
            $.ajax({
                type: 'POST',
                url: '${pageContext.request.contextPath}/mdel.do',
                data: {
                    user_id: '${member.user_id}'
                },
                success: function (result) {
                    alert('탈퇴가 완료되었습니다.');
                    location.href = '${pageContext.request.contextPath}/main.do';
                },
                error: function (xhr, status, error) {
                    alert('탈퇴 중 오류가 발생했습니다: ' + error);
                }
            });
        }

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
            <h1 style="font-family: 'siu'">
                <c:if test="${ member.user_admin eq 'Y' }">관리자 마이 페이지</c:if>
                <c:if test="${ member.user_admin eq 'N' }">회원 마이 페이지</c:if>
            </h1>
        </div>
    </div>
    <br>
    <div class="container" align="center">
        <div class="col-6">
            <table id="tbl" style="width: 500px;">
                <tr>
                    <th colspan="2" style="text-align: center;">
                        <c:if test="${ member.user_admin eq 'Y' }">관리자 정보</c:if>
                        <c:if test="${ member.user_admin eq 'N' }">회원 정보</c:if>
                    </th>
                </tr>
                <tr>
                    <th>이 름</th>
                    <td>${ member.user_name }</td>
                </tr>
                <tr>
                    <th>아이디</th>
                    <td>${ member.user_id }</td>
                </tr>
                <tr>
                    <th>닉네임</th>
                    <td>${ member.user_nick }</td>
                </tr>
                <tr>
                    <th>생년월일</th>
                    <td>${ member.birth }</td>
                </tr>
                <tr>
                    <th>프로필 사진</th>
                    <td>
                        <c:if test="${!empty member.user_picture}">
                            <img src="${pageContext.servletContext.contextPath}/resources/user_upfiles/${member.user_picture_rename}"
                                 style="width: 200px;">
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <th>성 별</th>
                    <td>
                        <c:if test="${ member.gender eq 'M' }">남자</c:if>
                        <c:if test="${ member.gender eq 'F' }">여자</c:if>
                    </td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td>${member.email }</td>
                </tr>
                <tr>
                    <th colspan="2" style="text-align: center;">${member.user_nick}의 반려견 정보</th>
                </tr>
                <tr>
                    <th>반려견 이름</th>
                    <td>${ member.dog_name }</td>
                </tr>
                <tr>
                    <th>반려견 생년월일</th>
                    <td>${ member.dog_birth }</td>
                </tr>
                <tr>
                    <th>반려견 종</th>
                    <td>${ member.dog_type }</td>
                </tr>
                <tr>
                    <th>반려견 성별</th>
                    <td>
                        <c:if test="${ member.dog_gender eq 'M' }">수컷</c:if>
                        <c:if test="${ member.dog_gender eq 'F' }">암컷</c:if>
                    </td>
                </tr>
                <tr>
                    <th colspan="3" style="text-align: center;">
                        <c:url var="moveup" value="/moveup.do">
                            <c:param name="user_id" value="${loginMember.user_id}"/>
                        </c:url>
                        <button onclick="location.href='${moveup}'" class="btn btn-primary">수정페이지</button>
                        <c:url var="mdel" value="/mdel.do">
                            <c:param name="user_id" value="${ loginMember.user_id }"/>
                        </c:url>
                        <button onclick="if (confirm('정말 탈퇴하시겠습니까?')) { withdraw(); } else { return false; }"
                                class="btn btn-primary">회원 탈퇴
                        </button>
                        <button onclick="location.href= '${pageContext.servletContext.contextPath}/myboardListPage.do';"
                                class="btn btn-primary">내가 쓴글 목록
                        </button>
                        <c:url var="myboardListPage" value="/myboardListPage.do">
                            <c:param name="user_id" value="${ loginMember.user_id }"/>
                        </c:url>
                    </th>
                </tr>
            </table>
        </div>
    </div>
</main>
<br style="clear: both">
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>