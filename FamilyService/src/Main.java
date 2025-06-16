// Main.java
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    // 핵심 기능 클래스
    private static final Registration registration = new Registration();
    private static final Login login = new Login();
    private static final ScheduleManager scheduleManager = new ScheduleManager();
    private static final UserProfile userProfile = new UserProfile();
    private static final ChatManager chatManager = new ChatManager();
    private static final HealthInfoManager healthInfoManager = new HealthInfoManager();
    private static final NeighborManager neighborManager = new NeighborManager();
    private static final NotificationManager notificationManager = new NotificationManager();
    private static final Album album = new Album();

    public static void main(String[] args) {
        while (true) {
            printMainMenu();
            System.out.print("메뉴 선택: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1": registration.register(); break;
                case "2": login.login(); break;
                case "3": scheduleMenu(); break;
                case "4": chatMenu(); break;
                case "5": userProfile.editProfile(); break;
                case "6": healthMenu(); break;
                case "7": neighborMenu(); break;
                case "8": albumMenu(); break;
                case "9": notificationMenu(); break;
                case "0":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n========= Woori 가족 관리 시스템 =========");
        System.out.println("1. 회원가입            2. 로그인");
        System.out.println("3. 일정 관리           4. 채팅 관리");
        System.out.println("5. 프로필 수정         6. 건강 정보 관리");
        System.out.println("7. 이웃 관리           8. 사진 앨범");
        System.out.println("9. 알림 관리           0. 종료");
    }

    private static void scheduleMenu() {
        while (true) {
            System.out.println("\n[일정 관리] 1. 일정 등록 2. 일정 목록 3. 기념일 목록 0. 뒤로");
            String input = scanner.nextLine();
            switch (input) {
                case "1": scheduleManager.addSchedule(); break;
                case "2": scheduleManager.showSchedules(); break;
                case "3": scheduleManager.showAnniversaries(); break;
                case "0": return;
                default: System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void chatMenu() {
        while (true) {
            System.out.println("\n[채팅 관리] 1. 메시지 전송 2. 수신 확인 3. 읽음 처리 4. 전체 보기 0. 뒤로");
            String input = scanner.nextLine();
            switch (input) {
                case "1": chatManager.sendMessage(); break;
                case "2": chatManager.receiveMessage(); break;
                case "3": chatManager.markAsRead(); break;
                case "4": chatManager.showChat(); break;
                case "0": return;
                default: System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void healthMenu() {
        while (true) {
            System.out.println("\n[건강 정보] 1. 등록 2. 조회 0. 뒤로");
            String input = scanner.nextLine();
            switch (input) {
                case "1": healthInfoManager.addNote(); break;
                case "2": healthInfoManager.viewNote(); break;
                case "0": return;
                default: System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void neighborMenu() {
        while (true) {
            System.out.println("\n[이웃 관리] 1. 요청 전송 2. 수락 3. 거절 4. 목록 보기 0. 뒤로");
            String input = scanner.nextLine();
            switch (input) {
                case "1": neighborManager.sendNeighborRequest(); break;
                case "2": neighborManager.acceptNeighbor(); break;
                case "3": neighborManager.rejectNeighbor(); break;
                case "4": neighborManager.showNeighbors(); break;
                case "0": return;
                default: System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void albumMenu() {
        while (true) {
            System.out.println("\n[앨범 관리] 1. 사진 업로드 2. 삭제 3. 보기 4. 댓글 작성 0. 뒤로");
            String input = scanner.nextLine();
            switch (input) {
                case "1": album.addPhoto(); break;
                case "2": album.deletePhoto(); break;
                case "3": album.showAlbum(); break;
                case "4": album.addComment(); break;
                case "0": return;
                default: System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void notificationMenu() {
        while (true) {
            System.out.println("\n[알림 관리] 1. 안읽은 보기 2. 읽음 처리 3. 삭제 4. 전체 보기 0. 뒤로");
            String input = scanner.nextLine();
            switch (input) {
                case "1": notificationManager.getUnreadNotifications(); break;
                case "2": notificationManager.markAsRead(); break;
                case "3": notificationManager.deleteNotification(); break;
                case "4": notificationManager.showNotifications(); break;
                case "0": return;
                default: System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
