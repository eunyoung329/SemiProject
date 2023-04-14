/**
 * infoChange.js
 */
 
 // /* myInfo.js*/

//닉네임,전화번호,생일,주소 

//회원수정 버튼 클릭시 검사가 완료되었는지 확인하는 함수
function infoValidate() {




  const memberNick=document.getElementById("memberNick");
  const memberBirth=document.getElementById("memberBirth");
  const memberTel=document.getElementById("memberTel");
  const address=document.querySelectorAll('input[name="memberAddress"]');
  
  const regExp1 = /^[a-zA-Z0-9가-힣]{2,10}$/;        // 닉네임 정규식
  const regExp2 = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/; // 전화번호 정규식
  
  if(memberNick.value.length==0){
    alert("닉네임을 입력해주세요");
     memberNickname.focus();
    return false;
  }
  
  if(!regExp1.test(memberNick.value)){
  alert("닉네임은 영어/숫자/한글 2~10 글자 사이로 작성해주세요.");
  memberNick.focus();
  return false;
  
  }
  
  if(memberTel.value.length==0){
    alert("전화번호를 입력해주세요");
    memberTel.focus();
   return false;
  }
  
  
  if(!regExp2.test(memberTel.value)){
    return printAlert(memberTel,"전화번호 형식이 맞지 않습니다.");
  }
  
  
  return true;
  
  }
  
  function printAlert(el,message){
  
  
    alert(message);
    el.focus();
    return false;
  
  }