<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>도그라미</title>
    <style>
        body h2 {
            font-family: 'siu';
        }

        body main img {
            width: 200px;
            height: 200px;
        }
    </style>
</head>
<body>
<%-- header --%>
<c:import url="/WEB-INF/views/common/menubar.jsp"/>

<main id="main">
    <section id="contract" class="contact mb-5">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center mb-5">
                    <h1 style="font-family: 'siu'">Shop</h1>
                </div>
            </div>

            <div class="row gy-4">
                <c:forEach items="${requestScope.list}" begin="0" end="2" var="shop" varStatus="status">
                    <div class="col-md-4">
                        <div class="info-item">
                            <a href="${shop.site_url}">
                                <img src="${pageContext.servletContext.contextPath}/resources/shop_upfiles/${shop.site_image_rename}">
                            </a>
                            <h2><a href="${shop.site_url}">${shop.site_name}</a></h2>
                            <c:if test="${loginMember.user_admin eq 'Y'}">
                                <td>
                                    <c:url var="shopup" value="shopupview.do">
                                        <c:param name="shop_no" value="${shop.shop_no}"/>
                                    </c:url>
                                    <a href="${shopup}" class="btn btn-primary">수정</a> &nbsp;
                                    <c:url var="shopdel" value="/shopdelete.do">
                                        <c:param name="shop_no" value="${shop.shop_no }"/>
                                        <c:param name="site_image_rename" value="${shop.site_image_rename}"/>
                                    </c:url>
                                    <a href="${shopdel}" class="btn btn-primary">삭제</a>
                                </td>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <br>
            <div class="row gy-4">
                <c:forEach items="${requestScope.list}" begin="3" end="5" var="shop" varStatus="status">
                    <div class="col-md-4">
                        <div class="info-item">
                            <a href="${shop.site_url}">
                                <img src="${pageContext.servletContext.contextPath}/resources/shop_upfiles/${shop.site_image_rename}">
                            </a>
                            <h2><a href="${shop.site_url}">${shop.site_name}</a></h2>
                            <c:if test="${loginMember.user_admin eq 'Y'}">
                                <td>
                                    <c:url var="shopup" value="shopupview.do">
                                        <c:param name="shop_no" value="${shop.shop_no}"/>
                                    </c:url>
                                    <a href="${shopup}" class="btn btn-primary">수정</a> &nbsp;
                                    <c:url var="shopdel" value="/shopdelete.do">
                                        <c:param name="shop_no" value="${shop.shop_no }"/>
                                        <c:param name="site_image_rename" value="${shop.site_image_rename}"/>
                                    </c:url>
                                    <a href="${shopdel}" class="btn btn-primary">삭제</a>
                                </td>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <br>
            <div class="row gy-4">
                <c:forEach items="${requestScope.list}" begin="6" var="shop" varStatus="status">
                    <div class="col-md-4">
                        <div class="info-item">
                            <a href="${shop.site_url}">
                                <img src="${pageContext.servletContext.contextPath}/resources/shop_upfiles/${shop.site_image_rename}">
                            </a>
                            <h2><a href="${shop.site_url}">${shop.site_name}</a></h2>
                            <c:if test="${loginMember.user_admin eq 'Y'}">
                                <td>
                                    <c:url var="shopup" value="shopupview.do">
                                        <c:param name="shop_no" value="${shop.shop_no}"/>
                                    </c:url>
                                    <a href="${shopup}" class="btn btn-primary">수정</a> &nbsp;
                                    <c:url var="shopdel" value="/shopdelete.do">
                                        <c:param name="shop_no" value="${shop.shop_no }"/>
                                        <c:param name="site_image_rename" value="${shop.site_image_rename}"/>
                                    </c:url>
                                    <a href="${shopdel}" class="btn btn-primary">삭제</a>
                                </td>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <!-- 관리자일때 글쓰기 버튼 보이게 -->
            <c:if test="${loginMember.user_admin eq 'Y'}">
                <div class="col-12" align="right">
                    <input type="button" onclick="javascript:location.href='shopwrite.do';" class="btn btn-primary"
                           value="글쓰기">
                </div>
            </c:if>
            <br><br>
            <form action="shopsearch.do" name="search" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <select name="action" style="height: 30px;">
                                <option value="site_name" selected>사이트명</option>
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
    </section>
</main>
<c:import url="/WEB-INF/views/common/paging.jsp"/>
<%-- footer --%>
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>
