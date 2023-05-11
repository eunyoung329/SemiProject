const reqEX1 = /^[\w\W]{1,30}$/
const reqEx2 = /^[\w\W]{1,500}$/
const board_title = document.getElementsByClassName("board_titleInput");
const tagBtn = document.getElementsByClassName("tagBtn");
//회원 프로필 이미지 변경.
const inputImage = document.getElementById("input-image");
const inputTag = document.getElementsByClassName("inputTag");
const inputArea = document.getElementById("inputArea");
if(inputImage != null){ //inputImage 요소가 화면에 존재할 때
    // input type = "file" 요소는 파일이 선택될때 change이벤트 발생
    inputImage.addEventListener("change", function(){
        //파일 목록에서 첫번째 파일 객체를 선택
        //files : input type = "file" 만 사용 가능한 속성으로 
        //              선택된 파일 목록(배열)을 반환

        this.files[0] != undefined//파일이 선택되었을때
            const reader = new FileReader();
            //JAVASCRIPT의 FileReader
            //웹 어플리케이션이 비동기적으로 데이터를 읽기 위하여 사용하는 객체

            reader.readAsDataURL(this.files[0])//지정된 파일의 내용을 읽기 시작하는 메소드
            //FileReader.readAsDataURL(파일)
            // - 지정된 파일의 내용을 읽기 시작함.
            // - 읽어오는 게 완료되면 RESULT 속성에 data에
            // 읽어온 파일의 위치를 나타내는 URL이 포함된다.
            // => 해당 URL을 이용해서 브라우저에서 이미지를 볼 수 있다.

            reader.onload = function(e){
                // e: 이벤트 발생 객체 -파일 리더.
                // e.target 이벤트가 발생한 요소.
                // e.target.result : FileReader가 읽어온 파일의 url

                // 프로필 : 이미지의 src 속성의 값을 FileReader가 읽어온 파일의 url로 변경.

                //const profileImage = document.getElementById("profile-image");
                //profileImage.setAttribute("src", e.target.result);
                //-> setAttribute() 호출 시 중복되는 속성이 존재하면 덮어쓰기.

                //이미지가 새로 추가 됐으니까 x누르면 1 안누르면 0..
                //document.getElementById("delete").value = 0;
                //새로운 이미지가 선택되었기 때문에 1->0 (안눌러짐 상태)로 변경.
            }
        }
)};
let tagSum;
let tagNum=0;
const valueList = {
    titleValue :false,
    textValue : false
}



//태그 삽입 및 삭제.
tagBtn[0].addEventListener("click",function(){


    const tagPlace = document.getElementById("tagPlace");
    const addTag = document.createElement("div");
    const invisibleTag = document.createElement("input");

    //태그 원하는 갯수. 여기서 나중에 발전하면 밑에 div를 추가해서
    //그곳에 더 넣을 수도 있을 것 같음.
    if(tagNum < 5){
        

    addTag.innerText = "#"+inputTag[0].value;
    addTag.classList.add("tagSpan");
    addTag.classList.add("destroy");
    invisibleTag.value = inputTag[0].value;
    invisibleTag.classList.add("invisibleTag");
    invisibleTag.setAttribute("name","tagValue");

    addTag.addEventListener("click",function(){
        // alert("동적요소 이벤트 추가");
        if(tagNum==5){
        tagBtn[0].classList.remove("invisible");
        inputTag[0].classList.remove("invisible");
        }
        tagNum--;
        this.remove();
    });
    console.log(tagNum);
    tagPlace.prepend(addTag);
    tagPlace.prepend(invisibleTag);
    tagNum++;
    }else{
        tagBtn[0].classList.add("invisible");
        inputTag[0].classList.add("invisible");
    }
});
function boardinvalidate(){

    
    if(reqEX1.test(board_title[0].value)){
        valueList.titleValue = true;
    }else{
        valueList.titleValue = false;
    }
    if(reqEx2.test(inputArea.value)){
        valueList.textValue = true;
    }else{
        valueList.textValue = false;
    }
    
    
    if(Object.values(valueList).reduce((acc, val) => acc + val, 0) === 2){
        
        
        
        return true;

    
    }else{
        return false;
    }
}
