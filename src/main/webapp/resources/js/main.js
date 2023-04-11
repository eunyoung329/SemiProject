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

/*
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