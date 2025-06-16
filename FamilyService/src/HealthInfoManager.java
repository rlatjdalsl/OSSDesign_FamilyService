import java.util.*;

class HealthInfoManager {
    private static final Scanner scanner = new Scanner(System.in);
    private final Map<String, HealthRecord> healthData = new HashMap<>();

    public void addNote() {
        System.out.println("\n[건강 정보 등록]");
        System.out.print("사용자 ID: ");
        String userId = scanner.nextLine();

        System.out.print("혈액형: ");
        String bloodType = scanner.nextLine();

        System.out.print("알러지 정보 (없으면 없음): ");
        String allergy = scanner.nextLine();

        System.out.print("복용 중인 약 (없으면 없음): ");
        String medication = scanner.nextLine();

        System.out.print("공개 범위 설정 (public/private): ");
        String privacy = scanner.nextLine();

        HealthRecord record = new HealthRecord(bloodType, allergy, medication, privacy);
        healthData.put(userId, record);

        System.out.println("건강 정보가 저장되었습니다.");
    }

    public void viewNote() {
        System.out.print("\n조회할 사용자 ID 입력: ");
        String userId = scanner.nextLine();

        HealthRecord record = healthData.get(userId);
        if (record == null) {
            System.out.println("해당 사용자에 대한 건강 정보가 없습니다.");
            return;
        }

        System.out.println("\n[건강 정보]");
        System.out.println("혈액형: " + record.bloodType);
        System.out.println("알러지: " + record.allergy);
        System.out.println("복용약: " + record.medication);
        System.out.println("공개 범위: " + record.privacyLevel);
    }

    public String getSharedHealthInfo(String userId) {
        HealthRecord record = healthData.get(userId);
        if (record != null && "public".equalsIgnoreCase(record.privacyLevel)) {
            return "[공유 건강 정보] 혈액형: " + record.bloodType +
                    ", 알러지: " + record.allergy +
                    ", 복용약: " + record.medication;
        }
        return "공유된 건강 정보가 없거나 비공개로 설정되어 있습니다.";
    }
}

class HealthRecord {
    String bloodType;
    String allergy;
    String medication;
    String privacyLevel; // public or private

    public HealthRecord(String bloodType, String allergy, String medication, String privacyLevel) {
        this.bloodType = bloodType;
        this.allergy = allergy;
        this.medication = medication;
        this.privacyLevel = privacyLevel;
    }
}
