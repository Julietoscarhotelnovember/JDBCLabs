import java.util.Scanner;

public class Ex04_Change_Fail {

	public static void main(String[] args) {
		
		
		String job = "";
		Scanner sc = new Scanner(System.in);
		System.out.print("직종 입력: ");
		job = sc.nextLine();
		String sql = "SELECT EMPNO, ENAME, JOB FROM EMP WHERE JOB='" + job + "'"; 

		
		Ex04_ConnectionHelper_Fail.ConnectDB();
	}
}
