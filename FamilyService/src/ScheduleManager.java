import java.util.*;

public class ScheduleManager {
    private static final Scanner scanner = new Scanner(System.in);
    private final List<String> scheduleList = new ArrayList<>();
    private final List<String> anniversaries = new ArrayList<>();

    public void addSchedule() {
        System.out.println("\n[일정 등록]");
        System.out.print("일정 제목: ");
        String title = scanner.nextLine();
        System.out.print("날짜 (yyyy-mm-dd): ");
        String date = scanner.nextLine();

        if (title.isEmpty() || date.isEmpty()) {
            System.out.println("필수 항목을 입력해주세요.");
            return;
        }

        String fullSchedule = title + " (" + date + ")";
        scheduleList.add(fullSchedule);

        System.out.print("기념일로 등록하시겠습니까? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            anniversaries.add(fullSchedule);
            System.out.println("기념일로 등록되었습니다.");
        }

        System.out.println("일정 등록 완료: " + fullSchedule);
    }

    public void showSchedules() {
        System.out.println("\n[등록된 일정 목록]");
        for (String s : scheduleList) System.out.println("- " + s);
    }

    public void showAnniversaries() {
        System.out.println("\n[기념일 목록]");
        for (String a : anniversaries) System.out.println("* " + a);
    }
}
