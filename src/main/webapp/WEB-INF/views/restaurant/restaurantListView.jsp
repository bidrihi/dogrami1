<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<c:set var="listCount" value="${ requestScope.paging.listCount }"/>
<c:set var="currentPage" value="${ requestScope.paging.currentPage }"/>

<html>
<head>
    <meta charset="UTF-8">
    <title>애견 동반 음식점</title>
    <c:import url="../common/menubar.jsp"/>
    <style type="text/css">
        .main table tr th {
            font-size: 20px;
        }

        .main table tr td {
            font-size: 18px;
        }

        div#map2 {
            margin: 0 auto;
            left: 200px;
            bottom: -100px;
        }

        /* div#map {
            margin: 0 auto;
            left: 200px;
            bottom: -100px;
        } */

        div#search {
            float: left;
        }

        div#container {
            margin: 0 auto;
            width: 50%;
        }

        table#li {
            border-collapse: collapse;
            width: 100%;
        }

        th#li, td#li {
            text-align: center;
            padding: 8px;
            border: 1px solid #ddd;
        }

        tr#li:nth-child(even) {
            background-color: #f2f2f2;
        }

        /* 테이블 스크롤바 디자인 */
        .table-container::-webkit-scrollbar {
            width: 8px;
            background-color: #f5f5f5;
        }

        .table-container::-webkit-scrollbar-thumb {
            background-color: #000000;
            border-radius: 10px;
        }

        /* 검색창 디자인 */
        input[type=search] {
            width: 300px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: none;
            outline: none;
        }

        #search {
            margin-top: 20px;
            margin-bottom: 20px;
            text-align: center;
            position: relative;
            left: 300px;
        }

        .table-container {
            width: 100%;
            height: 600px;
            overflow: auto;
        }

        /* 스크롤바 가리기 */
        div#list {
            -ms-overflow-style: none;
            scrollbar-width: none;

        }

        div#list::-webkit-scrollbar {
            display: none; /* Chrome , Safari , Opera */
        }
    </style>
