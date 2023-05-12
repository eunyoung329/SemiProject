<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>inquiry</title>
    <script src="https://kit.fontawesome.com/069a8eb008.js" crossorigin="anonymous"></script> 
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/inquiry.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
  <jsp:include page="/WEB-INF/views/common/header.jsp"/>
  <main>
    <section class="inquiry-Content">
        <form action="inquiry" method="POST" name="inquiry-form" onsubmit="return inquiryValidate()">
            <h3>1대 1문의</h3>

            <div>
            <select class="form-select" aria-label="Default select example" name="category" id="category">
              <option selected>메뉴카테고리</option>
              <option value="">가입/로그인관련</option>
              <option value="레스토랑관련">레스토랑관련</option>
              <option value="리뷰관련">리뷰관련</option>
            </select>
          </div>

          
            <div>
            <label for="inquiryName">제목</label>
            <input class="form-control" type="text" aria-label="default input example" name="inquiryTitle" id="inquiryTitle">
          </div>
          <div>
            <label for="floatingTextarea inquiryContent">문의내용</label>
            <div class="form-floating h25" name="inquiryContent" id="inquiryContent">
              <textarea class="form-control" id="inquiryContent" name="inquiryContent" style="height: 500px"></textarea>
      
            </div>
                       

            <button id="inquiryBtn"  onclick="secessionValidate()">문의하기</button>
        </form>
    </section>
</main>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>


  </body>
  </html>