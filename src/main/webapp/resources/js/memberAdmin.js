console.log("js is loaded")


  //화면이 켜지면 전체 멤버를 출력하는 함수
var itemObj;
var itemList = [];

  $(document).ready(function () {

    console.log("화면로드 함수 실행중")

    $.ajax({
      url: "memberLoad",
      type: "POST",
      dataType: "JSON",
      success: function (memberList) {
        console.log(memberList)
        // 1. 서버에서 받아온 데이터를 객체로 변환
        for (let i = 0; i < memberList.length; i++) {
          let item = memberList[i];
          let itemObj = {
            memberNo: item.memberNo,
            memberNick: item.memberNick,
            memberEmail: item.memberEmail,
            memberAddress: item.memberAddress,
            memberBirth:item.memberBirth,
            memberTel: item.memberTel,
            enrollDate: item.enrollDate,
            secessionFlag: item.secessionFlag,
            isAdmin: item.isAdmin
          };
          itemList.push(itemObj);
        }
  
       console.log("성공")
       localStorage.setItem("itemList", JSON.stringify(itemList));
       renderList(itemList);
       
      },
      error: function (error) {
        console.log("화면 로드 실패")
      }
    });

  })

// 렌더링 함수
function renderList(itemList, filteredItemList) {
  console.log("렌더링 실행 중...")
    const table = document.querySelector("#member-view-table");
    const membersToRender = filteredItemList || itemList

    table.innerHTML = "";
  
    // 이전에 존재하던 내용 삭제
    
    table.innerHTML = `
      <tr class="member-view-table-tr">
        <td>회원번호</td>
        <td>닉네임</td>
        <td>이메일</td>
        <td>생년월일</td>
        <td>주소</td>
        <td>전화번호</td>
        <td>가입일</td>
        <td>회원탈퇴여부</td>
        <td>운영자</td>
        <td>탈퇴</td>
      </tr>
    `;
  
    // itemList 배열을 반복문으로 돌면서 render 함수 호출
    membersToRender.forEach((item) => {
      const tr = `
        <tr class="member-view-table-body" style="border-bottom:1px solid #F0F0F1;">
          <td>${item.memberNo}</td>
          <td>${item.memberNick}</td>
          <td>${item.memberEmail}</td>
          <td>${item.memberBirth}</td>
          <td>${item.memberAddress}</td>
          <td>${item.memberTel}</td>
          <td>${item.enrollDate}</td>
          <td>${item.secessionFlag}</td>
          <td>${item.isAdmin}</td>
          <td><i class="fa-solid fa-right-from-bracket" id="${item.memberNo}" style="color: #005200;"></i></td>
        </tr>
      `;
      table.insertAdjacentHTML("beforeend", tr);
    });
  }
  
//////////////////////////////////////////////////////////////////
// 1. 전체 회원 리스트업
const allMember = document.getElementById("all-member");
const activeMember = document.getElementById("active-member");
const inactiveMember = document.getElementById("inactive-member");

allMember.addEventListener("click", function(){

  console.log("전체회원 조회")

  itemList= JSON.parse(localStorage.getItem("itemList"));
  renderList(itemList);

})

//2. 활동회원 조회하기
var filteredItemList = [];
activeMember.addEventListener("click", function(){

  filteredItemList = [];
  console.log("활동회원 조회")

  let unfilteredList = JSON.parse(localStorage.getItem("itemList"));
  
for (let i = 0; i < unfilteredList.length; i++) {
  let item = unfilteredList[i];
  if (item.secessionFlag === "N") {
    let itemObj = {
      memberNo: item.memberNo,
      memberNick: item.memberNick,
      memberEmail: item.memberEmail,
      memberAddress: item.memberAddress,
      memberBirth:item.memberBirth,
      memberTel: item.memberTel,
      enrollDate: item.enrollDate,
      secessionFlag: item.secessionFlag,
      isAdmin: item.isAdmin
    };
    console.log(itemObj)
    filteredItemList.push(itemObj);
  }
}

renderList(filteredItemList);

})

//3. 탈퇴회원 조회하기

inactiveMember.addEventListener("click", function(){
  // 누적되지 않도록 리셋
  filteredItemList = [];
  console.log("탈퇴회원 조회")

  let unfilteredList = JSON.parse(localStorage.getItem("itemList"));

for (let i = 0; i < unfilteredList.length; i++) {
  let item = unfilteredList[i];
  if (item.secessionFlag != "N") {
    let itemObj = {
      memberNo: item.memberNo,
      memberNick: item.memberNick,
      memberEmail: item.memberEmail,
      memberAddress: item.memberAddress,
      memberBirth:item.memberBirth,
      memberTel: item.memberTel,
      enrollDate: item.enrollDate,
      secessionFlag: item.secessionFlag,
      isAdmin: item.isAdmin
    };

    filteredItemList.push(itemObj);
  }
}

renderList(filteredItemList);

})

