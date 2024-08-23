package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestGetServlet
 */
@WebServlet("/test2.do")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("GET 요청이 들어왔습니다");
		
		/*
		 *첫번째 매개변수 (request)에는 요청 시 전달된 내용들이 담겨있음
		 *                              (사용자가 입력한 값, 요청방식, 요청자의 ip 주소 등)
		 *두번째 매개변수 (response)에는 요청 처리 후 응답할 때 사용되는 객체 
		 *
		 *- ----- -
		 *
		 *요청시 전달된 데이터 추출 (request 객체의 parameter 영역안에 데이터가 담겨있음)
		 *request.getParameter("키")
		 *                            
		 */
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");//이름: 홍길동
		String gender = request.getParameter("gender");//gender: 남자|여자|null
		int age = Integer.parseInt(request.getParameter("age"));//age
		String address = request.getParameter("address");
		double height = Double.parseDouble( request.getParameter("height"));
		 System.out.println("이름: " + userName);
		 System.out.println("gender: " + gender);
		 System.out.println("age: " + age);
		 System.out.println("address: " + address);
		 System.out.println("height: " + height);
		 
		 //같은 key 값으로 여러개의 데이터가 전달되는 경우 : request.getParameterValues("키"): String[]
		 String[] foods = request.getParameterValues("food");
		 //System.out.println(foods);
		 
		 if(foods == null) {
			 System.out.println("선택된 음식 없음");
		 }else {
			System.out.println("foods : "+ String.join("/", foods));
		}
		//-----------------------------------
		 
	  /*
	   * 순수 서블릿 방식 : java 코드 내에서 html 작성
	   * jsp(java server Page) 방식 : html 안에 Java 코드 작성
	   */
		 
		 //응답페이지에서 필요한 데이터를 정리하여 전달
		 //->전달하는 공간 : request 객체의 attribute 라는 공간 사용
		 request.setAttribute("name", userName);
		 request.setAttribute("gender", gender);
		 request.setAttribute("age", age);
		 request.setAttribute("address", address);
		 request.setAttribute("height", height);
		 request.setAttribute("foods", foods);
		 
		 
		 //응답 페이지를 jsp에게 맡기자!
		 //jsp 페이지로 응답 설정 : request.getReQuestDispatcher(응답할페이지경로);
		 RequestDispatcher view = request.getRequestDispatcher("views/responsePage.jsp");
		 view.forward(request, response);
	}
	
	// 요청시 전달된 데이터 => request의 pareameter 영역에 있음
	
	//
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 메소드 실행");
		doGet(request, response);
	}

}
