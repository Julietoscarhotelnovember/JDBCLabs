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
			// ����
			conn = SingletonHelper.getConnection("oracle");

			// ������ �غ�
			String sql = "INSERT INTO QUIZ1(ID, PASS) values(?, ?)";
			pstmt = conn.prepareStatement(sql);

			// �Է¹ޱ�
			Scanner sc = new Scanner(System.in);
			System.out.print("ID �Է�: ");
			String input1 = sc.nextLine();
			System.out.print("pass �Է�: ");
			String input2 = sc.nextLine();
			pstmt.setString(1, input1);
			pstmt.setString(2, input2);

			// �Է�
			int row = pstmt.executeUpdate();
			if (row > 0) {
				System.out.println("ȸ������ ����");
			} else {
				System.out.println("ȸ�ǰ��� ����");
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
			// ����
			conn = SingletonHelper.getConnection("oracle");

			// ������ �غ�
			String sql = "SELECT * FROM QUIZ1 WHERE ID=?";
			pstmt = conn.prepareStatement(sql);

			// �Է¹ޱ�
			Scanner sc = new Scanner(System.in);
			System.out.print("ID �Է�: ");
			String input1 = sc.nextLine();
			System.out.print("pass �Է�: ");
			String input2 = sc.nextLine();
			pstmt.setString(1, input1);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("PASS").equals(input2)) {
					System.out.println("�α��� ����");
				} else {
					System.out.println("�н����尡 Ʋ�Ƚ��ϴ�.");
				}
			} else {
				System.out.println("���̵� �����ϴ�.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.DbClose();
		}
	}
}