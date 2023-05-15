





function  validateForm() {
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
    alert("상점 이름을 입력해주세요.");
    return false;
  }

  // 주소 검사
  var sample4_postcode = document.getElementById("sample4_postcode").value;
  var sample4_roadAddress = document.getElementById("sample4_roadAddress").value;
  var sample4_detailAddress = document.getElementById("sample4_detailAddress").value;
  if (sample4_postcode == "" || sample4_roadAddress == "" || sample4_detailAddress == "") {
    alert("주소를 입력해주세요.");
    return false;
  }

  // 제보내용 검사
  var report_content = document.getElementById("report_content").value;
  if (report_content == "") {
    alert("제보내용을 입력해주세요.");
    return false;
  }

  return true;
}


  // $.ajax({
  //   url: 'report',
  //   type: 'POST',
  //   data: formData,
  //   processData: false,
  //   contentType: false,
  //   success: function(result) {
  //     console.log(result);
  //     if (result == 0) {
  //       console.log('제보실패');
  //     } else {
  //       return true;
  //     }
  //   },
  //   error: function(result) {
  //     console.log(result);
  //   }
  // });

