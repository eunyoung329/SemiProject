<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
    <link rel = "stylesheet" href ="${contextPath}/resources/css/board.css">
    <link rel = "stylesheet" href ="${contextPath}/resources/bootstrap/css/bootstrap.rtl.css">
    <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
        
    <script src="https://kit.fontawesome.com/d89904c156.js" crossorigin="anonymous"></script>
    <!-- css아래에 위치해있도록 하기. -->
</head>
<body>
  <jsp:include page ="/WEB-INF/views/common/header.jsp"/>





    <main>

      <c:choose>
        <c:when test="${empty requestScope.result}">
      
        <!-- <section>
          <div class="back-ground-image">
            출처 <a href="https://kr.freepik.com/free-vector/realistic-wood-texture-background_14881526.htm#query=%EB%82%98%EB%AC%B4%20%ED%85%8C%EC%9D%B4%EB%B8%94&position=17&from_view=keyword&track=ais">작가 vikayatskina</a> 출처 Freepik<a href="https://kr.freepik.com/free-vector/realistic-wood-texture-background_14881526.htm#query=%EB%82%98%EB%AC%B4%20%ED%85%8C%EC%9D%B4%EB%B8%94&position=17&from_view=keyword&track=ais">작가 vikayatskina</a> 출처 Freepik
            <img style = "width:100%; height:100vh;" src = "${contextPath}/resources/img/table.png">
            <div class = "test_obj">
              <span class = "font-gwang font-title">Community</span>
            </div>
          </div>
        </section> -->
        

        <!-- 커뮤니티 배너-->
        <!-- <section class = "container-first">
          <div class = "main-banner">
            <div>
              <span class = "font-gwang">먹토피아 커뮤니티</span>
            </div>
          </div>
        </section>
         -->
        <section id="title-area">
          <div class="title-text-container">
            <p class="title-text">SHARE <br> YOUR <br> THOUGHTS</p>
            <p class="title-text-sub">당신의 이야기를 들려주세요</p>
          </div>
        </section>




        <!-- <section class = "container-1">
            <div style = "width:800px;"><span class = "font-gwang">오늘의 화제</span></div>
            <div id="carouselExampleIndicators" class="carousel slide gradient" data-bs-ride="true">
              <div class="carousel-inner heightfull">
                <div class="carousel-item active heightfull">
                  <div class = "bestList-item">
                    <div><img src="/SemiProject/src/main/webapp/resources/img/defaultResImg.png" class="d-block w-100 imgsize" alt="..."></div>
                    <div class="item-sentence">
                      <div class="item-title">
                        <span>야</span>
                      </div>
                      <div>
                        <span>영역</span>
                      </div>
                    </div> 
                  </div>
                  <div class = "bestList-item">
                    <div><img src="/SemiProject/src/main/webapp/resources/img/defaultResImg.png" class="d-block w-100 imgsize" alt="..."></div>
                    <div class="item-sentence">
                      <div class="item-title">
                        <span>야</span>
                      </div>
                      <div>
                        <span>영역</span>
                      </div>
                    </div> 
                  </div>
                  <div class = "bestList-item">
                    <div><img src="/SemiProject/src/main/webapp/resources/img/defaultResImg.png" class="d-block w-100 imgsize" alt="..."></div>
                    <div class="item-sentence">
                      <div class="item-title">
                        <span>야</span>
                      </div>
                      <div>
                        <span>영역</span>
                      </div>
                    </div> 
                  </div>
                  <div class = "bestList-item">
                    <div><img src="/SemiProject/src/main/webapp/resources/img/defaultResImg.png" class="d-block w-100 imgsize" alt="..."></div>
                    <div class="item-sentence">
                      <div class="item-title">
                        <span>야</span>
                      </div>
                      <div>
                        <span>영역</span>
                      </div>
                    </div> 
                  </div>
                  <div class = "bestList-item">
                    <div><img src="/SemiProject/src/main/webapp/resources/img/defaultResImg.png" class="d-block w-100 imgsize" alt="..."></div>
                    <div class="item-sentence">
                      <div class="item-title">
                        <span>야</span>
                      </div>
                      <div>
                        <span>영역</span>
                      </div>
                    </div> 
                  </div>
                </div>
                  <div class="carousel-item heightfull">
                    <div class = "bestList-item">
                      <div><img src="/SemiProject/src/main/webapp/resources/img/defaultResImg.png" class="d-block w-100 imgsize" alt="..."></div>
                      <div class="item-sentence">
                        <div class="item-title">
                          <span>야</span>
                        </div>
                        <div>
                          <span>영역</span>
                        </div>
                      </div> 
                    </div>
                    <div class = "bestList-item">
                      <div><img src="/SemiProject/src/main/webapp/resources/img/defaultResImg.png" class="d-block w-100 imgsize" alt="..."></div>
                      <div class="item-sentence">
                        <div class="item-title">
                          <span>야</span>
                        </div>
                        <div>
                          <span>영역</span>
                        </div>
                      </div> 
                    </div>
                    <div class = "bestList-item">
                      <div><img src="/SemiProject/src/main/webapp/resources/img/defaultResImg.png" class="d-block w-100 imgsize" alt="..."></div>
                      <div class="item-sentence">
                        <div class="item-title">
                          <span>야</span>
                        </div>
                        <div>
                          <span>영역</span>
                        </div>
                      </div> 
                    </div>
                    <div class = "bestList-item">
                      <div><img src="/SemiProject/src/main/webapp/resources/img/defaultResImg.png" class="d-block w-100 imgsize" alt="..."></div>
                      <div class="item-sentence">
                        <div class="item-title">
                          <span>야</span>
                        </div>
                        <div>
                          <span>영역</span>
                        </div>
                      </div> 
                    </div>
                    <div class = "bestList-item">
                      <div><img src="/SemiProject/src/main/webapp/resources/img/defaultResImg.png" class="d-block w-100 imgsize" alt="..."></div>
                      <div class="item-sentence">
                        <div class="item-title">
                          <span>야</span>
                        </div>
                        <div>
                          <span>영역</span>
                        </div>
                      </div> 
                    </div>
                  </div>
                  <div class="carousel-item heightfull">
                    <div class = "bestList-item">
                      <div><img src="/SemiProject/src/main/webapp/resources/img/defaultResImg.png" class="d-block w-100 imgsize" alt="..."></div>
                      <div class="item-sentence">
                        <div class="item-title">
                          <span>야</span>
                        </div>
                        <div>
                          <span>영역</span>
                        </div>
                      </div> 
                    </div>
                    <div class = "bestList-item">
                      <div><img src="/SemiProject/src/main/webapp/resources/img/defaultResImg.png" class="d-block w-100 imgsize" alt="..."></div>
                      <div class="item-sentence">
                        <div class="item-title">
                          <span>야</span>
                        </div>
                        <div>
                          <span>영역</span>
                        </div>
                      </div> 
                    </div>
                    <div class = "bestList-item">
                      <div><img src="/SemiProject/src/main/webapp/resources/img/defaultResImg.png" class="d-block w-100 imgsize" alt="..."></div>
                      <div class="item-sentence">
                        <div class="item-title">
                          <span>야</span>
                        </div>
                        <div>
                          <span>영역</span>
                        </div>
                      </div> 
                    </div>
                    <div class = "bestList-item">
                      <div><img src="/SemiProject/src/main/webapp/resources/img/defaultResImg.png" class="d-block w-100 imgsize" alt="..."></div>
                      <div class="item-sentence">
                        <div class="item-title">
                          <span>야</span>
                        </div>
                        <div>
                          <span>영역</span>
                        </div>
                      </div> 
                    </div>
                    <div class = "bestList-item">
                      <div><img src="/SemiProject/src/main/webapp/resources/img/defaultResImg.png" class="d-block w-100 imgsize" alt="..."></div>
                      <div class="item-sentence">
                        <div class="item-title">
                          <span>야</span>
                        </div>
                        <div>
                          <span>영역</span>
                        </div>
                      </div> 
                    </div>
                  </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
                </button>
              <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
              </button>
            </div>
            <div class = "bestList-bottom">
              <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
              </div>
            </div>
        </section> -->
        <section class = "container-2">

          <!-- 글쓰기 버튼 -->
          <c:choose>
            <c:when test = "${!empty sessionScope.loginMember}">
              <div class = "writeBtnArea">
                <a href = "${contextPath}/board/boardWrite">
                <button class="writeBtn">
                  <i class="fa-regular fa-pen-to-square"></i> 글쓰기
                </button>
                </a>
              </div>
              <script>
                sessionStorage.setItem("loginMember",'${loginMember}');
              </script>
            </c:when>
          </c:choose>



          <div class="content-container">

            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3 mainContent">
              <!-- <div class="col">
                <div class="card shadow-sm">
                  <svg class="bd-placeholder-img card-img-top col-base" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
      
                  <div class="card-body">
                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    <div class="d-flex justify-content-between align-items-center">
                      
                      <small class="text-muted">9 mins</small>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col">
                <div class="card shadow-sm">
                  <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
      
                  <div class="card-body">
                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    <div class="d-flex justify-content-between align-items-center">
                      
                      <small class="text-muted">9 mins</small>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col">
                <div class="card shadow-sm">
                  <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
      
                  <div class="card-body">
                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    <div class="d-flex justify-content-between align-items-center">
                      
                      <small class="text-muted">9 mins</small>
                    </div>
                  </div>
                </div>
              </div>
      
              <div class="col">
                <div class="card shadow-sm">
                  <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
      
                  <div class="card-body">
                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    <div class="d-flex justify-content-between align-items-center">
                      
                      <small class="text-muted">9 mins</small>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col">
                <div class="card shadow-sm">
                  <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
      
                  <div class="card-body">
                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    <div class="d-flex justify-content-between align-items-center">
                      
                      <small class="text-muted">9 mins</small>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col">
                <div class="card shadow-sm">
                  <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
      
                  <div class="card-body">
                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    <div class="d-flex justify-content-between align-items-center">
                      
                      <small class="text-muted">9 mins</small>
                    </div>
                  </div>
                </div>
              </div>
      
              <div class="col">
                <div class="card shadow-sm">
                  <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
      
                  <div class="card-body">
                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    <div class="d-flex justify-content-between align-items-center">
                      
                      <small class="text-muted">9 mins</small>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col">
                <div class="card shadow-sm">
                  <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
      
                  <div class="card-body">
                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    <div class="d-flex justify-content-between align-items-center">
                      
                      <small class="text-muted">9 mins</small>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col">
                <div class="card shadow-sm">
                  <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
      
                  <div class="card-body">
                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                    <div class="d-flex justify-content-between align-items-center">
                      
                      <small class="text-muted">9 mins</small>
                    </div>
                  </div>
                </div>
              </div> -->
            </div>
          </div>
          



        </section>

        

        <!--
        <section class= "container-3">
          <div class = "con-attribute">  
            <div class = "button-group">
              <button class ="btn-group-style">1</button>
              <button class ="btn-group-style">2</button>
              <button class ="btn-group-style">3</button>
              <button class ="btn-group-style">4</button>
              <button class ="btn-group-style">5</button>
            </div>
          </div>
        </section>-->
        </c:when>
      </c:choose>
        <!-- <section class = "search-place">
            <div>
                <form action = "#" method="post">
                    <fieldset class = "searchField">
                        <input id="query" name="query" placeholder="게시물 제목을 입력해주세요">
                        <button id="search-btn"><i class="fa fa-thin fa-plane-departure"></i></button>
                    </fieldset>
                </form> 
            </div>
        </section> -->
    
        <!-- 위로 가기  -->
        <div class="board_top_btn_area container">
          <i class="fa-solid fa-square-caret-up"></i>
        </div>
        <%-- session에 message 속성이 존재하는 경우 alert창으로 해당 내용을 출력 --%>
   <c:if test="${ !empty sessionScope.message }">
       <script>
           alert("${message}");
           // EL 작성 시 scope를 지정하지 않으면
           // page -> request -> session -> application 순서로 검색하여
           // 일치하는 속성이 있으면 출력
       </script>
       
       <%-- message 1회 출력 후 session에서 제거 --%>
       <c:remove var="message" scope="session"/>
   </c:if>
      </main>
    <jsp:include page ="/WEB-INF/views/common/footer.jsp"/>

    <!--  부트스트랩 js 사용 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/bootstrap/js/bootstrap.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src ="${contextPath}/resources/js/board.js"></script>
    <script src="${contextPath}/resources/js/main.js"></script>
</body>
</html>