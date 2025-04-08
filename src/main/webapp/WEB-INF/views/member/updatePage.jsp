<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
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
    <script type="text/javascript"
            src="${ pageContext.servletContext.contextPath }/resources/js/jquery-3.6.3.min.js"></script>
    <script type="text/javascript">
        function validate() {
            // 캐시 사용을 막기 위해 응답 헤더를 수정
            $.ajaxSetup({
                cache: false
            });
            //암호확인의 포커스가 사라질 때
            //암호와 암호 확인이 일치하는지 체크
            var pwd1 = document.getElementById("upwd1").value;
            var pwd2 = $('#upwd2').val();

            if (pwd1 !== pwd2) {
                alert("암호와 암호 확인이 일치하지 않습니다.\n" + "다시 입력하세요.");
                document.getElementById("upwd1").value = "";
                document.getElementById("upwd2").value = "";
                document.getElementById("upwd1").focus();
                return false;
            } else { // 비밀번호가 일치하면 true 반환
                return true;
            }
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
                <c:if test="${ member.user_admin eq 'Y' }">관리자 정보 수정페이지</c:if>
                <c:if test="${ member.user_admin eq 'N' }">회원 정보 수정페이지</c:if>
            </h1>
        </div>
    </div>
    <br>
    <div class="container" align="center">
        <div class="col-6">
            <form action="mupdate.do" enctype="multipart/form-data" method="post">
                <input type="hidden" name="user_id" value="${member.user_id}">
                <input type="hidden" name="origin_user_pwd" value="${member.user_pwd}">
                <c:if test="${!empty member.user_picture}">
                    <input type="hidden" name="user_picture" value="${member.user_picture}">
                    <input type="hidden" name="user_picture_rename" value="${member.user_picture_rename}">
                </c:if>
                <table id="tbl" style="width: 500px;">
                    <tr>
                        <th>이 름</th>
                        <td><input type="text" name="user_name" value="${ member.user_name }"></td>
                    </tr>
                    <tr>
                        <th>아이디</th>
                        <td>${ member.user_id }</td>
                    </tr>
                    <tr>
                        <th>닉네임</th>
                        <td><input type="text" name="user_nick" value="${ member.user_nick }"></td>
                    </tr>
                    <tr>
                        <th>새 비밀번호</th>
                        <td><input type="password" name="user_pwd" id="upwd1"></td>
                    </tr>
                    <tr>
                        <th>새 비밀번호 확인</th>
                        <td><input type="password" id="upwd2" onblur="validate();"></td>
                    </tr>
                    <tr>
                        <th>생년월일</th>
                        <td><input type="date" name="birth" value="${ member.birth }"></td>
                    </tr>
                    <tr>
                        <th>프로필 사진</th>
                        <td>
                            <c:if test="${ !empty member.user_picture }">
                                ${ member.user_picture } &nbsp;
                                <input type="checkbox" name="delfile" value="yes"> 파일삭제
                                <br>
                            </c:if>
                            <input type="file" name="upfile">
                        </td>
                    </tr>
                    <tr>
                        <th>성 별</th>
                        <td>
                            <c:if test="${ member.gender eq 'M' }">
                                <input type="radio" name="gender" value="M" checked> 남자&nbsp;
                                <input type="radio" name="gender" value="F"> 여자
                            </c:if>
                            <c:if test="${ member.gender eq 'F' }">
                                <input type="radio" name="gender" value="M"> 남자 &nbsp;
                                <input type="radio" name="gender" value="F" checked> 여자
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td><input type="email" name="email" value="${ member.email }"></td>
                    </tr>
                    <tr>
                        <th colspan="2" style="text-align: center;">반려견 정보</th>
                    </tr>
                    <tr>
                        <th>반려견 이름</th>
                        <td><input type="text" name="dog_name" value="${ requestScope.member.dog_name }"></td>
                    </tr>
                    <tr>
                        <th>반려견 생년월일</th>
                        <td><input type="date" name="dog_birth" value="${ member.dog_birth }"></td>
                    </tr>
                    <tr>
                        <th>반려견 종</th>
                        <td><input type="text" name="dog_type" value="${ member.dog_type }"></td>
                    </tr>
                    <tr>
                        <th>반려견 성별</th>
                        <td>
                            <!-- 반려견 성별 미 입력했을 경우 -->
                            <c:if test="${not empty member.dog_gender and member.dog_gender eq 'M'}">
                                <input type="radio" name="dog_gender" value="M" checked> 수컷 &nbsp;
                                <input type="radio" name="dog_gender" value="F"> 암컷
                            </c:if>
                            <!-- 반려견 성별 수컷을 입력했을 경우 -->
                            <c:if test="${not empty member.dog_gender and member.dog_gender eq 'F'}">
                                <input type="radio" name="dog_gender" value="M"> 수컷 &nbsp;
                                <input type="radio" name="dog_gender" value="F" checked> 암컷
                            </c:if>
                            <!-- 반려견 성별 암컷을 입력했을 경우 -->
                            <c:if test="${empty member.dog_gender}">
                                <input type="radio" name="dog_gender" value="M"> 수컷 &nbsp;
                                <input type="radio" name="dog_gender" value="F"> 암컷
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center;">
                            <button type="submit" class="btn btn-primary">수정하기</button>
                            <button type="reset" onclick="history.back()" class="btn btn-primary">수정취소</button>
                            <button onclick="location.href='main.do'" class="btn btn-primary">메인</button>
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