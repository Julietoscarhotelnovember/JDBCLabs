import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
1.����̹� �ε�
2.���ᰴü ����
3.���(CRUD)
4.��� ����(Select : DML(insert, update, delete))
5.���ó��(��������, ȭ�����)
6.���� ����

�ڹ� �������̽�
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
			// 1.����̹� �ε�
			Class.forName("oracle.jdbc.OracleDriver");

			// 2.���ᰴü ����
			// ���� �۾�: ���� ���ڿ�
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kglim", "1004");
			System.out.println(conn.isClosed());

			// 3.��� ��ü ����
			stmt = conn.createStatement();

			// 4.��� ����(select, dml)
			String job = "";
			Scanner sc = new Scanner(System.in);
			System.out.print("���� �Է�: ");
			job = sc.nextLine();
			String sql = "SELECT EMPNO, ENAME, JOB FROM EMP WHERE JOB='" + job + "'"; // �����ϴ�,
																						// �̸�
																						// ����
																						// ��ü��
																						// �ִ�

			// select ���� �޼���: excuteQuery() > return resultSet(�������)
			// dml ���� �޼���: executeUpdate() > return int(�ݿ��� �� ����)
			// execute() > return boolean(�ݿ� ����)
			rs = stmt.executeQuery(sql);

			// 5.��� ó��
			// ����� ���� ���
			// ��� ������ single row�� ���
			// ����� multi row�� ���
			/*
			 * if (rs.next()) { //�ּ� 1��
			 * System.out.println(rs.getInt("EMPNO")+"/"+rs.getString("ENAME")+
			 * "/"+rs.getString("JOB"));
			 * 
			 * } else { //������ ���� System.out.println("��ȸ�� �����Ͱ� �����ϴ�"); }
			 */

			// ����: �� �ڵ带 �����Ͽ� SELECT�� ������ ��� ����ϱ�(���� �������� �ڵ�)
			if (rs.next()) {
				// �ּ� 1��
				do {
					System.out.println(rs.getInt("EMPNO") + "/" + rs.getString("ENAME") + "/" + rs.getString("JOB"));
				} while (rs.next());
			} else {
				// ������ ����
				System.out.println("��ȸ�� �����Ͱ� �����ϴ�");
			}
			// �ٷ� while���� ���� �����Ͱ� ���� ��츦 ó������ ���Ѵ�

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ڿ�����
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
