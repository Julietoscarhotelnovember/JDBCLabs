package kr.or.kosta.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SingletonHelper_Teacher {
	private static Connection conn=null;
	 
	 private SingletonHelper_Teacher(){}
	
	 public static Connection getConnection(String dsn) throws ClassNotFoundException, SQLException{
		 if(conn != null){
			 System.out.println("conn is not null");
			 return conn;
		 } 
			  	if(dsn.equals("mysql"))
				 	{
				 		Class.forName("com.mysql.jdbc.Driver");
				 		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kostadb", "kosta", "1004");
				 	
				 	}else if(dsn.equals("oracle")){
				 		
				 		Class.forName("oracle.jdbc.OracleDriver");
					 	conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "kglim", "1004");
				 	}	
					
		 return conn;

	 }
  public static void DbClose(){
		if(conn != null){
			try{
				conn.close();
				conn = null;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	/*
	 public static void close(Connection conn){
		 if(conn != null){
			 try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		 }
	 }

	 public static void close(Statement stmt){
		 if(stmt != null){
			 try {
				 stmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		 }
	 }
	 
	 public static void close(ResultSet rs){
		 if(rs != null){
			 try {
				 rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		 }
	 }
	 public static void close(PreparedStatement pstmt){
		 if(pstmt != null){
			 try {
				 pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		 }
	 }*/
}