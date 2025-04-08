<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <c:import url="/WEB-INF/views/common/menubar.jsp"/>
    <meta charset="UTF-8">
    <style type="text/css">
        form.sform {
            display: none; /* 안 보이게 설정 */
        }

        .main table tr th {
            font-size: 20px;
        }

        .main table tr td {
            font-size: 18px;
        }
    </style>
    <script type="text/javascript"
            src="${ pageContext.servletContext.contextPath }/resources/js/jquery-3.6.3.min.js"></script>
    <script type="text/javascript">

        $(function () {

            $('select[name=item]').on('change', function () {
                //change 이벤트가 발생한 select 와 셀렉된 폼만
                //보여지게 하고, 나머지 폼들은 안보이게 처리함
                var selectedValue = $(this).val();

                $('form.sform').css('display', 'none');
                switch (selectedValue) {
                    case 'uid':
                        $('#idform').css('display', 'inline-block');
                        break;
                    case 'uname':
                        $('#nameform').css('display', 'inline-block');
                        break;
                    case 'unick':
                        $('#nickform').css('display', 'inline-block');
                        break;
                    case 'uadmin':
                        $('#adminform').css('display', 'inline-block');
                        break;
                    case 'ulogin':
                        $('#loginform').css('display', 'inline-block');
                        break;
                }
            });  //on

        }); //document.ready

        //로그인 제한/가능 라디오 체크가 변경되었을 때 실행되는 함수임
        function changeLogin(element) {
            //선택한 radio의 name 속성의 이름에서 userid 분리 추출함
            var user_id = element.name.substring(12);
            console.log("changeLogin : " + user_id);

            if (element.checked == true && element.value == "N") {
                //로그인 제한을 체크했다면
                console.log("로그인 제한 체크함");
                location.href = "${ pageContext.servletContext.contextPath }/login_limit.do?user_id="
                    + user_id + "&login_limit=N";
            } else {
                //로그인 가능을 체크했다면
                console.log("로그인 가능 체크함");
                location.href = "${ pageContext.servletContext.contextPath }/login_limit.do?user_id="
                    + user_id + "&login_limit=Y";
            }
        }

        function changeAdmin(element) {
            //선택한 checkbox name 속성의 이름에서 userid 분리 추출함
            var user_id = element.name.substring(11);
            console.log("changeAdmin : " + user_id);

            if (element.checked == true) {
                //체크했다면
                console.log("관리자 권한 부여함");
                location.href = "${ pageContext.servletContext.contextPath }/user_admin.do?user_id="
                    + user_id + "&user_admin=Y";
            } else {
                //체크해재했다면
                console.log("관리자 권한 회수함");
                location.href = "${ pageContext.servletContext.contextPath }/user_admin.do?user_id="
                    + user_id + "&user_admin=N";
            }
        }
    </script>
