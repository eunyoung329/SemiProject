<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="${contextPath}/resources/css/mainPage.css" rel="stylesheet" type="text/css"/>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
</head>
<body>

  <main>
        <!-- 메인 이미지, 검색-->
        <div class="index_top_area mb-5">
            <img src="${contextPath}/resources/img/IndexFoodImg.jpg" alt="" class="index_main_img">
            
            <div class="index_search_area">
                <h1>지구를 위한 작은 선택, 오늘 채식 어때요?</h1>
                <button id="index_search_btn" onclick="location.href='${contextPath}/member/searchPage'">S E A R C H</button>
            </div>
        </div>
        


        
        <!-- 식당 소개 -->
        <div class="container index-wrap">
            
            <div class="index_res_wrap">
                <!-- 서울 -->
                <div class="index_res_item_wrap">
                    <div class="index_res_label">
                        <span><i class="fa-solid fa-location-dot"></i> 서울</span>
                        <div>
                            <button class="scroll-left-btn"><i class="fa-solid fa-arrow-left"></i></button>
                            <button class="scroll-right-btn"><i class="fa-solid fa-arrow-right"></i></button>
                        </div>
                    </div>
                    
                    <div class="index_res" id="index_res_seoul">
                        <!-- <div class="index_res_item">
                            <img src="${contextPath}/resources/img/defaultResImg.png" alt="레스토랑 썸네일">
                            <span class="index_res_category">베이커리</span>
                            <span class="index_res_name">외계인방앗간 정자점</span>
                            <span class="index_res_addr">경기도 성남시 분당구 정자일로 110</span>
                            <a><button type="button"><i class="fa-solid fa-seedling"></i>자세히 보기</button></a>
                        </div> -->
                        
                    </div><!-- 아이템 끝 -->
                </div><!-- 서울 끝 -->


                <!-- 경기 -->
                <div class="index_res_item_wrap">
                    <div class="index_res_label">
                        <span><i class="fa-solid fa-location-dot"></i> 경기</span>
                        <div>
                            <button class="scroll-left-btn"><i class="fa-solid fa-arrow-left"></i></button>
                            <button class="scroll-right-btn"><i class="fa-solid fa-arrow-right"></i></button>
                        </div>
                    </div>
                    
                    <div class="index_res" id="index_res_gyeonggi">
                       
                    </div><!-- 아이템 끝 -->
                </div><!-- 경기 끝 -->


                <!-- 부산 -->
                <div class="index_res_item_wrap">
                    <div class="index_res_label">
                        <span><i class="fa-solid fa-location-dot"></i> 부산</span>
                        <div>
                            <button class="scroll-left-btn"><i class="fa-solid fa-arrow-left"></i></button>
                            <button class="scroll-right-btn"><i class="fa-solid fa-arrow-right"></i></button>
                        </div>
                    </div>
                    
                    <div class="index_res" id="index_res_busan">
                        
                    </div><!-- 아이템 끝 -->
                </div><!-- 부산 끝 -->


                <!-- 제주 -->
                <div class="index_res_item_wrap">
                    <div class="index_res_label">
                        <span><i class="fa-solid fa-location-dot"></i> 제주</span>
                        <div>
                            <button class="scroll-left-btn"><i class="fa-solid fa-arrow-left"></i></button>
                            <button class="scroll-right-btn"><i class="fa-solid fa-arrow-right"></i></button>
                        </div>
                    </div>
                    
                    <div class="index_res" id="index_res_jeju">
                        
                    </div><!-- 아이템 끝 -->
                </div><!-- 제주 끝 -->


            <!-- 자세히보기 모달창 -->
            <div class="main_res_modal" >
                <!-- <div class="main_res_modal_content">
                    <button id="main_modal_close">&times;</button>

                    <h2 class="mb-5">${list[i].name}</h2>

                        <div class="main_modal_img_area">
                            <img src="${list[i].img}" alt="이미지샘플">
                        </div>

                        <div class="main_modal_info_area">
                            <span>${list[i].category}</span>
                            <span><i class="fa-solid fa-location-dot"></i>${list[i].address}</span>
                            <span><i class="fa-regular fa-clock"></i>${list[i].time}</span>
                            <span>
                                <i class="fa-solid fa-quote-left"></i>
                                ${list[i].contents}
                                <i class="fa-solid fa-quote-right"></i>
                            </span>
                            <span><a href="${list[i].sns}">SNS 바로가기</a></span>
                        </div>`
                </div> -->
            </div><!-- modal 끝 -->



            <!-- 제보하기 -->
            <div class="index_report_res_area mt-3 mb-5">
                <h3>채식이 가능한 식당을 발견하셨나요?</h3>
                <div class="index_report_res_wrap mt-3">
                    <img src="${contextPath}/resources/img/messageImg.png" alt="제보이미지">
                    
                    <div class="mt-3">
                        <h5>꼭 비건 메뉴만 판매하는 식당이 아니여도 좋아요</h5>
                        <h5>채식이 가능한 식당을 발견하신다면 어디든 제보해주세요!</h5>
                        <a href="${contextPath}/report/reportStore">
                            <button class="mt-2" type="button" id="main_report_btn">
                                <i class="fa-solid fa-envelope"></i>제보하기
                            </button>
                        </a>
                    </div>
                </div>
            </div><!-- 제보하기 끝 -->


            <!-- 로그인한 경우에만 제보하기 가능 -->
            <script>
                <% Object mainLoginMember = session.getAttribute("loginMember"); %>
                let mainLoginMember = '<%= mainLoginMember %>';
                const reportBtn = document.getElementById("main_report_btn");

                reportBtn.addEventListener("click", function(event){
                if(mainLoginMember === "null"){
                    alert("로그인 후 제보해주세요.");
                    event.preventDefault();
                }
            });
            </script>
            
        </div>

        <div class="index_top_btn_area">
            <i class="fa-solid fa-square-caret-up"></i>
        </div>
    </main>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="${contextPath}/resources/js/mainPage.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>




</body>
</html>