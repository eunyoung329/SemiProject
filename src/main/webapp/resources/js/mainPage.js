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
          contents: restList[i].rest_contents,
          time: restList[i].rest_time,
          sns: restList[i].rest_sns

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
            `<span class="index_res_addr">${list[i].address}</span>` +
            `<a><button type="button" class="main_modal_btn" data-target="${list[i].id}_main_modal"><i class="fa-solid fa-seedling"></i>자세히 보기</button></a>`;
            

            $(function () {
              $(`[data-target="${list[i].id}_main_modal"]`).click(function () {
                $(".main_res_modal").fadeIn();
                
                console.log("target: " , $(this).data("target"));

                let targetId = $(this).data("target");
                let targetItem = list.find((item) => item.id === targetId.split("_")[0]);

                console.log(targetItem);

                // $(".main_modal_close").click(function () {
                //   $(".main_res_modal").fadeOut();
                // });

                // function mainModalClose(){
                //   $(".main_res_modal").fadeOut();
                // }

                $(".main_res_modal").html(
                  `<div class="main_res_modal_content">
                      <button class="main_modal_close">&times;</button>

                      <h2 class="mb-4">${targetItem.name}</h2>

                          <div class="main_modal_img_area">
                              <img src="${targetItem.img}" alt="이미지샘플">
                          </div>

                          <div class="main_modal_info_area">
                              <span>${targetItem.category}</span>
                              <span><i class="fa-solid fa-location-dot"></i>${targetItem.address}</span>
                              <span><i class="fa-regular fa-clock"></i>${targetItem.time}</span>
                              <span>
                                  <i class="fa-solid fa-quote-left"></i>
                                  ${targetItem.contents}
                                  <i class="fa-solid fa-quote-right"></i>
                              </span>
                              <span><a href="${targetItem.sns}">SNS 바로가기</a></span>
                          </div>
                  </div>`
                        );

                $(".main_modal_close").click(function() {
                    $(".main_res_modal").fadeOut();
                });

              });
            
              
            });

            




          row.appendChild(newItem);
        }; // for문 끝
      };

      


 

      
      // 각 지역 리스트 출력
      printRegionList("seoul", regionList.seoul);
      printRegionList("gyeonggi", regionList.gyeonggi);
      printRegionList("busan", regionList.busan);
      printRegionList("jeju", regionList.jeju);


      console.log("regionList.seoul: ", regionList.seoul);
      console.log("regionList.gyeonggi: ", regionList.gyeonggi);
      console.log("regionList.busan: ", regionList.busan);
      console.log("regionList.jeju: ", regionList.jeju);


    },
    error : function(error){
      console.log("화면 로드 실패")
    }
  });
});



