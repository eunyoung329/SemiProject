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

<<<<<<< HEAD
/*
=======


const kakaoLogin_Btn = document.getElementById("kakaoLogin-Btn");
kakaoLogin_Btn.addEventListener("click",function(){
    loginwithKakao();

});

function loginwithKakao(){
    Kakao.init('ba5a975a4e3050a2c21c38fbe305e366');//사용자의 키
    Kakao.Auth.login({
        success: function(authObj) {
        //console.log(JSON.stringify(authObj));
        Kakao.API.request({
            url: '/v2/user/me',
            success: function(response) {
              // response에는 사용자 정보가 담겨 있음
              console.log(response);
              $.ajax({
                url: "member/login",
                type: "POST",
                data: {"kakaoId": response.id,
                       "kakaoNick" : response.properties.nickname,
                       "loginType" : "Y"},
                success : function(loginMember){
                    console.log(loginMember);
                    if(loginMember === "null"){
                        console.log("왜 안됨?");
                        $.ajax({
                            url: 'member/signUp',
                            type: "POST",
                            data: {"kakaoId": response.id,
                            "kakaoNick" : response.properties.nickname,
                            "loginType" : true},
                            success : function(result){
                                console.log(result);
                                $.ajax({
                                    url:member/returnHome,

                                    success:function(result){},
                                    error:function(result){}

                                });
                            },
                            error : function(result){
                                $.ajax({
                                    url:member/returnHome
                                });
                            }
                        });
                    }else{
                        console.log(typeof(loginMember));
                    }
                },
                error:function(){

                }

              });
            },
            fail: function(error) {
              console.log(error);
            }
            });

        },
        fail: function(err) {
        alert(JSON.stringify(err))
        },
    });
}

>>>>>>> feacher/member3
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

*/