a<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="${contextPath}/resources/css/secession.css">
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


        <!-- 회원 탈퇴 -->
        <section class="myPage-secession container">
            <form action="secession" method="POST" name="myPage-secession">
                <div class="currentPw mb-5">
                    <label>비밀번호</label>
                    <input type="password" name="currentPw" id="currentPw" maxlength="30">
                </div>
        
                <label>탈퇴하시기 전, 내용을 꼭 확인해주세요.</label>
                <div class="secession_info">
                    <div>
                    1. 탈퇴하신다면 회원 정보는 모두 삭제되어 복구할 수 없습니다. <br>
                    2. 탈퇴하신다 하더라도 작성한 게시글, 댓글은 삭제되지 않습니다. <br>
                    3. 이용과정에서 불편한 점이 있으셨다면 문의 남겨주시기 바랍니다.
                    </div>
                </div>
                
                <div >
                    <input type="checkbox" name="secession-agree-btn">
                    <label for="secession-agree-btn">내용을 모두 확인하였습니다.</label>
                </div>
                
                <button id="seccsion-btn">탈퇴하기</button>

            </form>
            

        </section>
    </main>


    <jsp:include page ="/WEB-INF/views/common/footer.jsp"/>
    

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>