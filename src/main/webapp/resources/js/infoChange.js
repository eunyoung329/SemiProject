// 모달 띄우기 
$(function(){ 

    $("#info_img_select_btn").click(function(){
      $(".info_img_modal").fadeIn();
    });
    
    $("#info_modal_close").click(function(){
      $(".info_img_modal").fadeOut();
    });
    
  });

// 사진 변경하기 
const inputImg = document.getElementById("input-image");

// inputImg가 존재 
if(inputImg != null){

  inputImg.addEventListener("change", function(){

    if(this.files[0] != undefined){

      console.log("this.files:", this.files[0]);

      const reader =   new FileReader();

      reader.readAsDataURL(this.files[0]);

      reader.onload = function(e){

        const profileImg = document.getElementById("info_profile_img");

        profileImg.setAttribute("src", e.target.result);

        document.getElementById("info_img_delete").value = 0;

        console.log("e.target.result", e.target.result);
      }

      
    }
  })
}

// 이미지 삭제 
const deleteImgBtn = document.getElementById("info_img_delete_btn");

deleteImgBtn.addEventListener("click", function(){

  const infoDelBtn = document.getElementById("info_img_delete");
  
  if(infoDelBtn.value == 0) {
    document.getElementById("info_profile_img").setAttribute("src", contextPath + "/resources/img/profileImg/defaultUser.png");
    document.getElementById("input-image").value = "";
    infoDelBtn.value = "1";
  
  };
});


// 이미지 선택 확인 
function profileValidate(){
  const inputImg = document.getElementById("input-image");
  const infoDelBtn = document.getElementById("info_img_delete");

  if(inputImg.value == "" && infoDelBtn.value == 0) {
    alert("이미지를 선택한 후 변경 버튼을 클릭해주세요.");
    return false;
  }

  return true;
}





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

