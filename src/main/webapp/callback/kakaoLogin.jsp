<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
    <script language="javascript">
        const urlParams = new URL(location.href).searchParams;
        const code = urlParams.get('code');
        console.log(code);

        var walletAddress;
        var totalReceived;
        var key;
        var txIDarray = null;
        var txID = null;
        api(code);
        function api(code){
            var grant_type ="authorization_code";
            var client_id ="96429edc93edc85fdb85c0bf03b50702";
            var redirect_uri = "http://localhost:8080/SemiProject/callback/kakaoLogin.jsp";
            var code = code;
            $.post("https://kauth.kakao.com/oauth/token", {grant_type:grant_type, client_id:client_id,redirect_uri:redirect_uri,code:code},
                function(data){
                    console.log(data);
                    var access_token = data['access_token'];
                    console.log(access_token);
                    tokenFunction(access_token);
                }            
            );

        }

        var tokenRequest = new XMLHttpRequest();
        function tokenFunction(access_token){
            var access_token = access_token;
            console.log(access_token);
            // tokenRequest.open("POST", "../member/tokenServlet?access_token"+ access_token, true);
            // tokenRequest.onreadystatechange = tokenProcess;
            // tokenRequest.send(null);
            tokenRequest.open("POST", "../member/tokenServlet", true);
            tokenRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            tokenRequest.send("access_token=" + access_token);
        }
        function tokenProcess(){
            if(tokenRequest.readyState == 4 && tokenRequest.status ==200){
                var result = tokenRequest.responseText;
                if(result==1){
                    alert("location.href 사용해서 로그인완료 페이지로 이동시키기");
                }else{
                    alert("location.href 사용해서 회원가입 페이지로 이동시키기");
                }
            }
        }
        console.log("안되냐");


    </script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</body>
</html>