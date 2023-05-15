









function AdminValidateForm(){




  // 카테고리 선택 여부 검사
  var rest_category = document.getElementById("rest_category").value;
  if (rest_category == "Open this select menu") {
    alert("카테고리를 선택해주세요.");
    return false;
  }
  //이미지 선택검사
 var rest_img = document.getElementById("rest_img");
  if (!rest_img.value) {
    alert("이미지 파일을 선택해주세요.");
    return false;
  }
  // 상점 이름 검사
  var rest_name = document.getElementById("rest_name").value;
  if (rest_name == "") {
    alert("레스토랑 이름을 입력해주세요.");
    return false;
  }
 
  //좌표검사
   var rest_x = document.getElementById("rest_x").value;
   if(rest_x==""){
   alert("x좌표를 입력해주세요");
   return false;
   }
   var rest_y = document.getElementById("rest_y").value;
   if(rest_y==""){
     alert("y좌표를 입력해주세요");
     return false;
     }
 
    //전화번호
    var rest_tel = document.getElementById("rest_tel").value;
    if (rest_tel == "") {
      alert("전화번호를 입력해주세요");
      return false;
    }
    var telRegExp = /^\d{2,3}-\d{3,4}-\d{4}$/; // 010-1234-5678과 같은 형식
    if (!telRegExp.test(rest_tel)) {
      alert("전화번호 형식이 올바르지 않습니다.");
      return false;
    }
    
    
    
   var rest_time = document.getElementById("rest_time").value;
   if(rest_time==""){
     alert("영업시간을 입력해주세요");
     return false;
     }
   var rest_sns = document.getElementById("rest_sns").value;
   if(rest_sns==""){
     alert("sns를 입력해주세요");
     return false;
     }
 
 
 
   var sample4_postcode = document.getElementById("sample4_postcode").value;
   var sample4_roadAddress = document.getElementById("sample4_roadAddress").value;
   var sample4_detailAddress = document.getElementById("sample4_detailAddress").value;
   if (sample4_postcode == "" || sample4_roadAddress == "" || sample4_detailAddress == "") {
     alert("주소를 입력해주세요.");
     return false;
   }
 
   var report_contents = document.getElementById("report_contents").value;
   if (report_contents == "") {
     alert("제보내용을 입력해주세요.");
     return false;
   }
 
 
 
 
 
 
 return true;
 
 
 
 
 
 
 
 
 
 
 
   }
 
 
 