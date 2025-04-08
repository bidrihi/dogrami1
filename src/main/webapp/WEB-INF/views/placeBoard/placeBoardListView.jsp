<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="listCount" value="${ requestScope.paging.listCount }"/>
<c:set var="currentPage" value="${ requestScope.paging.currentPage }"/>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <c:import url="../common/menubar.jsp"/>

    <style type="text/css">

        form.sform {
            display: none; /* 안 보이게 설정 */
        }


        .star {
            -webkit-text-fill-color: #fff58c
        }

        .star {
            font-size: 2.25rem;
            line-height: 2.5rem;
            padding: 0 0.2em;
            text-align: center;
            width: 5em;
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
    <script src="https://kit.fontawesome.com/86f3c6d543.js" crossorigin="anonymous"></script>
    <script type="text/javascript">

        $(function () {

            $('select[name=item]').on('change', function () {

                var selectedValue = $(this).val();

                $('form.sform').css('display', 'none');	//클래스가 sform 인 폼을 일단 안보이게함

                switch (selectedValue) {
                    case 'uid':
                        $('#idform').css('display', 'inline-block');
                        break;
                    case 'btitle':
                        $('#titform').css('display', 'inline-block');
                        break;
                    case 'bcontent':
                        $('#conform').css('display', 'inline-block');
                        break;
                }
                /*  if(selectValue == 'uid'){
                    $('#idform').css('display', 'inline-block');	//작성자아이디
                }else if(selectValue == 'btitle'){
                    $('#titform').css('display', 'inline-block');	//제목
                }else if(selectValue == 'bcontent'){
                    $('#conform').css('display', 'inline-block');	//내용
                }   */

            });	//serach change

            $(function () {

                $('select[name=location]').on('change', function () {
                    document.getElementById("loca").submit();

                });//location change

            });
        });	//document.ready


    </script>

</head>
<body>
<main id="main">
    <br>

    <div class="container" align="center">
        <div class="col-9">
            <a href="${ pageContext.servletContext.contextPath }/plist3.do"><h1 style="font-family: 'siu'">Place 후기</h1>
            </a>
        </div>
    </div>
    <br>
    <div class="container" align="center">
        <div class="col-9" align="left">
            <form action="placeLocation3.do" method="post" id="loca">
                <select name="location" style="height: 30px; font-size: 13pt;">
                    <option value="${requestScope.location}" selected="selected">지역선택
                    <option value="서울">서울
                    <option value="인천">인천
                    <option value="경기도">경기도
                    <option value="충청도">충청도
                    <option value="전라도">전라도
                    <option value="경상도">경상도
                    <option value="부산">부산
                    <option value="제주">제주
                    <option value="울산">울산
                    <option value="광주">광주
                </select>
                <input type=submit value="" style="background-color:transparent; border: 0 transparent solid;">
            </form>
        </div>
    </div>
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <table class="table table-hover" style="text-align: center;">
                <thead>
                <tr>
                    <th style="width: 60px;">번호</th>
                    <th>제목</th>
                    <th style="width: 100px">분류</th>
                    <th style="width: 60px;">지역</th>
                    <th style="width: 100px;">작성자</th>
                    <th style="width: 130px;">날짜</th>
                    <th style="width: 60px;">조회수</th>
                    <th style="width: 50px;">별점</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${ requestScope.list }" var="c" varStatus="status">
                    <tr>
                        <td>${ c.board_no }</td>

                        <c:url var="pdt" value="/pdetail3.do">
                            <c:param name="board_no" value="${ c.board_no }"/>
                            <c:param name="page" value="${ currentPage }"/>
                        </c:url>

                        <!-- 제목으로 상세보기 들어가기 -->
                        <td><a href="${ pdt }">${ c.board_title }</a></td>

                        <td>${ c.category }</td>

                        <td>${ c.location }</td>

                        <td>${ c.member.user_nick }</td>

                        <td><fmt:formatDate value="${ c.board_date }" pattern="yyyy-MM-dd"/></td>

                        <td>${c.board_count }</td>

                        <td class="star">
                            <c:if test="${c.star_point eq 0}">&nbsp;</c:if>
                            <c:if test="${c.star_point eq 1}">★</c:if>
                            <c:if test="${c.star_point eq 2}">★★</c:if>
                            <c:if test="${c.star_point eq 3}">★★★</c:if>
                            <c:if test="${c.star_point eq 4}">★★★★</c:if>
                            <c:if test="${c.star_point eq 5}">★★★★★</c:if>

                            <!-- 관리자일시 삭제처리 가능하게끔  -->
                            <c:if test="${loginMember.user_admin eq 'Y'}">
                        <td style="width: 70px;">
                            <c:url var="pdelete" value="/pdelete3.do">
                                <c:param name="board_no" value="${c.board_no }"/>
                                <c:param name="page" value="${currentPage }"/>
                            </c:url>
                            <a href="${pdelete}" class="btn btn-primary">삭제</a>
                        </td>
                        </c:if>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <hr>
            <!-- 로그인한 회원만 게시글 등록(글쓰기) 버튼이 보이게 함 -->
            <div class="col-12" align="right">
                <c:if test="${!empty sessionScope.loginMember}">
                    <input type="button" onclick="javascript:location.href='pwform3.do';" class="btn btn-primary"
                           value="글쓰기">
                </c:if>
            </div>

            <form action="placeSearch3.do" name="search" method="post">
                <table>
                    <tr>
                        <td>
                            <select name="action" style="height: 30px;">
                                <option value="board_title">제목</option>
                                <option value="user_nick">작성자</option>
                                <option value="board_content">내용</option>
                                <option value="category">분류</option>
                            </select>
                        </td>
                        <td>
                            <input type="search" name="keyword" placeholder="Search">
                        </td>
                        <td>
                            <input type="submit" value="검색">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</main>

<c:set var="url" value="/plist3.do"/>
<c:import url="/WEB-INF/views/common/paging.jsp"/>
<c:import url="../common/footer.jsp"/>
</body>
</html>