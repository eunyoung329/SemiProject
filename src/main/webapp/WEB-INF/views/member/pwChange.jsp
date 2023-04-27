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
    <link rel="stylesheet" href="${contextPath}/resources/css/pwChange.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    
    <jsp:include page ="/WEB-INF/views/common/header.jsp"/>

	    <main>
        <!-- 정보 메뉴 -->
        <section class="info-menu container">
            <ul>
                <li><a href="${contextPath}/member/infoChange">정보변경</a></li>
                <li><a href="${contextPath}/member/pwChange">비밀번호변경</a></li>
                <li><a href="${contextPath}/member/secession">회원탈퇴</a></li>
            </ul>
        </section>


        <!-- 비밀번호 변경 -->
        <section class="myPage-pwChange">
            <form action="chagePw" method="post" name="myPage-pwForm">
                <div>
                    <label>현재 비밀번호</label>
                    <input type="password" name="currentPw" id="currentPw" maxlength="30">
                </div>
    
                <div>
                    <label>새 비밀번호</label>
                    <input type="password" name="newPw" id="newPw" maxlength="30">
                </div>
    
                <div>
                    <label>새 비밀번호 확인</label>
                    <input type="password" name="newPwConfirm" id="newPwConfirm" maxlength="30">
                </div>
    
                <button id="pw-chagne-btn">변경하기</button>
            </form>
        </section>
        
            
    </main>


    <jsp:include page ="/WEB-INF/views/common/footer.jsp"/>
    

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>