</head>
<body>
<main id="main">
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <h1 style="font-family: 'siu'">회원 관리 페이지</h1>
        </div>
    </div>
    <br>
    <br>
    <div class="container" align="center">
        <div class="col-12">
            <table class="table table-hover" style="text-align: center;">
                <thead>
                <tr style="text-align: left">
                    <td colspan="12">
                        <div id="search-container" style="display: inline-block;">
                            <!-- 항목별 검색 기능 -->
                            <select name="item" id="ss" style="display: inline-block; height: 30px;">
                                <option value="">분류</option>
                                <option value="uid">아이디</option>
                                <option value="uname">이름</option>
                                <option value="unick">닉네임</option>
                                <option value="uadmin">관리자여부</option>
                                <option value="ulogin">로그인 제한여부</option>
                            </select>
                            <!-- 아이디 검색 폼 -->
                            <form action="${ pageContext.servletContext.contextPath }/msearch2.do"
                                  method="post" id="idform" class="sform">
                                <input type="hidden" name="action" value="user_id">
                                <input type="search" name="keyword"> &nbsp;
                                <input type="submit" value="검색">
                            </form>

                            <!-- 이름 검색 폼 -->
                            <form action="${ pageContext.servletContext.contextPath }/msearch2.do"
                                  method="post" id="nameform" class="sform">
                                <input type="hidden" name="action" value="user_name">
                                <input type="search" name="keyword"> &nbsp;
                                <input type="submit" value="검색">
                            </form>

                            <!-- 닉네임 검색 폼 -->
                            <form action="${ pageContext.servletContext.contextPath }/msearch2.do"
                                  method="post" id="nickform" class="sform">
                                <input type="hidden" name="action" value="user_nick">
                                <input type="search" name="keyword"> &nbsp;
                                <input type="submit" value="검색">
                            </form>

                            <!-- 관리자여부 검색 폼 -->
                            <form action="${ pageContext.servletContext.contextPath }/msearch2.do"
                                  method="post" id="adminform" class="sform">
                                <input type="hidden" name="action" value="user_admin">
                                <input type="radio" name="keyword" value="Y"> 관리자
                                &nbsp; <input type="radio" name="keyword" value="N"> 일반
                                <input type="submit" value="검색">
                            </form>

                            <!-- 로그인제한 여부 검색 폼 -->
                            <form action="${ pageContext.servletContext.contextPath }/msearch2.do"
                                  method="post" id="loginform" class="sform">
                                <input type="hidden" name="action" value="login_limit">
                                <input type="radio" name="keyword" value="Y"> 가능
                                &nbsp; <input type="radio" name="keyword" value="N"> 제한
                                <input type="submit" value="검색">
                            </form>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>닉네임</th>
                    <th>이메일</th>
                    <th>생년월일</th>
                    <th>성별</th>
                    <th>반려견 이름</th>
                    <th>반려견 생년월일</th>
                    <th>반려견 종</th>
                    <th>반려견 성별</th>
                    <th>관리자 여부</th>
                    <th>로그인 제한여부</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ requestScope.list }" var="m">
                    <tr>
                        <td>${ m.user_id }</td>
                        <td>${ m.user_name }</td>
                        <td>${ m.user_nick }</td>
                        <td>${ m.email }</td>
                        <td>${ m.birth }</td>
                        <td>${ m.gender }</td>
                        <td>${ m.dog_name }</td>
                        <td>${ m.dog_birth }</td>
                        <td>${ m.dog_type }</td>
                        <td>${ m.dog_gender }</td>
                        <td>
                            <c:if test="${ m.user_admin eq 'Y' }">
                                <input type="checkbox" name="user_admin_${ m.user_id }"
                                       value="Y" checked onchange="changeAdmin(this);"> 관리자
                            </c:if>
                            <c:if test="${ m.user_admin eq 'N' }">
                                <input type="checkbox" name="user_admin_${ m.user_id }"
                                       value="Y" onchange="changeAdmin(this);"> 관리자
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${ m.login_limit eq 'Y' }">
                                <input type="radio" name="login_limit_${ m.user_id }"
                                       value="Y" checked onchange="changeLogin(this);"> 가능 &nbsp;
                                <input type="radio" name="login_limit_${ m.user_id }"
                                       value="N" onchange="changeLogin(this);"> 제한
                            </c:if>
                            <c:if test="${ m.login_limit eq 'N' }">
                                <input type="radio" name="login_limit_${ m.user_id }"
                                       value="Y" onchange="changeLogin(this);"> 가능 &nbsp;
                                <input type="radio" name="login_limit_${ m.user_id }"
                                       value="N" checked onchange="changeLogin(this);"> 제한
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="col-12" align="center">
                <button onclick="javascript:location.href='${ pageContext.servletContext.contextPath }/mlist2.do';" class="btn btn-primary">전체 보기</button>
            </div>
        </div>
    </div>
</main>
<br style="clear: both">
<c:import url="/WEB-INF/views/common/paging.jsp"/>
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>