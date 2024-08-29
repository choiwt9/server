package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	/**
	 * Connection 객체 생성 후 반환해주는 메소드
	 */
	public static Connection getConnection() {
		Connection conn = null;
	    Properties prop = new Properties(); //DB접속 관련 설정을 저장하기 위한 객체
	    	
	    //classes 폴더 내의 driver.properties 파일의 물리적인 경로 조회
	   String filepath = JDBCTemplate.class.getResource("/DB/driver/driver.properties").getPath();
	    
	    
	    
	   try {
		   prop.load(new FileInputStream(filepath));
		   
		   //jdbc driver 등록
		   //Class.forName("oracle.jdbc.driver.OracleDriver");
		   Class.forName(prop.getProperty("driver"));
		   
		   //connection 객체 생성
		   //conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
			//	                               ,"C##SERVER"
			//	                               ,"SERVER");             
		   conn = DriverManager.getConnection(prop.getProperty("url")
                                                    ,prop.getProperty("username")
                                                     ,prop.getProperty("password") );
		   
		       conn.setAutoCommit(false);
	} catch (ClassNotFoundException e) {
	e.printStackTrace();	
	} catch (SQLException e) {
		e.printStackTrace();	
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	   
	   
		//System.out.println("----오류없이 끝----");
		return conn;
	}
	
	/**
	 * connection 객체를 전달받아서 commit 처리하는 메소드 
	 */
	public static void commit(Connection conn) {
		try {
			if(conn !=null && !conn.isClosed())
				conn.commit();
				
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * connection 객체를 전달받아서 rollback 처리하는 메소드 
	 */
	public static void rollback(Connection conn) {
		try {
			if(conn !=null && !conn.isClosed())
				conn.rollback();
				
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * connection 객체를 전달받아서 close 해주는 메소드
	 */
	public static void close(Connection conn) {
		try {
			if(conn !=null && !conn.isClosed())
				conn.close();
				
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * Statement 객체를 전달받아서 close 해주는 메소드
	 */
	public static void close(Statement stmt) {
		try {
			if(stmt !=null && !stmt.isClosed())
				stmt.close();
				
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * result 객체를 전달받아서 close 해주는 메소드
	 */
	public static void close(ResultSet rset) {
		try {
			if(rset !=null && !rset.isClosed())
				rset.close();
				
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
