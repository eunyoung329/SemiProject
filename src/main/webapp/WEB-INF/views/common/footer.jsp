<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<footer>
        <section class="container">
            <div class="footer-firstLine">
                
                <div class="info-area">
                    <span>About</span>
                    <a href="">회사소개</a>
                    <a href="">이용약관</a>
                    <a href="">공지사항</a>
                    <a href="">인재채용</a>
                </div>
                <div class="info-area">
                    <span>Help</span>
                    <a href="">1:1문의</a>
                    <a href="${contextPath}/admin/restAdmin">자주 묻는 질문</a>
                </div>
                <div class="info-area">
                    <span>Community</span>
                    <a href="${contextPath}/member/board">자유게시판</a>
                </div>
                <div class="sns-area">
                    <div class="sns-style">
                        <a href=""><i class="fa-brands fa-instagram icon"></i></a>
                    </div>
                    <div class="sns-style">
                        <a href=""><i class="fa-brands fa-twitter icon"></i></a>
                    </div>
                    <div class="sns-style">
                        <a href=""><i class="fa-brands fa-facebook-f icon"></i></a>
                    </div>         
                </div>
            </div>
            
            <div class="footer-secondLine">
                <div>
                    <span>대표이사: 홍길동</span>
                    |
                    <span>주소: 서울틀별시 강남구 테헤란로 110번길 50, 3층~6층</span>
                    |
                    <span>사업자등륵번호: 881-81-01223</span>
                </div>
                <div>
                   <!--<a href="${contextPath}/admin/adminLogin">administrator</a>-->
                </div>

            </div>
        </section>
    </footer>
    <%-- session에 message 속성이 존재하는 경우 alert창으로 해당 내용을 출력 --%>
    <c:if test="${ !empty sessionScope.message }">
        <script>
            alert("${message}");
            // EL 작성 시 scope를 지정하지 않으면
            // page -> request -> session -> application 순서로 검색하여
            // 일치하는 속성이 있으면 출력
        </script>
        
        <%-- message 1회 출력 후 session에서 제거 --%>
        <c:remove var="message" scope="session"/>
    </c:if>
