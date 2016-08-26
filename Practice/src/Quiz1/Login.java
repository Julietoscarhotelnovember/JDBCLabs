package Quiz1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {
	public void regID() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 연결
			conn = SingletonHelper.getConnection("oracle");

			// 쿼리문 준비
			String sql = "INSERT INTO QUIZ1(ID, PASS) values(?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 입력받기
			Scanner sc = new Scanner(System.in);
			System.out.print("ID 입력: ");
			String input1 = sc.nextLine();
			System.out.print("pass 입력: ");
			String input2 = sc.nextLine();
			pstmt.setString(1, input1);
			pstmt.setString(2, input2);

			// 입력
			int row = pstmt.executeUpdate();
			if (row > 0) {
				System.out.println("회원가입 성공");
			} else {
				System.out.println("회권가입 실패");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.DbClose();
		}
	}

	public void logIn() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 연결
			conn = SingletonHelper.getConnection("oracle");

			// 쿼리문 준비
			String sql = "SELECT * FROM QUIZ1 WHERE ID=?";
			pstmt = conn.prepareStatement(sql);

			// 입력받기
			Scanner sc = new Scanner(System.in);
			System.out.print("ID 입력: ");
			String input1 = sc.nextLine();
			System.out.print("pass 입력: ");
			String input2 = sc.nextLine();
			pstmt.setString(1, input1);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("PASS").equals(input2)) {
					System.out.println("로그인 성공");
				} else {
					System.out.println("패스워드가 틀렸습니다.");
				}
			} else {
				System.out.println("아이디가 없습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.DbClose();
		}
	}
}
