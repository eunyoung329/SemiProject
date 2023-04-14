//이메일 인증
const signUpEmail = document.getElementById("memberEmail");
const sendEmail =document.getElementById("sendEmailBtn");
const emailAlarm = document.getElementById("emailAlarm");
const cNumber = document.getElementById("cNumber");
const cNumberBtn = document.getElementById("cNumberBtn");


//비밀번호
const memberPw = document.getElementById("memberPw");
const memberPwConfirm = document.getElementById("memberPwConfirm");
const pwAlarm = document.getElementById("pwAlarm");

//닉네임
const memberNick = document.getElementById("memberNick");
const nickAlarm = document.getAnimations("nickAlarm");

//전화번호
const memberTel= document.getElementById("memberTel");
const telAlarm = document.getElementById("telAlarm");

//생일
const memberBirth = document.getElementById("memberBirth");

//주소
const memberAddr = document.getElementsByName("memberAddr");


//-----------------------------------------------------------
//addEventListener구현부

signUpEmail.addEventListener("blur",function(){
    console.log("비동기 통신으로 인증가능한 이메일인지 확인할 것이다.");
    $.ajax({
        url:member/emailDubChk,
        TYPE:"POST",
        data: {"signUpEmail":signUpEmail.value},
        success:function(result){
            
        }
    });
});



function signUpInvalidate(){

}