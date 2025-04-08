<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>DogRami's Enroll Page</title>
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
            //전송 보내기전 (submit 버튼 클릭시) 입력값들이 유효한지 검사

            //암호와 암호 확인이 일치하는지 체크
            var pwd1 = document.getElementById("upwd1").value;
            var pwd2 = $('#upwd2').val();

            if (pwd1 !== pwd2) {
                alert("암호와 암호 확인이 일치하지 않습니다.\n" + "다시 입력하세요.");
                document.getElementById("upwd1").select();
                return false; //전송 안 함
            }

            return true; //전송함
        }

        //아이디 중복을 확인하기 위한 ajax 요청 처리용 함수
        //ajax(Asynchronous Javascript And Xml) :
        //페이지를 바꾸거나 새로고침하지 않고, 서버와 통신하는 기술임
        //서버로 서비스 요청하고 결과받음
        function dupCheckId() {
            var userId = $('#user_id').val().trim();
            if (userId === '') {
                alert('아이디를 입력해주세요.');
                $('#user_id').focus();
                return false;
            }

            $.ajax({
                url: "idchk.do",
                type: "post",
                data: {userid: userId},
                success: function (data) {
                    console.log("success : " + data);
                    if (data == 'ok') {
                        alert("사용 가능한 아이디입니다.");
                        $('#user_nick').focus();
                    } else {
                        alert("이미 사용중인 아이디입니다.\n다시 입력하세요.");
                        $('#user_id').select();
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log("error : " + jqXHR.responseText + ", " + textStatus + ", " + errorThrown);
                }
            });

            return false; //클릭 이벤트 해제함
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
            <h1 style="font-family: 'siu'">회원 가입 페이지</h1>
        </div>
    </div>
    <br>
    <div class="container" align="center">
        <div class="col-6">
            <form action="enroll.do" enctype="multipart/form-data" method="post" onsubmit="return validate();">

                <table id="tbl" style="width: 500px;">
                    <tr>
                        <th colspan="2" style="text-align: center;">회원정보를 입력해 주세요. (* 표시는 필수입력 항목입니다)</th>
                    </tr>
                    <tr>
                        <th colspan="2" style="text-align: center;">회원 정보</th>
                    </tr>
                    <tr>
                        <th width="120">* 이 름</th>
                        <td><input type="text" name="user_name" required></td>
                    </tr>
                    <tr>
                        <th width="120">* 아이디</th>
                        <td><input type="text" name="user_id" id="user_id" required>
                            &nbsp; &nbsp; <input type="button" value="중복확인"
                                                 onclick="return dupCheckId();"></td>
                    </tr>
                    <tr>
                        <th width="120">* 닉네임</th>
                        <td><input type="text" name="user_nick" required></td>
                    </tr>
                    <tr>
                        <th width="120">* 비밀번호</th>
                        <td><input type="password" name="user_pwd" id="upwd1"
                                   required></td>
                    </tr>
                    <tr>
                        <th width="120">* 비밀번호 확인</th>
                        <td><input type="password" id="upwd2" required></td>
                    </tr>
                    <tr>
                        <th width="120">* 생년월일</th>
                        <td><input type="date" name="birth" required></td>
                    </tr>
                    <tr>
                        <th width="120">프로필 사진</th>
                        <td><input type="file" name="upfile" accept="image/*" onchange="fileCheck(this);"></td>
                    </tr>
                    <tr>
                        <th width="120">* 회원 성별</th>
                        <td><input type="radio" name="gender" value="M" required>
                            남자 &nbsp; <input type="radio" name="gender" value="F" required>
                            여자
                        </td>
                    </tr>
                    <tr class="separator">
                        <th class="email" width="120">* 이메일</th>
                        <td><input type="email" name="email" required></td>
                    </tr>
                    <tr>
                        <th colspan="2" style="text-align: center;">반려견 정보</th>
                    </tr>
                    <tr>
                        <th width="120">반려견 이름</th>
                        <td><input type="text" name="dog_name"></td>
                    </tr>
                    <tr>
                        <th width="120">반려견 생년월일</th>
                        <td><input type="date" name="dog_birth"></td>
                    </tr>
                    <tr>
                        <th width="120">반려견 종</th>
                        <td><input type="text" name="dog_type"></td>
                    </tr>
                    <tr>
                        <th width="120">반려견 성별</th>
                        <td><input type="radio" name="dog_gender" value="M">
                            수컷 &nbsp; <input type="radio" name="dog_gender" value="F">
                            암컷
                        </td>
                    </tr>
                    <tr>
                        <th colspan="2" style="text-align: center;">
                            <button type="submit" class="btn btn-primary">가입하기</button>
                            <button type="reset" class="btn btn-primary">작성취소</button>
                            <button onclick="location.href='main.do'" class="btn btn-primary">메인</button>
                        </th>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</main>
<br style="clear:both;">
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>