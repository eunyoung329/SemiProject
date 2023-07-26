
<div align=center>
<img src="https://capsule-render.vercel.app/api?type=waving&color=auto&height=200&section=header&text=read_me!&fontSize=50" />
</div>

<div align=center>
   <h2>🌟 목차 🌟</h2>

   [Tech Stack](#-tech-stack-)<br>
   [프로젝트 설계](#-프로젝트-설계-)<br>
   [웹페이지 기능 소개](#-웹페이지-기능-소개-)
</div>


<br><br><br><br>




<div align=center>
   <h2>📚 Tech Stack 📚</h2>
</div>

<div align=center>
  <h4>1. OS</h4>
  <img src="https://img.shields.io/badge/Windows-0078D6?style=flat&logo=Windows&logoColor=white" />
  <img src="https://img.shields.io/badge/macOS-000000?style=flat&logo=macOs&logoColor=white" />
</div>

<br>

<div align=center>
  <h4>2. Language</h4>
  <img src="https://img.shields.io/badge/Java-EC8225?style=flat&logo=Java&logoColor=white" />
  <img src="https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=HTML5&logoColor=white" />
  <img src="https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=CSS3&logoColor=white" />
  <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=JavaScript&logoColor=white" />
  <br>
  <img src="https://img.shields.io/badge/jQuery-0769AD?style=flat&logo=jQuery&logoColor=white" />
  <img src="https://img.shields.io/badge/XML-000000?style=flat&logo=XML&logoColor=white" />
  <img src="https://img.shields.io/badge/JSP-000000?style=flat&logo=JSP&logoColor=white" />
  <img src="https://img.shields.io/badge/AJAX-2E84D6?style=flat&logo=AJAX&logoColor=white" />
</div>

 <br>
 <div align=center>
  <h4>3. Tool</h4>
<img src="https://img.shields.io/badge/eclipse-2C2255?style=eclipseide&logo=eclipse&logoColor=white"/>
  <img src="https://img.shields.io/badge/Apache Tomcat-F8DC75?style=flat&logo=Apache Tomcat&logoColor=white" />
  <img src="https://img.shields.io/badge/dbeaver-3B2C25?style=flat&logo=dbeaver&logoColor=white" />
  <img src="https://img.shields.io/badge/Git-F05032?style=flat&logo=Git&logoColor=white" />
  <br>
  <img src="https://img.shields.io/badge/Notion-000000?style=flat&logo=Notion&logoColor=white" />
</div>

<br>

<div align=center> 
  <h2>📝 프로젝트 설계 📝</h2>  


<b>기간: 2023.04.17 - 05.15</b><br>
&nbsp;&nbsp; -  기획의도 수립/유스케이스및 ER다이어그램(DB설계)/개발환경세팅 (~4.24)<br>
&nbsp;&nbsp; -  웹페이지 개발(~5.15)
<br><br> 
</div>
<div align=center>
<h2> 내가 담당한 웹페이지 기능 소개</h2>
    
<br><br>
<b>1.관리자 로그인</b><br>
<img width="500" src="https://github.com/eunyoung329/SemiProject/assets/125863767/84fc252f-b11e-405e-b558-671f72c34097"><br>
<img width="500" src="https://github.com/eunyoung329/SemiProject/assets/125863767/17f5d3e8-5dc6-4d2d-ad29-9fbdc22b3842">
<br>
&nbsp;&nbsp;-Bcrypt 비밀번호 암호화를 통한 로그인 구현<br>
&nbsp;&nbsp;-쿠키로 아이디 저장하기 구현하여 로그인 성공 시 쿠키 저장(365일)

<br><br>
<h3>2.제보하기</h3>
<img width="500" src="https://github.com/eunyoung329/SemiProject/assets/125863767/a5220e77-39d5-4682-a51b-055d3edb0fb1"><br>
<br>
&nbsp;&nbsp; - 사이드바의 가게제보,메인페이지의 제보하기버튼을 통해 사용자는 레스토랑을 제보할 수 있다. <br>
&nbsp;&nbsp; - 이미지,주소,제보내용등 자세한 정보를 제공하며 해당내용은 검수를 거쳐 운영자에 의해 정식등록된다.<br>
&nbsp;&nbsp; - 로그인된 회원만 해당기능사용


<br><br>
<h3>관리자페이지_제보/등록</h3>
<img width="500"src="https://github.com/eunyoung329/SemiProject/assets/125863767/65160601-1949-41ed-b396-0ce1e7f87cb0"><br>
<br>
&nbsp;&nbsp;- AJAX를 사용하여 사이드메뉴의 제보관리를 클릭하면 메인화면에 제보된 전체내용이 표시된다.
&nbsp;&nbsp;- AJAX를 사용하여 회원이메일을 검색하면 회원정보와 회원이 제보한 내용이 표시된다.
&nbsp;&nbsp;- 레스토랑에서 사용자가 제보한내용은 DB Report테이블에 저장되며 관리자는 관리자페이지에서 해당내용을 볼수 있다. <br>
&nbsp;&nbsp;- 제보삭제를 누르면 AJAX를 이용하여 DB REPORT 테이블에서 delete된<br>
&nbsp;&nbsp;-레스토랑 등록 버튼을 누를경우 해당내용이 이미 기입된 등록페이지가 나타난다. 관리자는 검수후 새 레스토랑을 등록할 수 있다.<br>




<br><br>
</div>
