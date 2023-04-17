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