// index 화살표 스크롤
const scrollLeftBtn = document.querySelectorAll(".scroll-left-btn");
const scrollRightBtn = document.querySelectorAll(".scroll-right-btn");
const indexRes = document.querySelectorAll(".index_res");


for(let i = 0; i<indexRes.length; i++){

    scrollLeftBtn[i].addEventListener("click", ()=>{
        indexRes[i].scrollBy({
            left: -300,
            behavior: 'smooth'
        });
    
    });
    
    scrollRightBtn[i].addEventListener("click", ()=>{
        indexRes[i].scrollBy({
            left: 300,
            behavior: 'smooth'
        });
    });
}

// 맨 위로 가기
const topBtn = document.querySelector(".fa-square-caret-up");
topBtn.addEventListener('click', () => {
    window.scrollTo({
      top: 0,
      behavior: 'smooth'
    });
  });




// 데이터 가져오기 
let itemObj;
let itemList = [];

$(document).ready(function(){
    
 console.log("화면로드 함수 실행중")
  
  $.ajax({
    url: "member/load",
    type: "POST",
    dataType: "JSON",
    success: function (restList) {
      console.log("restList: ", restList);

      // 객체에 저장 

    
      
      // const seoulList = [];
      // const gyeonggiList = [];
      // const busanList = [];
      // const jejuList = [];

      // // 서울 리스트 만들기
      // for(let i = 0; i < restList.length; i++ ){
      //   // 객체 생성
      //   let itemObj = {
      //     id: restList[i].rest_id,
      //     name: restList[i].rest_name,
      //     address: restList[i].rest_Addr,
      //     category: restList[i].rest_category,
      //     img: restList[i].rest_img
      //   }

      //   // 각 지역 리스트에 레스토랑 추가 
      //   if(itemObj.address.startsWith("서울")) seoulList.push(itemObj);
      //   if(itemObj.address.startsWith("경기")) gyeonggiList.push(itemObj);
      //   if(itemObj.address.startsWith("부산")) busanList.push(itemObj);
      //   if(itemObj.address.startsWith("제주")) jejuList.push(itemObj);
      // }



      // // 화면에 출력(서울)
      // for (let i = 0; i < seoulList.length; i++) {
      //   let newItem = document.createElement("div");
      //   newItem.className = "index_res_item";
    
      //   newItem.innerHTML = `<img src="${seoulList[i].img}" alt="레스토랑 썸네일">` +
      //     `<span class="index_res_category">${seoulList[i].category}</span>` +
      //     `<span class="index_res_name">${seoulList[i].name}</span>` +
      //     `<span class="index_res_addr"${seoulList[i].address}</span>` +
      //     `<a><button type="button"><i class="fa-solid fa-seedling"></i>자세히 보기</button></a>`;
    
      //   // 새로운 div 요소의 내용을 설정 
      //   let seoulRow = document.getElementById("index_res_seoul");
      //   seoulRow.appendChild(newItem);
      // }

      // // 화면에 출력(경기)
      // for (let i = 0; i < gyeonggiList.length; i++) {
      //   let newItem = document.createElement("div");
      //   newItem.className = "index_res_item";
    
      //   newItem.innerHTML = `<img src="${gyeonggiList[i].img}" alt="레스토랑 썸네일">` +
      //     `<span class="index_res_category">${gyeonggiList[i].category}</span>` +
      //     `<span class="index_res_name">${gyeonggiList[i].name}</span>` +
      //     `<span class="index_res_addr"${gyeonggiList[i].address}</span>` +
      //     `<a><button type="button"><i class="fa-solid fa-seedling"></i>자세히 보기</button></a>`;
    
      //   // 새로운 div 요소의 내용을 설정 
      //   let gyeouggiRow = document.getElementById("index_res_gyeonggi");
      //   gyeouggiRow.appendChild(newItem);
      // }


      // // 화면에 출력(부산)
      // for (let i = 0; i < busanList.length; i++) {
      //   let newItem = document.createElement("div");
      //   newItem.className = "index_res_item";
    
      //   newItem.innerHTML = `<img src="${busanList[i].img}" alt="레스토랑 썸네일">` +
      //     `<span class="index_res_category">${busanList[i].category}</span>` +
      //     `<span class="index_res_name">${busanList[i].name}</span>` +
      //     `<span class="index_res_addr"${busanList[i].address}</span>` +
      //     `<a><button type="button"><i class="fa-solid fa-seedling"></i>자세히 보기</button></a>`;
    
      //   // 새로운 div 요소의 내용을 설정 
      //   let busanRow = document.getElementById("index_res_busan");
      //   busanRow.appendChild(newItem);
      // }

      // console.log("제주도: " , jejuList);

      // // 화면에 출력(제주)
      // for (let i = 0; i < jejuList.length; i++) {
      //   let newItem = document.createElement("div");
      //   newItem.className = "index_res_item";

      //   newItem.innerHTML = `<img src="${jejuList[i].img}" alt="레스토랑 썸네일">` +
      //     `<span class="index_res_category">${jejuList[i].category}</span>` +
      //     `<span class="index_res_name">${jejuList[i].name}</span>` +
      //     `<span class="index_res_addr"${jejuList[i].address}</span>` +
      //     `<a><button type="button"><i class="fa-solid fa-seedling"></i>자세히 보기</button></a>`;
    
      //   // 새로운 div 요소의 내용을 설정 
      //   let jejuRow = document.getElementById("index_res_jeju");
      //   jejuRow.appendChild(newItem);
      // }

      // 위 코드 업그레이드 
      const regionList = {
        seoul: [],
        gyeonggi: [],
        busan: [],
        jeju: [],
      };
      
      // 레스토랑 객체 생성 및 지역 리스트에 추가
      for (let i = 0; i < restList.length; i++) {
        let itemObj = {
          id: restList[i].rest_id,
          name: restList[i].rest_name,
          address: restList[i].rest_Addr,
          category: restList[i].rest_category,
          img: restList[i].rest_img,
        };
      
        if (itemObj.address.startsWith("서울")) regionList.seoul.push(itemObj);
        else if (itemObj.address.startsWith("경기")) regionList.gyeonggi.push(itemObj);
        else if (itemObj.address.startsWith("부산")) regionList.busan.push(itemObj);
        else if (itemObj.address.startsWith("제주")) regionList.jeju.push(itemObj);
      }
      
      // 지역 리스트를 출력하는 함수
      function printRegionList(regionName, list) {
        const row = document.getElementById(`index_res_${regionName}`);
        for (let i = 0; i < list.length; i++) {
          let newItem = document.createElement("div");
          newItem.className = "index_res_item";
      
          newItem.innerHTML = `<img src="${list[i].img}" alt="레스토랑 썸네일">` +
            `<span class="index_res_category">${list[i].category}</span>` +
            `<span class="index_res_name">${list[i].name}</span>` +
            `<span class="index_res_addr"${list[i].address}</span>` +
            `<a><button type="button"><i class="fa-solid fa-seedling"></i>자세히 보기</button></a>`;
      
          row.appendChild(newItem);
        }
      }
      
      // 각 지역 리스트 출력
      printRegionList("seoul", regionList.seoul);
      printRegionList("gyeonggi", regionList.gyeonggi);
      printRegionList("busan", regionList.busan);
      printRegionList("jeju", regionList.jeju);
    },
    error : function(error){
      console.log("화면 로드 실패")
    }
  });
});


