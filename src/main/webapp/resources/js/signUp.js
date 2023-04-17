//이메일 인증
const signUpEmail = document.getElementById("memberEmail");
const sendEmailBtn =document.getElementById("sendEmailBtn");
const emailAlarm = document.getElementById("emailAlarm");
const cMessage = document.getElementById("cMessage");
const cNumber = document.getElementById("cNumber");
const cNumberBtn = document.getElementById("cNumBtn");

let min = 4;
let sec = 59;
let checkInterval; //setInterval을 저장할 변수 clearInterval을 위해서 이렇게 변수에 집어넣는다.


//비밀번호
const memberPw = document.getElementById("memberPw");
const memberPwConfirm = document.getElementById("memberPwConfirm");
const pwAlarm = document.getElementById("pwAlarm");

//닉네임
const memberNick = document.getElementById("memberNick");
const nickAlarm = document.getElementById("nickAlarm");

//전화번호
const memberTel= document.getElementById("memberTel");
const telAlarm = document.getElementById("telAlarm");

//생일
const memberBirth = document.getElementById("memberBirth");

//주소
const memberAddr = document.getElementsByName("memberAddr");

//invalidate 여부 판단.


const checkObj = {
    "memberEmail" : false,
    "memberPw": false,//유효성 검사
    "memberPwConfirm" : false,//유효성 검사.
    "memberNickname" : false,//영어, 숫자, 한글 2~10글자 사이로, 중복검사.
    "memberTel" : false,//
    "sendEmail" : false,
    "checkNumber" : false
};

//-----------------------------------------------------------
//addEventListener구현부

signUpEmail.addEventListener("blur",function(){
    //"비동기 통신으로 인증가능한 이메일인지 확인할 것이다."
    if(signUpEmail.length == 0){
        emailAlarm.innerText = "메일을 받을 수 있는 이메일을 입력해주십시오.";
        //여기다가 remove와 success css를 추가해야한다.
    }else{
        const regExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;
        if(regExp.test(signUpEmail.value)){
            $.ajax({
                url:"emailDubChk",
                type:"POST",
                data: {"signUpEmail":signUpEmail.value},
                success:function(result){
                    if(result =="1"){
                        //중복인경우
                        emailAlarm.innerText = "이미 사용중인 이메일 입니다.";
                    }else{
                        emailAlarm.innerText="사용가능한 이메일 입니다.";
                        checkObj.memberEmail = true;
                    }
                },
                error : function(){
                    //비동기 통신중 오류가 발생한 경우
                }
            });
        }else{
            emailAlarm.innerText = "이메일 형식이 아닙니다."
            checkObj.memberEmail = false;
        }
        
    }    
});

sendEmailBtn.addEventListener("click",function(){
    if(checkObj.memberEmail){
        $.ajax({
            url: "sendEmail",
            data : {"inputEmail" : signUpEmail.value},
            type:"POST",
            success:function(result){
                console.log("이메일 발송 성공");
                console.log(result);
                //인증 버튼이 클리되어 정상적으로 보내졌음을 기록
                checkObj.sendEmail = true;
            },

            error:function(result){
                console.log("이메일 발송 실패");
            }

        });
        //Mail 발송 ajax 코드는 동작이 느림.
        //-> 메일은 메일대로 보내지고, 타이머는 바로 실행되어야한다.
        // --> ajax코드가 비동기이기 때문에 메일이 보내지는 것을 기다리지 않고
        //바로 수행된다.

        //5분 타이머
        //setInterval() : 지연시간이 지난 후 함수를 수행 (반복)
        cMessage.innerText="5:00";
        cMessage.classList.remove("confirm");
        cMessage.classList.remove("error");

        //변수를 저장해야 해당 함수를 멈출 수 있음.
        checkInterval = setInterval(function(){
            if(sec<10) sec = "0"+sec;
            cMessage.innerText = min + ":" + sec;
            if(Number(sec) === 0){
                min--;
                sec = 59;
            }else{
                sec--;
            }
            if(min === -1){
                cMessage.classList.add("error");
                cMessage.innerText = "인증번호가 만료되었습니다.";
                clearInterval(checkInterval);//setInterval 함수 반복을 지움.

            }
        },1000);//1초 지연 후 수행.
        alert("인증번호가 발송되었습니다. 이메일을 확인해주세요.");
    }
    
});

// const cNumber = document.getElementById("cNumber");
// const cNumberBtn = document.getElementById("cNumberBtn");

