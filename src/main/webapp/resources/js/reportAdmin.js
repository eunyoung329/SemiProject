/**
 * 
 */
console.log("main.js loaded.");

// // 회원 정보 조회 비동기 통신(AJAX)

//전체조회 구역
const boardDiv=document.getElementById("boardDiv");



const searchBtn = document.getElementById("searchBtn");
const table=document.getElementById("member-view-table");



document.getElementById("searchBtn").addEventListener("click", function() {

   const memberEmail = document.getElementById("memberEmail");//input창
   //const div = document.getElementById("result1");//btn

   // AJAX 코드 작성(jQuery 방식)
   $.ajax({
      url: "AdminSelectOne",
      data: { "memberEmail": memberEmail.value },
      type: "POST",
      dataType: "JSON", // dataType: 응답 데이터 형식을 지정
      // -> "JSON"으로 지정 시 자동으로 JS 객체로 변환
      success: function(admin) {
         console.log(admin);

         if (admin != null) {
            // 회원 정보가 있을 경우


  // 이전에 존재하던 내용 삭제
        table.innerHTML = "";
  
        // 이전에 존재하던 내용 삭제
        
        table.innerHTML = `
        <tr class="member-view-table-tr" style="border-top:2px solid #8aa088;border-bottom:2px solid #8aa088;">
        <th>회원번호</th>
        <th>이메일</th>
        <th>카테고리</th>
        <th>레스토랑이름</th>
        <th>이미지</th>
        <th>주소</th>
        <th>제보내용</th>
        <th>가입일</th>
      
       
      </tr>
        `;

        const tr = `
      <tr class="member-view-table-body">
        <td style="border-bottom:1px solid lightgrey;">${admin.memberNo}</td>
        <td style="border-bottom:1px solid lightgrey;" >${admin.memberEmail}</td>
        <td style="border-bottom:1px solid lightgrey;">${admin.rest_category}</td>
        <td style="border-bottom:1px solid lightgrey;">${admin.rest_name}</td>
        <td style="border-bottom:1px solid lightgrey;"><img src="../${admin.rest_img}" style="width:200px;height:200px;" alt="이미지"></td>
        <td style="border-bottom:1px solid lightgrey;">${admin.rest_Addr}</td>
        <td style="border-bottom:1px solid lightgrey;">${admin.report_Content}</td>
        <td style="border-bottom:1px solid lightgrey;">${admin.report_date}</td>
   
       
      </tr>
    `;
    table.insertAdjacentHTML("beforeend", tr);




    

        

      } else {
        // ...일치하는 회원이 없는 경우의 처리...
      }
    },
    error: function(request) {
      console.log("AJAX 에러 발생");
      console.log("상태코드 : " + request.status);
    }
  })
});









//회원 전체 조회 함수
window.onload = function() {
  selectAll();
}


function selectAll() {
  var itemObj;
  var itemList = [];

  $.ajax({
    url: "adminReportAll",
    type: "get",
    dataType: "json",
    success: function (stdList) {
      console.log(stdList);

    for (let i = 0; i < stdList.length; i++) {
            let item = stdList[i];
              itemObj = {
              //컬럼정의
              memberNo: item.memberNo,
  memberEmail: item.memberEmail,
  rest_category: item.rest_category,
  rest_name: item.rest_name,
  rest_img: item.rest_img,
  rest_Addr: item.rest_Addr,
  report_Content: item.report_Content,
  report_date: item.report_date,
  report_index: item.report_index // 추가된 필드
            };
            itemList.push(itemObj);
          }
    
          console.log("성공");
          renderList(itemList);
          for (let i = 0; i < itemList.length; i++) {
            console.log("report_index:"+itemList[i].report_index);
          }
          eventAdd();
          deleteEvent();

     
    },
    error: function(xhr, status, error) {
      console.log("error status: " + status);
      console.log("error message: " + error);
    

      console.log("error:" + error);
      console.log("화면로드실패");
      console.log(itemList);
     
    },
  });
}

function renderList(itemList) {
  const table = document.querySelector("#member-view-table");
  table.style.textAlign="center";
  



  table.innerHTML = `
    <tr class="member-view-table-tr" style="border-top:2px solid #8aa088;border-bottom:2px solid #8aa088;">
    <th>멤버번호</th>
    <th>이메일</th>
    <th>카테고리</th>
    <th>레스토랑이름</th>
    <th>이미지</th>
    <th>주소</th>
    <th>제보내용</th>
    <th>가입일</th>
    <th>제보삭제</th>
    <th>레스토랑등록</th>
  
    </tr>
  `

  itemList.forEach((item) => {
    const tr = `
    
      <tr class="member-view-table-body" >
        <td style="border-bottom:1px solid lightgrey;">${item.memberNo}</td>
        <td style="border-bottom:1px solid lightgrey;">${item.memberEmail}</td>
        <td style="border-bottom:1px solid lightgrey;">${item.rest_category}</td>
        <td style="border-bottom:1px solid lightgrey;">${item.rest_name}</td>
        <td style="border-bottom:1px solid lightgrey;"><img src="../${item.rest_img}" style="width:100px;height:100px;" alt="이미지"></td>
        <td style="border-bottom:1px solid lightgrey;">${item.rest_Addr}</td>
        <td style="border-bottom:1px solid lightgrey;">${item.report_Content}</td>
        <td style="border-bottom:1px solid lightgrey;">${item.report_date}</td>
        <td><button class="fa-solid fa-right-from-bracket" id="${item.report_index}" style="color: #005200;border:none;"></button></td>
        <td><button  class="register-button" id="${item.report_index}" >등록</button></td>
     
        </tr>

      </tr>
    `;
    table.insertAdjacentHTML("beforeend", tr);

});
}

// 등록 버튼 클릭 이벤트 바인딩
function eventAdd(){
const elements= document.getElementsByClassName('register-button');
  // report 객체의 값을 setAttribute
for(let i = 0; i<elements.length; i++){
  elements[i].addEventListener("click",function(event){
    const report_index = event.target.id;
    console.log(report_index+"안되지");
    $.ajax({
      url:"adminRegisterRest",
      type:"post",
      dataType:"JSON",
      data:{"report_index":report_index},
  
      success:function(result){
        console.log(result.rest_name);
        const reportStore = result;
        if (reportStore != null) { // 성공
              // requestScope에 할당
              
              
              // location 이동
              location.href = "adminRegisterRest";
          } else { // 실패
              location.href = "/admin/reportAdmin";
          }
      },
      error:function(error){
        console.log("실패")
      }
    });
  });
}
}
function deleteEvent(){
// 아이콘이 클릭되었을 때 실행될 함수
$('.fa-right-from-bracket').click(function() {
    
    var report_index = $(this).attr('id');
    alert(report_index);
    
    // Ajax 요청을 보냅니다.
    $.ajax({
      url: 'deleteReport', // 삭제를 처리할 서버의 URL
      type: 'POST',
      data: {"report_index": report_index}, // 서버로 보낼 데이터
      success: function(result) {
        console.log(result);
        // 삭제에 성공하면 해당 제보 데이터가 삭제된 것을 화면에서 반영합니다.
        $(this).closest('tr').remove(); // 해당 아이콘이 속한 행을 삭제합니다.
        console.log("삭제 성공");
        location.reload();
      },
      error: function() {
        alert('삭제에 실패했습니다.');
      }
    });
});
}