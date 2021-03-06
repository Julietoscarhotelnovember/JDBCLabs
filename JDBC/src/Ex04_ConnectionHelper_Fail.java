import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class Ex04_ConnectionHelper_Fail {
	
	public static void ConnectDB() {
		Connection conn = null;
		Statement stmt = null;

		Properties prop = new Properties();
		prop.setProperty("forName", "oracle.jdbc.OracleDriver");
		prop.setProperty("getConnection", "jdbc:oracle:thin:@localhost:1521:xe");
		prop.setProperty("id", "kglim");
		prop.setProperty("pass", "1004");

		try {
			Class.forName(prop.getProperty("forName"));
			conn = DriverManager.getConnection(prop.getProperty("getConnection"), prop.getProperty("id"),
					prop.getProperty("pass"));
			stmt = conn.createStatement();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
