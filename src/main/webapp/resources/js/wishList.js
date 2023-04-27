//=========FRONT=======================

//배너부분 슬라이드 에니메이션
let mainText = document.querySelector(".title-text-container");

window.addEventListener("scroll", function(){
    let scrollValue =window.scrollY;
    // console.log("scroll 값::", scrollValue)
    if(scrollValue > 250){
       mainText.style.animation='backslide 1s ease-out forwards';
    }else{
        mainText.style.animation='slide 1s ease-out';
    }
})


//모달창 크기를 동적으로 조절
$(document).ready(function() {
  // 모달창이 열릴 때 이벤트 핸들러 등록
  $('#myModal').on('show.bs.modal', function (event) {
    // 모달창의 이미지를 가져옵니다.
    var modalImg = $(this).find('.modal-body img');
    // 이미지 로딩 완료 후 실행되는 함수를 등록합니다.
    modalImg.on('load', function() {
      // 모달창 내부의 내용 크기에 맞게 모달창 크기를 동적으로 조절합니다.
      $(this).parents('.modal-body').height($(this).height());
      $(this).parents('.modal-content').height($(this).height() + $('.modal-header').outerHeight() + $('.modal-footer').outerHeight());
    });
  });
});


//==================================================================



//화면이 켜지자 마자 전체 내용을 프론트에 로드하는 ajax
// 레스토랑 정보가 담길 객체 itemObj, 객체 배열 itemList
var itemObj;
var itemList = [];

$(document).ready(function(){
    
 console.log("화면로드 함수 실행중")
  
  $.ajax({
    url: "wishListLoad",
    type: "POST",
    dataType: "JSON",
    success: function (restList) {
        console.log("restList::",restList)

     // 1. 서버에서 받아온 데이터를 객체로 변환
     for (let i = 0; i < restList.length; i++) {
        let item = restList[i];
        let itemObj = {
          id: item.wishlist_idx,
          rest_id: item.rest_id,
          name: item.rest_name,
          address: item.rest_Addr,
          category : item.rest_category,
          sns : item.rest_sns,
          tel : item.rest_tel,
          time : item.rest_time,
          img : item.rest_img,
          contents : item.rest_contents

        };
        itemList.push(itemObj);
      }
      console.log("itemList::"+itemList)
   addCard(itemList);
    
    },
    error : function(error){
      console.log("화면 로드 실패")
    }
  });

})





//카드 렌더링 함수
//현재 row에 카드가 4개가 다 찼다면 새로운 row를 생성하고 
//새로 생성된 row에 카드 추가
const cardArea = document.querySelector('.card-area');
const rows = document.querySelectorAll('.row');

function addCard(itemList){
  for (let i = 0; i < itemList.length; i++) {
    const itemObj = itemList[i];
    const cardHtml = `<div class="col-lg-3 col-md-6">
      <div class="card" style="width: 18rem;">
        <img src="${itemObj.img}" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">${itemObj.name}</h5>
          <p class="card-text">${itemObj.address}</p>
        </div>
        <ul class="list-group list-group-flush">
          <li class="list-group-item">${itemObj.category}</li>
          <li class="list-group-item">${itemObj.time}</li>
          <li class="list-group-item">${itemObj.tel}</li>
        </ul>
        <div class="card-body sns">
          <a href="${itemObj.sns}" class="btn btn-light mk">SNS 바로가기</a>
          <i class="fa-solid fa-heart" id="${itemObj.id}"></i>
        </div>

        <!-- 모달창 -->
        <div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">${itemObj.name}</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <img src="${itemObj.img}" alt="My Image">
              </div>
              <div class="modal-footer">
                <h6 class="modal-footer-content">${itemObj.contents}</h6>
                <a href="${itemObj.sns}" class="btn btn-light mk">SNS 바로가기</a>
                <i class="fa-solid fa-heart" ></i>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>`;

    const cardArea = document.getElementById("card-area");
    //페이지에 있는 전체 ROW중 마지막 ROW 지정(인덱스니까 -1)
    const lastRow = rows[rows.length - 1];
    //마지막 row가 있는 경우 해당 row 내의 모든 클래스 선택
    const lastRowCols = lastRow ? lastRow.querySelectorAll('.col-lg-3.col-md-6') : null;
    if (!lastRow || lastRowCols.length === 4) { 
      // row가 falsy거나(없거나) 마지막 row안의 카드가 4개일때
      const newRow = document.createElement('div');
      newRow.classList.add('row'); // <div class="row" >클래스 지정
      newRow.innerHTML = cardHtml;
      cardArea.appendChild(newRow);
    } else {
      lastRow.innerHTML += cardHtml;
    }
  }
}





