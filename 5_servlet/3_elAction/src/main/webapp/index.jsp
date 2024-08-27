<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP문법</h1>
<h2>* EL(Expression Language)</h2>
<p>
    기존에 사용했던 표현식(출력식) : &lt;%=변수/ 메소드 호출 %&gt; <br>
    위의 표현식과 비슷하게 JSP상에 표현하고자 하는 값을 작성하는 방법
    => \${변수/ 메소드호출} 형식으로 작성
</p>

<h4><a href="el.do">[1] EL 기본구문</a></h4>
<h4><a href="operator.do">[2] EL 연산자</a></h4>

<hr>

<h2>* Action Tag</h2>
<%--
*JSP를 이루는 구성요소*
[1] 스크립팅 원소 : jsp페이지 내에서 자바코드를 기술할 수있는 문법
  ex)스크립트릿, 표현식,....

[2] 지시어 : jsp 페이지 정보에 대한 내용을 표현하거나 다른 페이지를 포함하고자 할 때
           라이브러리 등록할 때 사용
           
[3] 액션 태그 : jsp 페이지에서 어떤 동작을 수행하고자 할 때 사용
     * 표준 액션 태그(Standard Action Tag) : jsp 페이지에서 사용가능
       => 모든 태그명 앞에 jsp 접두어를 붙여서 사용
       
     * 커스텀 액션 태그(Custom Action Tag): jsp 페이지에서 바로 사용 불가응(별도의 라이브러리 필요)
      =>가장 데표적안 라이브러리: jstl             
 --%>
 
 <h3>*표준 액션 태그(Standard Action Tag)</h3>
 <a href="views/2_Standard_Action/01_include.jsp">[1]jsp:include</a>
 <a href="views/2_Standard_Action/02_forward.jsp">[2] jsp:forward</a>
<br>

<h3>*커스텀 액션 태그(Custome Action Tag)</h3>
<h4>JSTL</h4>
<p>
jsp 에서 사용되는 커스텀 액션 태그 <br>
공통적으로 사용되는 코드들을 합하여 보다 쉽게 사용할 수 있도록 태그화하여 표준으로 제공되는 라이브러리
</p>

<h4>라이브러리 추가</h4>
<ol>
<li>톰켓사이트 접속</li>
<li>메뉴에서 taglib 메뉴를 찾아 접속(Download-taglibs)</li>
<li>네개의 라이브러리 파일 다운로드(.jar)</li>
<li>WEB-INF/lib/ 위치에 라이브러리 복사</li>
</ol>

<h4>JSTL 선언방법</h4>
<p>
JSTL을 사용하기 위하여 해당 jsp 상단에 <br>
taglib 지시어를 사용하여 선언 <br><br>

&lt;%@ taglib prefix = "접두어" uri라이브러리 파일상의 uri 주소 %&gt;
</p>

<h4>1. JSPL Core Library</h4>
<p>변수와 조건문, 반복문 등 로직과 관련된 문법을 제공</p>
<a href="views/3_Custom_Action/01_core.jsp">01 core</a>

</body>
</html>