<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>내가 쓴 글 목록</title>
    <style type="text/css">
        .main table tr th {
            font-size: 20px;
        }

        .main table tr td {
            font-size: 18px;
        }

        table .ellipsis {
            position: relative;
            min-width: 200px;
        }

        .table .ellipsis span {
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
            position: absolute;
            left: 9px;
            right: 9px;
        }

        .ellipsis:before {
            content: '';
            display: inline-block;
        }
    </style>
</head>
<body>
<c:import url="/WEB-INF/views/common/menubar.jsp"/>
<main id="main">
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <h1 style="font-family: 'siu'">내가 쓴 글 목록</h1>
        </div>
    </div>
    <br>
    <br>
    <div class="container" align="center">
        <div class="col-9">
            <form action="myboardListPage.do">
                게시판을 선택하세요:
                <select name="boardType" style="height: 30px;">
                    <option value="daily">일상잡담</option>
                    <option value="diary">동물일기</option>
                    <option value="care">Care</option>
                    <option value="place">Place</option>
                    <option value="question">Question</option>
                </select>
                <button type="submit">선택</button>
            </form>
        </div>
        <div>
            <table class="table table-hover" style="text-align: center">
                <thead>
                <tr>
                    <th style="width: 8%">글 번호</th>
                    <th style="width: 30%">제목</th>
                    <th style="width: 30%">내용</th>
                    <th style="width: 16%">작성일</th>
                    <th style="width: 8%">좋아요 수</th>
                    <th style="width: 8%">조회수</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="board" items="${boardList}">
                    <tr>
                        <td>${board.board_no}</td>
                        <td class="ellipsis"><span>${board.board_title}</span></td>
                        <td class="ellipsis"><span>${board.board_content}</span></td>
                        <td>${board.board_date}</td>
                        <td>${board.like_count}</td>
                        <td>${board.board_count}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>
<br style="clear:both;">
<c:import url="/WEB-INF/views/common/paging.jsp"/>
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>
