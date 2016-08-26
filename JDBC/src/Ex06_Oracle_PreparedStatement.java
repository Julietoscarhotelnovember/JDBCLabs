import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.kosta.utils.ConnectionHelper;

//오라클에서 쿼리 비교단계에서의 성능향상을 위해 사용
//미리 공통부분은 컴파일 해 놓고, 나머지 부분만 비교
public class Ex06_Oracle_PreparedStatement {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=ConnectionHelper.getConnection("oracle");
			String sql="select empno, ename from emp where deptno=?";
			pstmt=conn.prepareStatement(sql); //미리 컴파일 해 둔다
			pstmt.setInt(1, 30); //첫번째 물음표에 30 > 파라미터만 이용
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					System.out.println(rs.getInt(1)+"/"+rs.getString("ename"));
				} while(rs.next());
			} else {
				System.out.println("데이터 없음");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(rs);
			ConnectionHelper.close(conn);
		}

	}
}
