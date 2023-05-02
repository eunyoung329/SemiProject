// 지도 띄우기

let container = document.getElementById('map');
let mapoptions = {
  level: 3
};
var map;
let mapbounds;
let bounds;
let result;

 //제발 돼~!

// 현재 위치한 자리로 좌표를 읽어오기. 위치한 자리로 다시 검색하게끔 유도할 수도 있음.
if (navigator.geolocation) {
  navigator.geolocation.getCurrentPosition(function (position) {
    let lat = position.coords.latitude;
    let lon = position.coords.longitude;
    let locPosition = new kakao.maps.LatLng(lat, lon);
    mapoptions.center = locPosition;
    map = new kakao.maps.Map(container, mapoptions);
    mapbounds = map.getBounds();
    let mapTypeControl = new kakao.maps.MapTypeControl();
    map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

    var zoomControl = new kakao.maps.ZoomControl();
    map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
    var imageSrc = '../resources/img/now.png', // 마커이미지의 주소입니다    
      imageSize = new kakao.maps.Size(70, 70) // 마커이미지의 크기입니다
    //imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.


    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize)
    var marker = new kakao.maps.Marker({
      map: map,
      position: locPosition,
      image: markerImage
    });

    marker.setMap(map);
    document.getElementById("nowlocation").addEventListener('click', function () {
      marker.setMap(null);
      console.log("이거 안들어오냐?")
    })
    console.log(mapbounds);
    bounds = new kakao.maps.LatLngBounds();
  });
} else {
  let locPosition = new kakao.maps.LatLng(37.4812845080678, 126.952713197762);
  mapoptions.center = locPosition;
  map = new kakao.maps.Map(container, mapoptions);

  let mapTypeControl = new kakao.maps.MapTypeControl();
  map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

  var zoomControl = new kakao.maps.ZoomControl();
  map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
}

// // 1. 카태고리 버튼 값 가져오기
// // 2. 버튼 클릭 시, 배열에 담고 효과 주기 + 다시 클릭하면 배열에서 빠지고 효과 삭제
let locationKeywordArr = [];
let CategoryKeywordArr = [];
let locationBtn = document.querySelectorAll(".searchArea_location button")
let categoryBtn = document.querySelectorAll(".searchArea_category button")

for (let i = 0; i < locationBtn.length; i++) {
  locationBtn[i].addEventListener("click", function () {
    if (locationBtn[i].style.backgroundColor === '' || locationBtn[i].style.backgroundColor === 'transparent') {
      locationBtn[i].style.backgroundColor = '#7c8b66';
      locationBtn[i].style.color = 'white';
      locationKeywordArr.push(locationBtn[i].textContent)
    } else {
      locationBtn[i].style.backgroundColor = 'transparent';
      locationBtn[i].style.color = '#7c8b66';
      const removeArr = locationKeywordArr.indexOf(locationBtn[i].textContent);
      if (removeArr > -1) {
        locationKeywordArr.splice(removeArr, 1);
      };
    }
    console.log("locationKeywordArr: ", locationKeywordArr)
  });
}


for (let i = 0; i < categoryBtn.length; i++) {
  categoryBtn[i].addEventListener("click", function () {
    console.log(categoryBtn[i].textContent)

    if (categoryBtn[i].style.backgroundColor === '' || categoryBtn[i].style.backgroundColor === 'transparent') {
      categoryBtn[i].style.backgroundColor = '#7c8b66';
      categoryBtn[i].style.color = 'white';
      CategoryKeywordArr.push(categoryBtn[i].textContent)
    } else {
      categoryBtn[i].style.backgroundColor = 'transparent';
      categoryBtn[i].style.color = '#7c8b66';
      const removeArr = CategoryKeywordArr.indexOf(categoryBtn[i].textContent);
      if (removeArr > -1) {
        CategoryKeywordArr.splice(removeArr, 1);
      };
    }
    console.log("CategoryKeywordArr: ", CategoryKeywordArr)
  });
}

