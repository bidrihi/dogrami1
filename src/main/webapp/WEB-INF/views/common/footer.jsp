<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style type="text/css">
        footer {
            font-family: 'siu';
        }
    </style>
    <script type="text/javascript"
            src="${pageContext.servletContext.contextPath}/resources/js/jquery-3.6.3.min.js"></script>
    <script>
        $(function() {
            var values = $('#newnotice').html();
            $.ajax({
                url: "ntop5.do",
                type: "post",
                dataType: "json",
                success: function (data) {
                    var jsonStr = JSON.stringify(data);
                    var json = JSON.parse(jsonStr);

                    for (var i in json.list) {
                        values += "<li><a class='d-flex align-items-center' href='noticedetail.do?notice_no="
                            + json.list[i].notice_no + "'><div><div class='post-meta d-block'>" +
                            "<span class='date'>Notice</span> <span class='mx-1'>&bullet;</span> <span>" +
                            json.list[i].notice_date + "</span></div><span>"
                            + decodeURIComponent(json.list[i].notice_title).replace(/\+/gi, " ") + "</span></div></a></li>";
                    }
                    $('#newnotice').html(values);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log("ntop5.do error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
                }
            });
        });
    </script>
</head>
<body>
<%-- top scroll button --%>
<a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>
<%-- footer --%>
<footer id="footer" class="footer">
    <div class="footer-content">
        <div class="container">
            <div class="row g-5">
                <div class="col-lg-4">
                    <img src="${pageContext.servletContext.contextPath}/resources/images/logo-w.png"
                         style="max-width: 260px; height: auto;">
                    <p>한국 ICT 인재개발원 <br>
                        클라우드환경의 자바(java) 개발자 양성 과정-A <br>
                        5Team 코노 <br>
                        김상호, 김경환, 송영욱, 송지형, 심채린, 이원준</p>
                    <br>
                    <div class="copyright">
                        © Copyright <strong><span>ZenBlog</span></strong>. All Rights Reserved
                    </div>
                    <div class="credits">
                        <!-- All the links in the footer should remain intact. -->
                        <!-- You can delete the links only if you purchased the pro version. -->
                        <!-- Licensing information: https://bootstrapmade.com/license/ -->
                        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/herobiz-bootstrap-business-template/ -->
                        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                    </div>
                </div>

                <div class="col-6 col-lg-3">
                    <h3 class="footer-heading" style="font-family: 'siu'">Navigation</h3>
                    <c:if test="${loginMember.user_admin ne 'Y'}">
                        <ul class="footer-links list-unstyled">
                            <li><a href="main.do"><i class="bi bi-chevron-right"></i> Home</a></li>
                            <li><a href="infosharelist.do"><i class="bi bi-chevron-right"></i> Community</a></li>
                            <li><a href="trainningMap3.do"><i class="bi bi-chevron-right"></i> Care</a></li>
                            <li><a href="hotelMap3.do"><i class="bi bi-chevron-right"></i> Place</a></li>
                            <li><a href="contestlist.do"><i class="bi bi-chevron-right"></i> Play</a></li>
                            <li><a href="shop.do"><i class="bi bi-chevron-right"></i> Shop</a></li>
                            <li><a href="nlist.do"><i class="bi bi-chevron-right"></i> Notice</a></li>
                        </ul>
                    </c:if>
                    <c:if test="${loginMember.user_admin eq 'Y'}">
                        <ul class="footer-links list-unstyled">
                            <li><a href="main.do"><i class="bi bi-chevron-right"></i> Home</a></li>
                            <li><a href="mlist2.do"><i class="bi bi-chevron-right"></i> 회원관리</a></li>
                            <li><a href="infosharelist.do"><i class="bi bi-chevron-right"></i> Community</a></li>
                            <li><a href="trainningMap3.do"><i class="bi bi-chevron-right"></i> Care</a></li>
                            <li><a href="hotelMap3.do"><i class="bi bi-chevron-right"></i> Place</a></li>
                            <li><a href="contestlist.do"><i class="bi bi-chevron-right"></i> Play</a></li>
                            <li><a href="shop.do"><i class="bi bi-chevron-right"></i> Shop</a></li>
                            <li><a href="nlist.do"><i class="bi bi-chevron-right"></i> Notice</a></li>
                        </ul>
                    </c:if>
                </div>
                <div class="col-lg-5">
                    <h3 class="footer-heading" style="font-family: 'siu'">Recent Notice</h3>
                    <ul class="footer-links footer-blog-entry list-unstyled" id="newnotice">
                    </ul>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- Vendor JS Files -->
<script src="${pageContext.servletContext.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/vendor/swiper/swiper-bundle.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/vendor/glightbox/js/glightbox.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/vendor/aos/aos.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="${pageContext.servletContext.contextPath}/resources/js/main.js"></script>
</body>
</html>