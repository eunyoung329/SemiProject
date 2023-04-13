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

const loginID = document.getElementById("loginID");
const loginPw = document.getElementById("loginPw");

const checkOBJ = {
    loginIdck : false,
    loginPwck : false
}
var kakaoToken;
var kakao_account;
var loginMember;

const kakaoLogin_Btn = document.getElementById("kakaoLogin-Btn");
const options = "width=400, height=500, top=50, left=400";
const signUp_Btn = document.getElementById("signBtn");



signUp_Btn.addEventListener("click",function(){
    console.log("안돼?");

});




kakaoLogin_Btn.addEventListener("click", async function(){
    try{
		kakao_account = await loginwithKakao();
    	console.log(kakao_account);
    	if(kakao_account !== null){
        loginMember = await loginkakao();
        if(loginMember === "null"){
            const res = await signUpkakao();
            if(res ===1){
                loginMember = await loginkakao();
                console.log(loginMember);
                if(loginMember != "null"){
                    console.log("되냐");
                    location.href ='index';
                }
            }   

        }else{
            location.href = 'index.jsp';
        }
    }else{
        console.log("실패다");
    }
    }catch(error){
        console.log(error);
    }});

function loginwithKakao(){
        return new Promise((resolve,reject) =>{
        Kakao.init("ba5a975a4e3050a2c21c38fbe305e366");
        Kakao.Auth.login({
            scope : 'profile_nickname, profile_image, account_email, gender',
            success: function(authObj) {
                Kakao.API.request({  
                    url: '/v2/user/me',
                    
                    success: res =>{
                        
                        kakao_account = res.kakao_account;
                        console.log(kakao_account.email);   
                        resolve(kakao_account);
                         
                    },
                    fail: function(error) {
                        reject(error);
                    }
                });
            },
            fail: function(error) {
                console.log(error);
            }
        });
})
};


function loginkakao(){
    return new Promise((resolve,reject) =>{
    $.ajax({
        url:"member/login",
        data:{"kakaoId" : kakao_account.email,
              "kakaoNick" :kakao_account.profile.nickname,
              "loginType" : "Y"},
        type:"POST",
        success: res=>{
            resolve(res);
        },
        error: res=>{
            reject(res);
        }
    });
})
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
    return new Promise((resolve,reject) =>{
    $.ajax({
        url:"member/signUp",
        type:"POST",
        data:{"kakaoId" : kakao_account.email,
              "kakaoNick" : kakao_account.profile.nickname,
              "kakaoImage" : kakao_account.profile.profile_image_url,
              "kakaoGender" : kakao_account.gender
            },
        success:function(res){
            resolve(res)
            
        },
        error:function(){
            reject(res);
        }
    }); 
}) 
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

