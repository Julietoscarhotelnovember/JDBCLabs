import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.or.kosta.utils.ConnectionHelper;

public class Ex07_Oracle_PreparedStatement_DML {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=ConnectionHelper.getConnection("oracle");
			String sql="insert into empdml(empno, ename, deptno) values(?, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, 8888);
			pstmt.setString(2, "홍길");
			pstmt.setInt(3, 20);
			
			int row=pstmt.executeUpdate();
			if(row>0) {
				System.out.println("Insert row: "+row);
			} else {
				System.out.println("Insert failed "+row);
			}
			
			//위 코드를 이용해 update 하기
			//update empdml set ename=?, job=?, sal=?, deptno=?
			//where empno=?
			String sql2="update empdml set ename=?, job=?, sal=?, deptno=? where empno=?";
			pstmt=conn.prepareStatement(sql2);
			pstmt.setString(1, "홍길동이");
			pstmt.setString(2, "영업");
			pstmt.setInt(3, 2000);
			pstmt.setInt(4, 30);
			pstmt.setInt(5, 8888);
			
			int row2=pstmt.executeUpdate();
			if(row2>0) {
				System.out.println("Insert row: "+row2);
			} else {
				System.out.println("Insert failed "+row2);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

}
