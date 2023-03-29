<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>Revolve - Personal Magazine blog Template</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- THEME CSS
    ================================================== -->
    <!-- Bootstrap -->
    <link rel="stylesheet"
          href="${pageContext.servletContext.contextPath}/resources/plugins/bootstrap/css/bootstrap.min.css">
    <!-- Themify -->
    <link rel="stylesheet"
          href="${pageContext.servletContext.contextPath}/resources/plugins/themify/css/themify-icons.css">
    <link rel="stylesheet"
          href="${pageContext.servletContext.contextPath}/resources/plugins/slick-carousel/slick-theme.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/plugins/slick-carousel/slick.css">
    <!-- Slick Carousel -->
    <link rel="stylesheet"
          href="${pageContext.servletContext.contextPath}/resources/plugins/owl-carousel/owl.carousel.min.css">
    <link rel="stylesheet"
          href="${pageContext.servletContext.contextPath}/resources/plugins/owl-carousel/owl.theme.default.min.css">
    <link rel="stylesheet"
          href="${pageContext.servletContext.contextPath}/resources/plugins/magnific-popup/magnific-popup.css">
    <!-- manin stylesheet -->
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/style.css">
</head>
<body>
<c:import url="menubar.jsp"/>

</header>
<!--search overlay start-->
<div class="search-wrap">
    <div class="overlay">
        <form action="#" class="search-form">
            <div class="container">
                <div class="row">
                    <div class="col-md-10 col-9">
                        <input type="text" class="form-control" placeholder="Search..."/>
                    </div>
                    <div class="col-md-2 col-3 text-right">
                        <div class="search_toggle toggle-wrap d-inline-block">
                            <i class="ti-close"></i>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<!--search overlay end-->
