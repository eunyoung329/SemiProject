// 사이드메뉴 오픈 
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




// kakaoLogin_Btn.addEventListener("click",function(){
//     loginwithKakao();
//     if(kakaoToken === null){
//         console.log("오류");
//     }else{
//         const loginID = kakaoToken.id;
//         const loginNickname = kakaoToken.kakao_account.profile_nickname;
//         $.ajax({
//             url: "member/login",
//             type: "POST",
//             data: {"kakaoId": loginID,
//                    "kakaoNick" : loginNickname,//response.properties.nickname,
//                    "loginType" : "Y"},
//             success : function(loginMember){
//                 console.log(loginMember);
//                 if("${empty !empty sessionScope.loginMember"){
//                     console.log("되냐.");
//                 }
//             },
//             error:function(response){
//                 console.log(response)
//             }
//             });
//     }
// });

const kakaoLogin_Btn = document.getElementById("kakaoLogin-Btn");
kakaoLogin_Btn.addEventListener("click", async function(){
    try {
        kakaoToken = await loginwithKakao();
        if(kakaoToken === null){
            console.log("오류");
        }else{
            const loginID = kakaoToken.id;
            const loginNickname = kakaoToken.kakao_account.profile_nickname;
            $.ajax({
                url: "member/login",
                type: "POST",
                data: {"kakaoId": loginID,
                       "kakaoNick" : loginNickname,//response.properties.nickname,
                       "loginType" : "Y"},
                success : function(loginMember){
                    console.log(loginMember);
                    if("${!empty sessionScope.loginMember"){
                        console.log("되냐.");
                    }else{
                        console.log("회원가입해야함.");
                    }
                    
                },
                error:function(response){
                    console.log(response)
                }
                });
        }
        const loginID = kakaoToken.id;
        const loginNickname = kakaoToken.kakao_account.profile_nickname;
        // ...
    } catch (error) {
        console.error(error);
    }
});


function loginwithKakao(){
    return new Promise((resolve, reject) => {
        Kakao.init("ba5a975a4e3050a2c21c38fbe305e366");
        Kakao.Auth.login({
            success: function(response) {
                Kakao.API.request({
                    url: '/v2/user/me',
                    success: function(response) {
                        resolve(response);
                    },
                    fail: function(error) {
                        reject(error);
                    }
                });
            },
            fail: function(error) {
                reject(error);
            }
        });
    });
}

function signUpkakao(){
    const id = kakaoToken.id;
    const nickName = kakaoToken.kakao_account.profile_nickname;
   
}
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

