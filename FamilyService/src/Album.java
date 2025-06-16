import java.util.*;

class Album {
    private static final Scanner scanner = new Scanner(System.in);
    private final Map<Integer, Photo> photoMap = new HashMap<>();
    private int photoIdCounter = 0;

    public void addPhoto() {
        System.out.println("\n[사진 업로드]");
        System.out.print("사진 파일명: ");
        String name = scanner.nextLine();

        System.out.print("사진 제목: ");
        String title = scanner.nextLine();

        System.out.print("설명: ");
        String description = scanner.nextLine();

        System.out.print("날짜 (yyyy-mm-dd): ");
        String date = scanner.nextLine();

        Photo photo = new Photo(++photoIdCounter, name, title, description, date);
        photoMap.put(photo.id, photo);

        System.out.println("사진이 업로드되었습니다. 사진 ID: " + photo.id);
    }

    public void deletePhoto() {
        System.out.print("삭제할 사진 ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (photoMap.remove(id) != null) {
            System.out.println("사진 #" + id + " 삭제 완료.");
        } else {
            System.out.println("해당 ID의 사진이 존재하지 않습니다.");
        }
    }

    public void showAlbum() {
        if (photoMap.isEmpty()) {
            System.out.println("업로드된 사진이 없습니다.");
            return;
        }

        System.out.println("\n[앨범 목록]");
        for (Photo p : photoMap.values()) {
            System.out.println("#" + p.id + " - " + p.title + " (" + p.date + ")");
            System.out.println("  설명: " + p.description);
            if (!p.comments.isEmpty()) {
                System.out.println("  댓글:");
                for (String c : p.comments) {
                    System.out.println("   - " + c);
                }
            }
        }
    }

    public void addComment() {
        System.out.print("댓글을 달 사진 ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Photo photo = photoMap.get(id);

        if (photo == null) {
            System.out.println("사진이 존재하지 않습니다.");
            return;
        }

        System.out.print("댓글 내용: ");
        String comment = scanner.nextLine();
        photo.comments.add(comment);
        System.out.println("댓글이 추가되었습니다.");
    }
}

class Photo {
    int id;
    String name;
    String title;
    String description;
    String date;
    List<String> comments;

    public Photo(int id, String name, String title, String description, String date) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.date = date;
        this.comments = new ArrayList<>();
    }
}
