<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="https://kit.fontawesome.com/069a8eb008.js"
   crossorigin="anonymous"></script>
<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
<link rel="stylesheet"
   href="${contextPath}/resources/css/reportStore.css">
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
   rel="stylesheet"
   integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
   crossorigin="anonymous">
<script src="${contextPath}/resources/js/reportStore.js"></script>
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
   integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
   crossorigin="anonymous"></script>
</head>
<body>

   <jsp:include page="/WEB-INF/views/common/header.jsp" />

   <main>
      <section class="report-Content">

         <form action="reportStore" name="report-form" method="POST"
            enctype="multipart/form-data" onsubmit="return validateForm()">

            <h3>상점제보</h3>
            
               <select class="form-select" aria-label="Default select example"
                  name="rest_category" id="rest_category">
                  <option selected>Open this select menu</option>
                  <option value="한식">한식</option>
                  <option value="양식">양식</option>
                  <option value="베이커리">베이커리</option>
                  <option value="카페">카페</option>
                  <option value="기타">기타</option>
               </select>
         


            <label for="rest_img">사진</label>
            <div>
               <input type="file" name="rest_img" id="rest_img">

            </div>
            <label for="rest_name">상점이름</label>
            <div>
               <input type="text" name="rest_name" id="rest_name"
                  autocomplete="off">

            </div>


            <label for="sample4_postcode">주소검색</label>
            <div class="storeAddrDiv postCode">
               <input type="text" name="rest_Addr" id="sample4_postcode"
                  placeholder="우편번호를 입력해주세요" autocomplete="off"> <input
                  type="button" id="postBtn" onclick="sample4_execDaumPostcode()"
                  value="우편번호">
            </div>
            <label for="sample4_roadAddress">도로명주소</label>
            <div class="storeAddrDiv">
               <input type="text" name="rest_Addr" id="sample4_roadAddress"
                  placeholder="도로명주소를 입력해주세요" autocomplete="off">
            </div>
            
            <label for="sample4_detailAddress">상세주소</label>
            <div class="storeAddrDiv">
               <input type="text" name="rest_Addr" id="sample4_detailAddress"
                  placeholder="상세주소를 입력해주세요" autocomplete="off">
            </div>
         
            <label for="floatingTextarea report_content">제보내용</label>
               <textarea class="form-control" id="report_content"
                  name="report_content" style="height: 100px"></textarea>
         

            <button type="submit" id="reportBtn">제보하기</button>
         </form>
      </section>

   </main>
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