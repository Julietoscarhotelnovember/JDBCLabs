import java.sql.Connection;
import java.sql.SQLException;

import kr.or.kosta.utils.ConnectionHelper;
import kr.or.kosta.utils.SingletonHelper;
import kr.or.kosta.utils.SingletonHelper_Teacher;

public class Ex05_Singleton_Teacher {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
/*		Connection conn = null;
		conn = ConnectionHelper.getConnection("mysql");
		System.out.println(conn.toString());
		System.out.println(conn.isClosed());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		conn.close(); //helper 성 코드 없는 경우
		
		
		
		
		
		conn = ConnectionHelper.getConnection("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.isClosed());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		conn.close();
		
		
		
		conn = ConnectionHelper.getConnection("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.isClosed());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		conn.close();
		System.out.println(conn.isClosed());
		
	
		
		conn = ConnectionHelper.getConnection("oracle","HR","1004");
		System.out.println(conn.toString());
		System.out.println(conn.isClosed());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		ConnectionHelper.close(conn);*/
		//--------------------------------------------------------------
		
		 
		//여기서 부터 singleton	
				Connection conn = null;
				conn = SingletonHelper_Teacher.getConnection("oracle");
				System.out.println(conn.toString());
				System.out.println(conn.isClosed());
				System.out.println(conn.getMetaData().getDatabaseProductName());
				
				
				conn = SingletonHelper_Teacher.getConnection("oracle");
				System.out.println(conn.toString());
				System.out.println(conn.isClosed());
				System.out.println(conn.getMetaData().getDatabaseProductName());
				
				
				conn = SingletonHelper_Teacher.getConnection("oracle");
				System.out.println(conn.toString());
				System.out.println(conn.isClosed());
				System.out.println(conn.getMetaData().getDatabaseProductName());
				
								
				//두번재 문제 (mysql , oracle)
				conn.close();
				//connection 객체 소멸이 아니고 연결 종료
				//여전이 conn 참조하는 메모리는 존재
				
				SingletonHelper_Teacher.DbClose(); //conn = null;
				conn = SingletonHelper_Teacher.getConnection("mysql");
				System.out.println("mysql 연결");
				System.out.println(conn.toString());
				System.out.println(conn.isClosed());
				//System.out.println(conn.getMetaData().getDatabaseProductName());
				
							
				conn = SingletonHelper_Teacher.getConnection("mysql");
				System.out.println(conn.toString());
				System.out.println(conn.isClosed());
				System.out.println(conn.getMetaData().getDatabaseProductName());
				
				
				
				SingletonHelper_Teacher.DbClose();
				conn = SingletonHelper_Teacher.getConnection("oracle");
				System.out.println(conn.toString());
				System.out.println(conn.isClosed());
				System.out.println(conn.getMetaData().getDatabaseProductName());
		 
	}

}
