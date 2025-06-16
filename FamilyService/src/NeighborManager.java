import java.util.*;

class NeighborManager {
    private static final Scanner scanner = new Scanner(System.in);
    private final Map<String, String> pendingRequests = new HashMap<>(); // <code, userId>
    private final List<String> neighbors = new ArrayList<>();

    public void sendNeighborRequest() {
        System.out.println("\n[이웃 요청 보내기]");
        System.out.print("본인 ID: ");
        String userId = scanner.nextLine();

        System.out.print("이웃 초대 코드 입력: ");
        String code = scanner.nextLine();

        // 간단히 코드 유효성: 숫자 4자리
        if (!code.matches("\\d{4}")) {
            System.out.println("유효하지 않은 초대 코드입니다.");
            return;
        }

        pendingRequests.put(code, userId);
        System.out.println("이웃 요청이 전송되었습니다. 코드: " + code);
    }

    public void acceptNeighbor() {
        System.out.println("\n[이웃 요청 수락]");
        System.out.print("초대 코드 입력: ");
        String code = scanner.nextLine();

        if (pendingRequests.containsKey(code)) {
            String requester = pendingRequests.remove(code);
            neighbors.add(requester);
            System.out.println("이웃 요청을 수락하였습니다. → " + requester);
        } else {
            System.out.println("해당 코드의 요청이 존재하지 않습니다.");
        }
    }

    public void rejectNeighbor() {
        System.out.println("\n[이웃 요청 거절]");
        System.out.print("초대 코드 입력: ");
        String code = scanner.nextLine();

        if (pendingRequests.containsKey(code)) {
            String requester = pendingRequests.remove(code);
            System.out.println("이웃 요청을 거절하였습니다. → " + requester);
        } else {
            System.out.println("해당 코드의 요청이 존재하지 않습니다.");
        }
    }

    public void showNeighbors() {
        System.out.println("\n[현재 연결된 이웃 목록]");
        if (neighbors.isEmpty()) {
            System.out.println("등록된 이웃이 없습니다.");
            return;
        }

        for (String n : neighbors) {
            System.out.println("- " + n);
        }
    }
}
