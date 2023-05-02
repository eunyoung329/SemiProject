<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>


<c:choose>
    <c:when test = "${empty sessionScope.loginMember}">
    <div>
    	<a href="${contextPath}/index.jsp">
    		 <img src="${contextPath}/resources/img/logo.png" alt="로고">
    	 </a>
    </div>

    <div>
     <button type="button" onclick="openNav()" id="loinOpenBtn"><i class="fa-solid fa-user" style="color: #ffffff;"></i>Login</button>
    </div>
    
    <!-- 로그인/프로필 사이드 메뉴 -->
    <div class="side-menu" id="mySidenav">
         <button type="button" id="loginCloseBtn" onclick="closeNav()" >&times;</button>
         
         <div class="loginWrap">
             <div class="loginLogoArea">
                 <img src="${contextPath}/resources/img/logo.png" alt="로고">
             </div>

             <div class="login-area">

                 <form action="${contextPath}/member/login" method = "POST" name="loginForm" onsubmit = "loginInvalidate()">
                     <label>Email Address</label>
                     <input type="text" id ="loginID" name ="loginID">
                     <label>Password</label>
                     <input type="password" id = "loginPw" name = "loginPw">
                     <button id="loginBtn" type="submit">이메일로 로그인하기</button>
                 </form>
                    
                     <button id="kakaoLogin-Btn" onclick="loginwithKakao()"><i class="fa-solid fa-comment"></i>카카오톡으로 로그인하기</button>
                    
             </div>
            
             <span>
                 <a href="">이메일 찾기</a>
                 |
                 <a href="">비밀번호 찾기</a>
             </span>

             <div class="hr-sect">OR</div>
             
             
             <div class="sign-area">
                 <button id = "header_signBtn" onclick="location.href='${contextPath}/member/signUp';"><i class="fa-solid fa-envelope"></i>이메일로 가입하기</button>
                 <!-- <button type = "button" id = "kakaoLogin-Btn"><i class="fa-solid fa-comment"></i>카카오톡으로 가입하기</button> -->
             </div>
         </div>
     </div>
 </div>
</c:when>
<c:otherwise>

    <div>
         <a href="${contextPath}/index.jsp">
    		 <img src="${contextPath}/resources/img/logo.png" alt="로고">
    	 </a>
    </div>

    <div class="headerProfile">
     <span name="header_nickName" id="header_nickName">${loginMember.memberNick}</span>
     <button type="button" onclick="openNav()" id="profileBtn"><img src="${contextPath}/resources/img/defaultUser.png" alt=""></button>
    </div>

    <!-- 로그인/프로필 사이드 메뉴 -->
    <div class="side-menu" id="mySidenav">
         <button type="button" id="loginCloseBtn" onclick="closeNav()" >&times;</button>
         
         <div class="profileWrap">
             <div class="profileArea">
                 <img src="${contextPath}/resources/img/defaultUser.png" alt="">
                 <span name="header_nickName">${loginMember.memberNick}</span>
             </div>

             <ul class="infoList">
                 <a href="${contextPath}/member/infoChange">
                     <li>
                         <i class="fa-regular fa-user"></i>내 정보
                     </li>
                 </a>
                 <a href="">
                     <li>
                         <i class="fa-regular fa-comment"></i>내가 작성한 리뷰
                     </li>
                 </a>
                 <a href="${contextPath}/member/wishList">
                     <li>
                         <i class="fa-regular fa-heart"></i>찜한 목록
                     </li>
                 </a>
                 <a href="${contextPath}/member/reportStore">
                     <li>
                         <i class="fa-solid fa-shop"></i>가게 제보
                     </li>
                 </a>
                 <a href="">
                     <li>
                         <i class="fa-regular fa-circle-question"></i>도움말
                     </li>
                 </a>
             </ul>

             <a href="${contextPath}/member/logout" class="hey">
                 <div>
                     <i class="fa-solid fa-power-off"></i>로그아웃
                 </div>
             </a>

             
         </div>
     </div>
 </div>

</c:otherwise>
</c:choose>
</header>