import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

//DML(INSERT, UPDATE, DELETE)
//1. 결과집함을 만들지 않는다
//2. 영향 받은 행의 수 리턴(executeUpdate() > return int)
//3. 결과의 진위여부는 execute() > return boolean
//정정 결과 집합이 있으면 true???
//결과집합이 없고 수정된 것이 있으면 false 정상 수행되면???

//문제
//오라클에서 dml 작업에 대해 commit, rollback을 수행했는데, app에서는...?
//jdbc api를 이용한 dml 작업은 default로 auto commit
//app에서 트랜잭션 처리를 할 수 있다

/* 실습용 테이블 생성
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
			 * Scanner(System.in); System.out.print("사번 입력: ");
			 * empno=Integer.parseInt(sc.nextLine());
			 * System.out.print("이름 입력: "); ename=sc.nextLine();
			 * System.out.print("부서번호 입력: ");
			 * deptno=Integer.parseInt(sc.nextLine());
			 */

			/*
			 * //insert into empdml(empno, ename, deptno) values (1000, '홍길동',
			 * 10) String sql="INSERT INTO EMPDML(EMPNO, ENAME, DEPTNO)";
			 * sql+=" VALUES("+empno+", '"+ename+"', "+deptno+")"; //문장 끝에 ;를 넣지
			 * 않아도 된다
			 * 
			 * int resultrow=stmt.executeUpdate(sql); if(resultrow>0) {
			 * System.out.println("반영된 행의 수: "+resultrow); } else {
			 * System.out.println("반영 실패: "+resultrow); }
			 */

			/*
			 * //update 해보기 //update empdml set sal=변수 where deptno=변수 Scanner
			 * sc=new Scanner(System.in); System.out.print("월급 입력: "); int
			 * sal=Integer.parseInt(sc.nextLine());
			 * System.out.print("부서 번호 입력: "); int
			 * dtno=Integer.parseInt(sc.nextLine());
			 * 
			 * String sql="UPDATE EMPDML";
			 * sql+=" SET SAL="+sal+" WHERE DEPTNO="+dtno;
			 * 
			 * int resultrow=stmt.executeUpdate(sql); if(resultrow>0) {
			 * System.out.println("반영된 행의 수: "+resultrow); } else {
			 * System.out.println("반영 실패: "+resultrow); }
			 */

			// delete 해보기
			// delete from empdml where deptno=변수
			Scanner sc = new Scanner(System.in);
			System.out.print("부서 번호 입력: ");
			int dtno = Integer.parseInt(sc.nextLine());

			String sql = "DELETE FROM EMPDML";
			sql += " WHERE DEPTNO=" + dtno;

			int resultrow = stmt.executeUpdate(sql);
			if (resultrow > 0) {
				System.out.println("반영된 행의 수: " + resultrow);
			} else {
				System.out.println("반영 실패: " + resultrow);
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
