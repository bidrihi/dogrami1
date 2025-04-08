<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <c:import url="/WEB-INF/views/common/menubar.jsp"/>
    <meta charset="utf-8">
    <style type="text/css">
        .form {
            background-color: #f2f2f2;
            width: 100%;
            max-width: 432px;
            margin: auto;
            border-radius: 12px;
        }

        .form__container {
            padding: 52px 36px 38px;
            text-align: center;
            outline: none;
            margin: 0;
            border: 0;
            vertical-align: baseline;
            box-sizing: inherit;
            display: block;
            color: black;
        }

        img {
            overflow-clip-margin: content-box;
            overflow: clip;
        }

        div {
            outline: none;
            margin: 0;
            padding: 0;
            border: 0;
            vertical-align: baseline;
            box-sizing: inherit;
            display: block;
        }

        .input {
            font-family: 'siu';
            width: 100%;
            height: 64px;
            background: none;
            border: 0;
            border-bottom: 1px solid rgba(0, 0, 0, 0.2);
            font-size: 25px;
            color: black;
            text-align: center;
            outline: none;
            margin: 0;
            padding: 0;
            box-sizing: inherit;
        }

        .fieldset {
            margin-bottom: 48px;
        }

        .form__footer {
            padding: 19px 36px;
            border-top: 1px solid rgba(0, 0, 0, 0.2);
            font-size: 20px;
            text-align: center;
            color: black;
        }

        .form__footer a {
            text-decoration: none;
            color: black;
        }

        .btn {
            min-width: 234px;
            height: 50px;
            background-color: white;
            border-radius: 25px;
            font-size: 20px;
            color: #005450;
            letter-spacing: -0.3px;
            transition: opacity .2s;
            font-family: 'siu';
        }

        .text {
            margin-top: 24px;
            opacity: .7;
            font-size: 16px;
            line-height: 1.375;
        }

        .text a {
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>
<main id="main">
    <br>
    <div class="page page_login">
        <form class="form" action="login.do" method="post">
            <div class="form__container">
                <div class="logo"><img class="logo__pic"
                                       src="${pageContext.servletContext.contextPath}/resources/images/logo-b.png"
                                       width="150">
                </div>
                <div class="fieldset">
                    <div class="field"><input class="input" type="text" name="user_id" placeholder="User ID" required>
                    </div>
                    <div class="field"><input class="input" type="password" name="user_pwd" placeholder="Password"
                                              required></div>
                </div>
                <button class="btn">Login</button>
                <div class="text">비밀번호를 잊어버리셨나요? <a href="${ pageContext.servletContext.contextPath }/findpwform.do">비밀번호
                    찾기</a></div>
            </div>
            <div class="form__footer">계정이 없으신가요? <a href="${ pageContext.servletContext.contextPath }/enrollPage.do">회원가입</a>
            </div>
        </form>
    </div>
</main>
<br>
<c:import url="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>
