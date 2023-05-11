var showObj;
var showItems = [];
var td8;
$(document).ready(function () {
    $.ajax({
        url: "adminBoardList",
        dataType: "JSON",
        success: function (showList) {
            console.log(showList);
            for (let i = 0; i < showList.length; i++) {
                let show = showList[i];
                let showObj = {
                    bNo: show.boardNo,
                    mNo: show.memberNo,
                    title: show.title,
                    tagValue: show.tagValue,
                    inputArea: show.inputArea,
                    boardImage: show.boardImage
                };
                showItems.push(showObj);
                console.log(showItems);
            }
            selectAllBoard(showItems);
        },
        error: function () {
            console.log("게시판 에이젝스 오류발생!")
        }
    });


});

function selectAllBoard(showItems) {

    const tableBody_board = document.getElementById("tableBody_board");

    tableBody_board.innerHTML = "";
    for (let item of showItems) {
        const tr = document.createElement("tr");
        const td1 = document.createElement("td");
        td1.innerText = item.bNo;
        const td2 = document.createElement("td");
        const img = document.createElement("img");
        img.src = "../"+item.boardImage;
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
        const icon = document.createElement("i");
        icon.className = "fa-solid fa-delete-left";
        icon.setAttribute("id", item.bNo); // 아이콘에도 id 값을 부여합니다.
        td8.appendChild(icon);
        icon.addEventListener("click", function (event) { // 아이콘에 클릭 이벤트를 등록합니다.
            const id = event.target.id;
            $.ajax({
                url : "boardDelete",
                data : {"id": id
                    },
                success : function(result){
                    if(result>0){
                        alert("게시글이 삭제되었습니다.");
                        location.reload();
                    }else{
                        alert("게시글이 삭제되지 않았습니다.")
                    }
                },
                error : function(){
                    console.log("딜리트에이젝스 오류")
                }

            })
        });
        tr.append(td1, td2, td3, td4, td5, td6, td7, td8);
        tableBody_board.append(tr);
    }
}

