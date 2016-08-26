import java.sql.Connection;
import java.sql.SQLException;

import kr.or.kosta.utils.ConnectionHelper;

public class Ex05_Connection_Helper {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		
		/*conn = ConnectionHelper.getConnection("mysql");
		System.out.println(conn.toString());
		System.out.println(conn.isClosed());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		conn.close(); //helper 성 코드 없는 경우
*/	
		
		
		
		
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
		ConnectionHelper.close(conn);

	}

}
