import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.kosta.utils.ConnectionHelper;

/*
 * create table trans_A(
 * 	num number,
 * 	name varchar2(20)
 * );
 * 
 * create table trans_B(
 * 	num number primary key,
 * 	name varchar2(20)
 * );
 * 
 */
public class Ex08_Oracle_Transaction {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;

		conn = ConnectionHelper.getConnection("oracle");
		String sql = "insert into Trans_A(num, name) values(100, 'A')";
		String sql2 = "insert into Trans_B(num, name) values(100, 'B')";

		try {
			// key point
			conn.setAutoCommit(false); // autocommit > 수동으로 변경 > app에서 commit,
										// rollback 제어
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.executeUpdate();

			// 두개의 쿼리가 정상 처리되었다면
			conn.commit();
		} catch (Exception e) {
			// 툴 중 하나라도 실패하면
			conn.rollback();
			System.out.println(e.getMessage());
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(pstmt2);
			ConnectionHelper.close(conn);
		}
	}

}
