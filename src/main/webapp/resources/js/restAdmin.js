// console.log("js is loaded")


  //화면이 켜지면 전체 멤버를 출력하는 함수
var itemObj;
var itemList = [];

  $(document).ready(function () {

    console.log("화면로드 함수 실행중")

    $.ajax({
      url: "restLoad",
      type: "POST",
      dataType: "JSON",
      success: function (restList) {
        console.log(restList)
        // 1. 서버에서 받아온 데이터를 객체로 변환
        for (let i = 0; i < restList.length; i++) {
          let item = restList[i];
          let itemObj = {
            id : item.rest_id,
            name: item.rest_name,
            addr: item.rest_Addr,
            category: item.rest_category,
            sns:item.rest_sns,
            tel: item.rest_tel,
            time: item.rest_time,
            img: item.rest_img,
            contents: item.rest_contents
        };
          itemList.push(itemObj);
        }
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
  const table = document.getElementById("member-view-table-tr");
  const restToRender = filteredItemList || itemList;
  table.innerHTML = "";
  restToRender.forEach((item) => {
    const tr = document.createElement("tr");
    
    tr.innerHTML = `
      <td>${item.id}</td>
      <td>
        <div class='marker-image'>
          <img src="../${item.img ? item.img : 'resources/img/defaultimg.png'}" />
        </div>
      </td>
      <td>${item.name}</td>
      <td>${item.addr}</td>
      <td>${item.category}</td>
      <td>${item.contents}</td>
      <td>${item.tel}</td>
      <td>${item.time}</td>
      <td>${item.sns}</td>
      <td><i class="fa-solid fa-right-from-bracket" id="${item.id}" style="color: #005200;"></i></td>
    `;
    table.appendChild(tr);
  });
}

  // 1. 전체 회원 리스트업
const allMember = document.getElementById("all-member");
const kFood = document.getElementById("k-food");
const wFood = document.getElementById("w-food");
const cafe = document.getElementById("cafe");
const bakery = document.getElementById("bakery");
const etc = document.getElementById("etc");

allMember.addEventListener("click", function(){

  console.log("전체회원 조회")

  itemList= JSON.parse(localStorage.getItem("itemList"));
  renderList(itemList);

})

var filteredItemList = [];
kFood.addEventListener("click", function(){

  filteredItemList = [];
  console.log("kFood 조회")

  let unfilteredList = JSON.parse(localStorage.getItem("itemList"));
  console.log(unfilteredList);
for (let i = 0; i < unfilteredList.length; i++) {
  console.log("for문 실행여부");
  let item = unfilteredList[i];
  if (item.category === "한식") {
    let itemObj = {
      id : item.id,
      name: item.name,
      addr: item.addr,
      category: item.category,
      sns:item.sns,
      tel: item.tel,
      time: item.time,
      img: item.img,
      contents: item.contents
    };
    console.log(itemObj)
    filteredItemList.push(itemObj);
  }
}
renderList(filteredItemList);
})

wFood.addEventListener("click", function(){

  filteredItemList = [];
  console.log("wFood 조회")

  let unfilteredList = JSON.parse(localStorage.getItem("itemList"));
  console.log(unfilteredList);
for (let i = 0; i < unfilteredList.length; i++) {
  console.log("for문 실행여부");
  let item = unfilteredList[i];
  if (item.category === "양식") {
    let itemObj = {
      id : item.id,
      name: item.name,
      addr: item.addr,
      category: item.category,
      sns:item.sns,
      tel: item.tel,
      time: item.time,
      img: item.img,
      contents: item.contents
    };
    console.log(itemObj)
    filteredItemList.push(itemObj);
  }
}
renderList(filteredItemList);
})
cafe.addEventListener("click", function(){

  filteredItemList = [];
  console.log("wFood 조회")

  let unfilteredList = JSON.parse(localStorage.getItem("itemList"));
  console.log(unfilteredList);
for (let i = 0; i < unfilteredList.length; i++) {
  console.log("for문 실행여부");
  let item = unfilteredList[i];
  if (item.category === "카페") {
    let itemObj = {
      id : item.id,
      name: item.name,
      addr: item.addr,
      category: item.category,
      sns:item.sns,
      tel: item.tel,
      time: item.time,
      img: item.img,
      contents: item.contents
    };
    console.log(itemObj)
    filteredItemList.push(itemObj);
  }
}
renderList(filteredItemList);
})
bakery.addEventListener("click", function(){

  filteredItemList = [];
  console.log("wFood 조회")

  let unfilteredList = JSON.parse(localStorage.getItem("itemList"));
  console.log(unfilteredList);
for (let i = 0; i < unfilteredList.length; i++) {
  console.log("for문 실행여부");
  let item = unfilteredList[i];
  if (item.category === "베이커리") {
    let itemObj = {
      id : item.id,
      name: item.name,
      addr: item.addr,
      category: item.category,
      sns:item.sns,
      tel: item.tel,
      time: item.time,
      img: item.img,
      contents: item.contents
    };
    console.log(itemObj)
    filteredItemList.push(itemObj);
  }
}
renderList(filteredItemList);
})
etc.addEventListener("click", function(){

  filteredItemList = [];
  console.log("etc 조회")

  let unfilteredList = JSON.parse(localStorage.getItem("itemList"));
  console.log(unfilteredList);
for (let i = 0; i < unfilteredList.length; i++) {
  console.log("for문 실행여부");
  let item = unfilteredList[i];
  if (item.category === "기타") {
    let itemObj = {
      id : item.id,
      name: item.name,
      addr: item.addr,
      category: item.category,
      sns:item.sns,
      tel: item.tel,
      time: item.time,
      img: item.img,
      contents: item.contents
    };
    console.log(itemObj)
    filteredItemList.push(itemObj);
  }
}
renderList(filteredItemList);
})

const searchBtn = document.getElementById("searchBtn");
searchBtn.addEventListener("click", function(){

  const inputrestName = document.getElementsByName('inputrestName')[0].value;

  console.log("inputrestName::", inputrestName)

  let unfilteredList = JSON.parse(localStorage.getItem("itemList"));
  let filteredItemList = [];

  for (let i = 0; i < unfilteredList.length; i++){
    let item = unfilteredList[i];
    
    if(item.name.includes(inputrestName)){
      filteredItemList.push(item);
    }
  }
  console.log("검색하기 filteredItemList::", filteredItemList)
  renderList(filteredItemList);

})


$(document).on("click", ".fa-right-from-bracket", function () {
  var restid = $(this).attr("id");
  console.log("restId::", restid)
  deleteRest(restid);
});

function deleteRest(restid) {
  if (confirm("정말 삭제시키겠습니까?")) {
    // ajax 요청
    $.ajax({
      url: "deleteRest",
      type: "POST",
      data: { restid: restid },
      success: function (result) {
        console.log(restid);
        console.log(result);
        if (result > 0) {
          alert("레스토랑 삭제가 완료되었습니다.");
          location.reload(); // 페이지 새로고침
        } else {
          alert("레스토랑 삭제에 실패하였습니다.");
        }
      },
      error: function () {
        // 에러 발생 시 처리
        alert("ajax 오류 발생");
      },
    });
  }
}