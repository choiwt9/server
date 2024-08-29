<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<h2>회원가입</h2>
<form id="enroll-form" action="<%=contextPath %>/insert.me" method="post">
<table>
    <tr>
        <td>*아이디</td>
        <td>
           <input type="text" name="userId" maxlength="12" required>
        </td>
    </tr>
    <tr>
        <td>*비밀번호</td>
        <td>
            <input type="password" name="userPwd" maxlength="15" required>
        </td>
    </tr>
    <tr>
        <td>*비밀번호 확인</td>
        <td>
            <input type="password" name="userPwdCheck" maxlength="15" required>
        </td>
    </tr>
    <tr>
        <td>*이름</td>
        <td>
            <input type="text" name="userName" maxlength="6" required>
        </td>
    </tr>
    <tr>
        <td>전화번호</td>
        <td>
            <input type="tel" name="phone" placeholder="- 포함해서 입력">
        </td>
    </tr>
    <tr>
        <td>이메일</td>
        <td>
            <input type="email" name="email">
        </td>
    </tr>
    <tr>
        <td>주소</td>
        <td>
            <input type="text" name="address">
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
<button type="submit">회원가입</button>
<button type="reset">초기화</button>
</div>

<br><br>

</form>
</div>
</body>
</html>