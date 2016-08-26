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
		conn.close(); //helper �� �ڵ� ���� ���
		
		
		
		
		
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
		
		 
		//���⼭ ���� singleton	
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
				
								
				//�ι��� ���� (mysql , oracle)
				conn.close();
				//connection ��ü �Ҹ��� �ƴϰ� ���� ����
				//������ conn �����ϴ� �޸𸮴� ����
				
				SingletonHelper_Teacher.DbClose(); //conn = null;
				conn = SingletonHelper_Teacher.getConnection("mysql");
				System.out.println("mysql ����");
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
