<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="short icon" type="image/x-icon"
          href="${pageContext.servletContext.contextPath}/resources/images/dogrami3.png">
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>도그라미</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->


    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=EB+Garamond:wght@400;500&family=Inter:wght@400;500&family=Playfair+Display:ital,wght@0,400;0,700;1,400;1,700&display=swap"
          rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="${pageContext.servletContext.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/vendor/bootstrap-icons/bootstrap-icons.css"
          rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/vendor/swiper/swiper-bundle.min.css"
          rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/vendor/glightbox/css/glightbox.min.css"
          rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/vendor/aos/aos.css" rel="stylesheet">

    <!-- Template Main CSS Files -->
    <link href="${pageContext.servletContext.contextPath}/resources/css/variables.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/css/main.css" rel="stylesheet">

    <!-- =======================================================
    * Template Name: ZenBlog
    * Updated: Mar 10 2023 with Bootstrap v5.2.3
    * Template URL: https://bootstrapmade.com/zenblog-bootstrap-blog-template/
    * Author: BootstrapMade.com
    * License: https:///bootstrapmade.com/license/
    ======================================================== -->
    <style type="text/css">
        @font-face {
            font-family: 'siu';
            src: url("${pageContext.servletContext.contextPath}/resources/fonts/Ownglyph_2022_UWY_Si_Woo-Rg.woff");
        }

        body {
            font-family: 'siu';
        }

        .header div nav ul li a {
            font-family: 'siu';
            font-size: 22px;
        }

        .header div nav ul li a:hover {
            font-family: 'siu';
            font-size: 22px;
        }

        .header div nav ul li a[class='active'] {
            font-family: 'siu';
            font-size: 22px;
        }

        .header div div {
            font-size: 22px;
        }
    </style>