</head>
<body>
<br>
<main id="main">
    <div class="container" align="center">
        <div class="col-9">
            <!-- <table id="11" style="float:left;"> -->
            <a href="${ pageContext.servletContext.contextPath }/restaurantMap3.do"><h1
                    style="font-family: 'siu'">애견 동반 음식점</h1></a>
        </div>
    </div>
    <br>
    <div class="container" align="center">
        <table>
            <tr>
                <td><input style="width:250px; height:70px; font-size: 16pt;" class="btn btn-primary" type="button"
                           value="애견 동반 카페"
                           onclick="javascript:location.href='${pageContext.servletContext.contextPath}/cafeMap3.do';">
                </td>
                <td><input style="width:250px; height:70px; font-size: 16pt;" class="btn btn-primary" type="button"
                           value="애견 호텔"
                           onclick="javascript:location.href='${pageContext.servletContext.contextPath}/hotelMap3.do';">
                </td>
                <td><input style="width:250px; height:70px; font-size: 16pt;" class="btn btn-primary" type="button"
                           value="애견 동반 숙소"
                           onclick="javascript:location.href='${pageContext.servletContext.contextPath}/guesthouseMap3.do';">
                </td>
            </tr>
        </table>
        <br>
        <form action="restaurantSearch3.do" method="post" id="searchbar">
            &nbsp; <input type="search" name="location" placeholder="지역으로 검색"
                          style="width: 700px;"> <input type="submit"
                                                        class="btn btn-primary" value="검색">
        </form>
    </div>
    <br>
    <div class="container d-flex justify-content-center" align="center" style="display: inline-flex;">
        <div class="col-9" id="list" align="center" style="overflow: scroll; width: 800px; height: 1200px;">
            <table class="table table-striped" style="text-align: center; width: 800px;">
                <thead>
                <tr>
                    <th style="width: 250px;">업체명</th>
                    <th style="width: 400px;">주소</th>
                    <th style="width: 150px;">전화번호</th>
                </tr>
                </thead>
                <c:forEach var="location" items="${ requestScope.list }">
                    <tr id="li">
                        <c:if test="${ !empty location.address }">
                            <td>${ location.name }&nbsp;</td>
                            <td>${ location.address }&nbsp;</td>
                            <td>${ location.phone }&nbsp;</td>
                        </c:if>
                        <c:if
                                test="${ empty location.address && !empty location.address2 }">
                            <td>${ location.name }&nbsp;</td>
                            <td>${ location.address2 }&nbsp;</td>
                            <td>${ location.phone }&nbsp;</td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
            <c:import url="/WEB-INF/views/common/paging.jsp"/>
        </div>
        <div id="map2" align="center">
            <div id="map" style="width: 800px; height: 1200px; display: inline-flex;">
                <script type="text/javascript"
                        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ebb0ba6eeffeb77cf945f3cdee78f530&libraries=clusterer"></script>
                <script type="text/javascript">

                    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                        mapOption = {
                            center: new kakao.maps.LatLng(36.3911, 127.9253), // 지도의 중심좌표
                            level: 12 // 지도의 확대 레벨
                        };

                    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
                    var infowindow = new kakao.maps.InfoWindow({zIndex: 1});   //마커를 표시할 인포 윈도우
                    // 마커를 표시할 위치와 title 객체 배열입니다
                    var positions = [
                        <c:forEach var="map" items="${requestScope.list}">
                        {
                            name: '${map.name}',
                            latlng: new kakao.maps.LatLng(${map.latitude}, ${map.longitude}),
                            address: '${map.address}',
                            address2: '${map.address2}',
                            phone: '${map.phone}'
                        },
                        </c:forEach>
                    ];
                    console.log(positions.length);//갯수확인
                    // 마커 이미지의 이미지 주소입니다
                    var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

                    //마커 객체를 저장할 배열
                    var markers = [];

                    for (var i = 0; i < positions.length; i++) {

                        // 마커 이미지의 이미지 크기 입니다
                        var imageSize = new kakao.maps.Size(24, 35);

                        // 마커 이미지를 생성합니다
                        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

                        // 마커를 생성합니다
                        var marker = new kakao.maps.Marker({
                            map: map, // 마커를 표시할 지도
                            position: positions[i].latlng, // 마커를 표시할 위치
                            title: positions[i].name, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다

                            image: markerImage // 마커 이미지
                        });

                        // 마커에 mouseover 이벤트를 등록합니다
                        kakao.maps.event.addListener(marker, 'mouseover', (function (marker, position) {
                            return function () {
                                // mouseover 시 인포윈도우에 표시할 내용입니다
                                var content = '<div style="padding:10px; font-size:15px; width:300px; height:150px;">';
                                content += '<strong>' + position.name + '</strong><br>';
                                content += '소재지주소: ' + position.address + '<br>';
                                content += '도로명주소: ' + position.address2 + '<br>';
                                content += '전화번호: ' + position.phone + '</div>';

                                // 인포윈도우에 표시할 내용을 설정합니다
                                infowindow.setContent(content);

                                // 인포윈도우를 엽니다
                                infowindow.open(map, marker);

                                // 마커에 mouseout 이벤트를 등록합니다
                                kakao.maps.event.addListener(marker, 'mouseout', function () {
                                    // 마커에 mouseout 이벤트가 발생하면 인포윈도우를 제거합니다
                                    infowindow.close();
                                });
                            };
                        })(marker, positions[i]));

                        // 생성된 마커를 배열에 추가
                        markers.push(marker);
                    }

                    // 클러스터러를 생성하고, 마커 배열을 추가합니다.
                    var clusterer = new kakao.maps.MarkerClusterer({
                        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
                        averageCenter: true, // 클러스터 마커의 중심좌표를 클러스터 내의 마커들의 중심좌표로 설정합니다.
                        minLevel: 10, // 지도 레벨이 이 값 이상일 경우에만 클러스터링을 적용합니다.
                        calculator: [1, 10, 100] // 클러스터의 크기를 정하는 값입니다. 배열에 담긴 숫자들은 클러스터 안의 마커 수에 따라 적용됩니다.
                    });

                    // 클러스터러에 마커 배열을 추가합니다.
                    clusterer.addMarkers(markers);

                    // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
                    var zoomControl = new kakao.maps.ZoomControl();
                    map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
                </script>
                <br>
            </div>
        </div>
    </div>
</main>
<br style="clear: both">
<c:import url="../common/footer.jsp"/>
</body>
</html>