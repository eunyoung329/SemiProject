<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/SemiProject/src/main/webapp/resources/css/main.css" rel="stylesheet" type="text/css"/>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
</head>
<body>

  <main>
   
   

      <div class="container"><!--inputcontainer-->
        <div class="box"><!--박스-->
          <div class="introduce">Search Restaurant <br>
          </div><!--소개-->
      
          <form>
            <div class="searchArea"><!--search area-->
              <div><!--input묶음 what,where-->
                <span>what</span><br>
                <div class="what"><!--what묶음-->
                  <button class="fa-solid fa-magnifying-glass" width="35px"></button>
                  <input type="text" id="inputWhat" placeholder="가게이름을 적어주세요">
                </div>
                <span>where</span><br>
                <div class="where"><!--where묶음-->
                  <button class="fa-sharp fa-solid fa-map-location-dot" width="35px"></button>
                  <input type="text" id="inputWhere" placeholder="도시이름을 적어주세요">
                </div><!--where묶음-->
      
                <div class="btn_area"><!--버튼area-->
                  <button id="searchBtn" type="submit">SEARCH</button>
                </div><!--버튼area-->
              </div><!--input묶음 끝남-->
            </div><!--search area-->
          </form>
         
        </div><!--박스-->
      </div><!--inputContainer-->
     

    
    
    <!----------레스토랑소개부분------------>


<div class="container_Res"><!--레스토랑소개4줄-->

<div class="famous_Res"><!--famous seoul-->
  <div class="introduce_famousRe"><!--인기레스토랑 소개-->
   <h2 class="h2">강남 인기 맛집</h2><br>
    </div><!--인기레스토랑 소개-->

<div class="famous_all"><!--famous레스토랑 5개전체묶음 -->

<div class="famous_Res"><!--인기가게1-->
<div><!--인기가게1_1-->
<div><!--사진구역-->
  <a href=""><img width="236px" height="172px" src="${contextPath}//resources/img/main/witchkitchen.jpg"></a>
</div><!--사진-->
<div><!--소개전체-->
  <div><h4 class="h4">마녀주방 강남점</h4></div><!--가게이름-->
  <div></div><!--가게소개-->
</div><!--소개전체-->

</div><!--인기가게1_1-->
</div><!--인기가게1-->



<div class="famous_Res"><!--식당2-->
  <div><!--인기가게2_1-->
    <div><!--사진구역-->
      <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/darak.jpeg"></a>
    </div><!--사진-->
    <div><!--소개전체-->
      <div><h4 class="h4">을지다락 강남점</h4></div><!--가게이름-->
      <div></div><!--가게소개-->
    </div>
    
    </div><!--인기가게2_1-->
</div><!--식당2-->


<div class="famous_Res"><!--식당3-->
  <div><!--인기가게3_1-->
    <div><!--사진구역-->
      <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/primo.jpg"></a>
    </div><!--사진-->
    <div><!--소개전체-->
      <div><h4 class="h4">프리모바치오바치 강남점</h4></div><!--가게이름-->
      <div></div><!--가게소개-->
    </div>
    
    </div><!--인기가게3_1-->
</div><!--식당3-->


<div class="famous_Res"><!--식당4-->
  <div><!--인기가게4_1-->
    <div><!--사진구역-->
      <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/Tielo.jpg"></a>
    </div><!--사진-->
    <div><!--소개-->
      <div><h4 class="h4">띠엘로 강남점</h4></div><!--가게이름-->
      <div></div><!--가게소개-->
    </div>
    
    </div><!--인기가게4_1-->

</div><!--식당4-->


<div class="famous_Res"><!--식당5-->
  <div><!--인기가게5_1-->
    <div><!--사진구역-->
      <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/pinksol741.jpg"></a>
    </div><!--사진-->
    <div><!--소개-->
      <div><h4 class="h4">핑크솔740 </h4></div><!--가게이름-->
      <div></div><!--가게소개-->
    </div>
    
    </div><!--인기가게5_1-->
</div><!--식당5-->

</div><!--famous all-->
</div><!--famous seoul-->