//////////////////////////////////////////////////////////////////////////
//1. 가입 날짜로 검색하기
const startDateInput = document.getElementById('start_date');
const endDateInput = document.getElementById('end_date');

startDateInput.addEventListener("change", handleDateRangeChange);
endDateInput.addEventListener("change", handleDateRangeChange);

function handleDateRangeChange() {

  const startDate = document.getElementById('start_date').value;
  const endDate = document.getElementById('end_date').value;
  
  console.log("startDate::", startDate)
  console.log("endDate::", endDate)

  let unfilteredList = JSON.parse(localStorage.getItem("itemList"));
  let filteredItemList = [];

  for (let i = 0; i < unfilteredList.length; i++) {
    let item = unfilteredList[i];

    // 조건 1: start_date ~
    if (startDate && !endDate && new Date(item.enrollDate) >= new Date(startDate)) {
      console.log("시작일o, 끝나는 날x")
      filteredItemList.push(item);
    }

    // 조건 2: ~ end_date
    if (!startDate && endDate && new Date(item.enrollDate) <= new Date(endDate)) {
      console.log("시작일x, 끝나는 날o")
      filteredItemList.push(item);
    }

    // 조건 3: start_date ~ end_date
    if (startDate && endDate && new Date(item.enrollDate) >= new Date(startDate) && new Date(item.enrollDate) <= new Date(endDate)) {
      console.log("시작일o, 끝나는 날o")
      filteredItemList.push(item);
    }
  }
   console.log("날짜 filteredItemList::", filteredItemList)
   renderList(filteredItemList);

}

///////////////////////////////////////////////////////////////
//이메일로 회원조회

const searchBtn = document.getElementById("searchBtn");
searchBtn.addEventListener("click", function(){

  const inputMemberEmail = document.getElementsByName('inputMemberEmail')[0].value;

  console.log("inputMemberEmail::", inputMemberEmail)

  let unfilteredList = JSON.parse(localStorage.getItem("itemList"));
  let filteredItemList = [];

  for (let i = 0; i < unfilteredList.length; i++){
    let item = unfilteredList[i];
    
    if(item.memberEmail.includes(inputMemberEmail)){
      filteredItemList.push(item);
    }
  }
  console.log("검색하기 filteredItemList::", filteredItemList)
  renderList(filteredItemList);

})

/////////////////////////////////////////
//새로고침 버튼 + 마우스오버시 색바꾸기

const refreshBtn = document.querySelector('.fa-arrows-rotate'); // 아이콘 요소 선택

refreshBtn.addEventListener('click', () => {
  location.reload(); // 새로고침 수행
});

refreshBtn.addEventListener('mouseenter', () => {
  refreshBtn.style.color = '#F7E600'; // 색 변경
  refreshBtn.classList.add("fa-bounce"); // 애니메이션 클래스 추가

});

refreshBtn.addEventListener('mouseleave', () => {
  refreshBtn.style.color = '#005200'; // 원래 색으로 변경
  refreshBtn.classList.remove("fa-bounce"); // 애니메이션 클래스 제거
});

////////////////////////////////////////////////////////////////////////
//탈퇴기능
// 탈퇴 버튼 클릭 이벤트 바인딩


$(document).on("click", ".fa-right-from-bracket", function () {
  var memberNo = $(this).attr("id");
  console.log("memberNo::", memberNo)
  deleteMember(memberNo);
});

// 탈퇴 버튼 클릭 이벤트 핸들러 함수
function deleteMember(memberNo) {
  if (confirm("정말 탈퇴시키겠습니까?")) {
    // ajax 요청
    $.ajax({
      url: "/NewSemi/admin/deleteMember",
      type: "POST",
      data: { memberNo: memberNo },
      success: function (data) {
        if (data === "success") {
          // 탈퇴 성공 시 처리
          alert("회원 탈퇴가 완료되었습니다.");
          location.reload(); // 페이지 새로고침
        } else {
          // 탈퇴 실패 시 처리
          alert("회원 탈퇴에 실패하였습니다.");
        }
      },
      error: function () {
        // 에러 발생 시 처리
        alert("회원 탈퇴에 실패하였습니다.");
      },
    });
  }
}


