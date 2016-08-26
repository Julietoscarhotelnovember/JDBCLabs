import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/*
<자바를 통해 오라클 db 연동하기>
1.app(자바) <- jdbc api -> 오라클전용 드라이버 -> 오라클db에 접속
2.드라이버는 각 db벤더에 사이트에서 받음됨(오라클: ojdbc6.jar)
3.ojdbc6.jar에서 필요한 클래스를 메모리에 로드
4.new 안하고 바로 올릴 수 잇따 > 드라이버 로드
	Class.forName("클래스이름")
5.자바api(jdbc관련 클래스) > crud를 하면 됨
6.연결객체 생성(서버, 포트1521, 계정, 암호 접속시도) - 연결문자열 생성
	jdbc:oracle:thin:@localhost:1521:xe,kglim,1004
7.jdbc api
	import java.sql.*;
8.정해진 순서
	드라이버로딩 -> 연결 객체생성 -> 명령객체 생성 -> 명령실행 -> 결과처리 -> 자원해제
*/

public class Ex02_Mysql_Connect {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버 로딩 , 싱글톤패턴
			System.out.println("드라이버 로딩");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kostadb", "kosta", "1004");
			// 반환값 connection 타입
			System.out.println("연결 시도");
			System.out.println(conn.isClosed() + "너 닫혀있늬?"); // false 값을 도출해야함

			// 명령 실행
			stmt = conn.createStatement();
			String sql = "select empno, ename from emp";
			rs = stmt.executeQuery(sql);

			// 결과 처리
			while (rs.next()) {
				System.out.println(rs.getInt("empno") + "-" + rs.getString("ename"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 자원해제
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {

				}
			}

			if (stmt != null) {
				try {
					rs.close();
				} catch (Exception e) {

				}
			}

			if (conn != null) {
				try {
					rs.close();
				} catch (Exception e) {

				}
			}
		}
	}
}
