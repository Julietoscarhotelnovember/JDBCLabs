import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

//DML(INSERT, UPDATE, DELETE)
//1. ��������� ������ �ʴ´�
//2. ���� ���� ���� �� ����(executeUpdate() > return int)
//3. ����� �������δ� execute() > return boolean
//���� ��� ������ ������ true???
//��������� ���� ������ ���� ������ false ���� ����Ǹ�???

//����
//����Ŭ���� dml �۾��� ���� commit, rollback�� �����ߴµ�, app������...?
//jdbc api�� �̿��� dml �۾��� default�� auto commit
//app���� Ʈ����� ó���� �� �� �ִ�

/* �ǽ��� ���̺� ����
CREATE TABLE EMPDML
AS SELECT * FROM EMP;
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME='EMPDML';
ALTER TABLE EMPDML
ADD CONSTRAINT PK_EMPDML_EMPNO PRIMARY KEY(EMPNO);
*/

public class Ex04_Oracle_DML {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kglim", "1004");
			stmt = conn.createStatement();

			// insert
			/*
			 * int empno=0; String ename=""; int deptno=0; Scanner sc=new
			 * Scanner(System.in); System.out.print("��� �Է�: ");
			 * empno=Integer.parseInt(sc.nextLine());
			 * System.out.print("�̸� �Է�: "); ename=sc.nextLine();
			 * System.out.print("�μ���ȣ �Է�: ");
			 * deptno=Integer.parseInt(sc.nextLine());
			 */

			/*
			 * //insert into empdml(empno, ename, deptno) values (1000, 'ȫ�浿',
			 * 10) String sql="INSERT INTO EMPDML(EMPNO, ENAME, DEPTNO)";
			 * sql+=" VALUES("+empno+", '"+ename+"', "+deptno+")"; //���� ���� ;�� ����
			 * �ʾƵ� �ȴ�
			 * 
			 * int resultrow=stmt.executeUpdate(sql); if(resultrow>0) {
			 * System.out.println("�ݿ��� ���� ��: "+resultrow); } else {
			 * System.out.println("�ݿ� ����: "+resultrow); }
			 */

			/*
			 * //update �غ��� //update empdml set sal=���� where deptno=���� Scanner
			 * sc=new Scanner(System.in); System.out.print("���� �Է�: "); int
			 * sal=Integer.parseInt(sc.nextLine());
			 * System.out.print("�μ� ��ȣ �Է�: "); int
			 * dtno=Integer.parseInt(sc.nextLine());
			 * 
			 * String sql="UPDATE EMPDML";
			 * sql+=" SET SAL="+sal+" WHERE DEPTNO="+dtno;
			 * 
			 * int resultrow=stmt.executeUpdate(sql); if(resultrow>0) {
			 * System.out.println("�ݿ��� ���� ��: "+resultrow); } else {
			 * System.out.println("�ݿ� ����: "+resultrow); }
			 */

			// delete �غ���
			// delete from empdml where deptno=����
			Scanner sc = new Scanner(System.in);
			System.out.print("�μ� ��ȣ �Է�: ");
			int dtno = Integer.parseInt(sc.nextLine());

			String sql = "DELETE FROM EMPDML";
			sql += " WHERE DEPTNO=" + dtno;

			int resultrow = stmt.executeUpdate(sql);
			if (resultrow > 0) {
				System.out.println("�ݿ��� ���� ��: " + resultrow);
			} else {
				System.out.println("�ݿ� ����: " + resultrow);
			}

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