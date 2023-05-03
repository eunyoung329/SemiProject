var showObj;
var showItems=[];
$(document).ready(function () {
    $.ajax({
        url : "adminBoardList",
        dataType : "JSON",
        success : function(showList){
            console.log(showList);
            for(let i = 0; i< showList.length; i++){
                let show = showList[i];
                let showObj = {
                    bNo : show.boardNo,
                    mNo : show.memberNo,
                    title : show.title,
                    tagValue : show.tagValue,
                    inputArea : show.inputArea,
                    boardImage : show.boardImage
                };
                showItems.push(showObj);
                console.log(showItems);
            }
            selectAllBoard(showItems);
        },
        error : function(){
            console.log("게시판 에이젝스 오류발생!")
        }
    });    
   
        
});
  
function selectAllBoard(showItems){

    const tableBody_board = document.getElementById("tableBody_board");

    tableBody_board.innerHTML="";
    for (let item of showItems) {
        const tr = document.createElement("tr");
        const td1 = document.createElement("td");
        td1.innerText = item.bNo;
        const td2 = document.createElement("td");
        const img = document.createElement("img");
        img.src = item.boardImage;
        td2.appendChild(img);
        const td3 = document.createElement("td");
        td3.innerText = item.title;
        const td4 = document.createElement("td");
        td4.innerText = item.tagValue;
        const td5 = document.createElement("td");
        td5.innerText = item.inputArea;
        const td6 = document.createElement("td");
        td6.innerText = "time";
        const td7 = document.createElement("td");
        td7.innerText = item.mNo;
        const td8 = document.createElement("td");
        td8.innerHTML = "<i class='fa-solid fa-delete-left'></i>";

        tr.append(td1, td2, td3, td4, td5, td6, td7, td8);
        tableBody_board.append(tr);
        }
}