<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        //이미지 체크
        function fileCheck(el) {
            if (!/\.(jpeg|jpg|png|gif|bmp)$/i.test(el.value)) {
                alert('이미지 파일만 업로드 가능합니다.');
                el.value = '';
                el.focus();
            }
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

<%-- main --%>
<main id="main">
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <h1 style="font-family: 'siu'">게시글 작성</h1>
        </div>
    </div>
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <form action="cinsert3.do" method="post" enctype="multipart/form-data">
                <input type="hidden" name="user_id" value="${ sessionScope.loginMember.user_id }">
                <table class="table table-bordered" style="text-align: center;">
                    <tr>
                        <th>제목</th>
                        <td colspan="40"><input type="text" id="board_title" name="board_title"></td>
                    <tr>
                        <th>작성자</th>
                        <td>${sessionScope.loginMember.user_nick}</td>
                    </tr>
                    <tr>
                        <th>분류</th>
                        <td>
                            <select name="category">
                                <option value="동물병원">동물병원
                                <option value="장례업체">장례업체
                                <option value="애견미용실">애견미용실
                                <option value="애견훈련소">애견훈련소
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>지역</th>
                        <td colspan="3">
                            <select name="location">
                                <option value="서울">서울
                                <option value="인천">인천
                                <option value="경기">경기
                                <option value="충남">충남
                                <option value="충북">충북
                                <option value="경남">경상
                                <option value="경북">경북
                                <option value="전남">전남
                                <option value="전북">전북
                                <option value="부산">부산
                                <option value="제주">제주
                                <option value="울산">울산
                                <option value="광주">광주
                            </select>
                        </td>
                    <tr>
                        <th>이미지</th>
                        <td colspan="3">
                            <input type="file" name="upfile" accept="image/*" onchange="fileCheck(this);"/>
                        </td>
                    </tr>

                    <tr>
                        <th>별점</th>
                        <td colspan="3">
                            <div class="star-ratings" style="float: left;">
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
                        <td colspan="3">
                            <textarea id="board_content" name="board_content" cols="77" rows="5"></textarea>
                            <br>
                            <p id="text_cnt" style="text-align: right; margin-bottom: 0;">(0 / 600) &nbsp;</p>
                        </td>
                    </tr>
                </table>
                <div class="col-12" align="right">
                    <input type="submit" value="등록" class="btn btn-primary" onclick="return send();">
                    &nbsp;
                    <input type="reset" value="취소" class="btn btn-primary"> &nbsp;
                    <button onclick="javascript:history.go(-1); return false;"
                            class="btn btn-primary">이전
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