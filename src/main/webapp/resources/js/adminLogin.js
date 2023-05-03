/**
 * 
 */
 
 const adminEmail=document.getElementById("adminEmail");
 const adminPw=document.getElementById("adminPw");
 
 function adminLoginValidate(){

  if(adminEmail.value.trim().length==0 ){

    alert("아이디를 입력하세요")
    return false;
    }
    
    if(adminPw.value.trim().length==0) {
    
      alert("비밀번호를 입력하세요")
      return false;
    
    }


return true;



 }
 