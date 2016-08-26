import java.sql.Connection;
import java.sql.SQLException;
import kr.or.kosta.utils.SingletonHelper;


public class Ex05_Connection_Helper_Singleton {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		
		conn = SingletonHelper.getConnection("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.isClosed());
		System.out.println(conn.getMetaData().getDatabaseProductName());

		
		conn = SingletonHelper.getConnection("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.isClosed());
		System.out.println(conn.getMetaData().getDatabaseProductName());

		
		SingletonHelper.DbClose();
		conn = SingletonHelper.getConnection("mysql");
		System.out.println(conn.toString());
		System.out.println(conn.isClosed());
		System.out.println(conn.getMetaData().getDatabaseProductName());
	

	}

}
