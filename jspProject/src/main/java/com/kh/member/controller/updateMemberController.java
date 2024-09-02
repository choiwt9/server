package com.kh.member.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class updateMemberController
 */
@WebServlet("/update.me")
public class updateMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 전달된 데이터 추출
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] interArr = request.getParameterValues("interest");
		
		String interest="";
		if(interArr != null) {
			interest = String.join(",", interArr);
		}
		Member m = new Member(userId, userName, phone, email, address, interest);    
		
		Member updateMem = new MemberService().updateMember(m);
		
		if(updateMem == null) {//정보수정 실패
			//에러페이지로 응답
			
			
		}else {//정보수정 성공
			//세션영역에 변경된 사용자 정보 저장
            
			//수정 성공 했다는 메시지를 알림창을 띄울 수 있도록 세션 영역에 저장
			
			//마이페이지로 url 재요청 (/jsp/myPage.me)
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
