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
// //새로 생성된 row에 카드 추가
//const cardArea = document.querySelector('.card-area');
const rows = document.querySelectorAll('.row');
let cardId=0;
function addCard(itemList){
  let currentRow;
  let cardsInCurrentRow = 0;


  for (let i = 0; i < itemList.length; i++) {
    const itemObj = itemList[i];
    cardId++;
    const cardHtml = `<div class="col-lg-3 col-md-6">
      <div class="card" style="width: 22rem; height: 735.66px">
        <img src="../${itemObj.img}" class="card-img-top" alt="..."
        data-bs-toggle="modal" data-bs-target="#myModal-${cardId}">
        <div class="card-body">
          <h5 class="card-title">${itemObj.name}</h5>
          <div class="card-address">
            <span class="card-text">${itemObj.address}</span>
          </div>
        </div>
        <ul class="list-group list-group-flush">
          <li class="list-group-item"><i class="fa-sharp fa-solid fa-utensils" style="color: #558b2f;"></i> ${itemObj.category}</li>
          <li class="list-group-item"><i class="fa-sharp fa-regular fa-clock" style="color: #558b2f;"></i>  ${itemObj.time}</li>
          <li class="list-group-item"><i class="fa-solid fa-phone" style="color: #558b2f;"></i> ${itemObj.tel}</li>
        </ul>
        <div class="card-body sns">
          <a href="${itemObj.sns}" class="btn btn-light mk">SNS 바로가기</a>
          <i class="fa-solid fa-heart" id="${itemObj.rest_id}"></i>
        </div>

        <!-- 모달창 -->
        <div class="modal fade"  id="myModal-${cardId}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <di class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">${itemObj.name}</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <img src="../${itemObj.img}" alt="My Image">
              </div>
              <div class="modal-footer">
                <h6 class="modal-footer-content">${itemObj.contents}</h6>
                <a href="${itemObj.sns}" class="btn btn-light mk">SNS 바로가기</a>
                <i class="fa-solid fa-heart" id="heart-${itemObj.rest_id}"></i>
              </div>
            </div>
          </di                                                                                                                                       v>
        </div>
      </div>
    </div>`;

    if (cardsInCurrentRow === 0 || cardsInCurrentRow % 4 === 0) {
      // create a new row and append it to the card area
      currentRow = document.createElement('div');
      currentRow.classList.add('row');
      document.getElementById('card-area').appendChild(currentRow);
    }

    // append the new card to the current row
    currentRow.innerHTML += cardHtml;
    cardsInCurrentRow++;
  }
}


//카드와 모달창의 하트를 눌러서 위시리스트 삭제

document.addEventListener("click", function(event) {
   const clickedElement = event.target;
  // const classList = clickedElement.classList;

  const restIdElement = clickedElement.closest('[id^="heart-"]');
  const rest_id = restIdElement ? restIdElement.id.split("-")[1] : clickedElement.id;


    console.log("rest_id::",rest_id);
  if(rest_id){
    // itemId를 서버로 보내는 ajax 요청 코드 작성
    $.ajax({

      url: 'wishlistDelete', 
      method: 'POST',
      data: { itemId: rest_id },
      success: function(response) {
       //성공시 페이지 새로고침
       console.log("삭제 에이젝스 ")
       location.reload();
      },
      error: function() {
        alert('위시리스트 삭제 오류 발생');
      }
    });
  }
});




