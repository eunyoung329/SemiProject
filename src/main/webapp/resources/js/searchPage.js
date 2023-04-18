// 지도 띄우기
// let container = document.getElementById("map");
// let mapOptions = {
//     center: new kakao.maps.LatLng(33.450701, 126.570667),
//     level: 3
// };

// let map = new kakao.maps.Map(container, mapOptions);
let container = document.getElementById('map');
	let options = {
	  level: 3
	};
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
	    options.center = locPosition;
	    map = new kakao.maps.Map(container, options);
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
	    	url:"member/getShop",
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
	  options.center = locPosition;
	  map = new kakao.maps.Map(container, options);

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