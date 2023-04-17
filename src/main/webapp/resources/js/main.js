// 사이드메뉴 오픈 
//import {KAKAO_AUTH_URL} from "${contextPath}/resources/js/OAuth.js";
// const CLIENT_ID = "96429edc93edc85fdb85c0bf03b50702";
// const REDIRECT_URI =  "http://localhost:8080/SemiProject/callback/kakaoLogin.jsp";
// const KAKAO_AUTH_URL = "https://kauth.kakao.com/oauth/authorize?client_id=96429edc93edc85fdb85c0bf03b50702&redirect_uri=http://localhost:8080/SemiProject/callback/kakaoLogin.jsp&response_type=code";
//console.log(KAKAO_AUTH_URL);

const openNav = () => {

    console.log("click")
    document.getElementById("mySidenav").style.width = "400px"
}

const closeNav = () => {
    document.getElementById("mySidenav").style.width = "0"
}

console.log("working?")

let loginID = null;
let loginPw = null;
let kakaoLogin_Btn = null;
let kakaoToken;
let kakao_account;
let loginMember;
let signUp_Btn = null;
const options = "width=400, height=500, top=50, left=400";
if("${empty sessionScope.loginMember}" == true)
{
    loginID = document.getElementById("loginID");
    loginPw = document.getElementById("loginPw");
    kakaoLogin_Btn = document.getElementById("kakaoLogin-Btn");
    signUp_Btn = document.getElementById("signBtn");
}else{
    loginID = null;
    loginPw = null;
    kakaoLogin_Btn = null;
}



const checkOBJ = {
    loginIdck : false,
    loginPwck : false
}














function loginwithKakao(){
        Kakao.init("ba5a975a4e3050a2c21c38fbe305e366");
        Kakao.Auth.login({
            scope : 'profile_nickname, profile_image, account_email, gender',
            success: function(authObj) {
                Kakao.API.request({  
                    url: '/v2/user/me',
                    success: res =>{
                        kakao_account = res.kakao_account;
                        loginkakao();
                    },
                    fail: function(error) {
                    }
                });
            },
            fail: function(error) {
                console.log(error);
            }
        });
};


function loginkakao(){
    
    $.ajax({
        url:"member/login",
        data:{"kakaoId" : kakao_account.email,
              "kakaoNick" :kakao_account.profile.nickname,
              "loginType" : "Y"},
        type:"POST",
        success: res=>{
            if(res != "null"){
                console.log("로그인 되었습니다.")
                location.href = "index.jsp";
            }else{
                console.log("멤버가 없어 로그인이 되지 않았습니다. 회원가입.");
                signUpkakao();
            }
        },
        error: res=>{

        }
    });
};
//logoutKakao();
function logoutKakao(){
    Kakao.init("ba5a975a4e3050a2c21c38fbe305e366");
    Kakao.isInitialized();
    if(!Kakao.Auth.getAccessToken()){
        console.log('Not logged in');
        return;
    }
    Kakao.Auth.logout(function(){
        console.log(Kakao.Auth.getAccessToken());
    })
}

function signUpkakao(){
    console.log("회원가입시작");
    $.ajax({
        url:"member/kakaosignUp",
        type:"POST",
        data:{"kakaoId" : kakao_account.email,
              "kakaoNick" : kakao_account.profile.nickname,
              "kakaoImage" : kakao_account.profile.profile_image_url,
              "loginType" : "Y"
            },
        success:function(res){
            if(res == "1"){
                console.log("가입되었습니다.");
                loginkakao();
            }
        },
        error:function(){
            
        }
    }); 
};


function loginInvalidate(){
    if(loginID.value.length ==0){
        alert("로그인 아이디를 입력하시오");
        checkOBJ.loginIdck=false;
    }
    else
        checkOBJ.loginIdck = true;

    if(loginPw.value.length == 0){
        alert("비밀번호를 입력하시오");
        checkOBJ.loginPwck = false;
    }
    else
        checkOBJ.loginPwck = true;
    
    if(Object.values(checkOBJ).reduce((acc, val) => acc + val, 0) === 2){
        return true;
    }
    return false;
}

