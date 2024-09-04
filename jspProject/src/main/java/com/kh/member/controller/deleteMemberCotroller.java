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
 * Servlet implementation class deleteMemberCotroller
 */
@WebServlet("/delete.me")
public class deleteMemberCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteMemberCotroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     //전달된 데이터 추출
		String id = request.getParameter("userId");
		  String pwd = request.getParameter("userPwd");
		 
		//서비스 객체에게 데이터를 전달하면서 탈퇴 요청(사용자 삭제 -> update 탈퇴 컬럼(status))
		  int result = new MemberService().deletePassword(id, pwd);    
		
		if(result > 0) {//탈퇴 성공했을 경우 ->탈퇴 성공 메시지 출력, 로그아웃 처리
			 HttpSession session = request.getSession();
	    	 //session.invalidate();
			 session.removeAttribute("loginUser");
	    	 session.setAttribute("alertMsg", "회원탈퇴에 성공했습니다. 그동안 이용해주셔서 감사합니다");
	    	 response.sendRedirect(request.getContextPath());
	    	 
		}else{//탈퇴 실패했을 경우 -> 에러 페이지 응답. 달퇴 실패 메시지 담아서
            request.setAttribute("errorMsg", "탈퇴에 실패했습니다");
            request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response); 
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
