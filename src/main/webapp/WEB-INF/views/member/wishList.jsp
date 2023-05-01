<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my whishList</title>
<script src="https://kit.fontawesome.com/069a8eb008.js" crossorigin="anonymous"></script> 
<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
<link rel="stylesheet" href="${contextPath}/resources/img/">
<link rel="stylesheet" href="${contextPath}/resources/css/wishList.css">
<!-- <link rel="stylesheet" href="resources/css/wishList.css"> -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>

 <jsp:include page ="/WEB-INF/views/common/header.jsp"/>

    <main>
        <section id="title-area">
          <div class="title-text-container">
            <p class="title-text">PICK <br> YOUR <br> FAVORITE</p>
            <p class="title-text-sub">당신의 건강과 환경을 생각하는, 당신의 다음 목적지</p>
          </div>
        </section>
      
        <section id="card-area">
       
      
      
           
        </section>
      </main>
<jsp:include page ="/WEB-INF/views/common/footer.jsp"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="${contextPath}/resources/js/main.js"></script>
<script src="${contextPath}/resources/js/wishList.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>