// 지도 띄우기
// let container = document.getElementById("map");
// let mapOptions = {
//     center: new kakao.maps.LatLng(33.450701, 126.570667),
//     level: 3
// };

// let map = new kakao.maps.Map(container, mapOptions);
let container = document.getElementById('map');
	let mapoptions = {
	  level: 3	};
	let map;
	let mapbounds;
	let bounds;
	let result;

	// 현재 위치한 자리로 좌표를 읽어오기. 위치한 자리로 다시 검색하게끔 유도할 수도 있음.
	if (navigator.geolocation) {
	  navigator.geolocation.getCurrentPosition(function(position) {
	    let lat = position.coords.latitude;
	    let lon = position.coords.longitude;
	    console.log("되냐");
	    let locPosition = new kakao.maps.LatLng(lat, lon);
	    mapoptions.center = locPosition;
	    map = new kakao.maps.Map(container, mapoptions);
		mapbounds = map.getBounds();
	    let mapTypeControl = new kakao.maps.MapTypeControl();
	    map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

	    var zoomControl = new kakao.maps.ZoomControl();
	    map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

	    // 현위치 마커 생성
	    var marker = new kakao.maps.Marker({
	      map: map,
	      position: locPosition
	    });
		
		marker.setMap(map);
	    
		console.log(mapbounds);
	    bounds = new kakao.maps.LatLngBounds();
		//$.ajax를 통해 받아온 위도값과 경도값이 조건에 맞을 때, mark를 새겨라.
	    $.ajax({
	    	url:"getShop",
	    	type:"POST",
	    	data: {"storeName": "소듐"},
			datatype:"JSON",
	    	success: res =>{
				result = JSON.parse(res);
				console.log(result);
				
	    		if (result !== null) {
      				markerMake(result);
      			}
   				else {
     			 console.log("응 없어~");
    			}
	    	},
	    	error: res =>{
	    		
	    	}
	    })
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
	//var places = new kakao.maps.services.Places();
	//places.setMap(map);
	//장소 검색 객체 생성
	
 
   	function markerMake(rest_list){
		let points=[];
		
		for(let i=0; i<rest_list.length; i++){
			console.log(rest_list[i].rest_x);
			console.log(rest_list[i].rest_y);
			if((rest_list[i].rest_y<mapbounds.pa && rest_list[i].rest_y >mapbounds.qa)&&(rest_list[i].rest_x<mapbounds.oa && rest_list[i].rest_x>mapbounds.ha)){
				console.log("안되냐");
				let marker_list = new kakao.maps.LatLng(rest_list[i].rest_y,rest_list[i].rest_x);
				points.push(marker_list);
			}

		}
		console.log(points);
		let marker;
		// 		marker.setMap(map);	
		// 		bounds.extend(points[i]);
		if(points!=null){
			for(let i =0; i<points.length; i++){
				marker = new kakao.maps.Marker({ position : points[i] });
				marker.setMap(map);

				bounds.extend(points[i]);
			}
		}
	}
    //================================김승헌 현재 위치, 주변 띄우기===================







//============================프론트코드==========================================


// 1. 카태고리 버튼 값 가져오기
// 2. 버튼 클릭 시, 배열에 담고 효과 주기 + 다시 클릭하면 배열에서 빠지고 효과 삭제
let locationKeywordArr = []; 
let CategoryKeywordArr = [];
let locationBtn = document.querySelectorAll(".searchArea_location button")
let categoryBtn = document.querySelectorAll(".searchArea_category button")

for(let i = 0; i<locationBtn.length; i++){
    locationBtn[i].addEventListener("click", function(){
        if(locationBtn[i].style.backgroundColor === '' || locationBtn[i].style.backgroundColor === 'transparent'){
            locationBtn[i].style.backgroundColor = '#7c8b66';
            locationBtn[i].style.color = 'white';
            locationKeywordArr.push(locationBtn[i].textContent)
        } else {
            locationBtn[i].style.backgroundColor = 'transparent';
            locationBtn[i].style.color = '#7c8b66';
            const removeArr = locationKeywordArr.indexOf(locationBtn[i].textContent);
            if(removeArr > -1){
                locationKeywordArr.splice(removeArr, 1);
            };
        }
        console.log("locationKeywordArr: ", locationKeywordArr)
        });
}


for(let i = 0; i<categoryBtn.length; i++){
    categoryBtn[i].addEventListener("click", function(){
        console.log(categoryBtn[i].textContent)

        if(categoryBtn[i].style.backgroundColor === '' || categoryBtn[i].style.backgroundColor === 'transparent'){
            categoryBtn[i].style.backgroundColor = '#7c8b66';
            categoryBtn[i].style.color = 'white';
            CategoryKeywordArr.push(categoryBtn[i].textContent)
        } else {
            categoryBtn[i].style.backgroundColor = 'transparent';
            categoryBtn[i].style.color = '#7c8b66';
            const removeArr = CategoryKeywordArr.indexOf(categoryBtn[i].textContent);
            if(removeArr > -1){
                CategoryKeywordArr.splice(removeArr, 1);
            };
        }
        console.log("CategoryKeywordArr: ", CategoryKeywordArr)
        });
}

// 되돌리기 버튼 누르면 배열, 버튼효과 모두 리셋
const resestBtn = document.getElementById("category_reset");
resestBtn.addEventListener("click",function(){
    locationKeywordArr = [];
    CategoryKeywordArr = [];

    for(let i = 0; i<locationBtn.length; i++){
        locationBtn[i].style.backgroundColor = 'transparent';
        locationBtn[i].style.color = '#7c8b66';
    }
    
    for(let i = 0; i<categoryBtn.length; i++){
        categoryBtn[i].style.backgroundColor = 'transparent';
        categoryBtn[i].style.color = '#7c8b66';
    }
    
})
//============================프론트코드 끝==========================================




//2023.04.19 : 레스토랑 목록 필터링 기능 구현
//===============================전현정===========================

//화면이 켜지자 마자 전체 내용을 프론트에 로드하는 ajax
// 레스토랑 정보가 담길 객체 itemObj, 객체 배열 itemList
var itemObj;
var itemList = [];

$(document).ready(function(){
    
 console.log("화면로드 함수 실행중")
  
  $.ajax({
    url: "load",
    type: "POST",
    dataType: "JSON",
    success: function (restList) {
        console.log(restList)

     // 1. 서버에서 받아온 데이터를 객체로 변환
     for (let i = 0; i < restList.length; i++) {
        let item = restList[i];
        let itemObj = {
          id: item.rest_id,
          name: item.rest_name,
          address: item.rest_Addr,
          lat: item.rest_x,
          lng: item.rest_y,
          category : item.rest_category
        };
        itemList.push(itemObj);
      }
   render(itemList);
    
    },
    error : function(error){
      console.log("화면 로드 실패")
    }
  });

})

//레스토랑 전체 목록을 화면에 그리는 함수
//레스토랑 목록이 생성될 div
var listContainer = document.getElementById("item-list");
function render(itemList, filteredItems){
    listContainer.innerHTML = "";

    console.log("render() 실행중");

	//console.log("itemList:: ", itemList);
	console.log("render함수가 인자로 받은 filteredItems:: ", filteredItems);
 //const itemsToRender =  filteredItems || itemList; 
 let itemsToRender;
 if (filteredItems && filteredItems.length > 0) {
	itemsToRender = filteredItems;
  } else {
	itemsToRender = itemList;
  }

  console.log("itemsToRender:::"+JSON.stringify(itemsToRender))

//   if(filterItems.length == 0 || filterItems == undefined) {

//   }

  // 필터링된 배열이 있으면 해당 배열을, 없으면 전체 배열을 사용
  for (let item of itemsToRender) {
	  var itemElement = document.createElement("div");
	  itemElement.innerHTML='';
	  itemElement.classList.add("item");
    itemElement.innerHTML = `
      <div class="searchPage_res_item_info">
        <span class="item-name">${item.category}</span>
        <span class="item-category">${item.name}</span>
        <span class="item-address">${item.address}</span>
        <span><i class="fa-regular fa-heart"></i></span>
      </div>
    `;
    listContainer.appendChild(itemElement);
  }
}


//사용자가 선택한 지역과 카테고리에 따라 식당리스트 출력하는 함수

// 버튼 클릭 이벤트 리스너 등록
locationBtn.forEach(button => {
	console.log("지역선택")
	button.addEventListener('click', filterItems);
  });
  
categoryBtn.forEach(button => {
	console.log("지역선택")
	button.addEventListener('click', filterItems);
  });

//목록을 필터링 하는 함수

function filterItems(){
	console.log("필터함수 실행중")

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

  console.log(JSON.stringify(filteredList))
  console.log("필터링된 객체배열의 길이:: "+filteredList.length);
  render(itemList, filteredList); // 전체 리스트와 필터된 리스트를 함께 전달
}





  //=========================================전현정 현재위치======================
  
  
  
  
  //========================재범 작성시작=========================
 var infowindow = new kakao.maps.InfoWindow({
    content: "" // 인포윈도우에 표시할 내용
});
  
$.ajax({ 
    url: "maker", 
    dataType:"JSON",
    success: function(maker) {
        for (var i = 0; i < maker.length; i++) {
            var lat = maker[i].rest_y; // 경도 정보
            var lng = maker[i].rest_x; // 위도 정보
            var latlng = new kakao.maps.LatLng(lat, lng); // 마커의 위치 설정

            // 클로저를 활용하여 마커 보존
            (function(maker, latlng) { // store와 latlng를 인자로 받음
                var marker = new kakao.maps.Marker({
                    map: map,
                    position: latlng,
                });

                // 클릭 이벤트 처리
                kakao.maps.event.addListener(marker, 'click', function() {
                    $.ajax({
                        url: "pick",
                        data: {
                            "Y": latlng.getLat(), // 클릭한 마커의 위도 정보 가져오기
                            "X": latlng.getLng() // 클릭한 마커의 경도 정보 가져오기
                        },
                        dataType : "JSON",
                        success: function(pick) {
                            if (pick != null) {
                                if(pick.rest_img != null){
                                    content = "<img src='../"+pick.rest_img +"' style='border-radius: 50%; width: 100px; height: 100px;' /><div>"
                                         + pick.rest_name +
                                          "</div><div>" + pick.rest_category +
                                          "</div><span><a href='" + pick.rest_sns + "'>" +
                                            pick.restaurantSNS+"</a></span>";
                                }else{
                                    content = "<img src='../resources/img/defualtimg.png' style='border-radius: 50%; width: 100px; height: 100px;' /><div>"
                                         + pick.rest_name +
                                          "</div><div>" + pick.rest_category +
                                          "</div><span><a href='" + pick.rest_sns + "'>" +
                                            pick.rest_sns+"</a></span>";
                                }
                                infowindow.setContent(content);
                                infowindow.open(map, marker); // 인포윈도우 열기
                            }
                        },
                        error: function() {
                            console.log("통신오류!!!!")
                        }
                    });
                });

                // 마우스 아웃 이벤트 처리
                kakao.maps.event.addListener(marker, 'click', function() {
                    infowindow.close(); // 인포윈도우 닫기
                });
            })(maker[i], latlng); // maker[i]와 latlng를 인자로 전달
        }
    },
    error: function() {
        console.log("통신 오류!!");
    }
});
//======================= 작성완료 4/20 ==============================  
  