<section class="section-padding">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="category-item">
                    <div class="category-img">
                        <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/images/cat/cat-4.jpg"
                                         alt="" class="img-fluid w-100"></a>
                    </div>
                    <div class="content">
                        <a href="#" class="text-color text-uppercase font-sm letter-spacing font-extra">lifestyle</a>
                        <h4><a href="#">Managing your time In 3 easy steps</a></h4>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="category-item">
                    <div class="category-img">
                        <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/images/cat/cat-2.jpg"
                                         alt="" class="img-fluid w-100"></a>
                    </div>
                    <div class="content">
                        <a href="#" class="text-color text-uppercase font-sm letter-spacing font-extra">Fashion</a>
                        <h4><a href="#">The Ultimate Summer Hat Guide</a></h4>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6">
                <div class="category-item">
                    <div class="category-img">
                        <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/images/cat/cat-3.jpg"
                                         alt="" class="img-fluid w-100"></a>
                    </div>
                    <div class="content">
                        <a href="#" class="text-color text-uppercase font-sm letter-spacing font-extra">Travel</a>
                        <h4><a href="#">The trip you should take this fall</a></h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="section-padding pt-4">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="subscribe-home py-4 px-4 mb-5 bg-grey">
                    <div class="form-group row align-items-center mb-0">
                        <label for="colFormLabel" class="col-form-label col-sm-12 h4 col-lg-4">Subscribe for
                            Newsletter</label>
                        <div class="col-sm-6 col-lg-3">
                            <input type="email" class="form-control mb-3 mb-lg-0" id="colFormLabel"
                                   placeholder="Full Name">
                        </div>
                        <div class="col-sm-6 col-lg-3">
                            <input type="email" class="form-control mb-3 mb-lg-0" id="colFormLabel2"
                                   placeholder="Email Address">
                        </div>
                        <div class="col-sm-2">
                            <a href="#" class="btn btn-dark">Subscribe</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <article class="post-grid mb-5">
                            <a class="post-thumb mb-4 d-block" href="blog-single.html">
                                <img src="${pageContext.servletContext.contextPath}/resources/images/fashion/img-1.jpg"
                                     alt="" class="img-fluid w-100">
                            </a>
                            <span class="letter-spacing cat-name font-extra text-uppercase font-sm text-color ">Travel</span>
                            <h3 class="post-title mt-1"><a href="blog-single.html">Trip to California</a></h3>

                            <span class="text-muted letter-spacing text-uppercase font-sm">September 15, 2019</span>
                            <div class="post-content mt-4">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.Magnam nesciunt architecto
                                    quaerat
                                    necessitatibus tenetur ratione eius numquam!</p>

                                <a href="blog-single.html" class="btn btn-grey mt-3"> read more</a>
                            </div>
                        </article>


                        <article class="post-grid mb-5">
                            <a class="post-thumb mb-4 d-block" href="blog-single.html">
                                <img src="${pageContext.servletContext.contextPath}/resources/images/fashion/img-lg-2.jpg"
                                     alt="" class="img-fluid w-100">
                            </a>
                            <span class="letter-spacing cat-name font-extra text-uppercase font-sm text-color ">Lifestyle</span>
                            <h3 class="post-title mt-1"><a href="blog-single.html">Ways To Reach Goals</a></h3>

                            <span class="text-muted letter-spacing text-uppercase font-sm">August 12, 2019</span>
                            <div class="post-content mt-4">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.Magnam nesciunt architecto
                                    quaerat
                                    necessitatibus tenetur ratione eius numquam!</p>
                                <a href="blog-single.html" class="btn btn-grey mt-3"> read more</a>
                            </div>
                        </article>

                        <article class="post-grid mb-5">
                            <a class="post-thumb mb-4 d-block" href="blog-single.html">
                                <img src="${pageContext.servletContext.contextPath}/resources/images/fashion/img-7.jpg"
                                     alt="" class="img-fluid w-100">
                            </a>
                            <span class="letter-spacing cat-name font-extra text-uppercase font-sm text-color ">fashion</span>
                            <h3 class="post-title mt-1"><a href="blog-single.html">Bridal beauty span</a></h3>

                            <span class="text-muted letter-spacing text-uppercase font-sm">march 2, 2019</span>
                            <div class="post-content mt-4">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.Magnam nesciunt architecto
                                    quaerat
                                    necessitatibus tenetur ratione eius numquam!</p>
                                <a href="blog-single.html" class="btn btn-grey mt-3"> read more</a>
                            </div>
                        </article>

                        <article class="post-grid mb-5">
                            <span class="letter-spacing cat-name font-extra text-uppercase font-sm text-color ">Lifestyle</span>
                            <h3 class="post-title mt-1"><a href="blog-single.html">Beautiful Arrangement of The
                                Workplace</a></h3>

                            <span class="text-muted letter-spacing text-uppercase font-sm">September 12, 2019</span>
                            <div class="post-content mt-4">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.Magnam nesciunt architecto
                                    quaerat
                                    necessitatibus tenetur ratione eius numquam!</p>
                                <a href="blog-single.html" class="btn btn-grey mt-3"> read more</a>
                            </div>
                        </article>
                    </div>


                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <article class="post-grid mb-5">
                            <a class="post-thumb mb-4 d-block" href="blog-single.html">
                                <img src="${pageContext.servletContext.contextPath}/resources/images/fashion/img-lg-1.jpg"
                                     alt="" class="img-fluid w-100">
                            </a>
                            <span class="letter-spacing cat-name font-extra text-uppercase font-sm text-color ">Explore</span>
                            <h3 class="post-title mt-1"><a href="blog-single.html">Lets explore more</a></h3>

                            <span class="text-muted letter-spacing text-uppercase font-sm">September 4, 2019</span>
                            <div class="post-content mt-4">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.Magnam nesciunt architecto
                                    quaerat
                                    necessitatibus tenetur ratione eius numquam!</p>
                                <a href="blog-single.html" class="btn btn-grey mt-3"> read more</a>
                            </div>
                        </article>

                        <article class="post-grid mb-5">
                            <a class="post-thumb mb-4 d-block" href="blog-single.html">
                                <img src="${pageContext.servletContext.contextPath}/resources/images/fashion/img-md-1.jpg"
                                     alt="" class="img-fluid w-100">
                            </a>
                            <span class="letter-spacing cat-name font-extra text-uppercase font-sm text-color ">lifestyle</span>
                            <h3 class="post-title mt-1"><a href="blog-single.html">Feel Like Home</a></h3>

                            <span class="text-muted letter-spacing text-uppercase font-sm">September 15, 2019</span>
                            <div class="post-content mt-4">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.Magnam nesciunt architecto
                                    quaerat
                                    necessitatibus tenetur ratione eius numquam!</p>
                                <a href="blog-single.html" class="btn btn-grey mt-3"> read more</a>
                            </div>
                        </article>

                        <article class="post-grid mb-5">
                            <a class="post-thumb mb-4 d-block" href="blog-single.html">
                                <img src="${pageContext.servletContext.contextPath}/resources/images/fashion/img-lg-4.jpg"
                                     alt="" class="img-fluid w-100">
                            </a>
                            <span class="letter-spacing cat-name font-extra text-uppercase font-sm text-color ">Travel</span>
                            <h3 class="post-title mt-1"><a href="blog-single.html">What Type of Traveller Are You?</a>
                            </h3>

                            <span class="text-muted letter-spacing text-uppercase font-sm">September 15, 2019</span>
                            <div class="post-content mt-4">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.Magnam nesciunt architecto
                                    quaerat
                                    necessitatibus tenetur ratione eius numquam!</p>
                                <a href="blog-single.html" class="btn btn-grey mt-3"> read more</a>
                            </div>
                        </article>
                    </div>
                </div>

                <div class="pagination mt-5 pt-4">
                    <ul class="list-inline">
                        <li class="list-inline-item"><a href="#" class="active">1</a></li>
                        <li class="list-inline-item"><a href="#">2</a></li>
                        <li class="list-inline-item"><a href="#">3</a></li>
                        <li class="list-inline-item"><a href="#" class="prev-posts"><i class="ti-arrow-right"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                <div class="sidebar sidebar-right">
                    <div class="sidebar-wrap mt-5 mt-lg-0">
                        <div class="sidebar-widget about mb-5 text-center p-3">
                            <div class="about-author">
                                <img src="${pageContext.servletContext.contextPath}/resources/images/author.jpg" alt=""
                                     class="img-fluid">
                            </div>
                            <h4 class="mb-0 mt-4">Liam Mason</h4>
                            <p>Travel Blogger</p>
                            <p>I'm Liam, last year I decided to quit my job and travel the world. You can follow my
                                journey on this
                                blog!</p>
                            <img src="${pageContext.servletContext.contextPath}/resources/images/liammason.png" alt=""
                                 class="img-fluid">
                        </div>

                        <div class="sidebar-widget follow mb-5 text-center">
                            <h4 class="text-center widget-title">Follow Me</h4>
                            <div class="follow-socials">
                                <a href="#"><i class="ti-facebook"></i></a>
                                <a href="#"><i class="ti-twitter"></i></a>
                                <a href="#"><i class="ti-instagram"></i></a>
                                <a href="#"><i class="ti-youtube"></i></a>
                                <a href="#"><i class="ti-pinterest"></i></a>
                            </div>
                        </div>

                        <div class="sidebar-widget mb-5 ">
                            <h4 class="text-center widget-title">Trending Posts</h4>

                            <div class="sidebar-post-item-big">
                                <a href="blog-single.html"><img
                                        src="${pageContext.servletContext.contextPath}/resources/images/news/img-1.jpg"
                                        alt=""
                                        class="img-fluid"></a>
                                <div class="mt-3 media-body">
                                    <span class="text-muted letter-spacing text-uppercase font-sm">September 10, 2019</span>
                                    <h4><a href="blog-single.html">Meeting With Clarissa, Founder Of Purple Conversation
                                        App</a></h4>
                                </div>
                            </div>

                            <div class="media border-bottom py-3 sidebar-post-item">
                                <a href="#"><img class="mr-4"
                                                 src="${pageContext.servletContext.contextPath}/resources/images/news/thumb-1.jpg"
                                                 alt=""></a>
                                <div class="media-body">
                                    <span class="text-muted letter-spacing text-uppercase font-sm">September 10, 2019</span>
                                    <h4><a href="blog-single.html">Thoughtful living in los Angeles</a></h4>
                                </div>
                            </div>

                            <div class="media py-3 sidebar-post-item">
                                <a href="#"><img class="mr-4"
                                                 src="${pageContext.servletContext.contextPath}/resources/images/news/thumb-2.jpg"
                                                 alt=""></a>
                                <div class="media-body">
                                    <span class="text-muted letter-spacing text-uppercase font-sm">September 10, 2019</span>
                                    <h4><a href="blog-single.html">Vivamus molestie gravida turpis.</a></h4>
                                </div>
                            </div>
                        </div>


                        <div class="sidebar-widget category mb-5">
                            <h4 class="text-center widget-title">Catgeories</h4>
                            <ul class="list-unstyled">
                                <li class="align-items-center d-flex justify-content-between">
                                    <a href="#">Innovation</a>
                                    <span>14</span>
                                </li>
                                <li class="align-items-center d-flex justify-content-between">
                                    <a href="#">Software</a>
                                    <span>2</span>
                                </li>
                                <li class="align-items-center d-flex justify-content-between">
                                    <a href="#">Social</a>
                                    <span>10</span>
                                </li>
                                <li class="align-items-center d-flex justify-content-between">
                                    <a href="#">Trends</a>
                                    <span>5</span>
                                </li>
                            </ul>
                        </div>

                        <div class="sidebar-widget subscribe mb-5">
                            <h4 class="text-center widget-title">Newsletter</h4>
                            <input type="text" class="form-control" placeholder="Email Address">
                            <a href="#" class="btn btn-primary d-block mt-3">Sign Up</a>
                        </div>

                        <div class="sidebar-widget sidebar-adv mb-5">
                            <a href="#"><img
                                    src="${pageContext.servletContext.contextPath}/resources/images/sidebar-banner3.png"
                                    alt="" class="img-fluid w-100"></a>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<!--footer start-->
