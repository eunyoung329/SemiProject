const currentPw=document.getElementById("currentPw");
const newPw=document.getElementById("newPw");
const newPwConfirm=document.getElementById("newPwConfirm");



function pwChangeValidate() {




// if(currentPw.value.length==0){
//   if(newPw.value==0){
//     if(newPwConfirm.value.length==0){
//    alert("비밀번호 확인창에 비밀번호를 입력해주세요");
//    return false;
//     }
//   alert("새로운 비밀번호 창에 비밀번호를 입력해주세요");
//   return false;
//   }
//   alert("현재 비밀번호를 입력해주세요");
//   return false;
// }

//비밀번호창에 공백 X

if(currentPw.value.trim().length==0 ){


return printAlert(currentPw,"현재비밀번호를 입력해주세요")
}

if(newPw.value.trim().length==0) {


  return printAlert(newPw,"새로운 비밀번호를 입력해주세요");

}

if(newPwConfirm.value.trim().length==0){


  return printAlert(newPwConfirm,"새로운 비밀번호를 확인해주세요");
}






if(newPw.value!=newPwConfirm.value){

 return printAlert(newPw,"비밀번호가 일치하지 않습니다.");
}



return true;



   
   
   







}

   
   
   
   
   
function printAlert(el,message){

  alert(message);
  el.focus();
  return false;

}