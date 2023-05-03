<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자로그인</title>
<link rel="stylesheet"
	href="${contextPath}/resources/css/adminLogin.css">
	
</head>
<body>

  <section class="login-form">
    <form action="${contextPath}/admin/restAdmin" method="get" name="adminLogin" onsubmit="return adminLoginValidate()">
          <input type="text" class="text-field" id="adminEmail" name="adminEmail">
          <input type="password" class="text-field" id="adminPw" name="adminPw">
          <input type="submit" value="로그인" class="submit-btn">
        <div class="form-check">
          <input class="form-check-input" type="checkbox" id="adminAgree" name="adminAgree">
          <label class="form-check-label" for="adminAgree">
           아이디저장
          </label>
        </div>
    </form>
    </section>

  <script src="${contextPath}/resources/js/adminLogin.js"></script>

  </body>
  </html>

