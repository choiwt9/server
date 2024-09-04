<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 연습</title>
<link rel="icon" type="image/x-icon" href="https://img.icons8.com/?size=100&id=V6zmBDTUPL-g&format=png&color=000000">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<%-- TODO: 닉네임을 출력 --%>	
		<h2><span class="badge rounded-pill text-bg-info">${ nickname }</span>님 반갑습니다 ^^</h2>
		
		<hr>
		
		<table class="table">
			<thead class="table-light">
				<tr>
					<th>전시회명</th>
					<th>기간</th>
					<th>장소</th>
				</tr>
			</thead>
			
			<tbody>
				<%-- TODO: 결과화면 참고
					* 조회된 결과가 없을 경우 : 조회된 전시회가 없습니다 출력
					* 조회된 결과가 있을 경우 : 한 행씩 출력 
				--%>
				<c:choose>
				   <c:when test="${ empty eList }">
				         <tr>
				         <td colspan="3">조회된 전시회가 없습니다.</td>
				         </tr>
				   </c:when>
				   <c:otherwise>
				   <c:forEach var="e" items="${ eList }">
				   <tr>
				   <td>${e.title }</td>
			       <td>${e.period }</td>
			       <td>${e.location }</td>
				   </tr>
				   </c:forEach>
				   </c:otherwise>
				</c:choose>
			</tbody>
			
		</table>
	</div>
</body>
</html>