<footer class="footer-section bg-grey">
    <div class="instagram-photo-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h4 class="text-center">Follow in Instagram</h4>
                </div>
            </div>

            <div class="row no-gutters" id="instafeed">

            </div>
        </div>
    </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="mb-4">
                    <h2 class="footer-logo">Revolve.</h2>
                </div>
                <ul class="list-inline footer-socials">
                    <li class="list-inline-item"><a href="#"><i class="ti-facebook mr-2"></i>Facebook</a></li>
                    <li class="list-inline-item"><a href="#"><i class="ti-twitter mr-2"></i>Twitter</a></li>
                    <li class="list-inline-item"><a href="#"><i class="ti-linkedin mr-2"></i>Linkedin</a></li>
                    <li class="list-inline-item"><a href="#"><i class="ti-pinterest mr-2"></i>Pinterest</a></li>
                    <li class="list-inline-item"><a href="#"><i class="ti-github mr-2"></i>Github</a></li>
                    <li class="list-inline-item"><a href="#"><i class="ti-instagram mr-2"></i>Instrgram</a></li>
                    <li class="list-inline-item"><a href="#"><i class="ti-rss mr-2"></i>rss</a></li>
                </ul>
            </div>

            <div class="col-md-12 text-center">
                <p class="copyright">© Copyright 2019 - Revolve. All Rights Reserved. Distribution <a class="text-white"
                                                                                                      href="https://themewagon.com">ThemeWagon.</a>
                </p>
            </div>
        </div>
    </div>
</footer>
<!--footer end-->

