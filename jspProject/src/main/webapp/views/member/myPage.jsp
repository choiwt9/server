<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--jQuery library-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<style>
.outer{
    background-color: pink;
    color: white;
    width: 1000px;
    margin: auto;
    margin-top: 50px;
}

#enroll-form table{ margin: auto;}
#enroll-form input{margin: 5px;}

</style>

</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<div class="outer">
    <br>
<h2 align="center">마이페이지</h2>
<form id="enroll-form" action="<%=contextPath %>/update.me" method="post">
<table>
    <tr>
        <td>*아이디</td>
        <td>
           <input type="text" name="userId" maxlength="12" value="${loginUser.userId }" redonly>
        </td>
        
    </tr>
    <tr>
        <td>*이름</td>
        <td>
            <input type="text" name="userName" maxlength="6" value="${loginUser.userName}" required>
        </td>
    </tr>
    <tr>
        <td>전화번호</td>
        <td>
            <input type="tel" name="phone" placeholder="- 포함해서 입력" value="${loginUser.phone}" redonly>
        </td>
    </tr>
    <tr>
        <td>이메일</td>
        <td>
            <input type="email" name="email" value="${loginUser.email}" >
        </td>
    </tr>
    <tr>
        <td>주소</td>
        <td>
            <input type="text" name="address" value="${loginUser.address}">
        </td>
    </tr>
    <tr>
        <td>취미</td>
        <td>
           <input type="checkbox" name="interest" id="baseball" value="야구">
           <label for="baseball">야구</label>

           <input type="checkbox" name="interest" id="cartoon" value="만화">
           <label for="cartoon">만화</label>

           <input type="checkbox" name="interest" id="soccer" value="축구">
           <label for="soccer">축구</label>
<br>
           <input type="checkbox" name="interest" id="study" value="공부">
           <label for="study">공부</label>
           
           <input type="checkbox" name="interest" id="game" value="게임">
           <label for="game">게임</label>
        </td>
    </tr>
</table>

 <br><br>
<div align="center">
   <button type="submit">정보 수정</button>
   <button type="button">비밀번호 변경</button>
   <button type="button">회원 탈퇴</button>
</div>

<br><br>

</form>
</div>

<script>

$(function(){
	const interest = "${loginUser.interest}";
	const checkArr = $("input[name=interest]"); //[input, input, input,..]
	
	console.log(interest);
	console.log(checkArr);
	
	for(let check of checkArr){
		//check => js 방식으로 접근된 요소로 인식됨!
		if(interest.includes(check.value)){
			//check.prop("checked", true);
			check.checked = true; //js방식
		}
	}
});

function pwdCheck(){
    const pwd = document.querySelector("#enroll-form input[name=userPwd]").value;
    const pwdCheck = document.querySelector("#enroll-form input[name=userPwdCheck]").value;

    if(pwd != pwdCheck){
        alert("비밀번호와 비밀번호 확인 입력값이 다릅니다.");
        return false;
    }


}


}

</script>

</body>
</html>