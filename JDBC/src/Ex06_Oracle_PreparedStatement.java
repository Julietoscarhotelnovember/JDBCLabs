import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.kosta.utils.ConnectionHelper;

//����Ŭ���� ���� �񱳴ܰ迡���� ��������� ���� ���
//�̸� ����κ��� ������ �� ����, ������ �κи� ��
public class Ex06_Oracle_PreparedStatement {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=ConnectionHelper.getConnection("oracle");
			String sql="select empno, ename from emp where deptno=?";
			pstmt=conn.prepareStatement(sql); //�̸� ������ �� �д�
			pstmt.setInt(1, 30); //ù��° ����ǥ�� 30 > �Ķ���͸� �̿�
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					System.out.println(rs.getInt(1)+"/"+rs.getString("ename"));
				} while(rs.next());
			} else {
				System.out.println("������ ����");
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
