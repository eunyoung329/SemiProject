function secessionFLValidate() {

  const memberPw=document.getElementById("memberPw");
  const checkbox=document.getElementById("secession_agree");
 

  //pw이 공백일때
  if(memberPw.value.trim()==0){

   return printAlert(memberPw,"비밀번호를 입력해주세요")
  }
  //체크박스에 체크가 안됐을때
  if(!checkbox.checked){

 
    return printAlert(memberPw,"약관 동의 후 탈퇴 버튼을 클릭해주세요.");
  }

  //******정말 탈퇴할지 확인 ****/
  //-window.confirm("내용"): 대화상자에 확인/취소 생성
  //확인 클릭시 true/취소 클릭시 false
  //window는 생략가능

  if(!confirm("정말로 탈퇴 하시겠습니까?")){ //취소를 누른경우

    return false;




  }







return true;


}
function printAlert(el,message){


  alert(message);
  el.focus();
  return false;
}