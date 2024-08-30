package com.kh.member.model.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {

	public Member loginMember(String id, String pwd) {
		//Connection 객체를 생성하여 Dao 에게 전달
		Connection conn = getConnection();
		
		//Dao객체에 DB에 아이디랑 비밀번호에 해당하는 데이터가 있는지 확인 요청
		Member m = new MemberDao().loginMember(conn, id, pwd);
		
		//Connection 객체 반납(close)
		close(conn);
		
		return m;
	}

	public int insertMember(Member m) {
		Connection conn = getConnection();
		
		//insert(DDL) --> int  --> 트랜잭션처리(commit, rollback)
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) {//회원데이터 추가 성공
			commit(conn);
		}else {//회원데이터 추가 실패
             rollback(conn);		
	}
		close(conn);
		return result;

}
}
