<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="careBoard" value="${ requestScope.careBoard }"/>
<c:set var="currentPage" value="${ requestScope.currentPage }"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style type="text/css">
        .star-rating {
            display: flex;
            flex-direction: row-reverse;
            font-size: 2.25rem;
            line-height: 2.5rem;
            justify-content: space-around;
            padding: 0 0.2em;
            text-align: center;
            width: 5em;
        }

        .star-rating input {
            display: none;
        }

        .star-rating label {
            -webkit-text-fill-color: transparent; /* Will override color (regardless of order) */
            -webkit-text-stroke-width: 2.3px;
            -webkit-text-stroke-color: #2b2a29;
            cursor: pointer;
        }

        .star-rating :checked ~ label {
            -webkit-text-fill-color: gold;
        }

        .star-rating label:hover,
        .star-rating label:hover ~ label {
            -webkit-text-fill-color: #fff58c;
        }

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
            if ($('#board_title').val() == '') {
                alert("제목을 입력하세요");
                return false;
            }
            if ($('#board_content').val() == '') {
                alert("내용을 입력하세요");
                return false;
            }
            return true;
        }

        $(document).ready(function () {
            $('#board_content').on('keyup', function () {
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
<c:import url="../common/menubar.jsp"/>

<main id="main">
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <h1 style="font-family: 'siu'">${placeBoard.board_title }</h1>
        </div>
    </div>
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <form action="pboardUpdate3.do" method="post" enctype="multipart/form-data">
                <input type="hidden" name="board_no" value="${ placeBoard.board_no }">
                <input type="hidden" name="page" value="${ currentPage }">
                <table class="table table-bordered" style="text-align: center;">
                    <tr>
                        <th>제목</th>
                        <td><input type="text" id="board_title" name="board_title" value="${ placeBoard.board_title }">
                        </td>
                    </tr>

                    <tr>
                        <th>작성자</th>
                        <input type="hidden" name="user_id" readonly value="${ placeBoard.user_id }">
                        <td>${sessionScope.loginMember.user_nick}</td>
                    </tr>
                    <tr>
                        <th>분류</th>
                        <td><select name="category">
                            <option value="${placeBoard.category}">분류
                            <option value="애견호텔">애견호텔
                            <option value="애견동반카페">애견동반카페
                            <option value="애견동반숙소">애견동반숙소
                            <option value="애견동반음식점">애견동반음식점
                        </select></td>
                    </tr>
                    <tr>
                        <th>지역</th>
                        <td>
                            <select name="location">
                                <option value="${placeBoard.location}">지역
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
                        </td>

                    <tr>
                        <th>이미지</th>
                        <td>
                            <!-- 이미지파일이 있는경우, 삭제기능 추가 -->
                            <c:if test="${ !empty placeBoard.image }">
                                <input type="hidden" name="image" value="${placeBoard.image}">
                                <input type="hidden" name="new_image" value="${placeBoard.new_image}">
                                <img src="${ pageContext.servletContext.contextPath }/resources/placeBoard_upfiles/${placeBoard.new_image}">
                                <input type="checkbox" name="delfile" value="yes">파일삭제
                                <br>
                            </c:if>
                            <input type="file" name="upfile">
                        </td>
                    </tr>
                    <tr>
                        <th>별점</th>
                        <td>
                            <div class="star-ratings">
                                <div class="star-rating space-x-4 mx-auto">
                                    <input type="radio" id="5-stars" name="star_point" value="5" v-model="ratings"/>
                                    <label for="5-stars" class="star pr-4">★</label>
                                    <input type="radio" id="4-stars" name="star_point" value="4" v-model="ratings"/>
                                    <label for="4-stars" class="star">★</label>
                                    <input type="radio" id="3-stars" name="star_point" value="3" v-model="ratings"/>
                                    <label for="3-stars" class="star">★</label>
                                    <input type="radio" id="2-stars" name="star_point" value="2" v-model="ratings"/>
                                    <label for="2-stars" class="star">★</label>
                                    <input type="radio" id="1-star" name="star_point" value="1" v-model="ratings"/>
                                    <label for="1-star" class="star">★</label>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <script type="text/javascript">$('#board_content').val().replace(/(?:\r\n|\r|\n)/g, '<br/>')</script>
                    <tr>
                        <th style="vertical-align: middle; width: 20%">내용</th>
                        <td>
                            <textarea id="board_content" name="board_content" rows="5"
                                      cols="77">${ placeBoard.board_content }</textarea>
                            <br>
                            <p id="text_cnt" style="text-align: right; margin-bottom: 0;">(0 / 600) &nbsp;</p>
                        </td>
                    </tr>
                </table>
                <div class="col-12" align="right">
                    <input type="submit" value="수정" class="btn btn-primary" onclick="return send();"> &nbsp;
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

<c:import url="../common/footer.jsp"/>
</body>
</html>