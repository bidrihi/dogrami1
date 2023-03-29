<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<!-- 로그인 안 한 경우 -->
<c:if test="${ empty sessionScope.loginMember }">
    <div class="header-logo py-5 d-none d-lg-block">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6 text-center">
                    <a class="navbar-brand" href="main.do"><img
                            src="${pageContext.servletContext.contextPath}/resources/images/dogrami.png" alt=""
                            class="img-fluid w-100"></a>
                </div>
            </div>
        </div>
    </div>

    <header class="header-top bg-grey justify-content-center">
        <nav class="navbar navbar-expand-lg navigation">
            <div class="container">
                <a class="navbar-brand d-lg-none" href="main.do"><img
                        src="${pageContext.servletContext.contextPath}resources/images/dogrami.png" alt=""
                        class="img-fluid"></a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent"
                        aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarContent">
                    <ul id="menu" class="menu navbar-nav ">
                        <li class="nav-item"><a href="main.do" class="nav-link">Home</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button"
                               data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                Community
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                                <a class="dropdown-item" href="#">정보공유</a>
                                <a class="dropdown-item" href="#">일상잡담</a>
                                <a class="dropdown-item" href="#">질문답변</a>
                                <a class="dropdown-item" href="#">동물일기</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button"
                               data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                Care
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown3">
                                <a class="dropdown-item" href="#">애견 훈련소</a>
                                <a class="dropdown-item" href="${ pageContext.servletContext.contextPath }/hplist3.do">동물병원</a>
                                <a class="dropdown-item" href="#">애견미용실</a>
                                <a class="dropdown-item" href="#">장례업체</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown4" role="button"
                               data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                Play
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown4">
                                <a class="dropdown-item" href="#">컨테스트</a>
                                <a class="dropdown-item" href="#">퀴즈게시판</a>
                                <a class="dropdown-item" href="#">랜덤퀴즈</a>
                                <a class="dropdown-item" href="#">성향테스트</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown5" role="button"
                               data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                Place
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown5">
                                <a class="dropdown-item" href="#">애견 호텔</a>
                                <a class="dropdown-item" href="#">애견동반카페</a>
                                <a class="dropdown-item" href="#">애견동반숙소</a>
                                <a class="dropdown-item" href="#">애견동반음식점</a>
                            </div>
                        </li>
                        <li class="nav-item"><a href="#" class="nav-link">Shop</a></li>
                        <li class="nav-item d-lg-none">
                            <div class="search_toggle p-3 d-inline-block bg-white"><i class="ti-search"></i></div>
                        </li>
                    </ul>
                </div>
                <div class="text-right search d-none d-lg-block">
                    <div class="search_toggle"><i class="ti-search"></i></div>
                </div>
            </div>
        </nav>
    </header>
</c:if>

