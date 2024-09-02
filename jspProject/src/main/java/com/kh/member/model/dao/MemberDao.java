package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.kh.common.JDBCTemplate.*;
import com.kh.member.model.vo.Member;

public class MemberDao {

	private Properties prop = new Properties();
	
	public MemberDao() {
		String filepath = MemberDao.class.getResource("/DB/sql/member-mapper.xml").getPath();
	try {
		prop.loadFromXML(new FileInputStream(filepath));
	} catch (IOException e) {
		e.printStackTrace();
	}
	   
	}
	
	public Member loginMember(Connection conn, String id, String pwd) {
	 // SELECT 문 (조회) -> ResultSet 객체 (한 행)--> Member 객체 반환
		Member m = null; // 결과를 반환할 객체
		
		PreparedStatement pstmt = null; //jdbc 객체 ->sql문 실행 후 결과를 받아올 객체
		ResultSet rset = null;          //jdbc 객체 -> 조회결과가 담길 객체
		
		//실행할 쿼리문
		//String sql = "SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ?";
		String sql = prop.getProperty("loginMember");
		try {
			
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rset = pstmt.executeQuery(); // 조회결과가 있을 경우 한 행 반환, 없을 경우 아무것도 반환 안함
			
			if(rset.next()) {
				//조회된 결과가 있을 경우 Member 객체에 담기
				//int no = rset.getInt("user_no");
				
				m = new Member(rset.getInt("user_no"),
						rset.getString("user_id"),
						rset.getString("user_pwd"),
						rset.getString("user_name"),
						rset.getString("phone"),
						rset.getString("email"),
						rset.getString("address"),
						rset.getString("interest"),
						rset.getDate("enroll_date"),
						rset.getDate("modify_date"),
						rset.getString("status"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}

	public int insertMember(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMember");
		System.out.println(sql);
		System.out.println(m);
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getAddress());
			pstmt.setString(7, m.getInterest());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int incheck(Connection conn, String userId) {
		//필요한 변수 정의
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("userIdCheck");
		
			try {//jdbc객체 생성 및 쿼리문 실행
			pstmt = conn.prepareStatement(sql);// 여기까진 미완성 sql
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			//실행결과에 따른 처리 
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//생성했던 객체 반납
			close(rset);
			close(pstmt);
		}		
		// 결과 반환
		return count;
		
	}

	public int updateMember(Connection conn, Member m) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getInterest());
			pstmt.setString(6, m.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
				
		return result;
	}

	public Object selectMember(Connection conn, String userId) {
          Member m = null;
		  return m;
	}

}
