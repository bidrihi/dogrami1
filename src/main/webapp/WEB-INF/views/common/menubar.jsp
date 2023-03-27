<%--
  Created by IntelliJ IDEA.
  User: bidri
  Date: 2023-03-27 027
  Time: 오후 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        header {
            margin: 0;
            padding: 0;
        }

        header h1#logo {
            font-size: 36pt;
            font-style: italic;
            color: navy;
            text-shadow: 2px 2px 2px gray;
        }

        header ul#menubar {
            list-style: none;
            position: relative;
            left: 150px;
            top: -30px;
        }

        header ul#menubar li {
            float: left;
            width: 120px;
            height: 30px;
            margin-right: 5px;
            padding: 0;
        }

        header ul#menubar li a {
            text-decoration: none;
            width: 120px;
            height: 30px;
            display: block;
            background-color: orange;
            text-align: center;
            color: navy;
            font-weight: bold;
            margin: 0;
            text-shadow: 1px 1px 2px white;
            padding-top: 5px;
        }

        header ul#menubar li a:hover {
            text-decoration: none;
            width: 120px;
            height: 30px;
            display: block;
            background-color: navy;
            text-align: center;
            color: white;
            font-weight: bold;
            margin: 0;
            text-shadow: 1px 1px 2px orange;
            padding-top: 5px;
        }

        hr {
            clear: both;
        }
    </style>
</head>
<body>
<ul id="menubar">
    <li><a href="${ pageContext.servletContext.contextPath }/nlist.do">공지사항</a></li>
    <li><a href="${ pageContext.servletContext.contextPath }/blist.do?page=1">Community</a></li>
    <li><a href="${ pageContext.servletContext.contextPath }/test.do">Care</a></li>
    <li><a href="${ pageContext.servletContext.contextPath }/testLogin.do">Place</a></li>
    <li><a href="${ pageContext.servletContext.contextPath }/moveAOP.do">Shop</a></li>
</ul>
</body>
</html>
