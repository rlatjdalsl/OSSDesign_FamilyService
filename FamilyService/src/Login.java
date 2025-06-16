import java.util.Scanner;

public class Login {
    private static final Scanner scanner = new Scanner(System.in);

    public void login() {
        System.out.println("\n[로그인]");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("비밀번호: ");
        String pw = scanner.nextLine();

        if (id.isEmpty() || pw.isEmpty()) {
            System.out.println("모든 항목을 입력해주세요.");
            return;
        }

        Member member = Registration.findMemberById(id);
        if (member == null || !member.password.equals(pw)) {
            System.out.println("아이디 또는 비밀번호가 잘못되었습니다.");
        } else {
            System.out.println("로그인 성공!");
            System.out.println("이름: " + member.name + " | 관계: " + member.relation + " | 연락처: " + member.tel);
        }
    }
}
