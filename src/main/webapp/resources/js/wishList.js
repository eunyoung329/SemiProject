
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



//카드 렌더링 함수
//현재 row에 카드가 4개가 다 찼다면 새로운 row를 생성하고 
//새로 생성된 row에 카드 추가
const cardArea = document.querySelector('.card-area');
const rows = cardArea.querySelectorAll('.row');

const addCard = (cardData) => {
  const cardHtml = `<div class="col-lg-3 col-md-6">
  <div class="card" style="width: 18rem;">
  <img src="${cardData.imgSrc}" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">${cardData.title}</h5>
    <p class="card-text">${cardData.location}</p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">${cardData.keyword}</li>
    <li class="list-group-item">${cardData.businessHours}</li>
  </ul>
  <div class="card-body sns">
     <a href="#" class="btn btn-light mk">SNS 바로가기</a>
     <i class="fa-solid fa-heart"></i>
  </div>
  <!-- 모달창 -->
  <div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">레스토랑 이름</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <img src="https://cdn.vox-cdn.com/thumbor/vgkE3cbQfJtqV0j_Ja1gbNxp9AI=/0x0:2110x786/1200x675/filters:focal(887x225:1223x561)/cdn.vox-cdn.com/uploads/chorus_image/image/70831302/Screen_Shot_2022_05_04_at_10.52.23_AM.0.png" 
          alt="My Image">
        </div>
        <div class="modal-footer">
          <h6 class="modal-footer-content">레스토랑 메인 메뉴, 특징에 대한 간단한 설명, contents</h6>
          <a href="#" class="btn btn-light mk">SNS 바로가기</a>
          <i class="fa-solid fa-heart"></i>
        </div>
      </div>
    </div>
  </div>
</div>
</div>`;

  const lastRow = rows[rows.length - 1];
  const lastRowCols = lastRow ? lastRow.querySelectorAll('.col-lg-3 col-md-6') : null;
  if (!lastRow || lastRowCols.length === 4) { // row가 falsy거나 마지막 row안의 카드가 4개일때
    const newRow = document.createElement('div');
    newRow.classList.add('row');
    newRow.innerHTML = cardHtml;
    cardArea.appendChild(newRow);
  } else {
    lastRow.innerHTML += cardHtml;
  }
};

// 예시 데이터
const cardData = {
  imgSrc: 'https://cdn.vox-cdn.com/thumbor/vgkE3cbQfJtqV0j_Ja1gbNxp9AI=/0x0:2110x786/1200x675/filters:focal(887x225:1223x561)/cdn.vox-cdn.com/uploads/chorus_image/image/70831302/Screen_Shot_2022_05_04_at_10.52.23_AM.0.png',
  title: 'Restaurant Name',
  location: '110, Sejong-daero, Jung-gu, Seoul, Republic of Korea',
  keyword: '키워드',
  businessHours: '영업시간',
};

// 예시 카드 추가
addCard(cardData);
