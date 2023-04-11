<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>index</title>
    <script src="https://kit.fontawesome.com/069a8eb008.js" crossorigin="anonymous"></script> 
    <link rel="stylesheet" href="resources/css/infoChange.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    
    <jsp:include page ="/WEB-INF/views/common/header.jsp"/>

    <main>

 <!-- 정보 메뉴 -->
    <section class="info-side container">
        <ul>
            <li><a href="">정보변경</a></li>
            <li><a href="">비밀번호변경</a></li>
            <li><a href="">회원탈퇴</a></li>
        </ul>
    </section>

     <!-- 정보 사이드메뉴 -->
     
        <section class="info-area container">


            <div class="myImg-area">
                <img src="/img/defaultUser.png" alt="">
                <button type="button" id="imgSelectBtn"><i class="fa-solid fa-camera"></i></button>
            </div>

            <form action="" name="info-form">

                <label for="nickName">닉네임</label>
                <div>
                    <input type="text" id="nickName">
                </div>


                <label for="tel">전화번호</label>
                <div>
                    <input type="number" id="tel">
                </div>


                <label for="birth">생일</label>
                <div class="birth-area">  
                    <input type="number" max="2023" min="1900" placeholder="년">
                    <input type="number" max="12" min="1" placeholder="월">
                    <input type="number" max="31" min="1" placeholder="일">
                </div>


                <label for="addr">주소</label>
                <div class="addr-area">
                    <input type="text" id="postInput">
                    <button id="postBtn">우편번호</button>
                </div>
                <div class="addr-area">
                    <input type="text">
                </div>
                <div class="addr-area">
                    <input type="text">
                </div>

                <button id="saveBtn">변경하기</button>



            </form>
        </section>



    </main>


    <jsp:include page ="/WEB-INF/views/common/footer.jsp"/>
    


    <script src="resources/js/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</body>
</html>