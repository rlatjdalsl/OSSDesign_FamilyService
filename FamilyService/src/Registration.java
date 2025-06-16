import java.util.*;

public class Registration {
    private static final List<Member> memberList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public void register() {
        System.out.println("\n[회원가입]");

        System.out.print("이름: ");
        String name = scanner.nextLine();

        System.out.print("전화번호: ");
        String tel = scanner.nextLine();

        System.out.print("가족 내 관계 (예: 아빠, 엄마, 자녀 등): ");
        String relation = scanner.nextLine();

        String id;
        while (true) {
            System.out.print("ID: ");
            id = scanner.nextLine();
            if (isDuplicateID(id)) {
                System.out.println("이미 존재하는 ID입니다. 다시 입력해주세요.");
            } else break;
        }

        String password;
        while (true) {
            System.out.print("비밀번호 (6자 이상): ");
            password = scanner.nextLine();
            if (password.length() < 6) {
                System.out.println("비밀번호는 6자리 이상이어야 합니다.");
                continue;
            }
            System.out.print("비밀번호 확인: ");
            String confirm = scanner.nextLine();
            if (!password.equals(confirm)) {
                System.out.println("비밀번호가 일치하지 않습니다.");
            } else break;
        }

        Member newMember = new Member(id, password, name, tel, relation);
        memberList.add(newMember);
        System.out.println("회원가입이 완료되었습니다.");
    }

    private boolean isDuplicateID(String id) {
        return memberList.stream().anyMatch(m -> m.id.equals(id));
    }

    public static Member findMemberById(String id) {
        return memberList.stream().filter(m -> m.id.equals(id)).findFirst().orElse(null);
    }
}
