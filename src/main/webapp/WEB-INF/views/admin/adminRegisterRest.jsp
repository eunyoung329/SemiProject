<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en" data-bs-theme="auto">
  <head><script src="../assets/js/color-modes.js"></script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.111.3">
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sidebars/">
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/resources/css/reportAdmin.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/mainAdmin.css">
    <link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/SemiProject/src/main/webapp/resources/css/adminRegisterRest.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    
    
    
    
    
    
    
    <style>
      
    </style>

    
    <!-- 사이드바 아이콘 -->
    <link href="sidebars.css" rel="stylesheet">
  </head>
  <body>
    <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
      <symbol id="check2" viewBox="0 0 16 16">
        <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
      </symbol>
      <symbol id="circle-half" viewBox="0 0 16 16">
        <path d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z"/>
      </symbol>
      <symbol id="moon-stars-fill" viewBox="0 0 16 16">
        <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z"/>
        <path d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z"/>
      </symbol>
      <symbol id="sun-fill" viewBox="0 0 16 16">
        <path d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z"/>
      </symbol>
    </svg>

   

    <!-- 사이드바 아이콘 -->
<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
  <symbol id="bootstrap" viewBox="0 0 118 94">
    <title>Bootstrap</title>
    <path fill-rule="evenodd" clip-rule="evenodd" d="M24.509 0c-6.733 0-11.715 5.893-11.492 12.284.214 6.14-.064 14.092-2.066 20.577C8.943 39.365 5.547 43.485 0 44.014v5.972c5.547.529 8.943 4.649 10.951 11.153 2.002 6.485 2.28 14.437 2.066 20.577C12.794 88.106 17.776 94 24.51 94H93.5c6.733 0 11.714-5.893 11.491-12.284-.214-6.14.064-14.092 2.066-20.577 2.009-6.504 5.396-10.624 10.943-11.153v-5.972c-5.547-.529-8.934-4.649-10.943-11.153-2.002-6.484-2.28-14.437-2.066-20.577C105.214 5.894 100.233 0 93.5 0H24.508zM80 57.863C80 66.663 73.436 72 62.543 72H44a2 2 0 01-2-2V24a2 2 0 012-2h18.437c9.083 0 15.044 4.92 15.044 12.474 0 5.302-4.01 10.049-9.119 10.88v.277C75.317 46.394 80 51.21 80 57.863zM60.521 28.34H49.948v14.934h8.905c6.884 0 10.68-2.772 10.68-7.727 0-4.643-3.264-7.207-9.012-7.207zM49.948 49.2v16.458H60.91c7.167 0 10.964-2.876 10.964-8.281 0-5.406-3.903-8.178-11.425-8.178H49.948z"></path>
  </symbol>
  <symbol id="home" viewBox="0 0 16 16">
    <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5z"/>
  </symbol>
  <symbol id="speedometer2" viewBox="0 0 16 16">
    <path d="m7.646 9.354-3.792 3.792a.5.5 0 0 0 .353.854h7.586a.5.5 0 0 0 .354-.854L8.354 9.354a.5.5 0 0 0-.708 0z"/>
  <path d="M11.414 11H14.5a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.5-.5h-13a.5.5 0 0 0-.5.5v7a.5.5 0 0 0 .5.5h3.086l-1 1H1.5A1.5 1.5 0 0 1 0 10.5v-7A1.5 1.5 0 0 1 1.5 2h13A1.5 1.5 0 0 1 16 3.5v7a1.5 1.5 0 0 1-1.5 1.5h-2.086l-1-1z"/>
  </symbol>
  <symbol id="table" viewBox="0 0 16 16">
    <path d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm15 2h-4v3h4V4zm0 4h-4v3h4V8zm0 4h-4v3h3a1 1 0 0 0 1-1v-2zm-5 3v-3H6v3h4zm-5 0v-3H1v2a1 1 0 0 0 1 1h3zm-4-4h4V8H1v3zm0-4h4V4H1v3zm5-3v3h4V4H6zm4 4H6v3h4V8z"/>
  </symbol>
  <symbol id="people-circle" viewBox="0 0 16 16">
    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
    <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
  </symbol>
  <symbol id="grid" viewBox="0 0 16 16">
    <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z"/>
</svg>

<nav class="d-flex flex-nowrap">


 <!-- 하얀색 -->
 <div class="d-flex flex-column flex-shrink-0 p-3 bg-body-tertiary" style="width: 280px;">
  <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
    <img src="/sidebar/img/logo_trans.png" alt="" width="50" height="50" class="rounded-circle me-2">
    <span class="logo-text">&nbsp;LET'S VEGAN</span>
  </a>
  <hr>
  <ul class="nav nav-pills flex-column mb-auto">
    <li class="nav-item">
      <a href="#" class="nav-link link-body-emphasis " aria-current="page">
        <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#home"/></svg>
        메인홈으로
      </a>
    </li>
    <li class="nav-item">
      <a href="#" class="nav-link link-body-emphasis">
        <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#speedometer2"/></svg>
        레스토랑 관리
      </a>
    </li>
    <li class="nav-item">
      <a href="#" class="nav-link link-body-emphasis">
        <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#table"/></svg>
        게시판 관리
      </a>
    </li>
    <li class="nav-item">
      <a href="${contextPath}/admin/reportAdmin" class="nav-link link-body-emphasis">
        <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#grid"/></svg>
        제보관리
      </a>
    </li>
    <li class="nav-item">
      <a href="#" class="nav-link link-body-emphasis">
        <svg class="bi pe-none me-2" width="16" height="16"><use xlink:href="#people-circle"/></svg>
        회원 관리
      </a>
    </li>
  </ul>
  <hr>
  <div class="dropdown">
    <div class="d-flex align-items-center link-body-emphasis text-decoration-none" data-bs-toggle="dropdown" aria-expanded="false">
      <img src="/sidebar/img/logo_trans.png" alt="" width="32" height="32" class="rounded-circle me-2">
      <strong style="color: rgb(0, 82, 0);">admin  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong>
      <a href="${contextPath}/admin/adminLogOut">
        <button class="button-59" role="button">logout</button>
      </a>


    </div>
    <ul class="dropdown-menu text-small shadow">
      
    </ul>
  </div>