// 되돌리기 버튼 누르면 배열, 버튼효과 모두 리셋
const resestBtn = document.getElementById("category_reset");
resestBtn.addEventListener("click", function () {
  locationKeywordArr = [];
  CategoryKeywordArr = [];

  for (let i = 0; i < locationBtn.length; i++) {
    locationBtn[i].style.backgroundColor = 'transparent';
    locationBtn[i].style.color = '#7c8b66';
  }

  for (let i = 0; i < categoryBtn.length; i++) {
    categoryBtn[i].style.backgroundColor = 'transparent';
    categoryBtn[i].style.color = '#7c8b66';
  }

})

// //화면이 켜지자 마자 전체 내용을 프론트에 로드하는 ajax
// // 레스토랑 정보가 담길 객체 itemObj, 객체 배열 itemList
var itemObj;
var itemList = [];

$(document).ready(function () {

  console.log("화면로드 함수 실행중")

  $.ajax({
    url: "load",
    type: "POST",
    dataType: "JSON",
    success: function (restList) {
      console.log(restList)
      console.log(restList.id);
      // 1. 서버에서 받아온 데이터를 객체로 변환
      for (let i = 0; i < restList.length; i++) {
        let item = restList[i];
        let itemObj = {
          id: item.rest_id,
          name: item.rest_name,
          address: item.rest_Addr,
          lat: item.rest_x,
          lng: item.rest_y,
          category: item.rest_category,
          sns: item.rest_sns,
          img: item.rest_img
        };
        itemList.push(itemObj);
      }

      makingmarker(itemList)
      render(itemList);
      // heart(itemList);
    },
    error: function (error) {
      console.log("화면 로드 실패")
    }
  });
})
function makingmarker(itemList) {
  console.log(itemList);
  let content = "";
  var infowindow = new kakao.maps.InfoWindow({
    content: content
  });

  for (let i = 0; i < itemList.length; i++) {
    let item = itemList[i];
    let markerPosition = new kakao.maps.LatLng(item.lat, item.lng);
    let marker = new kakao.maps.Marker({
      map: map,
      position: markerPosition,
    });

    kakao.maps.event.addListener(marker, 'click', function () {
      content = "<div class='marker-content'>" +
        "<div class='marker-image'>" +
        "<img src='../" + (item.img ? item.img : "resources/img/defaultimg.png") + "' /></div>" +
        "<div class='marker-info'>" +
        "<div class='marker-name'>" + item.name + "</div>" +
        "<div class='marker-category'>" + item.category + "</div>" +
        "<div class='marker-sns'><a href='" + item.sns + "'>홈페이지</a></div>" +
        "</div>" +
        "</div>";
      infowindow.setContent(content); // infowindow 객체의 내용(content) 갱신
      infowindow.open(map, marker); // infowindow 객체 열기
      kakao.maps.event.addListener(map, 'click', function () {
        infowindow.close(); // 인포윈도우 닫기
      });
    });
  }
}

// //레스토랑 전체 목록을 화면에 그리는 함수
// //레스토랑 목록이 생성될 div
var listContainer = document.getElementById("item-list");
var infowindow = new kakao.maps.InfoWindow({ // infowindow 변수를 선언하고 초기화
  content: ""
});

