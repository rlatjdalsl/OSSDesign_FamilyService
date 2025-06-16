import java.util.Scanner;

class UserProfile {
    private static final Scanner scanner = new Scanner(System.in);

    public void editProfile() {
        System.out.println("\n[프로필 수정]");
        System.out.print("수정할 사용자 ID를 입력하세요: ");
        String id = scanner.nextLine();

        Member member = Registration.findMemberById(id);
        if (member == null) {
            System.out.println("존재하지 않는 사용자입니다.");
            return;
        }

        System.out.println("현재 이름: " + member.name);
        System.out.print("새 이름 (변경하지 않으려면 Enter): ");
        String nameInput = scanner.nextLine();
        if (!nameInput.isBlank()) member.name = nameInput;

        System.out.println("현재 가족 관계: " + member.relation);
        System.out.print("새 가족 관계 (예: 아빠, 엄마 등 / 변경하지 않으려면 Enter): ");
        String relationInput = scanner.nextLine();
        if (!relationInput.isBlank()) member.relation = relationInput;

        System.out.println("현재 전화번호: " + member.tel);
        System.out.print("새 전화번호 (변경하지 않으려면 Enter): ");
        String telInput = scanner.nextLine();
        if (!telInput.isBlank()) member.tel = telInput;

        System.out.println("프로필 수정이 완료되었습니다.");
        showProfile(member);
    }

    public void showProfile(Member member) {
        System.out.println("\n[사용자 프로필 정보]");
        System.out.println("이름: " + member.name);
        System.out.println("ID: " + member.id);
        System.out.println("가족 관계: " + member.relation);
        System.out.println("전화번호: " + member.tel);
    }
}
