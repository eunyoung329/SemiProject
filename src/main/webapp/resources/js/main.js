// 사이드메뉴 오픈 
const openNav = () => {

    console.log("click")
    document.getElementById("mySidenav").style.width = "400px"
}

const closeNav = () => {
    document.getElementById("mySidenav").style.width = "0"
}

console.log("working?")