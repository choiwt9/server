package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/login.me")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 요청 시 인코딩 처리 필요(요청시 전달되는 데이터에 한글이 포함되어 있는 경우 필요!)	
		request.setCharacterEncoding("UTF-8");
		//요청시 전달된 데이터 추출(아이디, 패스워드)
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		
		//System.out.printf("id: %s, pwd:%s\n", id, pwd);
		
		//전달된 사용자 정보가 db에 저장되어 있는 지 확인 => Service에 요청 (Service객체의 메소드 호출)
		Member member = new MemberService().loginMember(id, pwd);
		
		/**
		 * 응답페이지에 전달할 값이 있을 경우 어딘가에 담아줘야 함.(담을 수 있는 영역--> JSP 내장객체)
		 * [1] application : 어플리케이션(프로젝트) 전역에서 사용할 수 있음
		 * [2] session     : 서버가 실행되는 동안에 세션이 만료되기 전까지 사용할 수 있음
		 *                   jsp, servlet에서 접근 가능 
		 * [3] request     : 요청된 request 객체가 가지고 있음. 포워딩된 jsp 페이지에서만 접근가능
		 * [4] page        : jsp페이지에서 생성하고 해당 페이지 내에서만 사용가능
		 */
		
		//처리된 결과에 따라 사용자가 보게 될 응답화면을 저장하여 포워당 또는 url 재요청
		if(member == null) {
			//조회결과가 없는 경우 => 로그인 실패(에러페이지? 에러메시지?)
		   request.setAttribute("errorMsg", "로그인 실패! 아이디와 비밀번호를 확인할 수 없습니다.");
		
		   request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}else {
			//조회결과가 있는 경우 => 로그인 성공
			
			//로그인된 사용자 정보를 session영역에 저장
		     HttpSession session = request.getSession();
		     session.setAttribute("loginUser", member);//menubar.jsp 페이지에서 로그인 유무를 확인할 수 있다.
		     
		     //메인페이지(첫페이지, index.jsp)로 응답
		     //*포워딩방식-> 요청한 url이 변경되지 않음 (xxx/login.me)
		     //request.getRequestDispatcher("index.jsp").forward(request, response);
		   
		     //localhost:8090/jsp 요청 시 index.jsp 페이지가 보여짐
		     //* url재요청 방식
		     //"/jsp"-> request.getContextPath()
		     response.sendRedirect(request.getContextPath());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