<!-- 로그인한 경우 : 관리자인 경우 -->
<c:if test="${ !empty sessionScope.loginMember and loginMember.user_admin eq 'Y' }">
    <div class="header-logo py-5 d-none d-lg-block">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6 text-center">
                    <a class="navbar-brand" href="main.do"><img
                            src="${pageContext.servletContext.contextPath}/resources/images/dogrami.png" alt=""
                            class="img-fluid w-100"></a>
                </div>
            </div>
        </div>
    </div>

    <header class="header-top bg-grey justify-content-center">
        <nav class="navbar navbar-expand-lg navigation">
            <div class="container">
                <a class="navbar-brand d-lg-none" href="main.do"><img
                        src="${pageContext.servletContext.contextPath}/resources/images/dogrami.png" alt=""
                        class="img-fluid"></a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent"
                        aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarContent">
                    <ul id="menu" class="menu navbar-nav ">
                        <li class="nav-item"><a href="main.do" class="nav-link">Home</a></li>
                        <li class="nav-item"><a href="contact.html" class="nav-link">회원조회</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button"
                               data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                Community
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                                <a class="dropdown-item" href="standard-fullwidth.html">정보공유</a>
                                <a class="dropdown-item" href="standard-left-sidebar.html">일상잡담</a>
                                <a class="dropdown-item" href="standard-right-sidebar.html">질문답변</a>
                                <a class="dropdown-item" href="standard-right-sidebar.html">동물일기</a>
                            </div>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button"
                               data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                Care
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown3">
                                <a class="dropdown-item" href="post-video.html">애견 훈련소</a>
                                <a class="dropdown-item" href="post-audio.html">동물병원</a>
                                <a class="dropdown-item" href="post-link.html">애견미용실</a>
                                <a class="dropdown-item" href="post-gallery.html">장례업체</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown4" role="button"
                               data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                Play
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown4">
                                <a class="dropdown-item" href="post-video.html">컨테스트</a>
                                <a class="dropdown-item" href="post-audio.html">퀴즈게시판</a>
                                <a class="dropdown-item" href="post-link.html">랜덤퀴즈</a>
                                <a class="dropdown-item" href="post-gallery.html">성향테스트</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown5" role="button"
                               data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                Place
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown5">
                                <a class="dropdown-item" href="post-video.html">애견 호텔</a>
                                <a class="dropdown-item" href="post-audio.html">애견동반카페</a>
                                <a class="dropdown-item" href="post-link.html">애견동반숙소</a>
                                <a class="dropdown-item" href="post-gallery.html">애견동반음식점</a>
                            </div>
                        </li>
                        <li class="nav-item"><a href="contact.html" class="nav-link">Shop</a></li>
                        <li class="nav-item d-lg-none">
                            <div class="search_toggle p-3 d-inline-block bg-white"><i class="ti-search"></i></div>
                        </li>
                    </ul>
                </div>

                <div class="text-right search d-none d-lg-block">
                    <div class="search_toggle"><i class="ti-search"></i></div>
                </div>
            </div>
        </nav>

    </header>
</c:if>

<!-- 로그인한 경우 : 일반회원인 경우 -->
<c:if test="${ !empty sessionScope.loginMember and loginMember.user_admin eq 'N' }">
    <div class="header-logo py-5 d-none d-lg-block">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6 text-center">
                    <a class="navbar-brand" href="main.do"><img src="${pageContext.servletContext.contextPath}/resources/images/dogrami.png" alt=""
                                                                   class="img-fluid w-100"></a>
                </div>
            </div>
        </div>
    </div>

    <header class="header-top bg-grey justify-content-center">
        <nav class="navbar navbar-expand-lg navigation">
            <div class="container">
                <a class="navbar-brand d-lg-none" href="main.do"><img src="resources/images/dogrami.png" alt=""
                                                                         class="img-fluid"></a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent"
                        aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarContent">
                    <ul id="menu" class="menu navbar-nav ">
                        <li class="nav-item"><a href="contact.html" class="nav-link">Home</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button"
                               data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                Community
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                                <a class="dropdown-item" href="#">정보공유</a>
                                <a class="dropdown-item" href="#">일상잡담</a>
                                <a class="dropdown-item" href="#">질문답변</a>
                                <a class="dropdown-item" href="#">동물일기</a>
                            </div>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button"
                               data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                Care
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown3">
                                <a class="dropdown-item" href="#">애견 훈련소</a>
                                <a class="dropdown-item" href="#">동물병원</a>
                                <a class="dropdown-item" href="#">애견미용실</a>
                                <a class="dropdown-item" href="#">장례업체</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown4" role="button"
                               data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                Play
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown4">
                                <a class="dropdown-item" href="#">컨테스트</a>
                                <a class="dropdown-item" href="#">퀴즈게시판</a>
                                <a class="dropdown-item" href="#">랜덤퀴즈</a>
                                <a class="dropdown-item" href="#">성향테스트</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown5" role="button"
                               data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                Place
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown5">
                                <a class="dropdown-item" href="#">애견 호텔</a>
                                <a class="dropdown-item" href="#">애견동반카페</a>
                                <a class="dropdown-item" href="#">애견동반숙소</a>
                                <a class="dropdown-item" href="#">애견동반음식점</a>
                            </div>
                        </li>
                        <li class="nav-item"><a href="#" class="nav-link">Shop</a></li>
                        <li class="nav-item d-lg-none">
                            <div class="search_toggle p-3 d-inline-block bg-white"><i class="ti-search"></i></div>
                        </li>
                    </ul>
                </div>
                <div class="text-right search d-none d-lg-block">
                    <div class="search_toggle"><i class="ti-search"></i></div>
                </div>
            </div>
        </nav>
    </header>
</c:if>
</body>
</html>