</div>

<div class="b-example-divider b-example-vr"></div>

 <!-- 사이드바 끝 -->
 <!--메인화면-->
 <div id="admin-container" >
  <div id="admin-title" >
    <svg class="bi pe-none me-2" width="22" height="22"><use xlink:href="#speedometer2"/></svg>
    <span class="text-title">제보 관리</span>
     <span><button class="scroll-left-btn" onclick="location.href='${contextPath}/admin/reportAdmin'"><i class="fa-solid fa-arrow-left"></i></button></span>
    <hr style="margin: top 7px;">
  </div>

  <section class="main">
    
      <div class="main4">
  
        <section class="enroll-Content">
          <form action="adminRegisterRest" name="RegisterAdmin-form" method="post"
          enctype="multipart/form-data" onsubmit="return AdminValidateForm()">

            <table style="width:800px">
              <tr>
                <th></th>
                
                <td></td>
                <tr>
                  <th>카테고리선택</th>
                  <td>
                    <select class="form-select" aria-label="Default select example"
                    name="rest_category" id="rest_category" value="${rest_category}" style="width:400px">
                    <option value="" selected>카테고리선택</option>
                    <option value="한식">한식</option>
                    <option value="양식">양식</option>
                    <option value="베이커리">베이커리</option>
                    <option value="카페">카페</option>
                    <option value="기타">기타</option>
                  </select>
                </td>
                      </tr>
                      <tr>
                        
                        <th>레스토랑이름</th>
                        <td><input type="text" name="rest_name" id="rest_name"
                          autocomplete="off" value="${requestScope.rest_name}" style="width:400px"></td>
                      </tr>
                      <tr>
                        <th>이미지</th>
                        <td><div>
                          <input type="file" name="rest_img" id="rest_img" value="${rest_img}" style="width:400px">
                        </div></td>
                      </tr>
                      <tr>
                      <th>좌표X</th>
                      <td><input type="text" name="rest_x" id="rest_x"
                        autocomplete="off" style="width:400px"></td>
                      </tr>
                      <tr>
                        <th>좌표Y</th>
                        <td><input type="text" name="rest_y" id="rest_y"
                          autocomplete="off" style="width:400px"></td>
                        </tr>
                    <tr>
                      <th>tel</th>
                      <td><input type="text" name="rest_tel" id="rest_tel"
                        autocomplete="off" style="width:400px"></td>
                    </tr>
                   
                    <tr>
                      <th>영업시간</th>
                      <td><input type="text" name="rest_time" id="rest_time"
                        autocomplete="off" style="width:400px"></td>
                    </tr>
                    <tr>
                      <th>sns</th>
                      <td><input type="text" name="rest_sns" id="rest_sns"
                        autocomplete="off" style="width:400px"></td>
                    </tr>
                    <tr>
                      <th>주소</th>
                      <td><div class="storeAddrDiv postCode">
                        <input type="text" name="rest_Addr" id="sample4_postcode"
                          placeholder="우편번호를 입력해주세요" autocomplete="off"> <input
                          type="button" id="postBtn" onclick="sample4_execDaumPostcode()"
                          value="우편번호" value="${rest_Addr[0]}" style="width:210px">
                      </div>
                      <div class="storeAddrDiv">
                        <input type="text" name="rest_Addr" id="sample4_roadAddress"
                          placeholder="도로명주소를 입력해주세요" autocomplete="off" value="${rest_Addr[1]}" style="width:400px">
                      </div>
                      <div class="storeAddrDiv">
                        <input type="text" name="rest_Addr" id="sample4_detailAddress"
                          placeholder="상세주소를 입력해주세요" autocomplete="off" value="${rest_Addr[2]}" style="width:400px">
                      </div></td>
                    </tr>
                    <tr>
                      <th>레스토랑정보</th>
                      <td> <textarea  id="rest_contents"
                        name="rest_contents" style="height: 100px;width:400px;"></textarea></td>
                    </tr>
          
                    <tr>
                      <th></th>
                    <td><button type="submit" name="enrollBtn" id="submitBtn" style="width:400px;margin-top:30px">등록</button></td>
                  </tr>
            </table>
          </form>
        </section>
  
</div>
</section>
</nav>
 

<script src="${contextPath}/resources/js/adminRejisterRest.js"></script>
<!--<script src="${contextPath}/resources/js/reportAdmin.js"></script>-->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <!-- <script src="../assets/dist/js/bootstrap.bundle.min.js"></script> -->
  
    <script src="/sidebar/sidebars.js"></script>
    <script
      src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   <script>

   function sample4_execDaumPostcode() {
       new daum.Postcode({
           oncomplete: function(data) {
               // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

               // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
               // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
               var roadAddr = data.roadAddress; // 도로명 주소 변수

               // 우편번호와 주소 정보를 해당 필드에 넣는다.
               document.getElementById('sample4_postcode').value = data.zonecode;
               document.getElementById("sample4_roadAddress").value = roadAddr;
               
               if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                }
           }
       }).open();
   }
   </script>
   
  </body>
</html>