<!--------------------------2----------------------->
<div class="famous_Res"><!--famous seoul-->
  <div class="introduce_famousRe"><!--인기레스토랑 소개-->
    <h2 class="h2">역삼 인기 맛집</h2><br>
    </div><!--인기레스토랑 소개-->

<div class="famous_all"><!--famous레스토랑 전체묶음 -->

<div class="famous_Res"><!--인기가게1-->
<div><!--인기가게1_1-->
<div><!--사진구역-->
  <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/augusthill.jpg"></a>
</div><!--사진-->
<div><!--소개전체-->
  <div><h4 class="h4">어거스트힐 역삼점</h4></div><!--가게이름-->
  <div></div><!--가게소개-->
</div>

</div><!--인기가게1_1-->
</div><!--인기가게1-->



<div class="famous_Res"><!--식당2-->
  <div><!--인기가게2_1-->
    <div><!--사진구역-->
      <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/maguro.jpg"></a>
    </div><!--사진-->
    <div><!--소개전체-->
      <div><h4 class="h4">마구로우니도</h4></div><!--가게이름-->
      <div></div><!--가게소개-->
    </div>
    
    
    
    </div><!--인기가게2_1-->

</div><!--식당2-->

<div class="famous_Res"><!--식당3-->
  <div><!--인기가게3_1-->
    <div><!--사진구역-->
      <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/ddamddam.jpg"></a>
    </div><!--사진-->
    <div><!--소개전체-->
      <div><h4 class="h4">땀땀</h4></div><!--가게이름-->
      <div></div><!--가게소개-->
    </div>
    
    </div><!--인기가게3_1-->
</div><!--식당3-->


<div class="famous_Res"><!--식당4-->
  <div><!--인기가게4_1-->
    <div><!--사진구역-->
      <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/gamjatang.jpg"></a>
    </div><!--사진-->
    <div><!--소개-->
      <div><h4 class="h4">신동궁감자탕</h4></div><!--가게이름-->
      <div></div><!--가게소개-->
    </div>
    
    </div><!--인기가게4_1-->

</div><!--식당4-->

<div class="famous_Res"><!--식당5-->
  <div><!--인기가게5_1-->
    <div><!--사진구역-->
      <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/buja.jpg"></a>
    </div><!--사진-->
    <div><!--소개-->
      <div><h4 class="h4">알부자 </h4></div><!--가게이름-->
      <div></div><!--가게소개-->
    </div>
    
    </div><!--인기가게5_1-->
</div><!--식당5-->

</div><!--famous all-->
</div><!--famous 서울-->



<!--------------------#3-------------------------->
<div class="famous_Res"><!--famous seoul-->
  <div class="introduce_famousRe"><!--인기레스토랑 소개-->
    <h2 class="h2">명동 인기 맛집</h2><br>
    </div><!--인기레스토랑 소개-->

<div class="famous_all"><!--famous레스토랑 전체묶음 -->

<div class="famous_Res"><!--인기가게1-->
<div><!--인기가게1_1-->
<div><!--사진구역-->
  <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/mdkj.jpg"></a>
</div><!--사진-->
<div><!--소개전체-->
  <div><h4 class="h4">명동교자</h4></div><!--가게이름-->
  <div></div><!--가게소개-->
</div>

</div><!--인기가게1_1-->
</div><!--인기가게1-->



<div class="famous_Res"><!--식당2-->
  <div><!--인기가게2_1-->
    <div><!--사진구역-->
      <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/npmo.jpg"></a>
    </div><!--사진-->
    <div><!--소개전체-->
      <div><h4 class="h4">남포면옥</h4></div><!--가게이름-->
      <div></div><!--가게소개-->
    </div>
    
    
    
    </div><!--인기가게2_1-->

</div><!--식당2-->

<div class="famous_Res"><!--식당3-->
  <div><!--인기가게3_1-->
    <div><!--사진구역-->
    <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/dintai.jpg"></a>
    </div><!--사진-->
    <div><!--소개전체-->
      <div><h4 class="h4">딘타이펑 명동점</h4></div><!--가게이름-->
      <div></div><!--가게소개-->
    </div>
    
    </div><!--인기가게3_1-->
</div><!--식당3-->


