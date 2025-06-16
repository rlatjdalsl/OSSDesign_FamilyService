import java.util.*;

class ChatManager {
    private static final Scanner scanner = new Scanner(System.in);
    private final Map<String, List<Message>> chatThreads = new HashMap<>();

    public void sendMessage() {
        System.out.println("\n[메시지 전송]");
        System.out.print("보내는 사람 ID: ");
        String from = scanner.nextLine();
        System.out.print("받는 사람 ID: ");
        String to = scanner.nextLine();
        System.out.print("메시지 내용: ");
        String content = scanner.nextLine();

        Message msg = new Message(from, to, content);
        chatThreads.computeIfAbsent(to, k -> new ArrayList<>()).add(msg);

        System.out.println("메시지를 전송했습니다.");
    }

    public void receiveMessage() {
        System.out.print("수신자 ID를 입력하세요: ");
        String receiver = scanner.nextLine();

        List<Message> messages = chatThreads.getOrDefault(receiver, new ArrayList<>());
        if (messages.isEmpty()) {
            System.out.println("새로운 메시지가 없습니다.");
            return;
        }

        System.out.println("\n[읽지 않은 메시지 목록]");
        for (Message msg : messages) {
            if (!msg.read) {
                System.out.println("From: " + msg.sender + " - " + msg.content);
            }
        }
    }

    public void markAsRead() {
        System.out.print("수신자 ID: ");
        String receiver = scanner.nextLine();

        List<Message> messages = chatThreads.getOrDefault(receiver, new ArrayList<>());
        for (Message msg : messages) {
            msg.read = true;
        }

        System.out.println("모든 메시지를 읽음 처리했습니다.");
    }

    public void showChat() {
        System.out.println("\n[전체 채팅 로그]");
        for (Map.Entry<String, List<Message>> entry : chatThreads.entrySet()) {
            System.out.println("대상: " + entry.getKey());
            for (Message msg : entry.getValue()) {
                String status = msg.read ? "읽음" : "안읽음";
                System.out.println("From: " + msg.sender + " | 내용: " + msg.content + " [" + status + "]");
            }
        }
    }
}

class Message {
    String sender;
    String receiver;
    String content;
    boolean read;

    public Message(String sender, String receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.read = false;
    }
}

