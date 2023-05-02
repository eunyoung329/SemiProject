<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BoardWrite</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
    <link rel = "stylesheet" href = "${contextPath}/resources/css/boardWrite.css">
    <script src="https://kit.fontawesome.com/d89904c156.js" crossorigin="anonymous"></script>    
</head>
<body>
    <jsp:include page ="/WEB-INF/views/common/header.jsp"/>
    <!--전체 페이지-->
    <main>
        <!--최대한 네이버나 다른 프론트 처럼 줄여도 어느정도 줄어들었을때 더이상 줄어들지 않게 하는 프론트 엔드 작성.-->
        <!--타이틀-->
        <form action="boardWrite" method="POST" id = "boardForm" enctype="multipart/form-data" onsubmit="return boardinvalidate()">
            <section class = "board">
                <section class="board_Container-1">
                    <div class= "board_title-box">
                        <div class = "board_title_sentence">
                            <input type="text" class = "board_titleInput" name = "boardtitle" placeholder="제목을 입력하세요">                    
                        </div>
                    </div>
                </section>
                <!--태그-->
                <section class ="board_Container-2">
                    <div id = "tagPlace" style="width:392.5px;">  
                        <input class ="inputTag" type="text">
                        <div class = "tagBtn"><i class="fa fa-solid fa-plus tagButton"></i></div>
                    </div>

                    <div>
                        <div class="profile-btn-area">
                            <label for="input-image">
                                <i class="fas fa-upload"></i>
                                <input style ="display:none" type="file" name="boardImage" id="input-image" accept="image/*">
                            </label>
                            
                            <!-- accept="image/*" : 이미지 파일 확장자만 선택 허용 -->
                            <!-- accept="video/*" : 동영상 파일 확장자만 선택 허용 -->
                            <!-- accept=".pdf" : pdf파일만 선택 허용 -->
                        </div>
                    </div>
                    
                </section>
                <!--글효과(이미지삽입, 줄추가-classList.add를 사용할 것 같음.)-->
                <!--<section></section>-->
                <!--본문-->
                <section class ="board_Container-3">
                    <div class="board_content">
                        <textarea id="inputArea"></textarea>
                    </div>
                </section>
                <!--뒤로가기 및, 작성완료를 알리는 버튼 바닥에 달라붙어 있어야함-->
                <section class = "board_Container-4">
                    <div class ="btn-Group">
                        <div>
                            <button type="button" id="clear">초기화</button>
                            <button type="submit">보내기</button>
                        </div>
                    </div>
                </section>
            </section>
        </form>
    <main>
        <jsp:include page ="/WEB-INF/views/common/footer.jsp"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/main.js"></script>
    <script src="${contextPath}/resources/js/boardWrite.js"></script>
</body>
</html>