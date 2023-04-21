console.log("자스 연결?")

// 사진 선택 
const imgSelectBtn = document.getElementById("imgSelectBtn")
const imgInput = document.createElement("input")
imgInput.type = "file"

imgSelectBtn.addEventListener("click", ()=> {
    imgInput.click();
})


console.log("자스 연결????")

// 닉네임 중복 체크 
const nickInput = document.getElementById("nickName")
const nickMsg = document.getElementById("infoChange_nickMsg")

document.addEventListener("DOMContentLoaded", function(){
nickInput.addEventListener("input", function(){

    const regExp2 = /^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$/
    if(regExp2.test(nickInput.value)){
        $.ajax({
            url:"memberNickname",
            type:"POST",
            data:{"memberNickname" :nickInput.value},
            success: result =>{
                if(result == 0){
                    nickMsg.innerText = "사용가능한 닉네임입니다."
                }else{
                     nickMsg.innerText = "이미 사용된 닉네임입니다."
                }
            },
            error: result =>{
                //오류발생
            }
        });
    }else{
        nickMsg.innerText = "양식에 맞지 않는 닉네임입니다. 다시 입력해주세요."
    }
  })
  
})

