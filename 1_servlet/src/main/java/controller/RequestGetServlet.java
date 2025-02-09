package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestGetServlet
 */
@WebServlet("/test.do")
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetServlet() {
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
		 //Servlet -> DAO > DB작업
		 /*
		  * int result = new MemberService().insert(userName, height, address,....)
		  * if(result>0){
		  * //성공}else{
		  *   //실패
		  *   }
		  */
		 //응답데이터의 문서 형식 및 인코딩 방식 설정
        response.setContentType("text/html; charset=UTF-8");		 
		 //응답시 사용할 스트림 객체(응답 페이지 작성할 것임!)
		 PrintWriter pw = response.getWriter();
		 
		 pw.println("<html>");
		 
		 pw.println("<head>");
		 pw.println("<style>");
		 pw.println("span{color: red;}");
		 pw.println("</style>");
		 pw.println("</head>");
		 
		 pw.println("<body>");
		 
		 pw.println("<h2>응답 요청 페이지<h2>");
		 pw.printf("<span>%s</span>님", userName);
		 pw.printf("<span>%s</span>에 살고", address);
		 pw.printf("<span>%d</span>살입니다", age);
		 
		 if (foods==null) {
			 pw.println("좋아하는 음식은 없습니다");
			 }else {
				 pw.printf("좋아하는 음식: <span>%s</span>", String.join("/", foods));
			 }
		 
		 
		 pw.println("</body>");
		 
		 pw.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메소드 실행");
		doGet(request, response);
	}

}
