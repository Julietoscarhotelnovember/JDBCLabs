package Quiz1;

public class Main {

	public static void main(String[] args) {
		Login login=new Login();
		System.out.println("회원가입");
		login.regID();
		System.out.println("로그인");
		login.logIn();
	}
}
