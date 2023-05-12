// 모달 띄우기
$(function () {
  $("#info_img_select_btn").click(function () {
    $(".info_img_modal").fadeIn();
    $("body").css("overflow", "hidden"); 
  });

  $("#info_modal_close").click(function () {
    $(".info_img_modal").fadeOut();
    $("body").css("overflow", "visible");
  });
});

// 사진 변경하기 -------------------------------------------------------------------------------
const inputImg = document.getElementById("input-image");

// 사진 변경 버튼(div) 눌렀을 때 input이 눌린 효과 주기
document.querySelector(".info_modal_img_change_area").addEventListener("click", function () {
  inputImg.click();
  });


// inputImg가 존재
if (inputImg != null) {
  inputImg.addEventListener("change", function () {
    if (this.files[0] != undefined) {
      console.log("this.files:", this.files[0]);

      const reader = new FileReader();

      reader.readAsDataURL(this.files[0]);

      reader.onload = function (e) {
        const profileImg = document.getElementById("info_profile_img");

        profileImg.setAttribute("src", e.target.result);

        document.getElementById("info_img_delete").value = 0;

        console.log("e.target.result", e.target.result);
      };
    }
  });
}

const contextPath =
  window.location.origin + "/" + window.location.pathname.split("/")[1] + "/";

// 이미지 삭제
const deleteImgBtn = document.getElementById("info_img_delete_btn");

deleteImgBtn.addEventListener("click", function () {
  console.log("삭제 클릭");

  const infoDelBtn = document.getElementById("info_img_delete");

  if (infoDelBtn.value == 0) {
    console.log(
      "delbtn: ",
      contextPath + "resources/img/profileImg/defaultUser.png"
    );
    document
      .getElementById("info_profile_img")
      .setAttribute(
        "src",
        contextPath + "resources/img/profileImg/defaultUser.png"
      );
    document.getElementById("input-image").value = "";
    infoDelBtn.value = "1";
  }
});

// 이미지 선택 확인
function profileValidate() {
  const inputImg = document.getElementById("input-image");
  const infoDelBtn = document.getElementById("info_img_delete");

  if (inputImg.value == "" && infoDelBtn.value == 0) {
    alert("이미지를 선택한 후 변경 버튼을 클릭해주세요.");
    return false;
  }

  return true;
}





// 정보 변경하기 -------------------------------------------------------------------------------
// 닉네임 중복 체크
const nickInput = document.getElementById("nickName");
const nickMsg = document.getElementById("infoChange_nickMsg");
let nickChk = false; 

document.addEventListener("DOMContentLoaded", function () {
  nickInput.addEventListener("input", function () {
    const regExp2 = /^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$/;

    if (regExp2.test(nickInput.value)) {
      $.ajax({
        url: "memberNickname",
        type: "POST",
        data: { memberNickname: nickInput.value },
        success: (result) => {
          if (result == 0) {
            nickMsg.innerText = "사용가능한 닉네임입니다.";
            nickMsg.classList.add("confirm");
            nickMsg.classList.remove("error");

            nickChk = true;
            console.log("nickChk 가능:" , nickChk);
            
            

          } else {
            nickMsg.innerText = "이미 사용된 닉네임입니다.";
            nickMsg.classList.add("error");
            nickMsg.classList.remove("confirm");

            console.log("nickChk 사용:" , nickChk);

          }
        },

        error: (result) => {
          console.log("닉네임 중복체크 ajax 오류 발생");
        },
      });
    } else {
      nickMsg.innerText = "양식에 맞지 않는 닉네임입니다. 다시 입력해주세요.";
      nickMsg.classList.add("error");
      nickMsg.classList.remove("confirm");
      console.log(regExp2.test(nickInput.value));
    }
  });
});

// 우편번호-------
function execDaumPostcode() {
  new daum.Postcode({
      oncomplete: function(data) {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

          // 각 주소의 노출 규칙에 따라 주소를 조합한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          var addr = ''; // 주소 변수

          if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
            addr = data.roadAddress;
           }
          


          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          document.getElementById('info_postCode').value = data.zonecode;
          document.getElementById("info_address").value = addr;
          // 커서를 상세주소 필드로 이동한다.
          document.getElementById("info_detailAddress").value = "";
          document.getElementById("info_detailAddress").focus();
      }
  }).open();
}


// 전화번호, 생일 자릿수 제한하기 
const telInput = document.getElementById("tel");
const birthInput = document.getElementById("birth")

telInput.addEventListener("input", function(event){
  if(telInput.value.length > 11){
    telInput.value = telInput.value.slice(0,11);
  }
});

birthInput.addEventListener("input", function(event){
  if(birthInput.value.length > 8){
    birthInput.value = birthInput.value.slice(0,8);
  }
});




// 회원가입 검사
function infoValidate(event){

  console.log("form 전송? ")

  let infoCheck = {
    nick : false,
    tel : false,
    birth : false
  }

  if(nickChk == false){
    alert("부적합한 닉네임입니다. 다시 확인해주세요.")
    console.log("nickChk valdi:" , nickChk);

  } else{
    infoCheck.nick = true;
  }

  if(document.getElementById("tel").value.length != 11) {
    alert("전화번호는 11자리 숫자로 입력해주세요.")
    document.getElementById("tel").focus();
  } else{
    infoCheck.tel = true;
  }

  if(document.getElementById("birth").value.length != 8) {
    alert("생일은 8자리 숫자로 입력해주세요.")
    document.getElementById("birth").focus();
  } else{
    infoCheck.birth = true;
  } 

  if(infoCheck.nick && infoCheck.tel && infoCheck.birth){

    const infoFormsubmit = document.getElementById("info-form");
    const confirmMsg = confirm("변경하시겠습니까?");

    if(confirmMsg){
      infoFormsubmit.submit();

    } else{
      infoFormsubmit.preventdefault();
    }

  }
}