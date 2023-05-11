let mainContent = document.getElementsByClassName("mainContent");
const part = document.createElement("div");
const card_shadow_sm = document.createElement("div");
const bd_placeholder_img = document.createElement("svg");
const card_body = document.createElement("div");
const card_text = document.createElement("p");
const text_muted = document.createElement("small");
const contentContainer = document.getElementsByClassName("content-container");
let pageCount = 0;
let deleteBtn;
let dataCount = 0;
let cp = 1;
let repeat = 0;
let firstStart = 0;
let cardId = 0;
const screenHeight = screen.height; // 화면 크기
let col =`<div class="col">
<div class="card shadow-sm">
  <svg class="bd-placeholder-img card-img-top col-base" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>inputTitle</title><rect width="100%" height="100%" fill="#55595c"/><image xlink:href="/SemiProject/thumbNail" data-bs-toggle="modal" data-bs-target="#myModal-cardId" width="100%" height="100%"/><text x="50%" y="50%" fill="#eceeef" dy=".3em"></text></svg>

  <div class="card-body">
    <p class="card-text">inputTitle</p>
    <div class="d-flex justify-content-between align-items-center">
      <small class="text-muted">timeThrow</small>
    </div>
  </div>
</div>
</div>
<!-- 모달창 -->
        <div class="modal fade"  id="myModal-cardId" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">inputTitle</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <img src="../thumbNail" alt="../resources/img/boardImg/default_board.jpg">
              </div>
              <div class="modal-footer">
                <h6 class="modal-footer-content">mainContext</h6>
                <div class="delete-button-container"></div>
                <!--<i class="fa-solid fa-heart" id="heart-cardId"></i>-->
              </div>
            </div>
          </div>
        </div>
      </div>
`;
let surroundField = `<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3" id="mainContent"></div>`
getBoard();

function makeContent(boardList){
	
	if(boardList != null){
    if(repeat == 0){
	for (const item in boardList){
		
		const content = col.replaceAll("inputTitle", boardList[item].title).replaceAll("timeThrow", boardList[item].boardTime).replaceAll("thumbNail",boardList[item].boardImage).replaceAll("mainContext",boardList[item].inputArea).replaceAll("boardNo",boardList[item].boardNo).replaceAll("cardId",cardId);
		mainContent[repeat].innerHTML += content;
		addDelete(cardId,boardList[item].boardNo);
		cardId++;
			
		}
		
	}else{
		for (const item in boardList){
				
		const content = col.replaceAll("inputTitle", boardList[item].title).replaceAll("timeThrow", boardList[item].boardTime).replaceAll("thumbNail",boardList[item].boardImage).replaceAll("mainContext",boardList[item].inputArea).replaceAll("boardNo",boardList[item].boardNo);
		contentContainer[0].innerHTML += surroundField;
		mainContent = document.getElementsByClassName("mainContent");
		mainContent[repeat].innerHTML += content;	
		addDelete(cardId);
		cardId++;
		}
	}
	deleteBtn = document.getElementsByClassName("btn-delete");
	
	console.log(deleteBtn);
	repeat++;
	}
}




function getBoard(){
$.ajax({
    url:"board/selectPage",
    data:{"firstStart": firstStart},
    type:"POST",
    success:(result)=>{
        
        data = JSON.parse(result);
        console.log(data);
		firstStart = data.firstStart; 
        makeContent(data.boardList);
    },
    error:(result)=>{
        console.log("실패.");
    }
});
}
let onerTime = false;
document.addEventListener('scroll',OnScroll,{passive:true});
function OnScroll () { //스크롤 이벤트 함수
   const fullHeight = contentContainer.clientHeight; // infinite 클래스의 높이   
   const scrollPosition = pageYOffset; // 스크롤 위치
   if (fullHeight-screenHeight/2 <= scrollPosition && !oneTime) { // 만약 전체높이-화면높이/2가 스크롤포지션보다 작아진다면, 그리고 oneTime 변수가 거짓이라면
     oneTime = true; // oneTime 변수를 true로 변경해주고,
     getBoard(); // 컨텐츠를 추가하는 함수를 불러온다.
   }else{
	oneTime = false;
}
 }
 
 // 삭제하기 버튼을 생성하는 함수
function createDeleteButton() {
  const deleteButton = document.createElement('a');
  //deleteButton.setAttribute('href', '*');
  deleteButton.setAttribute('class', 'btn btn-light mk btn-delete');
  deleteButton.setAttribute('onClick','deleteBoard(event)');
  //deleteButton.setAttribute('name', '');
  deleteButton.textContent = '삭제하기';
  
  return deleteButton;
}

function deleteBoard(event){
	const boardNo = event.target.id;
 $.ajax({
    url:"board/delete",
    data:{"boardNo":boardNo},
    type:"post",
    success:function(result){
      console.log("될텐데.");
      
    },
    error:function(failed){

    }   
  });	
	
}



function addDelete(cardId,boardNo) {
  const deleteButtonContainer = document.getElementsByClassName('delete-button-container')[cardId];
  if (sessionStorage.getItem('loginMember')) {
    const deleteButton = createDeleteButton();
    deleteButton.setAttribute('id',boardNo);
    deleteButtonContainer.appendChild(deleteButton);
    
    
  }
}