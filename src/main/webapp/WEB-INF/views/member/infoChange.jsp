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
    <link rel="stylesheet" href="${contextPath}/resources/css/infoChange.css">
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


            <!-- 정보 변경 -->
            <section class="ChangeInfo-area container">

                <div class="myImg-area">
                    
                    <c:if test="${empty loginMember.profileImage}">
                        <img src="${contextPath}/resources/img/profileImg/defaultUser.png" alt="프로필 이미지">
                    </c:if> 
                   
                    <c:if test="${!empty loginMember.profileImage}">
                        <img src="${contextPath}/${loginMember.profileImage}" alt="프로필 이미지">
                    </c:if> 
                    
                    <button type="button" id="info_img_select_btn"><i class="fa-solid fa-camera"></i></button>
                </div>

                <!-- 사진 변경 모달 창 -->
                <div class="info_img_modal">
                    <div class="info_img_modal_content">
                        <button id="info_modal_close">&times;</button>
                        <h2>프로필 이미지 변경</h2>

                        <form action="profileImg" method="POST" name="profileImg-form" 
                              enctype="multipart/form-data" onsubmit="return profileValidate()">
                            <div class="info_modal_img_area">
                                <c:if test="${empty loginMember.profileImage}">
                                    <img src="${contextPath}/resources/img/profileImg/defaultUser.png" alt="프로필 이미지" id="info_profile_img">
                                </c:if> 
                               
                                <c:if test="${!empty loginMember.profileImage}">
                                    <img src="${contextPath}/${loginMember.profileImage}" alt="프로필 이미지" id="info_profile_img">
                                </c:if> 

                                <div class="info_modal_img_change_area">
                                    <label for="input-image"><i class="fa-solid fa-camera"></i></label>
                                    <input type="file" name="profileImage" id="input-image" accept="image/*">
                                </div>
                              </div>
                              
                              
                              <div class="info_modal_btn_area">
                                <button type="submit">저장</button>
                                <button  type="button" id="info_img_delete_btn">삭제</button>
                              </div>

                             <!-- 이미지 삭제 버튼이 눌러짐을 기록 --> <!-- 이미지 삭제 버튼이 눌러짐을 기록 -->
                             <input type="hidden" name="info_img_delete" id="info_img_delete" value="0">
                        </form>
                    </div><!-- modal content 끝 -->
                </div><!-- modal 끝 -->

                <form action="infoChange" method="POST" name="info-form" id="info-form">
                    <label for="nickName">닉네임</label>
                    <div>
                        <input type="text" name= "memberNickname" id="nickName" value="${loginMember.memberNick}"><br>
                    </div>
                    <span id="infoChange_nickMsg">닉네임 안내</span><br>


                    <label for="tel">전화번호</label>
                    <div>
                        <input type="number" name="memberTel" id="tel" value="${loginMember.memberTel}" placeholder="'-'를 제외한 11자리 번호를 입력하세요.">
                    </div>

                
                    <label for="birth">생일</label>
                    <div>  
                        <input type="number" name="memberBirth" id="birth" value="${loginMember.memberBirth}" maxlength="8" placeholder="'-'를 제외한 8자리 숫자를 입력하세요.">
                    </div>

                    <c:set var="addr" value="${fn:split(loginMember.memberAddress, ',,')}"/>
                    <label for="addr">주소</label>
                    <div class="addr-area">
                        <input type="text" name="memberAddress" id="info_postCode" value="${addr[0]}">
                        <button id="postBtn" type="button" onclick="return execDaumPostcode() ">우편번호</button>
                    </div>
                    <div class="addr-area">
                        <input type="text" name="memberAddress" value="${addr[1]}" id="info_address">
                    </div>
                    <div class="addr-area">
                        <input type="text" name="memberAddress" value="${addr[2]}" id="info_detailAddress">
                    </div>

                    <button id="saveBtn" type="button" onclick="return infoValidate()">변경하기</button>
                </form>
            </section>
    </main>


    <jsp:include page ="/WEB-INF/views/common/footer.jsp"/>
    

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/main.js"></script>
    <script src="${contextPath}/resources/js/infoChange.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>
</html>