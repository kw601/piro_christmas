package christmas.constant;

// 5천 원 이상: 별
// 1만 원 이상: 트리
// 2만 원 이상: 산타
public enum BadgeEnum {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int price;

    BadgeEnum(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getBadgeName() {
        return name;
    }

    public int getBadgePrice() {
        return price;
    }

    public static BadgeEnum getBadgeInfo(String testValue) {
        for (BadgeEnum badge : BadgeEnum.values()) {
            if (badge.getBadgeName().equalsIgnoreCase(testValue)) {
                return badge;
            }
        }
        return null;
    }
}