function render(itemList, filteredItems) {
  listContainer.innerHTML = "";
  let itemsToRender;
  if (filteredItems && filteredItems.length > 0) {
    itemsToRender = filteredItems;
  } else {
    itemsToRender = itemList;
  }

  for (let item of itemsToRender) {
    var itemElement = document.createElement("div");
    itemElement.innerHTML = '';
    itemElement.classList.add("item");
    itemElement.innerHTML = `
      <div class="searchPage_res_item_info" id="${item.id}">
        <span class="item-category">${item.category}</span>
        <span class="item-name">${item.name}</span>
        <span class="item-address">${item.address}</span>
        <span class="heart-icon" data-id="${item.id}"><button class="button-35" role="button">Like</button>
        </span>
      </div>
    `;
    listContainer.appendChild(itemElement);
    
    document.getElementById(item.id).addEventListener('dblclick', function () {
      var latlng = new kakao.maps.LatLng(item.lat, item.lng);
      var marker = new kakao.maps.Marker({
        map: map,
        position: latlng
      })
      map.setCenter(latlng);

      var content = "";
      content = "<div class='marker-content'>" +
        "<div class='marker-image'>" +
        "<img src='../" + (item.img ? item.img : "resources/img/defaultimg.png") + "' /></div>" +
        "<div class='marker-info'>" +
        "<div class='marker-name'>" + item.name + "</div>" +
        "<div class='marker-category'>" + item.category + "</div>" +
        "<div class='marker-sns'><a href='" + item.sns + "'>홈페이지</a></div>" +
        "</div>" +
        "</div>";

      infowindow.setContent(content);
      infowindow.open(map, marker);

      kakao.maps.event.addListener(marker, 'click', function () {
        content = "<div class='marker-content'>" +
          "<div class='marker-image'>" +
          "<img src='../" + (item.img ? item.img : "resources/img/defaultimg.png") + "' /></div>" +
          "<div class='marker-info'>" +
          "<div class='marker-name'>" + item.name + "</div>" +
          "<div class='marker-category'>" + item.category + "</div>" +
          "<div class='marker-sns'><a href='" + item.sns + "'>홈페이지</a></div>" +
          "</div>" +
          "</div>";
        infowindow.setContent(content);
        infowindow.open(map, marker);
      });
      kakao.maps.event.addListener(map, 'click', function () {
        infowindow.close(); // 인포윈도우 닫기
      });
    });
  }
  const heartIcons = document.querySelectorAll(".heart-icon");
  // 각 heart-icon 요소에 이벤트 리스너 등록
  heartIcons.forEach(heartIcon => {
    heartIcon.addEventListener("click", function () {
      // data-id 속성에서 아이템의 ID 값을 가져옴
      const itemId = this.getAttribute("data-id");
      
      $.ajax({
        url: "wishList",
        method: "POST",
        data: {
          "itemId": itemId
        },
        success: function ( ) {
          console.log(result+"위시리스트 등록 result")
          if (result> 0) {
            alert("위시리스트에 등록되었습니다.")
          } else if(result == 0){
            alert("중복된 위시리스트입니다.");
          }else{
            alert("로그인이 필요한 기능입니다.");
          }
        },
        error: function () {
          console.log("에이젝스 오류");
        }
      })

    });
  });
}
locationBtn.forEach(button => {
  console.log("지역선택")
  button.addEventListener('click', filterItems);
});

categoryBtn.forEach(button => {
  console.log("지역선택")
  button.addEventListener('click', filterItems);
});

// //목록을 필터링 하는 함수

function filterItems() {
  console.log("필터함수 실행중")
  // render(itemList, filteredItems);
  let filteredList = [];

  for (let i = 0; i < itemList.length; i++) {
    let item = itemList[i];

    // 사용자가 선택한 지역 키워드 검사
    let isLocationMatched = false;
    for (let j = 0; j < locationKeywordArr.length; j++) {
      let keyword = locationKeywordArr[j];
      if (item.address.includes(keyword)) {
        isLocationMatched = true;
        break;
      }
    }
    if (locationKeywordArr.length > 0 && !isLocationMatched) {
      continue; // 지역 키워드 불일치
    }

    // 사용자가 선택한 카테고리 키워드 검사
    let isCategoryMatched = false;
    for (let j = 0; j < CategoryKeywordArr.length; j++) {
      let keyword = CategoryKeywordArr[j];
      if (item.category === keyword) {
        isCategoryMatched = true;
        break;
      }
    }
    if (CategoryKeywordArr.length > 0 && !isCategoryMatched) {
      continue; // 카테고리 키워드 불일치
    }

    filteredList.push(item);
  }
  debugger;
  render(itemList, filteredList); // 전체 리스트와 필터된 리스트를 함께 전달
  // heart(itemList, filteredList);
  makingmarker(itemList);
}
// 지금 현재 위치로 돌아가는 코드
document.getElementById("nowlocation").addEventListener('click', function () {
  navigator.geolocation.getCurrentPosition(function (position) {
    let lat = position.coords.latitude;
    let lon = position.coords.longitude;
    let locPosition = new kakao.maps.LatLng(lat, lon);
    mapoptions.center = locPosition;
    map.setCenter(locPosition);
    mapbounds = map.getBounds();
    var imageSrc = '../resources/img/now.png', // 마커이미지의 주소입니다    
      imageSize = new kakao.maps.Size(70, 70) // 마커이미지의 크기입니다

    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize)
    var marker = new kakao.maps.Marker({
      map: map,
      position: locPosition,
      image: markerImage
    });
    marker.setMap(map);
  })
});