<div class="famous_Res"><!--식당4-->
  <div><!--인기가게4_1-->
    <div><!--사진구역-->
      <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/mok.jpg"></a>
    </div><!--사진-->
    <div><!--소개-->
      <div><h4 class="h4">목멱산방</h4></div><!--가게이름-->
      <div></div><!--가게소개-->
    </div>
    
    </div><!--인기가게4_1-->

</div><!--식당4-->

<div class="famous_Res"><!--식당5-->
  <div><!--인기가게5_1-->
    <div><!--사진구역-->
      <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/sungwon.jpg"></a>
    </div><!--사진-->
    <div><!--소개-->
      <div><h4 class="h4">성원갈비 </h4></div><!--가게이름-->
      <div></div><!--가게소개-->
    </div>
    
    </div><!--인기가게5_1-->

</div><!--식당5-->

</div><!--famous all-->

</div><!--famous 서울-->

<!------------4------------------------>
<div class="famous_Res"><!--famous seoul-->
  <div class="introduce_famousRe"><!--인기레스토랑 소개-->
    <h2 class="h2">홍대 인기맛집</h2><br>
    </div><!--인기레스토랑 소개-->

<div class="famous_all"><!--famous레스토랑 전체묶음 -->

<div class="famous_Res"><!--인기가게1-->
<div><!--인기가게1_1-->
<div><!--사진구역-->
  <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/india.jpg"></a>
</div><!--사진-->
<div><!--소개전체-->
  <div><h4 class="h4">델리인디아</h4></div><!--가게이름-->
  <div></div><!--가게소개-->
</div>

</div><!--인기가게1_1-->
</div><!--인기가게1-->



<div class="famous_Res"><!--식당2-->
  <div><!--인기가게2_1-->
    <div><!--사진구역-->
      <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/butadong.jpg"></a>
    </div><!--사진-->
    <div><!--소개전체-->
      <div><h4 class="h4">스미비부타동</h4></div><!--가게이름-->
      <div></div><!--가게소개-->
    </div>
    
    
    
    </div><!--인기가게2_1-->

</div><!--식당2-->

<div class="famous_Res"><!--식당3-->
  <div><!--인기가게3_1-->
    <div><!--사진구역-->
      <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/bbackdon.jpg"></a>
    </div><!--사진-->
    <div><!--소개전체-->
      <div><h4 class="h4">빽돈</h4></div><!--가게이름-->
      <div></div><!--가게소개-->
    </div>
    
    </div><!--인기가게3_1-->
</div><!--식당3-->


<div class="famous_Res"><!--식당4-->
  <div><!--인기가게4_1-->
    <div><!--사진구역-->
      <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/bistro.jpg"></a>
    </div><!--사진-->
    <div><!--소개-->
      <div><h4 class="h4">비스트로사랑방</h4></div><!--가게이름-->
      <div></div><!--가게소개-->
    </div>
    
    </div><!--인기가게4_1-->

</div><!--식당4-->

<div class="famous_Res"><!--식당5-->
  <div><!--인기가게5_1-->
    <div><!--사진구역-->
      <a href=""><img width="236px" height="172px" src="${contextPath}/resources/img/main/tantan.jpg"></a>
    </div><!--사진-->
    <div><!--소개-->
      <div><h4 class="h4">탄탄면공방</h4></div><!--가게이름-->
      <div></div><!--가게소개-->
    </div>
    
    </div><!--인기가게5_1-->

</div><!--식당5-->

</div><!--famous all-->
</div><!--container_Res-->
</div><!--famous 서울-->




<!---식당등록?-->

<div class="ownerAll">
  <div class="owner"><!--사진-->
    <a href=""><img src="${contextPath}/resources/img/main/owner.webp" width="400px" height="350px"></a>
  </div><!--사진-->
  <div class="owner"><!--소개페이지-->
  <div><!--사장으로 등록-->
  <h1 class="h1">당신의 가게를 등록하세요</h1><br>
  <p>다양한 정보를 보시려면 밑에 있는 버튼을 클릭하세요</p>
  
  <button id="informationBtn">see more information</button>
  
  </div><!--사장으로 등록-->
  </div><!--소개페이지-->
  </div><!--ownerAll-->




      




</div><!--container_res-->
</main><!--div main-->



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>




</body>
</html>