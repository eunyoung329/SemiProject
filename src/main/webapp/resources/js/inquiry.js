/**
 * 
 */  
 function inquiryValidate() {
    
    $.ajax({
      url: "inquiry",
      data: {
        "category": $('#category option:selected').val(), // 선택한 옵션의 값
        "inquiryTitle": $('#inquiryTitle').val(),
        "inquiryContent": $('#inquiryContent').val()
      },
      type: "POST",
      success: function(result) {
        console.log(result);
        if (result == 0) {
          console.log("문의실패");
        } else {
          return true;
        }
      },
      error: function(result) {
        console.log(result);
      }
    });
  }