import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
1.드라이버 로딩
2.연결객체 생성
3.명령(CRUD)
4.명령 실행(Select : DML(insert, update, delete))
5.명령처리(로직제어, 화면출력)
6.연결 종료

자바 인터페이스
Connection
Statment
Driver
ResultSet
*/
public class Ex03_Oracle_Connect_Select {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1.드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");

			// 2.연결객체 생성
			// 사전 작업: 연결 문자열
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kglim", "1004");
			System.out.println(conn.isClosed());

			// 3.명령 객체 생성
			stmt = conn.createStatement();

			// 4.명령 실행(select, dml)
			String job = "";
			Scanner sc = new Scanner(System.in);
			System.out.print("직종 입력: ");
			job = sc.nextLine();
			String sql = "SELECT EMPNO, ENAME, JOB FROM EMP WHERE JOB='" + job + "'"; // 불편하다,
																						// 이를
																						// 위한
																						// 객체가
																						// 있다

			// select 실행 메서드: excuteQuery() > return resultSet(결과집합)
			// dml 실행 메서드: executeUpdate() > return int(반영된 행 개수)
			// execute() > return boolean(반영 여부)
			rs = stmt.executeQuery(sql);

			// 5.명령 처리
			// 결과가 없는 경우
			// 결과 집합이 single row인 경우
			// 결과가 multi row인 경우
			/*
			 * if (rs.next()) { //최소 1건
			 * System.out.println(rs.getInt("EMPNO")+"/"+rs.getString("ENAME")+
			 * "/"+rs.getString("JOB"));
			 * 
			 * } else { //데이터 없음 System.out.println("조회된 데이터가 없습니다"); }
			 */

			// 퀴즈: 위 코드를 수정하여 SELECT한 데이터 모두 출력하기(가장 전형적인 코드)
			if (rs.next()) {
				// 최소 1건
				do {
					System.out.println(rs.getInt("EMPNO") + "/" + rs.getString("ENAME") + "/" + rs.getString("JOB"));
				} while (rs.next());
			} else {
				// 데이터 없음
				System.out.println("조회된 데이터가 없습니다");
			}
			// 바로 while문을 쓰면 데이터가 없는 경우를 처리하지 못한다

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
