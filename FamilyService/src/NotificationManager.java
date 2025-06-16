import java.util.*;

class NotificationManager {
    private static final Scanner scanner = new Scanner(System.in);
    private final Map<String, List<Notification>> notificationMap = new HashMap<>();
    private int notificationCounter = 0;

    public void addNotification(String msg, String userId) {
        Notification notification = new Notification(++notificationCounter, msg);
        notificationMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(notification);
        System.out.println("[알림 생성됨] " + msg + " → 사용자: " + userId);
    }

    public void getUnreadNotifications() {
        System.out.print("사용자 ID: ");
        String userId = scanner.nextLine();

        List<Notification> list = notificationMap.getOrDefault(userId, new ArrayList<>());
        System.out.println("\n[읽지 않은 알림]");
        for (Notification n : list) {
            if (!n.read) {
                System.out.println("#" + n.id + " - " + n.message);
            }
        }
    }

    public void markAsRead() {
        System.out.print("사용자 ID: ");
        String userId = scanner.nextLine();
        System.out.print("읽음 처리할 알림 ID: ");
        int notiId = Integer.parseInt(scanner.nextLine());

        List<Notification> list = notificationMap.get(userId);
        if (list == null) {
            System.out.println("해당 사용자의 알림이 존재하지 않습니다.");
            return;
        }

        for (Notification n : list) {
            if (n.id == notiId) {
                n.read = true;
                System.out.println("알림 #" + notiId + "을 읽음 처리했습니다.");
                return;
            }
        }
        System.out.println("알림 ID를 찾을 수 없습니다.");
    }

    public void deleteNotification() {
        System.out.print("사용자 ID: ");
        String userId = scanner.nextLine();
        System.out.print("삭제할 알림 ID: ");
        int notiId = Integer.parseInt(scanner.nextLine());

        List<Notification> list = notificationMap.get(userId);
        if (list == null) {
            System.out.println("해당 사용자의 알림이 없습니다.");
            return;
        }

        list.removeIf(n -> n.id == notiId);
        System.out.println("알림 #" + notiId + "이 삭제되었습니다.");
    }

    public void showNotifications() {
        System.out.print("사용자 ID: ");
        String userId = scanner.nextLine();

        List<Notification> list = notificationMap.getOrDefault(userId, new ArrayList<>());
        if (list.isEmpty()) {
            System.out.println("알림이 없습니다.");
            return;
        }

        System.out.println("\n[전체 알림 목록]");
        for (Notification n : list) {
            String status = n.read ? "읽음" : "안읽음";
            System.out.println("#" + n.id + " [" + status + "] - " + n.message);
        }
    }
}

class Notification {
    int id;
    String message;
    boolean read;

    public Notification(int id, String message) {
        this.id = id;
        this.message = message;
        this.read = false;
    }
}
