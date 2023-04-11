<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- <c:choose>
    <c:when test = "${empty sessionScope.loginMember}"> -->
<header>
    <div>
     <img src="${contextPath}/resources/img/logoSample2.png" alt="">
    </div>

    <div>
     <button type="button" onclick="openNav()" id="loinOpenBtn"><i class="fa-solid fa-user" style="color: #ffffff;"></i>Login</button>
    </div>
    
    <!-- 로그인/프로필 사이드 메뉴 -->
    <div class="side-menu" id="mySidenav">
         <button type="button" id="loginCloseBtn" onclick="closeNav()" >&times;</button>
         
         <div class="loginWrap">
             <div class="loginLogoArea">
                 <img src="${contextPath}/resources/img/logoSample2.png" alt="">
             </div>

             <div class="login-area">

                 <form action="" type = "post" name="loginForm" onclick = "loginInvalidate()">
                     <label>Email Address</label>
                     <input type="text" id ="loginID" name ="loinID">
                     <label>Password</label>
                     <input type="password" id = "loginPw" name = "loginPw">
                     <span id="mail-Msg">메일 입력 관련 메세지</span>
                     <button id="loginBtn">이메일로 로그인하기</button>
                 </form>
                     <button id="kakaoLogin-Btn"><i class="fa-solid fa-comment"></i>카카오톡으로 로그인하기</button>
             </div>

             <span>
                 <a href="">이메일 찾기</a>
                 |
                 <a href="">비밀번호 찾기</a>
             </span>

             <div class="hr-sect">OR</div>
             
             
             <div class="sign-area">
                 <button><i class="fa-solid fa-envelope"></i>이메일로 가입하기</button>
                 <button><i class="fa-solid fa-comment"></i>카카오톡으로 가입하기</button>
             </div>
         </div>
     </div>
 </div>
 </header>
