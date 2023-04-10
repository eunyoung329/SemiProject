<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>test2</title>
    <script src="https://kit.fontawesome.com/069a8eb008.js" crossorigin="anonymous"></script> 
    <link rel="stylesheet" href="/styleLogin.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>

    <header>
       <div>
        <img src="/img/logoSample2.png" alt="">
       </div>

       <div class="headerProfile">
        <span name="nickName" id="nickName">닉네임</span>
        <button type="button" onclick="openNav()" id="profileBtn"><img src="/img/defaultUser.png" alt=""></button>
       </div>

       <!-- 로그인/프로필 사이드 메뉴 -->
       <div class="side-menu" id="mySidenav">
            <button type="button" id="loginCloseBtn" onclick="closeNav()" >&times;</button>
            
            <div class="profileWrap">
                <div class="profileArea">
                    <img src="/img/defaultUser.png" alt="">
                    <span name="nickName">닉네임</span>
                </div>

                <ul class="infoList">
                    <a href="">
                        <li>
                            <i class="fa-regular fa-user"></i>내 정보
                        </li>
                    </a>
                    <a href="">
                        <li>
                            <i class="fa-regular fa-comment"></i>내가 작성한 리뷰
                        </li>
                    </a>
                    <a href="">
                        <li>
                            <i class="fa-regular fa-heart"></i>찜한 목록
                        </li>
                    </a>
                    <a href="">
                        <li>
                            <i class="fa-solid fa-shop"></i>상점등록
                        </li>
                    </a>
                    <a href="">
                        <li>
                            <i class="fa-regular fa-circle-question"></i>도움말
                        </li>
                    </a>
                </ul>

                <a href="" class="hey">
                    <div>
                        <i class="fa-solid fa-power-off"></i>로그아웃
                    </div>
                </a>

                
            </div>
        </div>
    </div>
    </header>



    
        
            
           
                



    <main>
        <div class="container">
            hi
        </div>
    </main>


    <footer>
        footer
    </footer>
    


    <script src="/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>