</head>
<body>
<%-- header --%>
<header id="header" class="header d-flex align-items-center fixed-top">
    <div class="container-fluid container-xl d-flex align-items-center justify-content-between">
        <a href="main.do" class="logo d-flex align-items-center" style="width: 180px">
            <img src="${pageContext.servletContext.contextPath}/resources/images/logo-b.png"
                 style="max-width: 100%; max-height: 100%;"/>
        </a>
        <c:if test="${loginMember.user_admin ne 'Y'}">
            <nav id="navbar" class="navbar">
                <ul>
                    <li><a href="main.do">Home</a></li>
                    <li class="dropdown"><a href="#"><span>Community</span> <i
                            class="bi bi-chevron-down dropdown-indicator"></i></a>
                        <ul>
                            <li><a href="${pageContext.servletContext.contextPath}/infosharelist.do">정보공유</a></li>
                            <li><a href="${pageContext.servletContext.contextPath}/dailylist.do">일상잡담</a></li>
                            <li><a href="${pageContext.servletContext.contextPath}/questionlist.do">질문답변</a></li>
                            <li><a href="${pageContext.servletContext.contextPath}/diarylist.do">동물일기</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="#"><span>Care</span> <i
                            class="bi bi-chevron-down dropdown-indicator"></i></a>
                        <ul>
                            <li><a href="${pageContext.servletContext.contextPath }/trainningMap3.do">애견 훈련소</a></li>
                            <li><a href="${pageContext.servletContext.contextPath }/hospitalMap3.do">동물병원</a></li>
                            <li><a href="${pageContext.servletContext.contextPath }/hairshopMap3.do">애견미용실</a></li>
                            <li><a href="${pageContext.servletContext.contextPath }/funeralMap3.do">장례업체</a></li>
                            <li><a href="${pageContext.servletContext.contextPath }/clist3.do">후기게시판</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="#"><span>Place</span> <i
                            class="bi bi-chevron-down dropdown-indicator"></i></a>
                        <ul>
                            <li><a href="${pageContext.servletContext.contextPath }/hotelMap3.do">애견 호텔</a></li>
                            <li><a href="${pageContext.servletContext.contextPath }/cafeMap3.do">애견 동반 카페</a></li>
                            <li><a href="${pageContext.servletContext.contextPath }/guesthouseMap3.do">애견 동반 숙소</a></li>
                            <li><a href="${pageContext.servletContext.contextPath }/restaurantMap3.do">애견 동반 음식점</a></li>
                            <li><a href="${pageContext.servletContext.contextPath }/plist3.do">후기게시판</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="#"><span>Play</span> <i
                            class="bi bi-chevron-down dropdown-indicator"></i></a>
                        <ul>
                            <li><a href="contestlist.do">컨테스트</a></li>
                            <li><a href="rdlist.do">랜덤퀴즈</a></li>
                            <li><a href="doglist.do">성향테스트</a></li>
                        </ul>
                    </li>
                    <li><a href="shop.do">Shop</a></li>
                    <li><a href="nlist.do">Notice</a></li>
                </ul>
            </nav>
            <%-- 비회원 --%>
            <c:if test="${empty sessionScope.loginMember}">
                <div class="position-relative" style="font-family: 'siu'">
                    <a href="${ pageContext.servletContext.contextPath }/loginPage.do" class="mx-2">로그인</a>
                    <a href="${ pageContext.servletContext.contextPath }/enrollPage.do" class="mx-2">회원가입</a>
                    <i class="bi bi-list mobile-nav-toggle"></i>
                </div>
            </c:if>
            <%-- 일반회원 --%>
            <c:if test="${!empty sessionScope.loginMember}">
                <div class="position-relative" style="font-family: 'siu'">
                        ${sessionScope.loginMember.user_nick}님
                    <c:url var="myinfo" value="myinfo.do">
                        <c:param name="user_id" value="${ sessionScope.loginMember.user_id }"/>
                    </c:url>
                    <a href="${ myinfo }">마이페이지</a>
                    <button onclick="javascript:location.href='logout.do';" style="border: none;">로그아웃
                    </button>
                    <i class="bi bi-list mobile-nav-toggle"></i>
                </div>
            </c:if>
        </c:if>
        <%-- 관리자 --%>
        <c:if test="${loginMember.user_admin eq 'Y'}">
            <nav id="navbar" class="navbar">
                <ul>
                    <li><a href="main.do">Home</a></li>
                    <li><a href="mlist2.do">회원관리</a></li>
                    <li class="dropdown"><a href="#"><span>Community</span> <i
                            class="bi bi-chevron-down dropdown-indicator"></i></a>
                        <ul>
                            <li><a href="${pageContext.servletContext.contextPath}/infosharelist.do">정보공유</a></li>
                            <li><a href="${pageContext.servletContext.contextPath}/dailylist.do">일상잡담</a></li>
                            <li><a href="${pageContext.servletContext.contextPath}/questionlist.do">질문답변</a></li>
                            <li><a href="${pageContext.servletContext.contextPath}/diarylist.do">동물일기</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="#"><span>Care</span> <i
                            class="bi bi-chevron-down dropdown-indicator"></i></a>
                        <ul>
                            <li><a href="${pageContext.servletContext.contextPath }/trainningMap3.do">애견 훈련소</a></li>
                            <li><a href="${pageContext.servletContext.contextPath }/hospitalMap3.do">동물병원</a></li>
                            <li><a href="${pageContext.servletContext.contextPath }/hairshopMap3.do">애견미용실</a></li>
                            <li><a href="${pageContext.servletContext.contextPath }/funeralMap3.do">장례업체</a></li>
                            <li><a href="${pageContext.servletContext.contextPath }/clist3.do">후기게시판</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="#"><span>Place</span> <i
                            class="bi bi-chevron-down dropdown-indicator"></i></a>
                        <ul>
                            <li><a href="${pageContext.servletContext.contextPath }/hotelMap3.do">애견 호텔</a></li>
                            <li><a href="${pageContext.servletContext.contextPath }/cafeMap3.do">애견 동반 카페</a></li>
                            <li><a href="${pageContext.servletContext.contextPath }/guesthouseMap3.do">애견 동반 숙소</a></li>
                            <li><a href="${pageContext.servletContext.contextPath }/restaurantMap3.do">애견 동반 음식점</a></li>
                            <li><a href="${pageContext.servletContext.contextPath }/plist3.do">후기게시판</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="#"><span>Play</span> <i
                            class="bi bi-chevron-down dropdown-indicator"></i></a>
                        <ul>
                            <li><a href="contestlist.do">컨테스트</a></li>
                            <li><a href="rdlist.do">랜덤퀴즈</a></li>
                            <li><a href="doglist.do">성향테스트</a></li>
                        </ul>
                    </li>
                    <li><a href="shop.do">Shop</a></li>
                    <li><a href="nlist.do">Notice</a></li>
                </ul>
            </nav>
            <div class="position-relative" style="font-family: 'siu'">
                    ${sessionScope.loginMember.user_nick}님
                <c:url var="myinfo" value="myinfo.do">
                    <c:param name="user_id" value="${ sessionScope.loginMember.user_id }"/>
                </c:url>
                <a href="${ myinfo }">마이페이지</a>
                <button onclick="javascript:location.href='logout.do';" style="border: none;">로그아웃
                </button>
                <i class="bi bi-list mobile-nav-toggle"></i>
            </div>
        </c:if>
    </div>
</header>
</body>
</html>