cNumberBtn.addEventListener("click",function(){
    // 1. 인증번호 받기 버튼이 클릭되어 이메일이 발송되었는지 확인.
    if(checkObj.sendEmail){
        //입력된 인증번호가 6자리가 맞는지 확인
        if(cNumber.value.length ==6){
            $.ajax({
                url: "checkNumber",
                data : {"cNumber" : cNumber.value,
                        "inputEmail" : signUpEmail.value},
                type:"Post",
                success:function(result){
                    console.log(result);
                
                    if(result == 1){
                        clearInterval(checkInterval);//타이머 멈춤.
                        cMessage.innerText="인증되었습니다."
                        checkObj.checkNumber = true;
                        //css추가해야한다.

                    }else if(result ==2){
                        alert("만료된 인증 번호 입니다.");
                        checkObj.checkNumber = false;
                    }else{
                        alert("인증 번호가 일치하지 않습니다.");
                        checkObj.checkNumber = false;
                    }
                },
                error:function(result){
                    console.log("이메일 발송 실패");
                }
        
            });
        }else
        {
            alert("인증번호를 정확하게 입력해주세요.");
            cNumber.focus();
        }
    
    }else{
        alert("인증번호 받기 버튼을 먼저 클릭해주세요.")
    }
});

// const memberPw = document.getElementById("memberPw");
// const memberPwConfirm = document.getElementById("memberPwConfirm");
// const pwAlarm = document.getElementById("pwAlarm");
memberPw.addEventListener("blur",function(){
    const regExp1 = /^[\w!@#_-]{6,30}$/;
    //6~30 특수문자 포함 영어 숫자 가능.
    
    if(regExp1.test(memberPw.value)){
        pwAlarm.innerText = "사용가능한 비밀번호 입니다.";
        //css추가.
        checkObj.memberPw = true;
    }
    else{
        pwAlarm.innerText = "사용불가능한 비밀번호 입니다.";
        //css추가
        checkObj.memberPw = false;
    }
});
memberPwConfirm.addEventListener("blur",function(){
    if(memberPwConfirm.value == memberPw.value){
        pwAlarm.innerText = "비밀번호가 일치합니다.";
        //css추가.
        checkObj.memberPwConfirm = true;

    }else{
        pwAlarm.innerText = "비밀번호가 불일치 합니다..";
        //css추가
        checkObj.memberPwConfirm = false;
    }
});
// const memberNick = document.getElementById("memberNick");
// const nickAlarm = document.getAnimations("nickAlarm");
memberNick.addEventListener("blur",function(){
    
    const regExp2 = /^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$/
    if(regExp2.test(memberNick.value)){
        console.log("되냐");
        $.ajax({
            url:"memberNickname",
            type:"POST",
            data:{"memberNickname" :memberNick.value},
            success: result =>{
                if(result == 0){
                    console.log("안돼?");
                    nickAlarm.innerText = "사용가능한 닉네임입니다."
                    checkObj.memberNickname = true;
                }else{
                    nickAlarm.innerText = "이미 사용된 닉네임입니다."
                    checkObj.memberNickname = false;
                }
            },
            error: result =>{
                //오류발생
            }
        });
    }else{
        nickAlarm.innerText = "양식에 맞지 않는 닉네임입니다. 다시 입력해주세요."
        checkObj.memberNickname = false;
    }

});




// const memberTel= document.getElementById("memberTel");
// const telAlarm = document.getElementById("telAlarm");
const regExp3 = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;
memberTel.addEventListener("blur",function(){
    if(regExp3.test(memberTel.value)){
        
        $.ajax({
            url:"memberTel",
            data: {"memberTel" :memberTel.value},
            type:"POST",
            success:function(result){
                console.log(result);
                //0인경우 중복x
                //1 중복
                if(result == 0){
                    telAlarm.innerText="사용가능한 전화 입니다.";
                    
                    checkObj.memberTel = true;
                }else{
                    telAlarm.innerText = "사용불가능한 전화 입니다.";
                    
                    checkObj.memberTel = false;
                }
            },
            error:function(result){
                console.log(result);
            }
        });
    
    }else{
        telAlarm.innerText="이 전화는 존재하지 않습니다.";
        
        checkObj.memberTel = false;

    }
});
function signUpInvalidate(){
    if(Object.values(checkObj).reduce((acc, val) => acc + val, 0) === 7){
        alert("모든 조건이 충족되었습니다.");
        

        $.ajax({
            url:"signUp",
            data: {"memberEmail" : signUpEmail.value,
                   "memberPw" : memberPw.value,
                   "memberNickname" :memberNick.value,
                    "memberTel" : memberTel.value,
                    "memberBirth": memberBirth.value,
                    "memberAddr" : memberAddr.value,
                    "loginType" : "N"
                },
            type:"POST",
            success:function(result){
                console.log(result);
                //0인경우 실패
                //1 성공
            
                if(result == 0){
                    console.log("회원가입실패");
                }else{
                    
                    return true;
                }
            },
            error:function(result){
                console.log(result);
            }
        });
        
    }else{
        alert("모든 조건이 충족되지 않았습니다.");
        return false;
    }
}