package kr.or.kosta.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
//�ݺ��Ǵ� �ڵ� (����̹� �ε� , ���ᰴü , ���ɰ�ü)
 
//���࿡ oracle �Ǵ� mysql �� �Ѵ� �����ϰ� �ʹٸ�
//��ü  APP ����κ� ��� Ŭ����
 
//���� (�ݺ��ڵ� ���δ�)
//���� (�޸� ������ ���� �� ( �ϳ��� �޸𸮷� : ���� > singleton)
//�Լ� > static > overloading > ������
public class ConnectionHelper {
     //��� (�Լ� : public , static)
	 public static Connection getConnection(String dsn){
		 Connection conn = null;
		 try {
			 	if(dsn.equals("mysql"))
			 	{
			 		Class.forName("com.mysql.jdbc.Driver");
			 		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kostadb", "kosta", "1004");
			 	
			 	}else if(dsn.equals("oracle")){
			 		
			 		Class.forName("oracle.jdbc.OracleDriver");
				 	conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "kglim", "1004");
			 	}	
			 	
				
		 } catch (Exception e) {
			e.printStackTrace();
		}finally{
			return conn;
		}
		 
	 }
	
	 public static Connection getConnection(String dsn, String uid, String pwd){
		 Connection conn = null;
		 try {
			 	if(dsn.equals("mysql"))
			 	{
			 		Class.forName("com.mysql.jdbc.Driver");
			 		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kostadb",uid, pwd);
			 	
			 	}else if(dsn.equals("oracle")){
			 		
			 		Class.forName("oracle.jdbc.OracleDriver");
				 	conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", uid, pwd);
			 	}	
			 	
				
		 } catch (Exception e) {
			e.printStackTrace();
		}finally{
			return conn;
		}
	 }
 
	 //���(�ڿ� ����)
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
	 }

}
 
 
 
 