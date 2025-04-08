<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <style type="text/css">
    </style>
    <script type="text/javascript"
            src="${pageContext.servletContext.contextPath}/resources/js/jquery-3.6.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var values = $('#topcontest').html();
            $.ajax({
                url: "contop4.do",
                type: "post",
                dataType: "json",
                success: function (data) {
                    var jsonStr = JSON.stringify(data);
                    var json = JSON.parse(jsonStr);

                    for (var i in json.list) {
                        values += "<div class='swiper-slide'><a class='img-bg d-flex align-items-end' " +
                            "style='background-image: url(\"${pageContext.servletContext.contextPath}/resources/contest_upfiles/"
                            + json.list[i].contest_newfile + "\")' href='contestdetail.do?contest_no="
                            + json.list[i].contest_no + "'><div class='img-bg-inner'><h2 style='font-family: \"siu\"'>"
                            + decodeURIComponent(json.list[i].contest_title).replace(/\+/gi, " ") +
                            "</h2><p>" + decodeURIComponent(json.list[i].contest_content).replace(/\+/gi, " ") + "</p></div></a></div>";
                    }

                    $('#topcontest').html(values);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log("contop4.do error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
                }
            });

            var values2 = $('#newcontest').html();
            $.ajax({
                url: "connew5.do",
                type: "post",
                dataType: "json",
                success: function (data) {
                    var jsonStr = JSON.stringify(data);
                    var json = JSON.parse(jsonStr);

                    for (var i in json.list) {
                        values2 += "<tr><td><a href='contestdetail.do?contest_no=" + json.list[i].contest_no + "'>"
                            + decodeURIComponent(json.list[i].contest_title).replace(/\+/gi, " ") +
                            "</td><td>" + json.list[i].like_count + "</td><td>" + json.list[i].contest_date + "</td></tr>";
                    }

                    $('#newcontest').html(values2);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log("connew5.do error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
                }
            });

            var values3 = $('#newplace').html();
            $.ajax({
                url: "placenew5.do",
                type: "post",
                dataType: "json",
                success: function (data) {
                    var jsonStr = JSON.stringify(data);
                    var json = JSON.parse(jsonStr);

                    for (var i in json.list) {
                        values3 += "<tr><td><a href='pdetail3.do?board_no=" + json.list[i].board_no + "'>"
                            + decodeURIComponent(json.list[i].board_title).replace(/\+/gi, " ") +
                            "</a></td><td>" + decodeURIComponent(json.list[i].category).replace(/\+/gi, " ") +
                            "</td><td>" + decodeURIComponent(json.list[i].location).replace(/\+/gi, " ") +
                            "</td><td>" + json.list[i].board_date + "</td></tr>";
                    }

                    $('#newplace').html(values3);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log("placenew5.do error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
                }
            });

            var values4 = $('#newcare').html();
            $.ajax({
                url: "carenew5.do",
                type: "post",
                dataType: "json",
                success: function (data) {
                    var jsonStr = JSON.stringify(data);
                    var json = JSON.parse(jsonStr);

                    for (var i in json.list) {
                        values4 += "<tr><td><a href='cdetail3.do?board_no=" + json.list[i].board_no + "'>" + decodeURIComponent(json.list[i].board_title).replace(/\+/gi, " ") +
                            "</a></td><td>" + decodeURIComponent(json.list[i].category).replace(/\+/gi, " ") +
                            "</td><td>" + decodeURIComponent(json.list[i].location).replace(/\+/gi, " ") +
                            "</td><td>" + json.list[i].board_date + "</td></tr>";
                    }

                    $('#newcare').html(values4);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log("carenew5.do error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
                }
            });
        });
    </script>
</head>
<c:import url="/WEB-INF/views/common/menubar.jsp"/>
<body>
<main id="main">
    <!-- ======= Hero Slider Section ======= -->
    <section id="hero-slider" class="hero-slider">
        <div class="container-md">
            <div class="row">
                <div class="col-12">
                    <div class="swiper sliderFeaturedPosts">
                        <div id="topcontest" class="swiper-wrapper">
                        </div>
                        <%-- 오른쪽 버튼 --%>
                        <div class="custom-swiper-button-next">
                            <span class="bi-chevron-right"></span>
                        </div>
                        <%-- 왼쪽 버튼 --%>
                        <div class="custom-swiper-button-prev">
                            <span class="bi-chevron-left"></span>
                        </div>
                        <%-- 아래 표시(페이징) --%>
                        <div class="swiper-pagination"></div>
                    </div>
                </div>
            </div>
            <br>
            <div class="container" style="display:inline-flex; justify-content: space-between;">
                <div style="text-align: center">
                    <h4 style="font-family: 'siu">Contest 최신글</h4>
                    <table id="newcontest" class="table table-bordered" style="text-align: center">
                        <tr style="background-color: #f2f2f2;">
                            <th>제목</th>
                            <th>좋아요</th>
                            <th>날짜</th>
                        </tr>
                    </table>
                </div>
                <div style="text-align: center">
                    <h4 style="font-family: 'siu">Place 최신글</h4>
                    <table id="newplace" class="table table-bordered" style="text-align: center">
                        <tr style="background-color: #f2f2f2;">
                            <th>제목</th>
                            <th>분류</th>
                            <th>지역</th>
                            <th>날짜</th>
                        </tr>
                    </table>
                </div>
                <div style="text-align: center">
                    <h4 style="font-family: 'siu">Care 최신글</h4>
                    <table id="newcare" class="table table-bordered" style="text-align: center">
                        <tr style="background-color: #f2f2f2;">
                            <th>제목</th>
                            <th>분류</th>
                            <th>지역</th>
                            <th>날짜</th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </section><!-- End Hero Slider Section -->
</main><!-- End #main -->

<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>
