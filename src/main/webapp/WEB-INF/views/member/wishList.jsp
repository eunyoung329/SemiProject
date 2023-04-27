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
      
        <!-- <div class="row" >
            <div class="col-lg-3 col-md-6" >
              <div class="card" style="width: 24rem;">
                
                <img src="https://veganseoul.com/wp-content/uploads/2019/11/vegan-seoul-gangnam-vegetarian-restaurant.jpg?ezimgfmt=ng%3Awebp%2Fngcb1%2Frs%3Adevice%2Frscb1-1U"
                  class="card-img-top" alt="..." data-bs-toggle="modal" data-bs-target="#myModal">
                <div class="card-body">
                  <h5 class="card-title">Restaurant Name</h5>
                  <p class="card-text">110  ,Sejong-daero   Jung-gu  Seoul, Republic of Korea</p>
                </div>
                <ul class="list-group list-group-flush">
                  <li class="list-group-item">키워드</li>
                  <li class="list-group-item">영업시간</li>
                  <li class="list-group-item">전화번호</li>
                </ul>
                <div class="card-body sns">
                   <a href="#" class="btn btn-light mk">SNS 바로가기</a>
                 <i class="fa-solid fa-heart"></i>
                  
                </div>
              </div>
      
            </div>
             //모달창
            <div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered" >
                <div class="modal-content" >
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">레스토랑 이름</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                    <img src="https://cdn.shopify.com/s/files/1/1055/2210/articles/bright_colored_foods-808927.jpg?v=1674614608" 
                    alt="My Image">
                  </div>
                  <div class="modal-footer">
                    <h6 class="modal-footer-content">레스토랑 메인 메뉴, 특징에 대한 간단한 설명, contents</h6>
                    <a href="#" class="btn btn-light mk">SNS 바로가기</a>
                    <i class="fa-solid fa-heart"></i>
                  </div>
                </div>
              </div>
            </div>
             -->
      
      
      
      
      
      
      
           
        </section>
      </main>
<jsp:include page ="/WEB-INF/views/common/footer.jsp"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="${contextPath}/resources/js/wishList.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>