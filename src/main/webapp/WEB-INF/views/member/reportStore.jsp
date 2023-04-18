<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <script src="https://kit.fontawesome.com/069a8eb008.js" crossorigin="anonymous"></script> 
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/reportStore.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="${contextPath}/resources/js/reportStore.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>

  <jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
	<main>
            <section class="report-Content">

                <form action="reportStore" name="report-form" method="POST" enctype="multipart/form-data" onsubmit="return validateForm()" >

                    <h3>상점제보</h3>

                    <label for="storeImage">사진</label>
                    <div>
                     <input type="file" name="storeImage" id="storeImage">
                        
                    </div>
                    <span>
                        
                    </span>


                    <label for="storeName">상점이름</label>
                    <div>
                        <input type="text" name="storeName" id="storeName" autocomplete="off">

                    </div>


                    <label for="sample4_postcode">주소검색</label>
                    <div class="storeAddrDiv postCode">
                        <input type="text" name="storeAddr"  id="sample4_postcode" placeholder="우편번호를 입력해주세요" autocomplete="off">
                        <input type="button" id="postBtn" onclick="sample4_execDaumPostcode()" value="우편번호">
                    </div>
                    <label for="sample4_roadAddress">도로명주소</label>
                    <div class="storeAddrDiv">
                        <input type="text" name="storeAddr" id="sample4_roadAddress" placeholder="도로명주소를 입력해주세요" autocomplete="off">
                    </div>
                    <label for="sample4_jibunAddress">지번주소</label>
                    <div class="storeAddrDiv">
                        <input type="text" name="storeAddr" id="sample4_jibunAddress" placeholder="지번주소를 입력해주세요" autocomplete="off">
                        <span id="guide" style="color:#999;display:none"></span>
                    </div>
                    <label for="sample4_detailAddress">상세주소</label>
                    <div class="storeAddrDiv">
                        <input type="text" name="storeAddr"  id="sample4_detailAddress" placeholder="상세주소를 입력해주세요" autocomplete="off">
                    </div>
                    <label for="sample4_extraAddress">참고항목</label>
                    <div class="storeAddrDiv">
                        <input type="text" name="storeAddr" id="sample4_extraAddress"  placeholder="참고항목을 입력해주세요" autocomplete="off">
                    </div>
                    

                    <button type="submit" id="reportBtn">제보하기</button>
                </form>
            </section>

    </main>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   <script>
  function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
            
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("sample4_extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            }
        }
    }).open();
}
</script>

  </body>
  </html>