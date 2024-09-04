<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pizza order</title>
</head>
<body>
<h1>피자주문하기</h1>

<h3>현재날짜</h3>
<% Date today = new Date(); %>
<h3><%= today %></h3> 
<form action="2_jsp/pizzaOrder">
<fieldset>
    <legend>주문자 정보</legend>
    이름 <input type="text" id="name"> <br>
    연락처 <input type="text" id="phone"> <br>
    주소 <input type="text" id="address"> <br>
    요청사항 <textarea name="" id="order"></textarea>

</fieldset>
<fieldset>
    <legend>주문정보</legend>
    피자 <select name="pizza" id="pizza">
        <option value="">콤비네이션</option>
        <option value="">치즈피자</option>
        <option value="">불고기피자</option>
        <option value="">하와이안피자</option>
        <option value="">페퍼로니피자</option>
    </select>
    토핑 <input type="checkbox" name="" id="cheese">치즈
    <input type="checkbox" name="" id="olive">올리브
    <input type="checkbox" name="" id="cheeseCrust">치즈크러스트 <br>
    <input type="checkbox" name="" id="pine">파인애플
    <input type="checkbox" name="" id="vacon">베이컨
    <input type="checkbox" name="" id="potato">포테이토
    <input type="checkbox" name="" id="shrimp">새우 <br>
    사이드 <input type="checkbox" name="" id="coke">콜라
    <input type="checkbox" name="" id="cyder">사이다
    <input type="checkbox" name="" id="pickle">피클 <br>
    <input type="checkbox" name="" id="spargetty">치즈오븐스파게티
    <input type="checkbox" name="" id="chicken">치킨텐더
</fieldset>

<button>주문</button>
<button type="reset">초기화</button>
</form>
</body>
</html>